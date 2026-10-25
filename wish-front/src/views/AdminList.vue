<template>
  <div>
    <el-button @click="goHome" type="primary" plain icon="House">返回首页</el-button>
    <el-table :data="tableData" border style="margin-top:10px">
      <el-table-column prop="id" label="ID"/>
      <el-table-column prop="studentNo" label="学号"/>
      <el-table-column prop="username" label="学生账号"/>
      <el-table-column prop="wishContent" label="意愿原文"/>
      <el-table-column prop="aiClassifyResult" label="AI分类结果"/>
      <el-table-column prop="createTime" label="填报时间"/>
      <el-table-column label="操作">
        <template #default="scope">
          <el-button type="danger" @click="del(scope.row.id)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
        v-model:current-page="pageNum"
        :total="total"
        :page-size="10"
        layout="prev, pager, next"
        @change="loadData"
    ></el-pagination>
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
