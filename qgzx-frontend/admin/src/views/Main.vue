<template>
  <div>
    <el-container style="height: 100vh; border: 1px solid #eee">
      <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
        <el-menu router default-active="1">
          <el-submenu index="1">
            <template slot="title"
              ><i class="el-icon-message"></i>操作</template
            >
            <el-menu-item-group>
              <template slot="title">管理员操作</template>
              <el-menu-item index="/admin/create">编辑管理员</el-menu-item>
              <el-menu-item index="/admin/list">管理员列表</el-menu-item>
            </el-menu-item-group>

            <el-menu-item-group title="公告管理">
              <el-menu-item index="/notice/create">公告编辑</el-menu-item>
              <el-menu-item index="/notice/list">公告列表</el-menu-item>
            </el-menu-item-group>
            <el-menu-item-group title="职位管理">
              <el-menu-item index="/job/create">职位编辑</el-menu-item>
              <el-menu-item index="/job/list">职位列表</el-menu-item>
            </el-menu-item-group>
          </el-submenu>
          <el-submenu index="2">
            <template slot="title"
              ><i class="el-icon-message"></i>系统管理</template
            >
            <el-menu-item index="/user-manager">用户管理</el-menu-item>
            <el-menu-item index="/dictionary">字典管理</el-menu-item>
            <el-menu-item index="/resource-manager">资源管理</el-menu-item>
            <el-menu-item index="/auth-manager">权限管理</el-menu-item>
          </el-submenu>
        </el-menu>
      </el-aside>

      <el-container>
        <el-header style="text-align: right; font-size: 12px">
          <el-dropdown>
            <i class="el-icon-setting" style="margin-right: 15px"></i>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item>查看</el-dropdown-item>
              <el-dropdown-item>新增</el-dropdown-item>
              <el-dropdown-item>删除</el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
          <span>王小虎</span>
        </el-header>

        <el-main>
          <router-view></router-view>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>
<script lang="ts">
import { Vue, Component } from "vue-property-decorator";
@Component
export default class Main extends Vue {}
</script>
<style scoped></style>
