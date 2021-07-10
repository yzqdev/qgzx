<template>
  <div class="home">
    <el-table :data="jobTable" :fit="fit">
      <el-table-column prop="name" label="职位"> </el-table-column>
      <el-table-column prop="hireNum" label="招聘人数"> </el-table-column>
      <el-table-column prop="pay" label="薪酬"> </el-table-column>
      <el-table-column prop="workplace" label="工作地点"> </el-table-column>
      <el-table-column prop="deadline" label="截止日期"> </el-table-column>
      <el-table-column label="操作" width="240">
        <template slot-scope="scope">
          <el-button
            @click="editjob(scope.$index, scope.row)"
            type="primary"
            size="small"
            >查看</el-button
          >
          <el-button type="danger" @click="deletejob(scope.row)" size="small"
            >删除</el-button
          >
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script lang="ts">
// @ is an alias to /src
import { Vue, Component } from "vue-property-decorator";
@Component
export default class JobList extends Vue {
  jobTable = [];
  pageNum = 1;
  fit = true;
  showjobInfo = false;
  jobInfo = { address: "", province: "", name: "" };
  getjobList() {
    this.$http.get(`/getAllJobs`).then((res) => {
      this.jobTable = res.data.data;
    });
  }
  editjob(index, row) {
    this.$router.push(`/job/edit/${row.id}`);
  }

  deletejob(row) {
    this.$http.delete("/deleteJob/" + row.id).then((res) => {
      this.getjobList();
    });
  }
  submitjobInfo() {
    this.$http.put("/job/update", this.jobInfo).then((res) => {
      this.$message.success({ message: "更新成功" });
      this.showjobInfo = false;
    });
  }
  mounted() {
    this.getjobList();
  }
}
</script>
