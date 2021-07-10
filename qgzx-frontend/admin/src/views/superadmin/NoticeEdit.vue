<template>
  <div class="home">
    <el-form ref="form" :model="form" label-width="80px">
      <el-form-item label="标题">
        <el-input v-model="form.noticeTitle"></el-input> </el-form-item
      ><el-form-item label="副标题">
        <el-input v-model="form.subTitle"></el-input> </el-form-item
      ><el-form-item label="正文">
        <el-input v-model="form.content"></el-input>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="onSubmitNotice">添加</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script lang="ts">
// @ is an alias to /src
import { Vue, Component } from "vue-property-decorator";
@Component
export default class AdminEdit extends Vue {
  form = {
    noticeTitle: "",
    subTitle: "",
    content: "",
  };

  onSubmitNotice() {}
}
</script>
