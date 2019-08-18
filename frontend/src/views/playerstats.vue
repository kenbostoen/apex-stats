<template>
  <div class="about">
    <h1>Searched</h1>
    <router-link to="/">Go back</router-link>
  </div>
</template>
<script>
export default {
  name: "playerstats",
    data: function() {
      return {
        stats: null
      }
    },
    created() {
        console.log('test');
    },
    mounted() {
        axios
            .get('http://localhost:8081/api/player/stats/keniboy20')
            .then(response => {
                this.stats = response;
                console.log(response);
            })
    }
};
</script>
