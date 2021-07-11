<template>
  <div class="home">
    <el-row>
      <el-col :span="6">
        <el-select v-model="select" @change="getAdminList" placeholder="请选择">
          <el-option label="所有" value=""></el-option>
          <el-option label="超级管理员" value="1"></el-option>
          <el-option label="普通管理员" value="0"></el-option>
        </el-select
        >
      </el-col>
      <el-col :span="12">
        <el-input
            placeholder="请输入内容"
            v-model="searchText"
            class="input-with-select"
        >
          <el-button slot="append" icon="el-icon-search"></el-button>
        </el-input
        >
      </el-col>
    </el-row>
    <br/>
    <el-table :data="tableData" :fit="fit">
      <el-table-column prop="id" label="ID"></el-table-column>
      <el-table-column prop="name" label="用户名"></el-table-column>
      <el-table-column prop="pass" label="密码"></el-table-column>
      <el-table-column prop="isSuper" label="管理员类型" :formatter="formatter">
      </el-table-column>
      <el-table-column label="操作" width="240">
        <template #default="scope">
          <el-button @click="editAdmin(scope.row)" type="primary" size="small"
          >查看
          </el-button
          >
          <el-button type="danger" @click="deleteAdmin(scope.row)" size="small"
          >删除
          </el-button
          >
        </template>
      </el-table-column>
    </el-table>
    <el-dialog title="管理员信息" v-model="showAdminInfo">
      <el-form :model="adminInfoDialog" label-width="100px">
        <el-form-item label="用户名">
          <el-input v-model="adminInfoDialog.name" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="密  码">
          <el-input v-model="adminInfoDialog.pass" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="管理员类型">
          <el-select v-model="adminInfoDialog.isSuper" placeholder="请选择">
            <el-option label="超级管理员" value="1"></el-option>
            <el-option label="普通管理员" value="0"></el-option>
          </el-select>
        </el-form-item>
      </el-form>
      <template #footer class="dialog-footer">
        <el-button @click="showAdminInfo = false">取 消</el-button>
        <el-button type="primary" @click="submitEditAdmin">确 定</el-button>
      </template>
    </el-dialog>
  </div>
</template>

<script>
import {updateAdmin} from "@/utils/apis/admin";
import {delAdmin, getAllAdmin} from "@/utils/apis/admin";

export default {
  data() {
    return {
      tableData: [],
      pageNum: 1,
      fit: true,
      searchText: "",
      select: "",
      showAdminInfo: false,
      adminInfo: {
        name: "",
        pass: "",
        isSuper: "",
      }, adminInfoDialog: {
        name: "",
        pass: "",
        isSuper: "",
      },
    };
  },
  methods: {
    getAdminList() {
      getAllAdmin(this.select)
          .then((res) => {
            console.log(res.data);
            this.tableData = res.data.data;
          });
    },
    formatter(row, column) {
      return row.isSuper == "0" ? "普通管理员" : "超级管理员";
    },
    submitEditAdmin() {
      updateAdmin(this.adminInfoDialog).then(({data}) => {
        if (data.success) {
          this.$message.success({message: data.msg})
          this.getAdminList()
        }
      });
      this.showAdminInfo = false;
    },
    editAdmin(row) {
      this.showAdminInfo = true;
      let _row = row;
      this.adminInfoDialog = Object.assign({}, _row);
    },
    deleteAdmin(row) {
      console.log(row.id);
      delAdmin(row.id).then((res) => {
        this.getAdminList();
      });
    },
  },

  created() {
    this.getAdminList();
  },
};
</script>
