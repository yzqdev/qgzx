import Vue from "vue";
import VueRouter, { RouteConfig } from "vue-router";
import Main from "../views/Main.vue";
import AdminEdit from "@/views/superadmin/AdminEdit.vue";
import AdminList from "@/views/superadmin/AdminList.vue";
import NoticeEdit from "@/views/superadmin/NoticeEdit.vue";
import NoticeList from "@/views/superadmin/NoticeList.vue";
import TimeInfo from "@/views/superadmin/TimeInfo.vue";
import JobEdit from "@/views/superadmin/JobEdit.vue";
import JobList from "@/views/superadmin/JobList.vue";

import AuthManager from "@/views/systemManager/AuthManager.vue";
import ResourceManager from "@/views/systemManager/ResourceManager.vue";
import UserManager from "@/views/systemManager/UserManager.vue";
import Dictionary from "@/views/systemManager/Dictionary.vue";
// import SystemConstants from "@/views/systemOperation/SystemConstants.vue";
import Login from "@/views/Login.vue";
Vue.use(VueRouter);

const routes: Array<RouteConfig> = [
  {
    path: "*",
    redirect: "/404",
  },
  { path: "/login", component: Login },
  {
    path: "/",
    name: "Home",
    component: Main,
    children: [
      { path: "/admin/create", component: AdminEdit },
      { path: "/admin/edit/:id", component: AdminEdit, props: true },
      { path: "/admin/list", component: AdminList },
      { path: "/notice/create", component: NoticeEdit },
      { path: "/notice/edit/:id", component: NoticeEdit, props: true },
      { path: "/notice/list", component: NoticeList },
      { path: "/job/list", component: JobList },
      { path: "/job/create", component: JobEdit },
      { path: "/job/edit/:id", component: JobEdit, props: true },
      {
        path: "/auth-manager",
        component: AuthManager,
        meta: { title: "权限管理" },
      },
      {
        path: "/resource-manager",
        component: ResourceManager,
        meta: { title: "资源管理" },
      },
      {
        path: "/user-manager",
        component: UserManager,
        meta: { title: "用户管理" },
      },
      {
        path: "/dictionary",
        component: Dictionary,
        meta: { title: "系统字典" },
      },
    ],
  },
];

const router = new VueRouter({
  routes,
});

export default router;
