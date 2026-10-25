<template>
  <div class="fill-page">
    <div class="card">
      <h2 class="title">学生意愿填报</h2>
      <p class="desc">填写信息提交，AI自动完成意愿分类</p>
      <el-form :model="form" label-width="100px">
        <el-form-item label="学号">
          <el-input v-model="form.studentNo"></el-input>
        </el-form-item>
        <el-form-item label="你的意愿">
          <el-input v-model="form.wishContent" type="textarea" rows="6"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="submit">提交意愿，AI自动分类</el-button>
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
const form = ref({
  studentNo:'',
  wishContent:'',
  username:localStorage.getItem('stuUser')
})

const submit = async ()=>{
  const res = await axios.post('/wish/submit',form.value)
  if(res.data.code ===200){
    alert(res.data.msg + "\nAI分类结果："+res.data.classify)
  }else{
    alert("提交失败")
  }
}

const goHome = () => {
  router.push('/')
}
</script>

<style scoped>
.fill-page {
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
  width: 520px;
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
