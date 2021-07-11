<template>
  <div class="home">
    <el-form ref="form" :model="form" label-width="80px" label-position="top">
      <el-form-item label="管理员账号">
        <el-input v-model="form.name"></el-input> </el-form-item
      ><el-form-item label="管理员密码">
        <el-input v-model="form.pass"></el-input> </el-form-item
      ><el-form-item label="管理员确认密码">
        <el-input v-model="form.confirmPass"></el-input>
      </el-form-item>
      <el-form-item label="选择管理员类型">
        <el-select v-model="form.isSuper" placeholder="请选择管理员类型">
          <el-option
            v-for="(item, index) of adminType"
            :key="item + index"
            :label="item.label"
            :value="item.value"
          ></el-option>
        </el-select>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="onSubmit">添加</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import {adminReg} from "@/utils/apis/admin";

export default {
  data() {
    return {
      form: {
        name: "yzq",
        pass: "123456",
        confirmPass: "123456",
        isSuper: "1",
      },
      adminType: [
        {
          value: "0",
          label: "普通管理员",
        },
        {
          value: "1",
          label: "超级管理员",
        },
      ],
    };
  },

  methods: {
    onSubmit() {
      adminReg(  this.form).then((res) => {
        if (res.data.success) {
          this.$message.success({ message: "成功" });
          this.$router.push("/admin/list");
        }
      });
    },
  },
};
</script>
