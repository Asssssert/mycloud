<template>
  <el-row>
    <el-form :model="form" :rules="rules" ref="form" label-width="100px" class="demo-form">
      <el-form-item label="权限名称" prop="name">
        <el-input v-model="form.name" placeholder="请输入类型名称" :clearable="true"></el-input>
      </el-form-item>
      <el-form-item label="备注" prop="describes">
        <el-input type="textarea" :autosize="{ minRows: 3, maxRows: 10}" v-model="form.describes" placeholder="请输入备注"
                  :clearable="true"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitForm('form')" size="small">立即创建</el-button>
        <el-button @click="resetForm('form')" size="small">重置</el-button>
      </el-form-item>
    </el-form>
  </el-row>
</template>

<script>
  import http from 'assets/js/http';
  import api from 'assets/js/api';

  export default {
    mixins: [http],
    name: "PermissionAdd",
    components: {},
    data() {
      return {
        query: [],
        form: {
          parentId: 0,
          type: 1,
          name: '',
          resource: '',
          method: '',
          url: '',
          describes: '',
        },
        rules: {
          name: [
            {required: true, message: '请输入类型名称', trigger: 'blur'},
          ],
          // describes: [
          //   {required: true, message: '请输入备注', trigger: 'blur'},
          // ],
        }
      }
    },
    mounted: function () {
      let pid = Lockr.get('pid');
      if (pid) {
        this.form.parentId = parseInt(pid);
      }
    },
    methods: {
      submitForm(form) {
        this.$refs[form].validate((valid) => {
          if (valid) {
            this.apiPost(api.permissionAdd, this.form)
              .then(resp => {
                _g.notification("success", resp.msg);
                this.$emit('mClose');
              })
          }
        });
      },
      resetForm(form) {
        this.$refs[form].resetFields();
      }
    },
  }
</script>

<style scoped>

</style>
