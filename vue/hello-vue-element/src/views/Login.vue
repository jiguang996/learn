<template>
    <div>
      <el-form ref="loginForm" :model="form" :rules="rules" label-width="80px" class="login-box">
        <h1 class="login-title">欢迎登录</h1>
        <el-form-item label="账号" prop="username">
          <el-input v-model="form.username"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password">
          <el-input  type="password" v-model="form.password"></el-input>
        </el-form-item>
        <el-form-item >
          <el-button type="primary" @click="login('loginForm')">登录</el-button>
        </el-form-item>

      </el-form>

    </div>
</template>

<script>
    export default {
        name: "Login.vue",
        data() {
            return{
                form:{
                    name:"登录",
                    username:'',
                    password:''
                },
                rules:{
                    username:[
                        {required:true,message:"账号不能为空",trigger:'blur'}
                    ],
                    password:[
                        {required:true,message:"密码不能为空",trigger:'blur'}
                    ]
                }
            }
        },
        methods:{
            login: function (formName) {
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        sessionStorage.setItem("isLogin","true");
                        this.$store.dispatch("asyncUpdateUser",form);
                        this.$router.push("/main");
                    } else {
                        this.$message.error('用户名或密码错误');
                        return false;
                    }
                });
            }
        }
    }
</script>

<style scoped>
  .login-title{
    text-align: center;
    color: red;
  }
.login-box{
  width: 400px;
  border: 1px solid #DCDFE6;
  margin: 0 auto;
  padding: 20px 50px 20px 20px;
  margin-top: 200px;
  border-radius: 3px;
  box-shadow: 0 0 1px;
}
</style>
