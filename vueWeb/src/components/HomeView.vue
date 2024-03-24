<template>
  <div>
    <el-dialog title="Add New Quiz" :visible.sync="addQuizDialogVisible" width="90%">
      <el-form ref="newQuiz" :form="newQuiz">
        <el-form-item label="Quiz Name" :required="true">
          <el-input v-model="newQuiz.quizName" type="text" placeholder="Please enter the quiz name"></el-input>
        </el-form-item>
        <el-form-item label="Quiz Type" :required="true">
          <el-select v-model="newQuiz.quizType" placeholder="Please select the quiz type">
            <el-option :label="quizType.replaceAll('_', ' ')" :value="quizType" v-for="quizType in allQuizTypes" v-bind:key="quizType" />
          </el-select>
        </el-form-item>
        <el-form-item label="Quiz Question" :required="true">
          <el-input v-model="newQuiz.quizQuestion" type="textarea"
            placeholder="Please type in the quiz question"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="addNewQuiz(newQuiz)">Add</el-button>
        <el-button @click="addQuizDialogVisible = false">Cancel</el-button>
      </div>
    </el-dialog>

    <el-container style="height: 650px; border: 1px solid #eee">
      <el-aside width="250px" style="background-color: rgb(238, 241, 246)">
        <el-menu :default-openeds="allQuizTypes" v-for="quizType in allQuizTypes" v-bind:key="quizType">
          <el-submenu :index="quizType">
            <template slot="title">{{ quizType.replaceAll('_', ' ') }}</template>
            <el-menu-item-group v-for="singleQuiz in getTypedQuizs(quizType)" v-bind:key="singleQuiz.quizId">
              <el-menu-item @click="showQuiz(singleQuiz)">{{ singleQuiz.quizName }}</el-menu-item>
            </el-menu-item-group>
          </el-submenu>
        </el-menu>
      </el-aside>

      <el-container>
        <el-header style="text-align: right; font-size: 12px">
          <el-dropdown trigger="click">
            <i class="el-icon-setting" style="margin-right: 30px"></i>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item v-if="!teacher" @click.native="login()">Login as Teacher</el-dropdown-item>
              <el-dropdown-item v-if="teacher" @click.native="addQuizDialogVisible = true">Add new Quiz</el-dropdown-item>
              <el-dropdown-item v-if="teacher" @click.native="logout()">Logout</el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
          <span v-if="teacher === false">Student</span>
          <span v-else>Teacher</span>
        </el-header>

        <el-main>
          <div v-if="Home">
            Home Page
          </div>
          <QuizPage v-else :quiz="quiz" :answers="answers" :teacher="teacher"></QuizPage>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
import axios from 'axios'
import QuizPage from './QuizPage.vue'

export default {
  name: "HomeView",
  components: {
    QuizPage
  },
  props: {
    teacher: {
      type: Boolean,
      default: false
    }
  },
  data() {
    return {
      quiz: {
        quizId: '',
        quizName: '',
        quizQuestion: '',
        quizType: ''
      },
      answers: [],
      approvalMode: false,
      Home: true,
      allQuizs: [],
      allQuizTypes: [
        "UML_Class_Diagram",
        "UML_Sequence_Diagram",
        "Nested_State_Diagram"
      ],
      addQuizDialogVisible: false,
      newQuiz: {
        quizName: '',
        quizQuestion: '',
        quizType: ''
      },
    }
  },
  created() {
    axios.post("http://localhost:8080/quiz/page", {}).then(response => {
      this.allQuizs = response.data.data
    })
  },
  methods: {
    showQuiz(quiz) {
      this.Home = false
      this.quiz = quiz
      axios.post("http://localhost:8080/answer/page", {
        quizId: quiz.quizId,
        approved: !this.teacher
      }).then(response => (
        this.answers = response.data.data
      ))
    },
    login() {
      this.$router.push("/teacherLogin")
    },
    giveApprovedSignal() {
      if (this.teacher) {
        return null
      } else {
        return true
      }
    },
    logout() {
      this.$router.push("/teacherLogin")
    },
    getTypedQuizs(type) {
      let index = 0
      let pickedQuizs = []
      for (let i = 0; i < this.allQuizs.length; i++) {
        if (this.allQuizs[i].quizType === type) {
          pickedQuizs[index] = this.allQuizs[i];
          index++;
        }
      }
      return pickedQuizs
    },
    addNewQuiz(newQuiz) {
      if (newQuiz.quizName === "") {
        alert("Quiz name is required")
      } else if (newQuiz.quizType === "") {
        alert("Quiz type is required")
      } else if (newQuiz.quizQuestion === "") {
        alert("Quiz question is required")
      } else {
        axios.post("http://localhost:8080/quiz/save", newQuiz)
        this.newQuiz = {
          quizName: '',
          quizQuestion: '',
          quizType: ''
        }
        this.addQuizDialogVisible = false;
      }
    }
  }
}
</script>

<style>
.el-header {
  background-color: #B3C0D1;
  color: #333;
  line-height: 60px;
}

.el-aside {
  color: #333;
}
</style>