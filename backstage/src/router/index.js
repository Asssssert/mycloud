import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);
//布局
const Home = resolve => require(['@/components/Home'], resolve);
const Aside = resolve => require(['@/components/common/Aside'], resolve);
const Footer = resolve => require(['@/components/common/Footer'], resolve);
const Header = resolve => require(['@/components/common/Header'], resolve);
const Main = resolve => require(['@/components/common/Main'], resolve);
//登录
const Login = resolve => require(['@/components/account/Login'], resolve);//登录
const ForgetPWD = resolve => require(['@/components/account/ForgetPWD'], resolve);//密码找回
//主页
const Sheet = resolve => require(['@/components/apps/Sheet'], resolve);//主页
const AccountManage = resolve => require(['@/components/apps/author/account/AccountManage'], resolve);//用户管理
const RoleManage = resolve => require(['@/components/apps/author/role/RoleManage'], resolve);//角色管理
const PermissionManage = resolve => require(['@/components/apps/author/permission/PermissionManage'], resolve);//权限管理
const PermissionChildManage = resolve => require(['@/components/apps/author/permission/PermissionChildManage'], resolve);//子权限列表
export default new Router({
  routes: [
    {path: '/', redirect: 'login'},
    {path: '/login', name: 'login', component: Login},
    {path: '/forgetPWD', name: 'forgetPWD', component: ForgetPWD},
    {
      path: 'home', name: 'home', component: Home, children: [
        {
          path: '/index',
          name: 'index',
          components: {
            header: Header,
            aside: Aside,
            footer: Footer,
            main: Main,
          },
          children: [
            {path: "sheet", name: 'sheet', component: Sheet},
            {path: "accountManage", name: 'accountManage', component: AccountManage},
            {path: "roleManage", name: 'roleManage', component: RoleManage},
            {path: "permissionManage", name: 'permissionManage', component: PermissionManage},
            {path: "permissionChildManage", name: 'permissionChildManage', component: PermissionChildManage},
          ]
        }
      ]
    }
  ]
})
