<template>
    <div :stype="{'width':'50%'}">
        <el-form ref="loginForm" :model="form" :rules="rules" label-position="top">
            <h3 :style="{'font-size':'35px','font-weight':'bold'}">Teacher Login</h3>
            <el-form-item label="Account" prop="username" :style="{'font-size':'35px','font-weight':'bold'}">
                <el-input type="text" placeholder="Please enter the account" v-model="form.username" :stype="{'width':'50%'}"/>
            </el-form-item>
            <el-form-item label="Password" prop="password" :style="{'font-size':'35px','font-weight':'bold'}">
                <el-input type="password" placeholder="Please enter the password" v-model="form.password" :stype="{'width':'50%'}"/>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" v-on:click="onSubmit()">login</el-button>
                <el-button type="warning" v-on:click="goBack()">Back</el-button>
            </el-form-item>
        </el-form>
    </div>  
</template>
<script>
import axios from "axios";
export default {
    name: "TeacherLogin",
    data() {
        return {
            form: {
                username: "",
                password: ""
            },
            //表单验证，需要在el-form-item元素中添加prop属性
            rules: {
                username: [
                    {required: true, message: "Account can't be empty", trigger: "blur"}
                ],
                password: [{required: true,message: "Password can't be empty", trigger: "blur"}]
            }
        };
    },
    methods: {
        onSubmit() {
            //this.$router.push({name:"Home",params:{"teacher":true}});   
            //为表单绑定验证功能
            axios.post("http://localhost:8080/teacher/find",{
                username:this.form.username,
                password:this.form.password
            },{
                headers:{"Content-Type": 'application/json;charset=UTF-8',}
            })
                .then(response => {
                    if(response.data){
                        this.$router.push({name:"Home",params:{"teacher":true}});
                    }else{
                        alert("Account or Password is wrong")
                    }
                })
                .catch(error=> {
                    console.log(error);
                });
        },
        goBack(){
            this.$router.push({name:"Home",params:{"teacher":false}});
        }
    }
};
</script>