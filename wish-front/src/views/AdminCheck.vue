<template>
  <el-form :model="form" label-width="100px">
    <el-form-item label="管理员密码">
      <el-input v-model="form.adminPwd" type="password"></el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="danger" @click="verify">验证进入后台</el-button>
      <el-button @click="goHome" type="primary" plain icon="House">返回首页</el-button>
    </el-form-item>
  </el-form>
</template>

<script setup>
import {ref} from 'vue'
import {useRouter} from 'vue-router'
import axios from 'axios'
const router = useRouter()
const form = ref({adminPwd:''})

const verify = async ()=>{
  const res = await axios.post('/admin/verify',form.value)
  if(res.data.code ===200){
    localStorage.setItem('adminOk','yes')
    router.push('/admin-list')
  }else{
    alert(res.data.msg)
  }
}

const goHome = () => {
  router.push('/')
}
</script>
