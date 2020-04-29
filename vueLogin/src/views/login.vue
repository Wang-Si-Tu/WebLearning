<template>
  <div class="login">
    <div>
      <el-input placeholder="请输入用户名" v-model="account" clearable class="input_style"></el-input>
<!--      <span v-if="error" class="err-msg">用户名或密码错误</span>-->
    </div>
    <div>
      <el-input placeholder="请输入密码" v-model="password" show-password class="input_style"></el-input>
    </div>
    <div>
      <el-button type="primary" @click="login" class="login_style" v-loading.fullscreen.lock="fullscreenLoading">登录</el-button>
    </div>
  </div>
</template>

<script>
  export default {
    name: "login",
    data(){
      return {
        account: '',
        password : '',
        fullscreenLoading: false
      }
    },
    methods:{
      login(){
        //console.log(this.account+" "+this.password)
        this.fullscreenLoading = true;
        setTimeout(() => {
          this.fullscreenLoading = false;
        }, 1000);
        this.$axios.post("/login",{
          account:this.account,
          password:this.password
        })
        .then(response=>{
          if(response.data=="Success") {
            this.$message({message:"登录成功",type:"success",showClose:true});
            this.$router.push({path:'/mainInterface'});
          }
          if(response.data=="Fail") this.$message({message:"用户名或密码错误",type:"error",showClose:true});
          // else this.$message({message:"后端未部署或网络异常",type:"error",showClose:true});
        })
        .catch(error=>{
          this.$message({message:"后端未部署或网络异常",type:"error",showClose:true});
        })
        // this.$message.error("")
        // this.$alert('<el-alert title="success alert" type="success"></el-alert>')
      }
    }
  }
</script>

<style scoped>
  .login{
    margin-top: 200px;
  }
  .input_style{
    width: 200px;
    margin-bottom: 10px;
  }
  .login_style{
    width: 200px;
  }
</style>
