<template>
  <div class="login-container">
    <el-row>
      <el-col :span="17">
        <div class="left">
        </div>
      </el-col>
      <el-col :span="7" >
        <div class="right"></div>
      </el-col>
    </el-row>
  </div>
</template>

<script lang="ts" setup>
import tools from '@/utils/tool'

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
.right {

  background-color: aliceblue;
}
</style>