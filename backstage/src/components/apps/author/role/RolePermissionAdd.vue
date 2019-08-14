<template>
  <div>
    <el-transfer
      v-model="value"
      :titles="['所有权限', '已有权限']"
      :props="{key: 'id',label: 'name'}"
      :data="data"></el-transfer>
    <el-row>
      <el-button type="success" size="small" style="float: right;margin-top: 20px;" @click="upPermission">修改</el-button>
    </el-row>
  </div>
</template>

<script>
  import http from 'assets/js/http';
  import api from 'assets/js/api';

  export default {
    mixins: [http],
    props: ["id"],
    name: "RolePermissionAdd",
    components: {},
    data() {
      return {
        data: [],
        value: [],
      }
    },
    mounted: function () {
      this.getPermissions();
      this.getPermissionsByRid();
    },
    methods: {
      getPermissions() {
        this.apiGet(api.permissionListAll)
          .then(resp => {
            this.data = resp.data;
          })
      },
      getPermissionsByRid() {
        this.apiGet(api.permissionListByRid + "/" + this.id)
          .then(resp => {
            for (let i = 0; i < resp.data.length; i++) {
              this.value.push(resp.data[i].id);
            }
          })
      },
      upPermission() {
        let data = {
          rid: this.id,
          pids: this.value
        };
        this.apiPost(api.roleAddPermission, data)
          .then(resp => {
            _g.notification("success", resp.msg);
            this.$emit('mClose');
          })
      }
    }
  }
</script>

<style scoped>

</style>
