<template>
  <div class="home">
    <h1>{{ id ? "修改" : "添加" }}工作</h1>
    <br />
    <el-form ref="form" :model="form" label-position="top" label-width="80px">
      <el-form-item label="标题">
        <el-input v-model="form.title"></el-input> </el-form-item
      ><el-form-item label="职位">
        <el-input v-model="form.name"></el-input> </el-form-item
      ><el-form-item label="单位地址">
        <el-input v-model="form.location"></el-input>
      </el-form-item>
      <el-form-item label="工作时间">
        <el-input v-model="form.worktime"></el-input> </el-form-item
      ><el-form-item label="发布时间">
        <el-date-picker
          v-model="form.time"
          align="right"
          type="datetime"
          placeholder="选择日期"
          :picker-options="pickerOptions"
        >
        </el-date-picker></el-form-item
      ><el-form-item label="工作地点">
        <el-input v-model="form.workplace"></el-input>
      </el-form-item>
      <el-form-item label="岗位性质">
        <el-select v-model="form.type" placeholder="请选择">
          <el-option
            v-for="item in options"
            :key="item.value"
            :label="item.label"
            :value="item.value"
          >
          </el-option> </el-select
      ></el-form-item>
      <el-form-item label="工作报酬">
        <el-input v-model="form.pay"></el-input> </el-form-item
      ><el-form-item label="截止时间">
        <el-date-picker
          v-model="form.deadline"
          align="right"
          type="date"
          placeholder="选择日期"
          :picker-options="pickerOptions"
        >
        </el-date-picker></el-form-item
      ><el-form-item label="性别">
        <el-input v-model="form.sex"></el-input> </el-form-item
      ><el-form-item label="招聘人数">
        <el-input v-model="form.hireNum"></el-input> </el-form-item
      ><el-form-item label="工作内容">
        <el-input v-model="form.content"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="addSchool">{{
          id ? "修改" : "添加"
        }}</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script lang="ts">
// @ is an alias to /src
import { Vue, Component, Prop } from "vue-property-decorator";
@Component
export default class JobEdit extends Vue {
  form = {};
  @Prop() private id?: String;
  pickerOptions = {
    disabledDate(time) {
      return time.getTime() > Date.now();
    },

    shortcuts: [
      {
        text: "今天",
        onClick(picker) {
          picker.$emit("pick", new Date());
        },
      },
      {
        text: "昨天",
        onClick(picker) {
          const date = new Date();
          date.setTime(date.getTime() - 3600 * 1000 * 24);
          picker.$emit("pick", date);
        },
      },
      {
        text: "一周前",
        onClick(picker) {
          const date = new Date();
          date.setTime(date.getTime() - 3600 * 1000 * 24 * 7);
          picker.$emit("pick", date);
        },
      },
    ],
  };
  options = [
    {
      value: "1",
      label: "固定",
    },
    {
      value: "0",
      label: "临时",
    },
  ];
  addSchool() {
    if (this.id) {
      this.$http.put("/updateJob", this.form).then((res) => {
        this.$message.success({
          message: res.data.message,
        });
        this.$router.push("/job/list");
      });
    } else {
      this.$http.post("/addJob", this.form).then((res) => {
        this.$message.success({
          message: res.data.message,
        });
        this.$router.push("/job/list");
      });
    }
  }
  getJobData() {
    this.$http.get("/getJobById/" + this.id).then((res) => {
      this.form = res.data.data;
    });
  }
  created() {
    this.id && this.getJobData();
  }
}
</script>
<style scoped>
.home {
  margin: 30px;
}
</style>
