<template>
  <div>
    <el-transfer
      v-model="value"
      :titles="['所有角色', '已有角色']"
      :props="{key: 'id',label: 'nickname'}"
      :data="data"></el-transfer>
    <el-row>
      <el-button type="success" size="small" style="float: right;margin-top: 20px;" @click="upRole">修改</el-button>
    </el-row>
  </div>
</template>

<script>
  import http from 'assets/js/http';
  import api from 'assets/js/api';

  export default {
    mixins: [http],
    props: ["id"],
    name: "AccountRoleAdd",
    components: {},
    data() {
      return {
        data: [],
        value: [],
      }
    },
    mounted: function () {
      this.getRoles();
      this.getRolesByAid();
    },
    methods: {
      getRoles() {
        this.apiGet(api.roleListAll)
          .then(resp => {
            this.data = resp.data;
          })
      },
      getRolesByAid() {
        this.apiGet(api.roleListByAid + "/" + this.id)
          .then(resp => {
            for (let i = 0; i < resp.data.length; i++) {
              this.value.push(resp.data[i].id);
            }
          })
      },
      upRole() {
        // if (this.value.length <= 0) return _g.message("error", "请添加角色！");
        let data = {
          aid: this.id,
          rids: this.value
        };
        this.apiPost(api.accountAddRole, data)
          .then(resp => {
            _g.notification("success", resp.msg);
            this.$emit('mClose');
          })
      }
    },
  }
</script>

<style scoped>

</style>
