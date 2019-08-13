<template>
  <el-row>
    <el-card>
      <div slot="header" class="header-title">用户列表</div>
      <div>
        <el-row></el-row>
        <el-row>
          <el-table
            size="small"
            :data="table.data"
            :stripe="true"
            @selection-change="selectionChange"
            style="width: 100%;"
            v-loading="table.loading">
            <el-table-column
              type="selection"
              width="55">
            </el-table-column>
            <el-table-column prop="id"
                             align="center"
                             width="50"
                             label="ID"></el-table-column>
            <el-table-column prop="account"
                             align="center"
                             label="用户名"></el-table-column>
            <el-table-column prop="nickname"
                             align="center"
                             label="昵称"></el-table-column>
            <el-table-column prop="realname"
                             align="center"
                             label="真实姓名"></el-table-column>
            <el-table-column prop="sex"
                             align="center"
                             :formatter="sex"
                             label="性别"></el-table-column>
            <el-table-column prop="email"
                             align="center"
                             label="邮箱"></el-table-column>
            <el-table-column prop="phone"
                             align="center"
                             label="手机"></el-table-column>
            <el-table-column prop="create_time"
                             align="center"
                             label="创建时间"></el-table-column>
            <el-table-column prop="lock"
                             align="center"
                             :formatter="lock"
                             label="账号状态"></el-table-column>
          </el-table>
        </el-row>
        <el-row>
          <el-pagination
            style="text-align: center;margin-top: 15px;"
            @size-change="handleSizeChange"
            @current-change="handleCurrentChange"
            :current-page="currentPage"
            :page-sizes="[10, 20]"
            :page-size="pageSize"
            layout="total, sizes, prev, pager, next, jumper"
            size-change="sizeChange"
            :total="total">
          </el-pagination>
        </el-row>
      </div>
    </el-card>
  </el-row>
</template>

<script>
  import http from 'assets/js/http';
  import api from 'assets/js/api';

  export default {
    mixins: [http],
    name: "AccountManage",
    components: {},
    data() {
      return {
        table: {
          loading: true,
          data: [],
        },
        pageSize: 10,
        currentPage: 1,
        total: 0,
        ids: [],
      }
    },
    mounted: function () {
      this.getData();
    },
    methods: {
      getData() {
        let data = {
          page: this.currentPage,
          size: this.pageSize,
        };
        this.apiGet(api.accountList, data)
          .then(resp => {
            this.table.loading = false;
            this.table.data = resp.data.records;
            this.total = resp.data.total;
          })
      },
      selectionChange(val) {
        this.selection = val;
        let ids = [];
        for (let i = 0; i < this.selection.length; i++) {
          ids.push(this.selection[i].id);
        }
        this.ids = ids;
      },
      lock(val) {
        return val.lock == 1 ? "启用" : "禁用"
      },
      sex(val) {
        return val.sex == 0 ? "男" : "女"
      },
      handleSizeChange(pageSize) {
        this.pageSize = pageSize;
        this.getData();
      },
      handleCurrentChange(current) {
        this.currentPage = current;
        this.getData();
      },
    },
  }
</script>

<style scoped>
  .header-title {
    font-weight: bolder;
    font-size: 18px;
  }
</style>
