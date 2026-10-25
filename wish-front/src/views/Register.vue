<template>
  <div class="register-page">
    <div class="card">
      <h2 class="title">学生注册</h2>
      <p class="desc">填写信息，注册账号</p>
      <el-form ref="formRef" :model="form" label-width="100px">
        <el-form-item label="账号" prop="username">
          <el-input v-model="form.username"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password">
          <el-input v-model="form.password" type="password"></el-input>
        </el-form-item>
        <el-form-item label="确认密码" prop="repwd">
          <el-input v-model="form.repwd" type="password"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="submit">注册</el-button>
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
const form = ref({username:'',password:'',repwd:''})

const submit = async ()=>{
  if(form.value.password !== form.value.repwd){
    alert("两次密码不一致")
    return
  }
  const res = await axios.post('/user/register',form.value)
  if(res.data.code === 200){
    alert("注册成功，跳转登录页")
    router.push('/login')
  }else{
    alert(res.data.msg)
  }
}

const goHome = () => {
  router.push('/')
}
</script>

<style scoped>
.register-page {
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
