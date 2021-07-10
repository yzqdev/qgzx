<template>
  <div class="home">
    <h1>考研时间管理</h1>
    <el-form ref="form" :model="form" label-position="top" label-width="80px">
      <el-form-item label="报名开始前">
        <el-date-picker
          type="date"
          placeholder="选择日期"
          format="yyyy 年 MM 月 dd 日"
          value-format="yyyy-MM-dd"
          v-model="form.date1"
          style="width: 100%;"
        ></el-date-picker> </el-form-item
      ><el-form-item label="报名开始">
        <el-date-picker
          type="date"
          placeholder="选择日期"
          v-model="form.date2"
          format="yyyy 年 MM 月 dd 日"
          value-format="yyyy-MM-dd"
          style="width: 100%;"
        ></el-date-picker> </el-form-item
      ><el-form-item label="打印准考证">
        <el-date-picker
          type="date"
          placeholder="选择日期"
          v-model="form.date3"
          format="yyyy 年 MM 月 dd 日"
          value-format="yyyy-MM-dd"
          style="width: 100%;"
        ></el-date-picker> </el-form-item
      ><el-form-item label="开始考试">
        <el-date-picker
          type="date"
          placeholder="选择日期"
          v-model="form.date4"
          format="yyyy 年 MM 月 dd 日"
          value-format="yyyy-MM-dd"
          style="width: 100%;"
        ></el-date-picker> </el-form-item
      ><el-form-item label="报名结束">
        <el-date-picker
          type="date"
          placeholder="选择日期"
          v-model="form.date5"
          format="yyyy 年 MM 月 dd 日"
          value-format="yyyy-MM-dd"
          style="width: 100%;"
        ></el-date-picker>
      </el-form-item>
    </el-form>
    <el-button type="primary" @click="submitDate">提交</el-button>
  </div>
</template>

<script lang="ts">
// @ is an alias to /src
import { Vue, Component } from "vue-property-decorator";
@Component
export default class TimeInfo extends Vue {
  form = {
    date1: "",
    date2: "",
    date3: "",
    date4: "",
    date5: "",
  };
  submitDate() {
    let data = {
      "1": this.form.date1,
      "2": this.form.date2,
      "3": this.form.date3,
      "4": this.form.date4,
      "5": this.form.date5,
    };
    this.$http.put("/superManager/updateTime", data).then((res) => {
      console.log(res);
    });
  }
  created() {}
}
</script>
