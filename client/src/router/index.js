import Vue from 'vue'
import Router from 'vue-router'
import Student from '../components/Student'
import Search from '../components/Search'
import Delete from '../components/Delete'

Vue.use(Router)

export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name:'Student',
      component: Student
    },
    {
      path: '/Search',
      name:'Search',
      component: Search
    },
    {
      path: '/Delete',
      name:'Delete',
      component: Delete
    }
  ]
})