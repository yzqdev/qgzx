<template>
  <div class="home">
    <el-table :data="tableData" fit>
      <el-table-column prop="id" label="ID"> </el-table-column>
      <el-table-column prop="title" label="标题"> </el-table-column>
      <el-table-column prop="subTitle" label="副标题"> </el-table-column>
      <el-table-column prop="content" label="内容" width="120">
      </el-table-column>
      <el-table-column label="操作">
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
    <el-dialog title="管理员信息"  v-model="showNoticeDialog">
      <el-form :model="notice" label-width="100px">
        <el-form-item label="标题"  >
          <el-input v-model="notice.title" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="副标题"  >
          <el-input v-model="notice.subTitle" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="内容" >
          <el-input v-model="notice.content" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <template #footer class="dialog-footer">
        <el-button @click="showNoticeDialog = false">取 消</el-button>
        <el-button type="primary" @click="updateDialogNotice"
          >确 定</el-button
        >
      </template>
    </el-dialog>
  </div>
</template>

<script>
import {deleteNoticeById, getAllNotices, updateNotice} from "@/utils/apis/notice";

export default {
  data() {
    return {
      tableData: [],
      pageNum: 1,
      showNoticeDialog: false,
      notice: {title: "这是标题",
        subTitle: "这是副标题",
        content: "这是正文",},
    };
  },
  created() {
    this.getNoticeList();
  },
  methods: {
    getNoticeList() {
      getAllNotices().then((data) => {
        this.tableData = data.data;
      });
    },
    editAdmin(row) {
      this.showNoticeDialog = true;
      console.log(row);
      this.notice = row;
    },
    updateDialogNotice(){
      updateNotice(this.notice).then((data ) => {
        if (data.success ) {
          this.$message.success({
            message:data.msg
          })
          this.getNoticeList()
          this.showNoticeDialog=false
        }
      })
    },
    deleteAdmin(row) {
      deleteNoticeById(row.id).then((data) => {
        if (data.success) {
          this.$message.success({ message: data.msg });
          this.getNoticeList();
        }
      });
    },
  },
};
</script>
