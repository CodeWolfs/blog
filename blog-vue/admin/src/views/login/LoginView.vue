<template>
  <el-row class="el-login-container">
    <el-col :span="18">
      <div class="left">
      </div>
    </el-col>
    <el-col :span="6" class="el-right">
      <el-form ref="loginFormRef" :model="loginForm" :rules="rules" class="login-form" :size="formSize">
        <p class="title">管理员登录</p>
        <el-form-item prop="userName">
          <el-input v-model="loginForm.userName" :prefix-icon="UserFilled" />
        </el-form-item>
        <el-form-item prop="password">
          <el-input v-model="loginForm.password" :prefix-icon="Lock"  show-password />
        </el-form-item>
        <el-form-item>
          <el-button type="primary" class="login-btn" @click="submitForm(loginFormRef)">登录</el-button>
        </el-form-item>
        <el-form-item>
          <el-button type="danger" class="login-btn" @click="resetForm(loginFormRef)">重置</el-button>
        </el-form-item>
      </el-form>
    </el-col>
  </el-row>
</template>

<script lang="ts" setup>
import tools from '@/utils/tool'
import { reactive, ref } from 'vue'
import type { FormInstance, FormRules } from 'element-plus'
import { UserFilled, Lock } from '@element-plus/icons-vue'

const formSize = ref('large')
const loginFormRef = ref<FormInstance>()
const loginForm = reactive({
  userName: '',
  password: ''
})

const rules = reactive<FormRules>({
  userName: [
    {
      required: true,
      message: 'Please input UserName',
      trigger: 'blur'

    }
  ],
  password: [
    {
      required: true,
      message: 'Please input Password',
      trigger: 'blur'
    }
  ]
})

const submitForm = async (formEl: FormInstance | undefined) => {
  if (!formEl) return
  await formEl.validate((valid, fields) => {
    if (valid) {
      //发送请求
      console.log('submit!')

    } else {
      console.log('error submit!')
    }
  })
}

const resetForm = (formEl: FormInstance | undefined) => {
  if (!formEl) return
  formEl.resetFields()
}


</script>

<style  scoped>
.login-container {
  height: 100%;
  background-image: url(https://static.talkxj.com/config/0w3pdr.jpg);
  background-size: cover;
  background-repeat: no-repeat;
}

.left {
  height: 100%;
  overflow: hidden;
}

.el-right {
  height: 100%;
  background-color: rgb(255, 255, 255);

  position: relative;
}

.el-login-container {
  height: 100%;
  background-image: url(https://static.talkxj.com/config/0w3pdr.jpg);
  background-size: cover;
  background-repeat: no-repeat;

}

.login-form {
  position: absolute;
  top: 20%;
  left: 0;
  right: 0;
  margin: 0px auto;

  min-width: 300px;
  width: 70%;
}

.login-form .title {
  margin: 20px auto;

  font-weight: bolder;
  font-size: 20px;
}

.login-form .login-btn {
  width: 100%;
}
</style>