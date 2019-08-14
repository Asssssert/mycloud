<template>
  <el-container>
    <el-aside width="200px">
      <router-view name="aside" style="height: 100%;"></router-view>
    </el-aside>
    <el-container>
      <el-header height="80px">
        <router-view name="header"></router-view>
      </el-header>
      <el-main>
        <router-view name="main"></router-view>
      </el-main>
      <el-footer>
        <router-view name="footer"></router-view>
      </el-footer>
    </el-container>
  </el-container>
</template>

<script>
  export default {
    name: "Home",
    components: {},
    data() {
      return {}
    },
    mounted: function () {
    },
    methods: {},
    filters: {}
  }
</script>

<style scoped>
  .el-footer {
    background-color: #B3C0D1;
    color: #333;
    text-align: center;
    line-height: 60px;
  }
</style>
