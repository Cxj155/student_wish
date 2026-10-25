<template>
  <div class="login-page">
    <div class="card">
      <h2 class="title">学生登录</h2>
      <p class="desc">请输入账号密码进行登录</p>
      <el-form ref="formRef" :model="form" label-width="100px">
        <el-form-item label="账号">
          <el-input v-model="form.username"></el-input>
        </el-form-item>
        <el-form-item label="密码">
          <el-input v-model="form.password" type="password"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="login">登录</el-button>
          <el-button @click="goHome" type="primary" plain icon="House">返回首页</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script setup>
import {ref} from 'vue'
import {useRouter} from 'vue-router'
import axios from 'axios'
const router = useRouter()
const form = ref({username:'',password:''})

const login = async ()=>{
  const res = await axios.post('/user/login',form.value)
  if(res.data.code === 200){
    localStorage.setItem('stuUser',form.value.username)
    alert("登录成功")
    router.push('/fill')
  }else{
    alert(res.data.msg)
  }
}

const goHome = () => {
  router.push('/')
}
</script>

<style scoped>
.login-page {
  min-height: 100vh;
  background: linear-gradient(135deg, #74b9ff 0%, #0984e3 100%);
  display: flex;
  justify-content: center;
  align-items: center;
}
.card {
  background: #fff;
  padding: 44px 52px;
  border-radius: 16px;
  box-shadow: 0 8px 28px rgba(0,0,0,0.12);
  width: 440px;
}
.title {
  font-size: 26px;
  color: #333;
  margin: 0 0 10px;
  text-align: center;
}
.desc {
  color: #666;
  font-size: 15px;
  text-align: center;
  margin-bottom: 32px;
}
</style>
