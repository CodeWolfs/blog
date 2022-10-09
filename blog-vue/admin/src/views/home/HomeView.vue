<template>
  <div id="border">
    测试border
  </div>

  <div>
    <p>测试字体大小文本</p> 
  </div>

  <ul>
    <li>12</li>
    <li>12</li>
    <li>12</li>
    <li>12</li>
  </ul>
</template>

<script lang="ts" setup>

</script>

<style scoped>

  #border {
    height: 200px;
    border: 2px solid;
    border-radius: 50%;
    margin: 10px 20px;

    box-shadow: -10px -100px 5px #888888;
    background-color: aqua;
    background-image: url(https://static.talkxj.com/config/0w3pdr.jpg);
    background-position: left top;
    background-repeat: no-repeat;
    background-size: 50% 50%;
  }
  p {
    font-size: 1.5em;
  }

  ul {
    padding: 20px 0px;
    list-style: circle;
    list-style-type:circle;
  }
  ul li {
    padding-left: 30px;
    list-style: square;
    list-style-type: square;

  }

</style>