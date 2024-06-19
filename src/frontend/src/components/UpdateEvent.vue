<template>
  <div class="add-event">
    <h2>編輯活動詳細資料</h2>
    <form @submit.prevent="updateEvent">
      <label for="title">活動名稱：</label>
      <input type="text" id="title" v-model="event.voteTitle" required>
      <br>
      <label for="author">活動內容：</label>
      <input type="text" id="author" v-model="event.content" required>
      <br>
      <label for="imageUrl">活動圖片 URL：</label>
      <input type="text" id="imageUrl" v-model="event.imageUrl" required>
      <br>
      <button type="submit">更新</button>
    </form>
  </div>
</template>



<script>
export default {
  name: 'UpdateEvent',
  data(){
    return {
      event: [],
      msg:''
    }
  },
  mounted() {
    const voteId = this.$route.params.voteId;
    this.fetchVote(voteId);
  },
  methods:{
    fetchVote(voteId){
      console.log(voteId);
      fetch(`/api/votes/${voteId}`)
          .then((response) => response.json())
          .then((data) => {
            console.log(data);
            this.event = data;
          });
    },
    updateEvent(){
      console.log(this.event.voteId);
      console.log(this.event);
      fetch(`/api/votes/${this.event.voteId}`, {
        method: 'PUT',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(this.event)
      })
          .then(response => {
            console.log('Status code:', response.status);
            if (!response.ok) {
              this.msg = '新增失敗請再試一次'
              throw new Error(response.status);
            }
            return response.json()
          })
          .then(data => {
            console.log('新增成功：', data);
            this.$router.push('/VoteEvent/'+data.voteId);
          })
          .catch(error => {
            console.error('Error deleting book:', error);
          });
    }
  }
}
</script>

<style scoped>
/* 组件样式 */
.add-event {
  max-width: 400px;
  margin: 0 auto;
}
form {
  display: flex;
  flex-direction: column;
}
label {
  margin-bottom: 0.5rem;
}
input, button {
  margin-bottom: 1rem;
  padding: 0.5rem;
}
button {
  background-color: #4CAF50;
  color: white;
  border: none;
  cursor: pointer;
}
button:hover {
  opacity: 0.8;
}
</style>