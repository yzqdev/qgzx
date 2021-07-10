<template>
  <div class="container">
    <h2>系统字典</h2>
    <el-table :data="dictionaryData" style="width: 100%">
      <el-table-column prop="date" label="日期" width="180"> </el-table-column>
      <el-table-column prop="name" label="姓名" width="180"> </el-table-column>
      <el-table-column prop="address" label="地址"> </el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button size="mini" @click="handleEdit(scope.$index, scope.row)"
            >编辑</el-button
          >
          <el-button
            size="mini"
            type="danger"
            @click="handleDelete(scope.$index, scope.row)"
            >删除</el-button
          >
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
export default {
  name: "SystemConstants",
  // 对象
  props: {
    propA: {
      type: String, //传入值限定类型
      // type 值可为String,Number,Boolean,Array,Object,Date,Function,Symbol
      // type 还可以是一个自定义的构造函数，并且通过 instanceof 来进行检查确认
      required: true, //是否必传
      default: 200, //默认值,对象或数组默认值必须从一个工厂函数获取如 default:()=>[]
      validator(value) {
        // 这个值必须匹配下列字符串中的一个
      }
    }
  },
  data() {
    return {
      name: "",
      dictionaryData: [
        {
          date: "2016-05-02",
          name: "王小虎",
          address: "上海市普陀区金沙江路 1518 弄"
        },
        {
          date: "2016-05-04",
          name: "王小虎",
          address: "上海市普陀区金沙江路 1517 弄"
        },
        {
          date: "2016-05-01",
          name: "王小虎",
          address: "上海市普陀区金沙江路 1519 弄"
        },
        {
          date: "2016-05-03",
          name: "王小虎",
          address: "上海市普陀区金沙江路 1516 弄"
        }
      ]
    };
  },
  watch: {},
  mounted() {
    this.function();
  },
  methods: {
    function() {},
    handleEdit(index, row) {
      console.log(index, row);
    },
    handleDelete(index, row) {
      console.log(index, row);
    }
  }
};
</script>

<style scoped>
@import "../../assets/less/common.less";
</style>
