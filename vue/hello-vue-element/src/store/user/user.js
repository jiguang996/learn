const User= {
   state:sessionStorage.getItem("userState") ? JSON.parse(sessionStorage.getItem("userState")) :{
    user:{
      username:"",
    }
  },

  getters:{
    getUser(state){
      return state.user;
    }
  },

  mutations:{
    updateUser(state,user){
      state.user=user;
    }
  },

  actions:{
    asyncUpdateUser(context,user ){
      context.commit('updateUser')
    }
  }
}
export  default User ;


