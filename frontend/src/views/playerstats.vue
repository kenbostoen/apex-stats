<template>
  <div class="wrapper">
      <v-btn color="error" dark large v-on:click="toHome">Go back</v-btn>
      <div v-if="profileData" class="container">
          <h1 class="gamertag">
              <img :src="profileData.platformInfo.avatarUrl" alt class="platform-avatar" />
              {{profileData.platformInfo.platformUserId}}
          </h1>
          <div class="grid">
              <div>
                  <img :src="profileData.segments[1].metadata.imageUrl" alt />
              </div>
              <div>
                  <ul>
                      <li>
                          <h4>Selected Legend</h4>
                          <p>{{profileData.segments[1].metadata.name}}</p>
                      </li>
                      <li v-if="profileData.segments[0].stats.season2Wins">
                          <h4>Season 2 Wins</h4>
                          <p>
                              {{profileData.segments[0].stats.season2Wins.displayValue}}
                              <span>({{profileData.segments[0].stats.season2Wins.percentile}})</span>
                          </p>
                      </li>
                      <li v-if="profileData.segments[0].stats.level">
                          <h4>Apex Level</h4>
                          <p>
                              {{profileData.segments[0].stats.level.displayValue}}
                              <span>({{profileData.segments[0].stats.level.percentile}}%)</span>
                          </p>
                      </li>
                      <li v-if="profileData.segments[0].stats.kills">
                          <h4>Lifetime Kills</h4>
                          <p>
                              {{profileData.segments[0].stats.kills.displayValue}}
                              <span>({{profileData.segments[0].stats.kills.percentile}}%)</span>
                          </p>
                      </li>
                      <li v-if="profileData.segments[0].stats.damage">
                          <h4>Damage Done</h4>
                          <p>
                              {{profileData.segments[0].stats.damage.displayValue}}
                              <span>({{profileData.segments[0].stats.damage.percentile}}%)</span>
                          </p>
                      </li>
                  </ul>
              </div>
          </div>
      </div>
  </div>
</template>
<script>
export default {
  name: "playerstats",
    data: function() {
      return {
          profileData: null
      }
    },
    mounted() {
        axios
            .get('http://localhost:8081/api/player/stats/' + this.$route.params.platform + '/' + this.$route.params.playername)
            .then(response => {
                this.profileData = response.data;
            })
    },
    methods: {
        toHome() {
            this.$router.push({ path: '/' });
        }
    }
};
</script>
<style scoped>
    .wrapper {
        padding: 50px;
    }
    .container {
        background: rgba(0, 0, 0, 0.7);
        color: #fff;
        max-width: 700px;
        margin: 1rem auto;
        padding: 2rem 1.5rem;
        border-radius: 20px;
    }
    h1.gamertag {
        font-size: 2rem;
        padding: 0.3rem 0.5rem;
        text-align: center;
        margin-bottom: 3rem;
        display: flex;
        align-items: center;
    }
    a {
        display: inline-block;
        margin-top: 2rem;
        border: #fff 2px solid;
        padding: 0.5rem 0.8rem;
    }
    a:hover {
        border: #ccc 2px solid;
        color: #ccc;
    }
    .platform-avatar {
        width: 40px;
        margin-right: 0.7rem;
    }
    img {
        width: 100%;
    }
    .grid {
        display: grid;
        grid-template-columns: repeat(2, 1fr);
        grid-gap: 1rem;
    }
    li {
        padding: 1rem;
        margin-bottom: 0.7rem;
        border-radius: 10px;
        list-style: none;
        text-align: left;
    }
    li p {
        font-size: 2rem;
    }
    li:first-child p {
        font-size: 1.5rem;
    }
    li span {
        font-size: 1rem;
        color: #ccc;
    }
    @media (max-width: 500px) {
        h1 {
            font-size: 1.5rem;
            display: block;
            text-align: center;
        }
        .platform-avatar {
            display: none;
        }
        .grid {
            grid-template-columns: 1fr;
        }
        li p {
            font-size: 1.5rem;
        }
    }
</style>
