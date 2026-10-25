<template>
  <div class="home">
    <div class="card">
      <h2 class="title">学生意愿AI分类系统</h2>
      <p class="desc">请选择进入对应通道</p>
      <div class="btn-group">
        <el-button type="primary" size="large" @click="$router.push('/student')">学生意愿填报</el-button>
        <el-button type="danger" size="large" @click="$router.push('/admin-check')">管理员入口</el-button>
      </div>
    </div>
  </div>
</template>

<style scoped>
.home {
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
  gap: 24px;
  justify-content: center;
}
</style>
