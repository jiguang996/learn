<template>
  <div>
    用户列表
    {{$route.params.id}}
  </div>
</template>

<script>
    export default {
        name: "List",
        beforeRouteEnter:(to,from,next)=>{
            console.log("页面进入前");
            next(vm => {
                vm.getData();
            });
        },
        beforeRouteLeave:(to,from,next)=>{
            console.log("页面离开");
            next();
        },
        methods: {
            getData: function () {
              this.axios({
                  type:'get',
                  url:"http://localhost:8080/static/data.json"
              }).then(response =>{
                  console.log(response);
              }).catch(error=>{
                  console.log(error);
              })
            }
        }
    }
</script>

<style scoped>

</style>
