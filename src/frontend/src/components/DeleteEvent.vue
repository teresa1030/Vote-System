<template>
  <div>
    <h2>活動列表</h2>
    <h3>{{msg}}</h3>
    <ul>
      <li v-for="event in events" :key="event.voteId">
        <h3>活動名稱：{{ event.voteTitle }} </h3>
        <p>內容： {{ event.content }}</p>
        <button @click="deleteEvent(event.voteId)">删除</button>
      </li>
    </ul>
  </div>


</template>

<script>
export default {
  name: 'DeleteEvent',
  data(){
    return {
      events: [],
      msg:''
    }
  },
  mounted() {
    this.fetchVotes();
  },
  methods:{
    fetchVotes(){
      fetch("/api/votes")
          .then((response) => response.json())
          .then((data) => {
            this.events = data;
          });
    },
    deleteEvent(voteId){
      console.log(voteId);
      fetch(`/api/votes/${voteId}`, {
        method: 'DELETE'
      })
          .then(response => {
            console.log('Status code:', response.status);
            if (!response.ok) {
              this.msg = '新增失敗請再試一次'
              throw new Error(response.status);
            }
            this.fetchVotes();  //更新書本列表
          })
          .catch(error => {
            console.error('Error deleting book:', error);
          });
    }
  }
}
</script>