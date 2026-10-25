<template>
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
