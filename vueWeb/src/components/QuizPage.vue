<template>
    <div>
        <div :style="{'font-size':'35px','font-weight':'bold'}">
            {{ quiz.quizName }}
        </div>
        <div v-for="line in quiz.quizQuestion.split('\n')" v-bind:key="line" :style="{'text-align':'left','font-size':'18px'}">
            {{ line }}
        </div>
        <div>
            <router-view />
        </div>
        <el-radio-group v-model="mode" size="medium" v-if="teacher">
            <el-radio-button label="ViewMode">View Mode</el-radio-button>
            <el-radio-button label="ApprovalMode">Approval Mode</el-radio-button>
            <el-radio-button label="FeedbackMode">Feedback Mode</el-radio-button>
        </el-radio-group>
        <el-radio-group v-model="mode" size="medium" v-else>
            <el-radio-button label="ViewMode">All Answers</el-radio-button>
            <el-radio-button label="TeacherAnswersMode">Teacher' Answers</el-radio-button>
            <el-radio-button label="StudentAnswersMode">Student's Answers</el-radio-button>
        </el-radio-group>
        <AnswerPage :answers="pickAnswers(mode)" :teacher="teacher"></AnswerPage>
        <div>
            <el-upload class="avatar-uploader" action="http://localhost:8080/image/uploadAnswer" :show-file-list="false"
                ref="upload" :data={quizId:this.quiz.quizId,teacher:this.teacher}>
                <el-button size="medium" type="primary">Click to Add Your Own Answer</el-button>
                <div slot="tip" class="el-upload__tip">jpg/png Image only, can't exceed 500kb</div>
            </el-upload>
        </div>
    </div>
</template>

<script>
import AnswerPage from "./AnswerPage.vue";
export default {
    props: {
        quiz: {
            type: Object
        },
        answers: {
            type: Array
        },
        teacher: {
            type: Boolean
        }
    },
    name: "QuizPage",
    components:{
        AnswerPage
    },
    data() {
        return {
            mode: "ViewMode",
            pickedAnswers: [],
            currentAnswer: 1,
            showFeedback: "No"
        };
    },
    methods: {
        pickAnswers(mode) {
            let pickedAnswers = [];
            let index = 0;
            if (mode === "ViewMode") {
                return this.answers
            }
            else {
                for (let i = 0; i < this.answers.length; i++) {
                    if (this.generateConditions(mode, this.answers[i])) {
                        pickedAnswers[index] = this.answers[i];
                        index++;
                    }
                }
            }
            return pickedAnswers;
        },
        generateConditions(mode,answer){
            if (mode === "ApprovalMode") {
                return !answer.approved
            }
            else if (mode === 'FeedbackMode') {
                return (answer.feedback == null || answer.feedback === "")
            }
            else if (mode === "TeacherAnswersMode"){
                return answer.answerType === "T"
            }else if (mode === "StudentAnswersMode"){
                return answer.answerType === "S"
            }
            else {
                return true;
            }
        }
    }
}
</script>   