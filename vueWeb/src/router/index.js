import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../components/HomeView'
import QuizPage from '../components/QuizPage'
import TeacherLogin from '../components/TeacherLogin'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: HomeView,
    props: true,
    children: [{
      path: "/quizpage1",
      name: 'QuizPage1',
      component: QuizPage,
      props: true,
    }, {
      path: "/quizpage2",
      name: 'QuizPage2',
      component: QuizPage,
      props: true,
    }]
  }, {
    path: '/teacherLogin',
    name: 'TeacherLogin',
    component: TeacherLogin
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
