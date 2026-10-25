import { createRouter, createWebHistory } from 'vue-router'
import Home from '../views/Home.vue'
import StudentSelect from '../views/StudentSelect.vue'
import Register from '../views/Register.vue'
import Login from '../views/Login.vue'
import FillWish from '../views/FillWish.vue'
import AdminCheck from '../views/AdminCheck.vue'
import AdminList from '../views/AdminList.vue'

const routes = [
    {path:'/',component:Home},
    {path:'/student',component:StudentSelect},
    {path:'/register',component:Register},
    {path:'/login',component:Login},
    {path:'/fill',component:FillWish},
    {path:'/admin-check',component:AdminCheck},
    {path:'/admin-list',component:AdminList},

]
const router = createRouter({history:createWebHistory(),routes})
export default router
