<template>
  <div id="app">
    <router-view/>
  </div>
</template>

<style>
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  background-image: url("./assets/background.jpg");
  background-position-x: center;
  background-position-y: center;
  background-size: cover;
  min-height: 100vh;
  min-width: 100vw;
  overflow: hidden;
}

body {
  margin: 0;
}
</style>

<script>
export default {
  name: "App"
};
</script>
