<template>
  <div id="app">
    <img src="@/assets/logo.png" alt="Logo" class="logo" @click="this.$router.push({ path: '/' })">
    <Content class="index" />
  </div>
</template>

<script>
import Content from './template/ContentRoute.vue'


export default {
  name: 'App',
  components: { Content },
  watch: {
    $route(to) {
      document.title = to.meta.title || 'XPTO Manager';
    }
  },
  created() {
    document.title = this.$route.meta.title || 'XPTO Manager';
  }
}
</script>

<style>
body {
  z-index: 1000;
  position: relative;
  background-color: #050A24;
}

#app {
  position: fixed;
  width: 100%;
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
}

.logo {
  position: fixed;
  top: 0;
  left: 0;
  margin: 50px 0 0 50px;
}

.index {
  flex: 1;
}
</style>
