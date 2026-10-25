<template>
  <div class="wrap">
    <el-button type="primary" @click="$router.push('/register')">新用户注册</el-button>
    <el-button type="success" @click="$router.push('/login')">已注册去登录</el-button>
    <el-button @click="goHome" type="primary" plain icon="House">返回首页</el-button>
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
.wrap{
  display:flex;
  gap:30px;
  justify-content:center;
  align-items:center;
  height:100vh;
}
</style>
