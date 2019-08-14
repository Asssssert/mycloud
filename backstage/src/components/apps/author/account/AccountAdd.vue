<template>
  <el-row>
    <el-form :model="form" :rules="rules" ref="form" label-width="100px" class="demo-form">
      <el-form-item label="用户名" prop="account">
        <el-input v-model="form.account" placeholder="请输入用户名" :clearable="true"></el-input>
      </el-form-item>
      <el-form-item label="密码" prop="password">
        <el-input v-model="form.password" type="password" :show-password="true" :clearable="true"
                  placeholder="请输入密码"></el-input>
      </el-form-item>
      <el-form-item label="昵称" prop="nickname">
        <el-input v-model="form.nickname" placeholder="请输入昵称" :clearable="true"></el-input>
      </el-form-item>
      <el-form-item label="性别" prop="sex">
        <el-radio-group v-model="form.sex">
          <el-radio label="男"></el-radio>
          <el-radio label="女"></el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="真实姓名" prop="realname">
        <el-input v-model="form.realname" placeholder="请输入真实姓名" :clearable="true"></el-input>
      </el-form-item>
      <el-form-item label="邮箱" prop="email">
        <el-input v-model="form.email" placeholder="请输入邮箱" :clearable="true"></el-input>
      </el-form-item>
      <el-form-item label="手机号码" prop="phone">
        <el-input v-model="form.phone" placeholder="请输入手机号码" :clearable="true"></el-input>
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
    name: "AccountAdd",
    components: {},
    data() {
      return {
        form: {
          account: '',
          password: '',
          sex: "男",
          nickname: '',
          realname: '',
          email: '',
          phone: '',
        },
        rules: {
          account: [
            {required: true, message: '请输入用户名', trigger: 'blur'},
          ],
          password: [
            {required: true, message: '请输入密码', trigger: 'blur'},
          ],
          nickname: [
            {required: true, message: '请输入昵称', trigger: 'blur'},
          ],
          sex: [
            {required: true, message: '请选择性别', trigger: 'change'}
          ],
          realname: [
            {required: true, message: '请输入真实姓名', trigger: 'blur'},
          ],
          email: [
            {required: true, message: '请输入邮箱', trigger: 'blur'},
            {type: 'email', message: "邮箱格式不正确"},
          ],
          phone: [
            {required: true, message: '请输入手机号码', trigger: 'blur'},
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
            let data = {
              account: this.form.account,
              password: this.form.password,
              sex: this.form.sex == "男" ? 0 : 1,
              nickname: this.form.nickname,
              realname: this.form.realname,
              email: this.form.email,
              phone: this.form.phone,
            };
            this.apiPost(api.accountAdd, data)
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
