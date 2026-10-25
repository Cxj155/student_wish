<template>
  <div class="home">
    <el-button type="primary" size="large" @click="$router.push('/student')">学生意愿填报</el-button>
    <el-button type="danger" size="large" @click="$router.push('/admin-check')">管理员入口</el-button>
  </div>
</template>
<style scoped>
.home{
  display:flex;
  gap:30px;
  justify-content:center;
  align-items:center;
  height:100vh;
}
</style>
