<template>
  <div class="admin-list-page">
    <div class="container">
      <div class="header-bar">
        <h2 class="page-title">学生意愿管理后台</h2>
        <el-button @click="goHome" type="primary" plain icon="House">返回首页</el-button>
      </div>
      <el-table :data="tableData" border stripe style="width:100%;margin-top:16px">
        <el-table-column prop="id" label="ID" width="70"/>
        <el-table-column prop="studentNo" label="学号" width="120"/>
        <el-table-column prop="username" label="学生账号" width="120"/>
        <el-table-column prop="wishContent" label="意愿原文"/>
        <el-table-column prop="aiClassifyResult" label="AI分类结果" width="160"/>
        <el-table-column prop="createTime" label="填报时间" width="180"/>
        <el-table-column label="操作" width="100">
          <template #default="scope">
            <el-button type="danger" size="small" @click="del(scope.row.id)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
      <el-pagination
          v-model:current-page="pageNum"
          :total="total"
          :page-size="10"
          layout="prev, pager, next"
          @change="loadData"
          class="pagination-wrap"
      ></el-pagination>
    </div>
  </div>
</template>

<script setup>
import {ref,onMounted} from 'vue'
import {useRouter} from 'vue-router'
import axios from 'axios'
const router = useRouter()
const tableData = ref([])
const pageNum = ref(1)
const total = ref(0)

const loadData = async ()=>{
  const res = await axios.get(`/wish/page?pageNum=${pageNum.value}`)
  if(res.data.code===200){
    tableData.value = res.data.records
    total.value = res.data.total
  }
}
const del = async (id)=>{
  if(!confirm("确定删除？")) return
  await axios.delete(`/wish/${id}`)
  loadData()
}
const goHome = () => {
  router.push('/')
}
onMounted(()=>loadData())
</script>

<style scoped>
.admin-list-page {
  min-height: 100vh;
  background-color: #f4f7fa;
  padding: 32px;
  box-sizing: border-box;
}
.container {
  background: #fff;
  border-radius: 16px;
  box-shadow: 0 6px 24px rgba(0,0,0,0.08);
  padding: 28px;
}
.header-bar {
  display: flex;
  justify-content: space-between;
  align-items: center;
}
.page-title {
  font-size: 24px;
  color: #333;
  margin: 0;
}
.pagination-wrap {
  margin-top: 20px;
  text-align: right;
}
</style>
