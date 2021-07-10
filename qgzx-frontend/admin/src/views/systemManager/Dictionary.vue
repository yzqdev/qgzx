<template>
  <div class="container">
    <div class="saixuan">
      <el-form class="demo-form-inline" :inline="true" :model="SDformInline"
        ><el-form-item label="字典名称/字典代码"
          ><el-input
            v-model="SDformInline.mc"
            placeholder="字典名称"
            size="mini"
            style="min-width:80px"
          ></el-input></el-form-item
        ><el-form-item label="父代码"
          ><el-input
            v-model="SDformInline.fdm"
            placeholder="父代码"
            size="mini"
            style="width:180px"
          ></el-input></el-form-item
        ><el-form-item label="启用状态"
          ><el-select
            style="width:100px"
            v-model="SDformInline.jlzt"
            placeholder="启用状态"
            size="mini"
            clearable="clearable"
            ><el-option label="启用状态" value=""></el-option
            ><el-option label="已启用" value="Y"></el-option
            ><el-option
              label="已禁用"
              value="N"
            ></el-option></el-select></el-form-item
        ><el-form-item
          ><el-button type="primary" @click="chaxunSubmit"
            >查询</el-button
          ></el-form-item
        ></el-form
      >
      <div class="tjbtn">
        <el-button type="primary" @click="tjbtn">添加字典</el-button>
      </div>
    </div>
    <el-table
      :data="SDtableData"
      highlight-current-row="highlight-current-row"
      id="SDtable1"
      ><el-table-column prop="dm" label="字典代码" width="150"></el-table-column
      ><el-table-column prop="mc" label="字典名称" width="200"></el-table-column
      ><el-table-column prop="fdm" label="父代码" width="130"></el-table-column
      ><el-table-column
        prop="mrz"
        label="默认值"
        min-width="230"
      ></el-table-column
      ><el-table-column
        prop="jlzt"
        label="启用状态"
        width="100"
        :formatter="jlztformatter"
      ></el-table-column
      ><el-table-column label="操作" prop="zips" width="100"
        ><template slot-scope="scope"
          ><el-button
            size="mini"
            @click="handleEdit(scope.$index, scope.row)"
            :disabled="scope.row.hyzt === '03'"
            >编辑</el-button
          ></template
        ></el-table-column
      ></el-table
    ><el-pagination
      class="page-style"
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :page-sizes="[20, 30, 40]"
      :current-page.sync="yemapage"
      :page-size="sizepage"
      layout="total, sizes, prev, pager, next, jumper"
      :total="num"
      :pager-count="11"
    ></el-pagination
    ><el-dialog
      title="字典编辑"
      :visible.sync="dialogzdbj"
      :before-close="handleClose"
      ><el-form
        :model="zdbjform"
        :rules="zdbjrules"
        label-width="100px"
        style="width:480px"
        ><div class="zdbjbox" @click="zblxchange">
          <el-form-item label="字典代码" prop="dm"
            ><el-input
              v-model="zdbjform.dm"
              placeholder="请输入字典代码"
              type="text"
            ></el-input></el-form-item
          ><el-form-item label="字典名称" prop="mc"
            ><el-input
              v-model="zdbjform.mc"
              placeholder="请输入字典名称"
              type="text"
            ></el-input></el-form-item
          ><el-form-item label="父代码" prop="fdm"
            ><el-input
              v-model="zdbjform.fdm"
              placeholder="请输入父代码"
              type="text"
            ></el-input></el-form-item
          ><el-form-item label="是否启用"
            ><el-switch v-model="zdbjform.sfqy"></el-switch></el-form-item
          ><el-form-item label="默认值"
            ><el-input
              class="textarea"
              type="textarea"
              rows="8"
              v-model="zdbjform.mrz"
            ></el-input></el-form-item
          ><el-form-item class="tjrsbtn"
            ><el-button @click.stop="dialogzdbj = false">取 消</el-button
            ><el-button type="primary" @click.stop="tjrsclick"
              >确 定</el-button
            ></el-form-item
          >
        </div></el-form
      ></el-dialog
    >
  </div>
</template>

<script lang="ts">
import dic from "../../plugins/DIC.js";
let btnmc;
let sftj = true;
import { Vue, Component } from "vue-property-decorator";
@Component
export default class Dictionary extends Vue {
  dialoggxrz = false;
  lsbbrzlist = [];
  value5 = "N";
  xmdm = "";
  xmmc = "";
  xmlist = [];
  xtrzform = {
    gxdz: "",
    bbh: "",
    gxnr: "",
  };
  fullscreenLoading = false;
  HistoricalRenewal = [];
  zdbjform = {
    dm: "",
    mc: "",
    fdm: "",
    sfqy: true,
    mrz: "",
    id: "",
  };
  zdbjrules = {
    dm: [{ required: true, message: "请输入字典代码", trigger: "blur" }],
    mc: [{ required: true, message: "请输入字典名称", trigger: "blur" }],
    fdm: [{ required: true, message: "请输入父代码", trigger: "blur" }],
  };
  dialogzdbj = false;
  tableboxh = "";
  SDtableData = [];
  num = 10;
  sizepage = 20; //默认显示条数
  yemapage = 1; //默认页码
  SDformInline = {
    mc: "",
    fdm: "",
    jlzt: "",
  };
  dkh = "Y";
  mounted() {
    this.SDtableData = dic;
  }
  zblxchange() {
    sftj = false;
  }
  handleClose(done) {
    if (sftj) {
      return done();
    }
    this.$confirm("确认关闭？注意是否已提交更改")
      .then((_) => {
        done();
      })
      .catch((_) => {});
  }

