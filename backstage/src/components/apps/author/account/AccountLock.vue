<template>
  <div style="text-align: center">
    <el-row>
      <el-switch
        v-model="lock"
        active-color="#ff4949"
        active-text="禁用"
        inactive-text="启用"
        active-value="1"
        inactive-value="0"
        inactive-color="#13ce66">
      </el-switch>
    </el-row>
    <el-row>
      <el-button type="success" size="small" style="float: right;" @click="upLock">修改</el-button>
    </el-row>
  </div>
</template>

<script>
  import http from 'assets/js/http';
  import api from 'assets/js/api';

  export default {
    mixins: [http],
    props: ["ids"],
    name: "AccountLock",
    components: {},
    data() {
      return {
        lock: 0,
      }
    },
    mounted: function () {
    },
    methods: {
      upLock() {
        this.apiPatch(api.accountLock + "/" + [this.ids], {lock: this.lock})
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
