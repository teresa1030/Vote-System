<template>
  <h1>{{ vote.voteTitle }}</h1>
  <p>{{ vote.content }}</p>
  <img :src= "vote.imageUrl" class="imgSize" ><br>
  <h3>{{msg}}</h3>
  <router-link :to="{ name: 'UpdateEvent', params: { voteId: vote.voteId }}">更新活動資料</router-link>
  <ul>
    <li v-for="item in items" :key="item.itemId">
      <label>
        <input type="checkbox" v-model="selectedItems" :value="item.itemId">
        {{ item.itemTitle }} 票數: {{ item.votes }}
      </label>
    </li>
  </ul>
  <button @click="submitVotes">確定投票</button>

</template>



<script>
export default {
  name: 'VoteEvent',
  data(){
    return {
      vote: [],
      items: [],
      voteId: this.$route.params.voteId,
      selectedItems: [],
      msg: ''
    }
  },
  mounted() {
    const voteId = this.$route.params.voteId;
    this.fetchVote(voteId);

  },
  methods:{
    fetchVote(voteId){
      fetch("/api/votes/"+voteId)
          .then((response) => response.json())
          .then((data) => {
            this.vote = data;
            console.log(data);
          });
      fetch("/api/votes/"+voteId+"/items")
          .then((response) => response.json())
          .then((data) => {
            this.items = data;
            console.log(data);
          });
    },
    submitVotes(){
      console.log(this.selectedItems);
      fetch(`/api/votes/${this.vote.voteId}/items`, {
        method: 'PUT',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(this.selectedItems)
      })
          .then(response => {
            console.log('Status code:', response.status);
            if (!response.ok) {
              this.msg = '投票失敗'
              throw new Error(response.status);
            }
            return response.json()
          })
          .then(data => {
            console.log('投票成功：', data);
            // this.$router.push('/VoteEvent/'+this.vote.voteId);
            this.selectedItems = [];
            this.fetchVote(this.vote.voteId);
          })
          .catch(error => {
            console.error('Error deleting book:', error);
          });
    }
  }
}
</script>
<style scoped>
.imgSize {
  width: 300px;
  height: 150px;
}
</style>