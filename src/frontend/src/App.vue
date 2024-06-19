<template>
  <img alt="Vue logo" src="./assets/logo.png">
<!--  <HelloWorld msg="Welcome to Your Vue.js App"/>-->
  <h1><router-link :to="{ name: 'AllEvents' }">Home</router-link></h1>
  <h1><router-link :to="{ name: 'AddNewEvent' }">新增活動</router-link></h1>
  <h1><router-link :to="{ name: 'DeleteEvent' }">刪除活動</router-link></h1>

  <router-view></router-view>
</template>

<!--<script>-->
<!--import HelloWorld from './components/HelloWorld.vue'-->

<!--export default {-->
<!--  name: 'App',-->
<!--  components: {-->
<!--    HelloWorld-->
<!--  }-->
<!--}-->
<!--</script>-->

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
<script setup lang="ts">
</script>