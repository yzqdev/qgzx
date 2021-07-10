<template>
  <div></div>
</template>

<script lang="ts">
import { Vue, Component } from "vue-property-decorator";
@Component
export default class AuthManager extends Vue {
  name = "";

  mounted() {
    this.function();
  }
  function() {}
}
</script>

<style scoped></style>
