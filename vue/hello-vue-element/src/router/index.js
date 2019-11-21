import Vue from 'vue'
import Router from 'vue-router'
import Login from "../views/Login"
import Main from '../views/Main'
import AddUser from "../views/user/Add";
import UserList from "../views/user/List";
import NotFound from "../views/404";

Vue.use(Router);
export default new Router({
  routes: [
    {
      // 登录页
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      // 首页
      path: '/main',
      name: 'Main',
      component: Main,
      children:[
        {name:'AddUser', path:'/user/add/:id', component:AddUser,props:true},
        {name:'UserList',path:'/user/list/:id',component:UserList}
      ]
    },
    {
      //404
      path:'*',
      component:NotFound
    }
  ]
});
