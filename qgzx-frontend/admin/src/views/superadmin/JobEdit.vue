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
          type="date"
          placeholder="选择日期"
          :picker-options="pickerOptions"
        >
        </el-date-picker></el-form-item
      ><el-form-item label="性别">
        <el-select v-model="form.sex">
          <el-option label="男" value="0"></el-option>
          <el-option label="女" value="1"></el-option>
        </el-select> </el-form-item
      ><el-form-item label="招聘人数">
        <el-input v-model="form.hireNum"></el-input> </el-form-item
      ><el-form-item label="工作内容">
        <el-input v-model="form.content"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="addJob">{{
          id ? "修改" : "添加"
        }}</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import { addJob, getJobById, updateJob } from "@/utils/apis/jobs";

export default {
  data() {
    return {
      form: {
        title: "这是标题",
        name: "这是名字",
        location: "地址",
        worktime: "工作室就",
        time: new Date(),
        workplace: "啊啊啊",
        type: "1",
        pay: "啊啊啊",
        deadline: new Date(),
        sex: "1",
        hireNum: 34,
        content: "这是工作内容",
      },
      options: [
        {
          value: "1",
          label: "固定",
        },
        {
          value: "0",
          label: "临时",
        },
      ],
      pickerOptions: {
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
      },
    };
  },
  props: {
    id: { type: String },
  },

  methods: {
    addJob() {
      if (this.id) {
        updateJob(this.form).then((data) => {
          this.$message.success({
            message: data.msg,
          });
          this.$router.push("/job/list");
        });
      } else {
        addJob(this.form).then((data) => {
          this.$message.success({
            message: data.msg,
          });
          this.$router.push("/job/list");
        });
      }
    },
    getJobData() {
      getJobById(this.id).then((data) => {
        this.form =  data.data;
      });
    },
  },
  created() {
    if (this.id) {
      this.getJobData();
    }
  },
};
</script>
<style scoped>
.home {
  width: 100%;
  margin: 30px;
}
</style>
