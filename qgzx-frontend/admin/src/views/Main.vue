<template>
  <div>
    <el-container style="height: 100vh; border: 1px solid #eee">
      <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
        <el-menu router default-active="1">
          <el-submenu index="1">
            <template #title><i class="el-icon-message"></i>操作</template>
            <el-menu-item-group>
              <template #title>管理员操作</template>
              <el-menu-item index="/admin/admin-create"
                >编辑管理员</el-menu-item
              >
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
            <template #title><i class="el-icon-message"></i>系统管理</template>
            <el-menu-item index="/user-manager">用户管理</el-menu-item>
            <el-menu-item index="/dictionary">字典管理</el-menu-item>
            <el-menu-item index="/resource-manager">资源管理</el-menu-item>
            <el-menu-item index="/auth-manager">权限管理</el-menu-item>
          </el-submenu>
        </el-menu>
      </el-aside>

      <el-container>
        <el-header>
          <el-dropdown style="text-align: right">
            <i class="el-icon-setting" style="margin-right: 15px"></i
            ><span>王小虎</span>
            <template #dropdown>
              <el-dropdown-menu>
                <el-dropdown-item>查看</el-dropdown-item>
                <el-dropdown-item>新增</el-dropdown-item>
                <el-dropdown-item>删除</el-dropdown-item>
              </el-dropdown-menu></template
            >
          </el-dropdown>
        </el-header>

        <el-main>
          <router-view></router-view>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>
<script></script>
<style scoped></style>
