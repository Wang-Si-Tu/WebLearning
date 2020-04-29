<template>
  <el-row type="flex" justify="center">
    <el-col>
      <el-table :data="tableData" style="width: 100%">
        <el-table-column label="账号" width="180">
<!--          <template slot-scope="scope">-->
<!--            <span style="margin-left: 10px">{{ scope.row.account }}</span>-->
<!--          </template>-->
          <template slot-scope="scope">
          <el-input placeholder="请输入账号" v-model="account"></el-input>
          </template>
        </el-table-column>
        <el-table-column label="密码" width="180">
<!--          <template slot-scope="scope">-->
<!--            <span style="margin-left: 10px">{{ scope.row.password }}</span>-->
<!--          </template>-->
          <template slot-scope="scope">
          <el-input placeholder="请输入密码" v-model="password"></el-input>
          </template>
        </el-table-column>
        <el-table-column label="操作">
          <template slot-scope="scope">
            <el-button
              size="mini"
              type="success"
              @click="handleAdd()"><i class="el-icon-plus"></i>添加</el-button>
          </template>
        </el-table-column>
      </el-table>
    </el-col>
  </el-row>
</template>

<script>
    export default {
        name: "addUser",
      data(){
          return {
            account: null,
            password: null,
            tableData: [{
              account: "",
              password: ""
            }]
          }
      },
      methods:{
          handleAdd(){
              this.$axios.post("/addAccount",{
                account:this.account,
                password:this.password
              })
                .then(response=>{
                  //console.log(response.data);
                  if(response.data=="Success") {
                    this.$message({message:"添加成功",type:"success",showClose:true});
                  }
                  if(response.data=="Fail") this.$message({message:"用户名已存在",type:"error",showClose:true});
                })
              //console.log(index);
              //console.log(row);
          }
      }
    }
</script>

<style scoped>
  .el-col{
    width: 42%;
  }
</style>
