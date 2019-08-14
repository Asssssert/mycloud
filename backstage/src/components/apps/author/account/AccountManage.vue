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
            <el-table-column label="操作" fixed="right" width="200" align="center">
              <template slot-scope="scope">
                <el-button
                  size="mini"
                  type="text"
                  @click="handleLock(scope.$index, scope.row)">{{scope.row.lock==1 ? "启用" : "禁用"}}
                </el-button>
                <el-button
                  size="mini"
                  type="text"
                  @click="handleEdit(scope.$index, scope.row)">编辑
                </el-button>
                <el-button
                  size="mini"
                  type="text"
                  @click="handleDelete(scope.$index,scope.row)">删除
                </el-button>
              </template>
            </el-table-column>
          </el-table>
        </el-row>
        <el-row>
          <div style="float:left;margin-top: 20px;">
            <el-button type="primary" size="small" @click="add">添加用户</el-button>
            <el-button type="danger" size="small" @click="batchDelete">批量删除</el-button>
          </div>
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
        <el-row>
          <el-dialog :title="dialog.title"
                     width="25%"
                     :visible.sync="dialog.dialogTableVisible"
                     v-if='dialog.dialogTableVisible'>
            <AccountAdd v-if="dialog.active==1" @mClose="mClose"></AccountAdd>
            <AccountUpd v-if="dialog.active==2" :id="dialog.id" @mClose="mClose"></AccountUpd>
          </el-dialog>
        </el-row>
      </div>
    </el-card>
  </el-row>
</template>

<script>
  import AccountAdd from '@/components/apps/author/account/AccountAdd'
  import AccountUpd from '@/components/apps/author/account/AccountUpd'
  import http from 'assets/js/http';
  import api from 'assets/js/api';

  export default {
    mixins: [http],
    name: "AccountManage",
    components: {
      AccountAdd,
      AccountUpd,
    },
    data() {
      return {
        dialog: {
          id: 0,
          title: '',
          active: 0,
          dialogTableVisible: false,
        },
        table: {
          loading: true,
          data: [],
        },
        pageSize: 10,
        currentPage: 1,
        total: 0,
        ids: [],
        selection: [],
      }
    },
    mounted: function () {
      this.getData();
    },
    methods: {
      batchDelete() {
        if (this.selection.length <= 0) return _g.message("error", "请选择要删除的科目");
        _g.meassageBox('warning', '警告', "确定删除这些科目吗？（删除后无法恢复）")
          .then(() => {
            this.apiDelete(api.accountDel + "/" + this.ids)
              .then(resp => {
                _g.notification("success", resp.msg);
                this.getData();
              })
          })
          .catch(() => {
          });
      },
      add() {
        this.dialog.title = "添加用户";
        this.dialog.dialogTableVisible = true;
        this.dialog.active = 1;
      },
      handleLock(index, row) {
        let lock = row.lock == 0 ? 1 : 0;
        this.apiPatch(api.accountLock + "/" + [row.id], {lock: lock})
          .then(resp => {
            _g.notification("success", resp.msg);
            this.getData();
          })
      },
      handleEdit(index, row) {
        this.dialog.title = "编辑用户";
        this.dialog.dialogTableVisible = true;
        this.dialog.active = 2;
        this.dialog.id = row.id;
      },
      handleDelete(index, row) {
        _g.meassageBox('warning', '警告', "确定删除该科目吗？（删除后无法恢复）")
          .then(() => {
            this.apiDelete(api.accountDel + "/" + [row.id])
              .then(resp => {
                _g.notification("success", resp.msg);
                this.getData();
              })
          })
          .catch(() => {
          });
      },
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
        return val.lock == 0 ? "正常" : "禁用"
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
      mClose() {
        this.dialog.title = "";
        this.dialog.dialogTableVisible = false;
        this.dialog.active = 0;
        this.dialog.id = 0;
        this.getData();
      }
    },
  }
</script>

<style scoped>
  .header-title {
    font-weight: bolder;
    font-size: 18px;
  }
</style>
