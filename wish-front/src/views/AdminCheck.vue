<template>
  <div class="admin-check-page">
    <div class="card">
      <h2 class="title">管理员验证</h2>
      <p class="desc">输入管理员密码，进入后台管理</p>
      <el-form :model="form" label-width="100px">
        <el-form-item label="管理员密码">
          <el-input v-model="form.adminPwd" type="password"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="danger" @click="verify">验证进入后台</el-button>
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

<style scoped>
.admin-check-page {
  min-height: 100vh;
  background: linear-gradient(135deg, #ff7675 0%, #d63031 100%);
  display: flex;
  justify-content: center;
  align-items: center;
}
.card {
  background: #ffffff;
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
