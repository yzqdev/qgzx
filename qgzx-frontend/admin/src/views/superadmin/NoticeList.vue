<template>
  <div class="home">
    <el-table :data="tableData">
      <el-table-column prop="id" label="ID" width="140"> </el-table-column>
      <el-table-column prop="name" label="用户名" width="120">
      </el-table-column>
      <el-table-column prop="password" label="密码" width="120">
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
          <el-input v-model="adminInfo.password" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="学校" label-width="40">
          <el-input v-model="adminInfo.school" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="showAdminInfo = false">取 消</el-button>
        <el-button type="primary" @click="showAdminInfo = false"
          >确 定</el-button
        >
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
  showAdminInfo = false;
  adminInfo = {};
  getAdminList() {
    this.$http
      .get(`/superManager/getAllAcounts/${this.pageNum}`)
      .then((res) => {
        this.tableData = res.data.data.list;
      });
  }
  editAdmin(row) {
    this.showAdminInfo = true;
    console.log(row);
    this.adminInfo = row;
  }
  deleteAdmin(row) {
    this.$http.post("/superManager/deleteManager/" + row.id).then((res) => {
      console.log(res);
    });
  }
  created() {
    this.getAdminList();
  }
}
</script>
