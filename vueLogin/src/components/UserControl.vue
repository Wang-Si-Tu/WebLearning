<template>
  <el-row type="flex" justify="center">
  <el-col>
  <el-table :data="tableData" style="width: 100%">
    <el-table-column label="账号" width="180">
      <template slot-scope="scope">
        <span style="margin-left: 10px">{{ scope.row.account }}</span>
      </template>
    </el-table-column>
    <el-table-column label="密码" width="180">
      <template slot-scope="scope">
        <span style="margin-left: 10px">{{ scope.row.password }}</span>
      </template>
    </el-table-column>
    <el-table-column label="操作">
      <template slot-scope="scope">
        <el-button
          size="mini"
          type="danger"
          @click="handleDelete(scope.$index, scope.row)"><i class="el-icon-delete"></i>删除</el-button>
      </template>
    </el-table-column>
  </el-table>
  </el-col>
  </el-row>
</template>

<script>
    export default {
      name: "UserControl",
      data() {
        return {
          tableData: []
          // [{
          //   account: '',
          //   password: ''
          // }]
        }
      },
      mounted:function(){
        this.$axios.post("/getAccount",{})
        .then(response=>{
          console.log(response.data);
          //this.tableData=response.data;
          for(let i=0;i<response.data.length;i++){
            this.tableData.push({
              account: response.data[i].account,
              password: response.data[i].password,
            })
          }
        })
      },
      methods: {
        handleDelete(index,row) {
          this.$axios.post("/deleteAccount",{
            account:row.account,
            password:row.password
          })
            .then(response=>{
              //console.log(response.data);
              if(response.data=="Success") {
                this.$message({message:"删除成功",type:"success",showClose:true});
                this.tableData.splice(index,1);
              }
              if(response.data=="Fail") this.$message({message:"删除失败",type:"error",showClose:true});
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
