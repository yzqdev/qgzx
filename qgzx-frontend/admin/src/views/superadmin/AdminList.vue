<template>
  <div class="home">
    <el-row>
      <el-col :span="6">
        <el-select v-model="select" @change="getAdminList" placeholder="请选择">
          <el-option label="超级管理员" value="1"></el-option>
          <el-option label="普通管理员" value="0"></el-option> </el-select
      ></el-col>
      <el-col :span="12">
        <el-input
          placeholder="请输入内容"
          v-model="searchText"
          class="input-with-select"
        >
          <el-button slot="append" icon="el-icon-search"></el-button> </el-input
      ></el-col>
    </el-row>
    <br />
    <el-table :data="tableData" :fit="fit">
      <el-table-column prop="id" label="ID"> </el-table-column>
      <el-table-column prop="name" label="用户名"> </el-table-column>
      <el-table-column prop="pass" label="密码"> </el-table-column>
      <el-table-column prop="isSuper" label="管理员类型" :formatter="formatter">
      </el-table-column>
      <el-table-column label="操作" width="240">
        <template slot-scope="scope">
          <el-button @click="editAdmin(scope.row)" type="primary" size="small"
            >查看</el-button
          >
          <el-button type="danger" @click="deleteAdmin(scope.row)" size="small"
            >删除</el-button
          >
        </template>
      </el-table-column>
    </el-table>
    <el-dialog title="管理员信息" :visible.sync="showAdminInfo">
      <el-form :model="adminInfo">
        <el-form-item label="用户名" label-width="40">
          <el-input v-model="adminInfo.name" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="密码" label-width="40">
          <el-input v-model="adminInfo.pass" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="管理员类型" label-width="40">
          <el-input v-model="adminInfo.isSuper" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="showAdminInfo = false">取 消</el-button>
        <el-button type="primary" @click="submitEditAdmin">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script lang="ts">
// @ is an alias to /src
import { Vue, Component } from "vue-property-decorator";
@Component
export default class AdminList extends Vue {
  tableData = [];
  pageNum = 1;
  fit = true;
  searchText = "";
  select = "0";
  showAdminInfo = false;
  adminInfo = {};
  getAdminList() {
    this.$http.get(`/admin/getAllAdmins?isSuper=${this.select}`).then((res) => {
      console.log(res.data);
      this.tableData = res.data.data;
    });
  }
  formatter(row, column) {
    return row.isSuper == "0" ? "普通管理员" : "超级管理员";
  }
  submitEditAdmin() {
    this.$http.put("/admin/updateAdmin", this.adminInfo).then((res) => {
      console.log(res);
    });
    this.showAdminInfo = false;
  }
  editAdmin(row) {
    this.showAdminInfo = true;
    let _row = row;
    this.adminInfo = Object.assign({}, _row);
  }
  deleteAdmin(row) {
    console.log(row.id);
    this.$http.delete("/admin/deleteAdmin/" + row.id).then((res) => {
      this.getAdminList();
    });
  }
  created() {
    this.getAdminList();
  }
}
</script>
