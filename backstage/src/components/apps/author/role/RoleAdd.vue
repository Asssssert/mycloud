<template>
  <el-row>
    <el-form :model="form" :rules="rules" ref="form" label-width="100px" class="demo-form">
      <el-form-item label="角色名" prop="name">
        <el-input v-model="form.name" placeholder="请输入角色名" :clearable="true"></el-input>
      </el-form-item>
      <el-form-item label="昵称" prop="nickname">
        <el-input v-model="form.nickname" placeholder="请输入角色昵称" :clearable="true"></el-input>
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
    name: "RoleAdd",
    components: {},
    data() {
      return {
        form: {
          name: '',
          nickname: '',
        },
        rules: {
          name: [
            {required: true, message: '请输入角色名', trigger: 'blur'},
          ],
          nickname: [
            {required: true, message: '请输入角色名称', trigger: 'blur'},
          ],
        }
      }
    },
    mounted: function () {

    },
    methods: {
      submitForm(form) {
        this.$refs[form].validate((valid) => {
          if (valid) {
            this.apiPost(api.roleAdd, this.form)
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
