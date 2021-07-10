<template>
  <div class="home">
    <el-table :data="tableData" fit>
      <el-table-column prop="id" label="ID"  > </el-table-column>
      <el-table-column prop="title" label="标题"  >
      </el-table-column>
      <el-table-column prop="subTitle" label="副标题" >
      </el-table-column>   <el-table-column prop="content" label="内容" width="120">
      </el-table-column>
      <el-table-column label="操作"  >
        <template #default="scope">
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

<script>
export default {
  data() {
    return {
      tableData: [],
      pageNum: 1,
      showAdminInfo: false,
      adminInfo: {},
    };
  },
  created() {
    this.getAdminList();
  },
  methods: {
    getAdminList() {
      this.$http
        .get(`/getAllNotices`)
        .then((res) => {
          this.tableData = res.data.data;
        });
    },
    editAdmin(row) {
      this.showAdminInfo = true;
      console.log(row);
      this.adminInfo = row;
    },
    deleteAdmin(row) {
      this.$http.delete("/deleteNotice/" + row.id).then((res) => {
        console.log(res);
        if (res ) {
          this.$message.success({message:res.data.msg})
          this.getAdminList()
        }
      });
    },
  },
};
</script>
