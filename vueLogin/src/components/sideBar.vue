<template>
  <el-col :span="4">
    <el-menu router :default-active="$route.path" class="el-menu-vertical-demo" theme="dark">
<!--      @open="handleOpen" @close="handleClose"-->
      <el-submenu index="1">
        <template slot="title">
          <i class="el-icon-location"></i>
          <span>用户信息</span>
        </template>
        <el-menu-item-group>
          <el-menu-item index="/UserControl">账号管理</el-menu-item>
<!--          @click="goTo('/UserControl'-->
          <el-menu-item index="/addUser">添加用户</el-menu-item>
        </el-menu-item-group>
      </el-submenu>
      <el-submenu index="2">
        <template slot="title">
          <i class="el-icon-location"></i>
          <span>商品信息</span>
        </template>
        <el-menu-item-group>
          <el-menu-item>商品管理</el-menu-item>
          <el-menu-item>添加商品</el-menu-item>
        </el-menu-item-group>
      </el-submenu>
    </el-menu>
  </el-col>
</template>

<script>
    export default {
        name: "sideBar",
      // methods:{
      //   goTo(path){
      //     this.$router.replace(path);
      //   }
      // }
    }
</script>

<style scoped>
  /*.el-col{*/
  /*  width: 15%;*/
  /*}*/
</style>
