<template>
  <div class="home">
    <el-form ref="form" :model="form" label-width="80px">
      <el-form-item label="标题">
        <el-input v-model="form.title"></el-input>
      </el-form-item
      >
      <el-form-item label="副标题">
        <el-input v-model="form.subTitle"></el-input>
      </el-form-item
      >
      <el-form-item label="正文">
        <el-input v-model="form.content"></el-input>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="onSubmitNotice">添加</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>

export default {
  data() {
    return {
      form: {
        title: "这是标题",
        subTitle: "这是副标题",
        content: "这是正文",
      }
    }
  },methods:{
    onSubmitNotice(){
     this.$http.post("/addNotice",this.form).then(({data }) => {
       if (data) {
         this.$message.success({
           message:data.msg
         })
       }
     })
    }
  }

}
</script>
