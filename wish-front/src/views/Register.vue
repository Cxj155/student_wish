<template>
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
