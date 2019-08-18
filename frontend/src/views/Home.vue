<template>
  <div id="home">
    <h3>Enter the username you want to search</h3>
      <v-btn-toggle v-model="platform">
          <v-btn text value="origin">
              PC
          </v-btn>
          <v-btn text value="psn">
              Playstation
          </v-btn>
          <v-btn text value="xbl">
              Xbox
          </v-btn>
      </v-btn-toggle>
    <v-text-field v-model="username" label="username"></v-text-field>
    <v-btn id="search-button" large color="darkred" v-on:click="search">Search</v-btn>
  </div>
</template>
<style scoped>
h3 {
  margin-bottom: 20px;
}
#home {
  background-color: white;
  width: 30%;
  height: 300px;
  padding: 80px;
  opacity: 0.8;
  position: absolute;
  margin: auto;
  top: 0;
  right: 0;
  bottom: 0;
  left: 0;
}
#search-button {
  background-color: darkred;
  font-weight: bold;
  color: white;
}

@media only screen and (max-width: 1200px) {
  #home {
    width: 50%;
  }
}

@media only screen and (max-width: 800px) {
  #home {
    width: 80%;
  }
}

@media only screen and (max-width: 400px) {
  #home {
    width: 100%;
  }
}
</style>
<script>
export default {
  data: function() {
    return {
      username: "",
        platform: 'origin'
    };
  },
  methods: {
    search() {
        this.$router.push({ path: `/search/${this.platform}/${this.username}` });
    }
  }
};
</script>
