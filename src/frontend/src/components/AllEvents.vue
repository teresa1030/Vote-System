

<template>
  <div v-for="event in events" :key="event.voteId">
    <h1>{{ event.voteId }}</h1>
<!--    <router-link :to="{ name: 'BookItem', params: { bookId: item.bookId }}">{{ item.title }}</router-link>-->
    <h1>{{ event.voteTitle }}</h1>
    <h3>{{ event.content }}</h3>
    <router-link :to="{ name: 'VoteEvent', params: { voteId: event.voteId }}">{{ event.voteTitle }}</router-link>


  </div>
</template>

<script>
export default {
  name: 'AllEvents',
  data(){
    return {
      events: []
    }
  },
  mounted() {
    fetch("/api/votes")
        .then((response) => response.json())
        .then((data) => {
          //this.msg = [data];
          this.events = data;
          console.log(data);
          console.log(this.events.title);
        });

  }
}
</script>


<!--<style scoped>-->

<!--.imgSize {-->
<!--  width: 300px;-->
<!--  height: 150px;-->
<!--}-->

<!--</style>-->