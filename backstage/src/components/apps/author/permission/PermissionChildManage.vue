<template>
  <el-row>
    <el-card>
      <div slot="header" class="header-title"><i class="el-icon-arrow-left" @click="$router.back(-1)"></i>子权限列表</div>
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
            <el-table-column prop="parentId"
                             align="center"
                             :formatter="parentId"
                             label="父权限ID"></el-table-column>
            <el-table-column prop="type"
                             align="center"
                             :formatter="type"
                             label="权限类型"></el-table-column>
            <el-table-column prop="name"
                             align="center"
                             label="权限名称"></el-table-column>
            <el-table-column prop="resource"
                             align="center"
                             label="资源编码"></el-table-column>
            <el-table-column prop="method"
                             align="center"
                             label="请求方法"></el-table-column>
            <el-table-column prop="url"
                             align="center"
                             label="请求地址"></el-table-column>
            <el-table-column prop="describes"
                             align="center"
                             label="备注"></el-table-column>
            <el-table-column label="操作" fixed="right" width="200" align="center">
              <template slot-scope="scope">
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
                <el-button
                  :disabled="scope.row.type==2"
                  size="mini"
                  type="text"
                  @click="handleChild(scope.$index,scope.row)">子权限
                </el-button>
              </template>
            </el-table-column>
          </el-table>
        </el-row>
        <el-row>
          <div style="float:left;margin-top: 20px;">
            <el-button type="success" size="small" @click="addType">添加类型</el-button>
            <el-button type="primary" size="small" @click="addPermission">添加权限</el-button>
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
            <PermissionAddType v-if="dialog.active==1"  @mClose="mClose"></PermissionAddType>
            <PermissionAddPermission v-if="dialog.active==2" @mClose="mClose"></PermissionAddPermission>
            <PermissioniUpd v-if="dialog.active==3" :id="dialog.id" @mClose="mClose"></PermissioniUpd>
          </el-dialog>
        </el-row>
      </div>
    </el-card>
  </el-row>
</template>

<script>
  import PermissionAddType from '@/components/apps/author/permission/PermissionAddType'
  import PermissionAddPermission from '@/components/apps/author/permission/PermissionAddPermission'
  import PermissioniUpd from '@/components/apps/author/permission/PermissioniUpd'
  import http from 'assets/js/http';
  import api from 'assets/js/api';

  export default {
    mixins: [http],
    name: "PermissionChildManage",
    components: {
      PermissionAddType,
      PermissionAddPermission,
      PermissioniUpd,
    },
    data() {
      return {
        dialog: {
          id: 0,
          title: '',
          active: 0,
          type: 0,
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
        query: [],
      }
    },
    mounted: function () {
      let pid = Lockr.get('pid');
      this.getData(pid);
    },
    methods: {
      getData(pid) {
        let data = {
          page: this.currentPage,
          size: this.pageSize,
          pid: pid,
        };
        this.apiGet(api.permissionListPid, data)
          .then(resp => {
            this.table.loading = false;
            this.table.data = resp.data.records;
            this.total = resp.data.total;
          })
      },
      batchDelete() {
        if (this.selection.length <= 0) return _g.message("error", "请选择要删除的科目");
        _g.meassageBox('warning', '警告', "确定删除这些权限吗？（删除后无法恢复）")
          .then(() => {
            this.apiDelete(api.permissionDel + "/" + this.ids)
              .then(resp => {
                _g.notification("success", resp.msg);
                this.getData(Lockr.get('pid'));
              })
          })
          .catch(() => {
          });
      },
      addType() {
        this.dialog.title = "添加类型";
        this.dialog.dialogTableVisible = true;
        this.dialog.active = 1;
      },
      addPermission() {
        this.dialog.title = "添加权限";
        this.dialog.dialogTableVisible = true;
        this.dialog.active = 2;
      },
      handleEdit(index, row) {
        this.dialog.title = "编辑权限";
        this.dialog.dialogTableVisible = true;
        this.dialog.active = 3;
        this.dialog.id = row.id;
      },
      handleChild(index, row) {
        Lockr.set("pid", row.id);
        this.getData(row.id);
      },
      handleDelete(index, row) {
        _g.meassageBox('warning', '警告', "确定删除该权限吗？（删除后无法恢复）")
          .then(() => {
            this.apiDelete(api.permissionDel + "/" + [row.id])
              .then(resp => {
                _g.notification("success", resp.msg);
                this.getData(Lockr.get('pid'));
              })
          })
          .catch(() => {
          });
      },
      selectionChange(val) {
        this.selection = val;
        let ids = [];
        for (let i = 0; i < this.selection.length; i++) {
          ids.push(this.selection[i].id);
        }
        this.ids = ids;
      },
      handleSizeChange(pageSize) {
        this.pageSize = pageSize;
        this.getData(Lockr.get('pid'));
      },
      handleCurrentChange(current) {
        this.currentPage = current;
        this.getData(Lockr.get('pid'));
      },
      mClose() {
        this.dialog.title = "";
        this.dialog.dialogTableVisible = false;
        this.dialog.active = 0;
        this.dialog.id = 0;
        this.getData(Lockr.get('pid'));
      },
      parentId(val) {
        return val.parentId == 0 ? "无" : val.parentId
      },
      type(val) {
        return val.type == 1 ? "分类" : "权限"
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
