<template>
  <div class="bg">
    <el-row style="width: 100px;float: right;margin-top: 20px;">
      <el-col :span="12">
      <span class="header-name icon-bt">
      {{user.realname}}
    </span>
      </el-col>
      <el-col :span="12">
        <i class="el-icon-switch-button icon-bt" @click="exit"></i>
      </el-col>
    </el-row>
  </div>
</template>

<script>
  import http from 'assets/js/http';
  import api from 'assets/js/api';

  export default {
    mixins: [http],
    name: "Header",
    components: {},
    data() {
      return {
        user: {
          realname: ""
        }
      }
    },
    mounted: function () {
      this.getUserInfo();
    },
    methods: {
      getUserInfo() {
        this.apiGet(api.userInfo)
          .then(resp => {
            let user = resp.data;
            this.user = user;
            store.dispatch('upUser', user);
          })
      },
      exit() {
        this.apiGet(api.logout)
          .then(resp => {
            _g.notification("success", resp.msg);
            store.dispatch('logout');
            _g.toPageByName('login');
          })
      }
    },
    filters: {}
  }
</script>

<style scoped>
  .header-name {
    color: #3a8ee6;
    font-size: 12px;
  }

  .icon-bt:hover {
    color: #3a8ee6;
    cursor: pointer;
  }

  .divider {
    height: 1px;
    background: #eee;
    margin-top: 10px;
    margin-bottom: 10px;
  }
</style>
