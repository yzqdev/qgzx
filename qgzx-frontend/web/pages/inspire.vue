<template>
  <v-layout>
    <v-flex class="text-center">
      <v-form ref="form" v-model="valid" lazy-validation>
        <v-text-field
          v-model="form.name"
          :counter="10"
          label="用户名"
          required
        ></v-text-field>
        <v-text-field v-model="form.email" label="邮箱" required></v-text-field>
        <v-text-field
          v-model="form.password"
          label="密码"
          required
        ></v-text-field>
        <v-text-field
          v-model="form.password2"
          label="确认密码"
          required
        ></v-text-field>

        <v-checkbox
          v-model="checkbox"
          :rules="[(v) => !!v || '您需要同意']"
          label="是否同意?"
          required
        ></v-checkbox>

        <v-btn @click="submit"> 提交 </v-btn>
      </v-form>
    </v-flex>
  </v-layout>
</template>
<script>
export default {
  data() {
    return {
      valid:true,
      form: {
        name: "",
        email: "",
        password: "",
        password2: "",
      },
      checkbox: false,
    };
  },
  methods: {
    submit() {
      console.log("...");
    },
  },
};
</script>
