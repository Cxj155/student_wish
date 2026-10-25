<template>
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
