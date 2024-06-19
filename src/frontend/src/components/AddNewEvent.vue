<template>
  <h1>增加活動</h1>
  <h3>{{msg}}</h3>
  <div class="add-event">
    <form @submit.prevent="addEvent">
      <label for="title">活動名稱：</label>
      <input type="text" id="title" v-model="newEvent.voteTitle" required>

      <label for="author">活動內容：</label>
      <input type="text" id="author" v-model="newEvent.content" required>

      <label for="imageUrl">活動圖片 URL：</label>
      <input type="text" id="imageUrl" v-model="newEvent.imageUrl" required>

      <button type="submit">新增活動</button>
    </form>
  </div>

</template>

<script>
export default {
  name: 'AddNewEvent',
  data(){
    return {
      newEvent: {
        voteTitle: '',
        imageUrl: '',
        content:''
      },
      msg:''
    }
  },
  methods:{
    addEvent(){
      console.log('add new event：', this.newEvent);
      fetch('/api/votes', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(this.newEvent)
      })
          .then(response =>{
            console.log('Status code:', response.status);
            if(!response.ok){
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
            console.error('新增失败：', error);
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