<script setup>

</script>

<template>
  <h1>{{ vote.voteTitle }}</h1>
  <p>{{ vote.content }}</p>
  <img :src= "vote.imageUrl" class="imgSize" ><br>
  <router-link :to="{ name: 'UpdateEvent', params: { bookId: vote.bookId }}">更新活動資料</router-link>
</template>



<script>
export default {
  name: 'VoteEvent',
  data(){
    return {
      vote: [],
      voteId: this.$route.params.voteId
    }
  },
  mounted() {
    fetch("/api/votes/"+this.voteId)
        .then((response) => response.json())
        .then((data) => {
          this.vote = data;
          console.log(data);
        });

  }
}
</script>
<style scoped>
.imgSize {
  width: 300px;
  height: 150px;
}
</style>