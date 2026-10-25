<template>
  <div class="student-page">
    <div class="card">
      <h2 class="title">学生通道</h2>
      <p class="desc">选择注册或者登录，进入意愿填报</p>
      <div class="btn-group">
        <el-button type="primary" size="large" @click="$router.push('/register')">新用户注册</el-button>
        <el-button type="success" size="large" @click="$router.push('/login')">已注册去登录</el-button>
        <el-button @click="goHome" type="primary" plain icon="House">返回首页</el-button>
      </div>
    </div>
  </div>
</template>

<script setup>
import { useRouter } from 'vue-router'
const router = useRouter()
const goHome = () => {
  router.push('/')
}
</script>

<style scoped>
.student-page {
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
  text-align: center;
}
.title {
  font-size: 26px;
  color: #333;
  margin: 0 0 10px;
}
.desc {
  color: #666;
  font-size: 15px;
  margin-bottom: 32px;
}
.btn-group {
  display: flex;
  gap: 20px;
  justify-content: center;
  flex-wrap: wrap;
}
</style>