  xmchangefn(e) {
    this.xmmc = this.hqhyssdwmcffs(this.xmdm);
    this.xmdmfn(this.xmdm);
  }
  xmdmfn(value) {
    this.$axios
      .post("v1/user/cxlsgxrzlb", { dm: value })
      .then((res) => {
        if (res.data.status === "SUCCESS") {
          this.lsbbrzlist = res.data.transfer.cxlsgxrzlb;
          if (res.data.transfer.dbbbgxrz) {
            this.xtrzform = {
              gxdz: res.data.transfer.dbbbgxrz.gxdz,
              bbh: res.data.transfer.dbbbgxrz.bbh.substring(1),
              gxnr: res.data.transfer.dbbbgxrz.gxnr.replace(/;/g, "\n"),
            };
            this.xmdm = res.data.transfer.dbbbgxrz.dm;
            this.xmmc = res.data.transfer.dbbbgxrz.mc;
            this.value5 = res.data.transfer.dbbbgxrz.qzgx;
          } else {
            this.xtrzform = {
              gxdz: "",
              bbh: "",
              gxnr: "",
            };
          }
        } else {
          this.SDtableData = dic;
        }
      })
      .catch((res) => {
        this.SDtableData = dic;
      });
  }
  xggxrz() {
    let data = {
      bbh: this.xtrzform.bbh,
      gxdz: this.xtrzform.gxdz,
      gxnr: this.xtrzform.gxnr,
      mc: this.xmmc,
      qzgx: this.value5,
      xtdm: this.xmdm,
    };
    this.$axios
      .post("v1/user/sgtjgxrz", data)
      .then((res) => {
        if (res.data.status === "SUCCESS") {
          this.xmdmfn(this.xmdm);
        }
      })
      .catch((res) => {});
  }
  tjbtn() {
    sftj = true;
    this.zdbjform = {
      dm: "",
      mc: "",
      fdm: "",
      sfqy: true,
      mrz: "",
      id: "",
    };
    btnmc = "tj";
    this.dialogzdbj = true;
  }
  // 编辑完成
  tjrsclick() {
    let url = "";
    let data = {};
    if (btnmc === "tj") {
      url = "v1/user/addXtzd";
      data = {
        dm: this.zdbjform.dm,
        fdm: this.zdbjform.fdm,
        mc: this.zdbjform.mc,
        mrz: this.zdbjform.mrz ? this.zdbjform.mrz : "",
        sfqy: this.zdbjform.sfqy ? "Y" : "N",
      };
    }
    if (btnmc === "bj") {
      url = "v1/user/updateXtzd";
      data = {
        dm: this.zdbjform.dm,
        fdm: this.zdbjform.fdm,
        id: this.zdbjform.id,
        mc: this.zdbjform.mc,
        mrz: this.zdbjform.mrz ? this.zdbjform.mrz : "",
        sfqy: this.zdbjform.sfqy ? "Y" : "N",
      };
    }
    let loading = this.$loading({
      lock: true,
      text: "努力提交中",
      spinner: "el-icon-loading",
      background: "rgba(0, 0, 0, 0.7)",
    });
    let set = setTimeout(() => {
      loading.close();
      this.$message.error("提交失败");
    }, 7000);
    this.$axios
      .post(url, data)
      .then((response) => {
        if (response.data.status === "SUCCESS") {
          sftj = true;
          this.dialogzdbj = false;
          this.table(this.yemapage, this.sizepage);
          this.$message({
            message: "操作成功",
            center: true,
            type: "success",
          });
        }
        loading.close();
        clearTimeout(set);
      })
      .catch((error) => {
        loading.close();
        clearTimeout(set);
      });
  }
  // 请求table
  table(pageNumber, pageSize) {
    let zdcxDTO = {
      zddm: this.SDformInline.mc,
      fdm: this.SDformInline.fdm,
      qyzt: this.SDformInline.jlzt,
    };
    let params = {
      pageNumber: pageNumber,
      pageSize: pageSize,
      zdcxDTO: zdcxDTO,
    };
    this.yemapage = pageNumber;
    this.sizepage = pageSize;

    this.$axios
      .post("v1/user/getAllXtzd", {
        pageNumber: pageNumber - 1,
        pageSize: pageSize,
        zdcxDTO: zdcxDTO,
      })
      .then((response) => {
        if (response.data.status === "SUCCESS") {
          this.num = response.data.transfer.totalSize;
          this.SDtableData = response.data.transfer.all_xtzd;
          this.yemapage = pageNumber;
          this.sizepage = pageSize;
        }
      })
      .catch((res) => {});
  }
  // 编辑按钮
  handleEdit(index, row) {
    sftj = true;
    btnmc = "bj";
    this.zdbjform = {
      dm: row.dm,
      mc: row.mc,
      fdm: row.fdm,
      sfqy: row.jlzt === "Y",
      mrz: row.mrz,
      id: row.id,
    };
    this.dialogzdbj = true;
  }
  // 查询按钮
  chaxunSubmit() {
    this.yemapage = 1;
    this.table(this.yemapage, this.sizepage);
  }
  // 监听显示条数
  handleSizeChange(val) {
    this.sizepage = val;
    this.table(this.yemapage, this.sizepage);
  }
  // 监听页码改变
  handleCurrentChange(val) {
    this.yemapage = val;
    this.table(this.yemapage, this.sizepage);
  }
  jlztformatter(row, column, cellValue, index) {
    if (cellValue === "Y") return "已启用";
    if (cellValue === "N") return "已禁用";
  }
  hqhyssdwmcffs(dm) {
    let mc = "";
    for (let key in this.xmlist) {
      if (this.xmlist[key].dm === dm) {
        mc = this.xmlist[key].mc;
      }
    }
    return mc;
  } // 单位formatter
}
</script>

<style scoped>
/* @import "../../assets/less/common";
@import "dic"; */
</style>
