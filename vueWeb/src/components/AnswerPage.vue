<template>
    <div v-if="answers.length > 0">
        <div class="block" width="300px" height="300px">
            <el-image :src="baseUrl + answers[currentAnswer - 1].picture" fit="contain"></el-image>
        </div>
        <el-radio-group v-model="showFeedback" size="medium">
            <el-radio-button label="No">Hide FeedBack</el-radio-button>
            <el-radio-button label="Yes">View FeedBack</el-radio-button>
        </el-radio-group>
        <div v-if="showFeedback == 'Yes'">
            <div v-if="answers[currentAnswer - 1].feedback == null || answers[currentAnswer - 1].feedback === ''">
                This answer don't have feedback yet
            </div>
            <div v-else>
                <h1 :style="{'text-align':'left','font-size':'18px'}">Feedbacks:</h1>
                <div v-for="feedbackLine in answers[currentAnswer-1].feedback.split('\n')" v-bind:key="feedbackLine" :style="{'text-align':'left','font-size':'18px'}">
                    {{feedbackLine}}
                </div>
            </div>
        </div>
        <div v-if="teacher">
            <el-input type="textarea" placeholder="Give Some New Feedbacks" 
                v-model="newFeedback" autosize></el-input>
            <el-button type="primary" v-on:click="submitFeedback(currentAnswer - 1)">Submit</el-button>
        </div>
        <div>
            <el-pagination :page-count="answers.length" layout="prev, pager, next" :current-page.sync="currentAnswer">
            </el-pagination>
        </div>
        <div v-show="teacher">
            <el-button size="medium" type="primary" v-on:click="approve(currentAnswer - 1)"
                v-show="!answers[currentAnswer - 1].approved">Approve</el-button>
            <el-button size="medium" type="danger" v-on:click="disapproveWarningVisible = true">Disapprove</el-button>
        </div>
        <el-dialog title="Disapprove Warning" :visible.sync="disapproveWarningVisible">
            <h1 :style="{'font-size':'25px','color':'red'}">If you disapprove this answer, it will be deleted</h1>
            <div slot="footer" class="dialog-footer">
                <el-button type="danger" @click="disapprove(currentAnswer-1)">Delete</el-button>
                <el-button @click="disapproveWarningVisible = false">Cancel</el-button>
            </div>
        </el-dialog>
    </div>
    <div v-else>
        There are no answers for this quiz yet
    </div>
</template>

<script>
import axios from 'axios';
export default {
    name: "AnswerPage",
    props: {
        answers: {
            type: Array
        },
        teacher: {
            type: Boolean
        }
    },
    data() {
        return {
            baseUrl: "http://localhost:8080/image/showAnswer?filename=",
            currentAnswer: 1,
            showFeedback: "No",
            newFeedback: "",
            disapproveWarningVisible: false
        };
    },
    created(){
        console.log(123)
    },
    methods: {
        disapprove(index) {
            axios.delete("http://localhost:8080/answer/del", {
                data: this.answers[index]
            }).then(
                this.currentAnswer = 1
            )
            this.disapproveWarningVisible = false
        },
        approve(index) {
            let tempAnswer = this.answers[index]
            this.$set(tempAnswer, 'approved', true)
            this.$set(this.answers, index, tempAnswer)
            axios.post("http://localhost:8080/answer/save", this.answers[index])
        },
        submitFeedback(index) {
            let tempAnswer = this.answers[index]
            if (tempAnswer.feedback == null || tempAnswer.feedback === "") {
                this.$set(tempAnswer, 'feedback', '(1)' + this.newFeedback)
            } else {
                let previousFeedbacks = tempAnswer.feedback
                previousFeedbacks += '\n' + '(' + (previousFeedbacks.split('\n').length + 1) +')' +this.newFeedback
                this.$set(tempAnswer, 'feedback', previousFeedbacks)
            }
            this.$set(this.answers, index, tempAnswer)
            axios.post("http://localhost:8080/answer/save", this.answers[index])
            this.newFeedback = ""
        }
    }
}

</script>