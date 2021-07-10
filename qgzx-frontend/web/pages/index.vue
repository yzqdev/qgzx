<template>
  <v-layout column justify-center align-center>
    <v-flex xs12 sm8 md6>
      <div class="text-center">欢迎来到杨总的会场!</div>
      <v-card v-for="item in jobs" :key="item.id">
        <hr class="my-3"/>
        <v-card-title class="headline"> {{ item.title }}</v-card-title>
        <v-card-subtitle>发布时间:{{ item.time }}</v-card-subtitle>
        <v-card-text>
          <ul class="middle">
            <li>
              招聘职位：<span>{{ item.name }}</span>
            </li>
            <li>
              岗位性质：<span>{{ item.type }}</span>
            </li>
            <li>
              单位地址：<span>{{ item.location }}</span>
            </li>
            <li>
              工作时间：<span>{{ item.worktime }}</span>
            </li>
            <li>
              工作地点：<span>{{ item.workplace }}</span>
            </li>
            <li>
              工作报酬：<span>{{ item.pay }}</span>
            </li>

            <li>
              截止时间：<span>{{ item.deadline }}</span>
            </li>
            <li>
              性别要求：<span>{{ item.sex }}</span>
            </li>
            <li>
              工作内容：<span>{{ item.content }}</span>
            </li>
          </ul>
          <hr class="my-3"/>
          <p>
            <strong>备注:</strong
            ><br/>1:每位同学只能参加一份校内固定岗位,不得同时报名临时岗位;<br/>
            2:临时岗位可同时报名数个,但每月工资加起来不得超过400.00元.<br/>报名的同学请及时联系合肥工业大学勤工助学中心校内岗位部.电话:<a
            href="tel:0551-62901052"
          >0551-62901052</a
          >
            ;QQ:<a href="http://wpa.qq.com/msgrd?v=1&uin=1826814987"
          >1826814987</a
          >
          </p>
        </v-card-text>
        <v-card-actions>
          <v-spacer/>
          <v-btn color="primary" nuxt to="/inspire">
            参加
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-flex>
  </v-layout>
</template>

<script>
import Logo from "~/components/Logo.vue";
import VuetifyLogo from "~/components/VuetifyLogo.vue";

export default {
  components: {
    Logo,
    VuetifyLogo
  },
  async asyncData({$http}) {
    let {data} = await $http.$get(`/getAllJobs`);
    return {jobs: data};
  }
};
</script>
<style scoped>
.middle {
  list-style-type: none;
}
</style>
