<template>
  <div class="main-content">
    <!-- 列表页 -->
    <div v-if="showFlag">
      <el-form :inline="true" :model="searchForm" class="form-content">
        <el-row :gutter="20" class="slt" :style="{justifyContent:contents.searchBoxPosition=='1'?'flex-start':contents.searchBoxPosition=='2'?'center':'flex-end'}">
                                                    <el-form-item :label="contents.inputTitle == 1 ? '劳模工号' : ''">
                  <el-input v-if="contents.inputIcon == 1 && contents.inputIconPosition == 1" prefix-icon="el-icon-search" v-model="searchForm.jiaoshigonghao" placeholder="劳模工号" clearable></el-input>
                  <el-input v-if="contents.inputIcon == 1 && contents.inputIconPosition == 2" suffix-icon="el-icon-search" v-model="searchForm.jiaoshigonghao" placeholder="劳模工号" clearable></el-input>
                  <el-input v-if="contents.inputIcon == 0" v-model="searchForm.jiaoshigonghao" placeholder="劳模工号" clearable></el-input>
                </el-form-item>
                                                                              <el-form-item :label="contents.inputTitle == 1 ? '劳模姓名' : ''">
                  <el-input v-if="contents.inputIcon == 1 && contents.inputIconPosition == 1" prefix-icon="el-icon-search" v-model="searchForm.jiaoshixingming" placeholder="劳模姓名" clearable></el-input>
                  <el-input v-if="contents.inputIcon == 1 && contents.inputIconPosition == 2" suffix-icon="el-icon-search" v-model="searchForm.jiaoshixingming" placeholder="劳模姓名" clearable></el-input>
                  <el-input v-if="contents.inputIcon == 0" v-model="searchForm.jiaoshixingming" placeholder="劳模姓名" clearable></el-input>
                </el-form-item>
                                                                                                                                                                                                                                                                                                          <el-form-item :label="contents.inputTitle == 1 ? '职称' : ''">
                  <el-input v-if="contents.inputIcon == 1 && contents.inputIconPosition == 1" prefix-icon="el-icon-search" v-model="searchForm.zhicheng" placeholder="职称" clearable></el-input>
                  <el-input v-if="contents.inputIcon == 1 && contents.inputIconPosition == 2" suffix-icon="el-icon-search" v-model="searchForm.zhicheng" placeholder="职称" clearable></el-input>
                  <el-input v-if="contents.inputIcon == 0" v-model="searchForm.zhicheng" placeholder="职称" clearable></el-input>
                </el-form-item>
                                                                              <el-form-item :label="contents.inputTitle == 1 ? '岗位' : ''">
                  <el-input v-if="contents.inputIcon == 1 && contents.inputIconPosition == 1" prefix-icon="el-icon-search" v-model="searchForm.gangwei" placeholder="岗位" clearable></el-input>
                  <el-input v-if="contents.inputIcon == 1 && contents.inputIconPosition == 2" suffix-icon="el-icon-search" v-model="searchForm.gangwei" placeholder="岗位" clearable></el-input>
                  <el-input v-if="contents.inputIcon == 0" v-model="searchForm.gangwei" placeholder="岗位" clearable></el-input>
                </el-form-item>
                                                                                                                                      <el-form-item>
            <el-button v-if="contents.searchBtnIcon == 1 && contents.searchBtnIconPosition == 1" icon="el-icon-search" type="success" @click="search()">{{ contents.searchBtnFont == 1?'查询':'' }}</el-button>
            <el-button v-if="contents.searchBtnIcon == 1 && contents.searchBtnIconPosition == 2" type="success" @click="search()">{{ contents.searchBtnFont == 1?'查询':'' }}<i class="el-icon-search el-icon--right"/></el-button>
            <el-button v-if="contents.searchBtnIcon == 0" type="success" @click="search()">{{ contents.searchBtnFont == 1?'查询':'' }}</el-button>
          </el-form-item>
        </el-row>
        <el-row class="ad" :style="{justifyContent:contents.btnAdAllBoxPosition=='1'?'flex-start':contents.btnAdAllBoxPosition=='2'?'center':'flex-end'}">
          <el-form-item>
            <el-button
              v-if="isAuth('gerendangan','新增') && contents.btnAdAllIcon == 1 && contents.btnAdAllIconPosition == 1"
              type="success"
              icon="el-icon-plus"
              @click="addOrUpdateHandler()"
            >{{ contents.btnAdAllFont == 1?'新增':'' }}</el-button>
            <el-button
              v-if="isAuth('gerendangan','新增') && contents.btnAdAllIcon == 1 && contents.btnAdAllIconPosition == 2"
              type="success"
              @click="addOrUpdateHandler()"
            >{{ contents.btnAdAllFont == 1?'新增':'' }}<i class="el-icon-plus el-icon--right" /></el-button>
            <el-button
              v-if="isAuth('gerendangan','新增') && contents.btnAdAllIcon == 0"
              type="success"
              @click="addOrUpdateHandler()"
            >{{ contents.btnAdAllFont == 1?'新增':'' }}</el-button>
            <el-button
              v-if="isAuth('gerendangan','删除') && contents.btnAdAllIcon == 1 && contents.btnAdAllIconPosition == 1 && contents.tableSelection"
              :disabled="dataListSelections.length <= 0"
              type="danger"
              icon="el-icon-delete"
              @click="deleteHandler()"
            >{{ contents.btnAdAllFont == 1?'删除':'' }}</el-button>
            <el-button
              v-if="isAuth('gerendangan','删除') && contents.btnAdAllIcon == 1 && contents.btnAdAllIconPosition == 2 && contents.tableSelection"
              :disabled="dataListSelections.length <= 0"
              type="danger"
              @click="deleteHandler()"
            >{{ contents.btnAdAllFont == 1?'删除':'' }}<i class="el-icon-delete el-icon--right" /></el-button>
            <el-button
              v-if="isAuth('gerendangan','删除') && contents.btnAdAllIcon == 0 && contents.tableSelection"
              :disabled="dataListSelections.length <= 0"
              type="danger"
              @click="deleteHandler()"
            >{{ contents.btnAdAllFont == 1?'删除':'' }}</el-button>

	    <download-excel v-if="isAuth('gerendangan','导出')" class = "export-excel-wrapper" :data = "dataList" :fields = "json_fields" name = "个人档案.xls">
		      <!-- 导出excel -->
            	<el-button
              	v-if="contents.btnAdAllIcon == 1 && contents.btnAdAllIconPosition == 1"
              	type="primary"
              	icon="el-icon-download"
            	>{{ contents.btnAdAllFont == 1?'导出':'' }}</el-button>
            	<el-button
              	v-if="contents.btnAdAllIcon == 1 && contents.btnAdAllIconPosition == 2"
              	type="primary"
            	>{{ contents.btnAdAllFont == 1?'导出':'' }}<i class="el-icon-download el-icon--right" /></el-button>
            	<el-button
              	v-if="contents.btnAdAllIcon == 0"
              	type="primary"
            	>{{ contents.btnAdAllFont == 1?'导出':'' }}</el-button>
       	    </download-excel>
            <el-button
              v-if="isAuth('gerendangan','打印') && contents.btnAdAllIcon == 1 && contents.btnAdAllIconPosition == 1"
              type="success"
              icon="el-icon-printer"
              @click="printJson"
            >{{ contents.btnAdAllFont == 1?'打印':'' }}</el-button>
            <el-button
              v-if="isAuth('gerendangan','打印') && contents.btnAdAllIcon == 1 && contents.btnAdAllIconPosition == 2"
              type="success"
              @click="printJson"
            >{{ contents.btnAdAllFont == 1?'打印':'' }}<i class="el-icon-printer el-icon--right" /></el-button>
            <el-button
              v-if="isAuth('gerendangan','打印') && contents.btnAdAllIcon == 0"
              type="success"
              @click="printJson"
            >{{ contents.btnAdAllFont == 1?'打印':'' }}</el-button>

                      </el-form-item>
        </el-row>
      </el-form>
      <div class="table-content">
        <el-table class="tables" :size="contents.tableSize" :show-header="contents.tableShowHeader"
            :header-row-style="headerRowStyle" :header-cell-style="headerCellStyle"
            :border="contents.tableBorder"
            :fit="contents.tableFit"
            :stripe="contents.tableStripe"
            :row-style="rowStyle"
            :cell-style="cellStyle"
            :style="{width: '100%',fontSize:contents.tableContentFontSize,color:contents.tableContentFontColor}"
            v-if="isAuth('gerendangan','查看')"
            :data="dataList"
            v-loading="dataListLoading"
            @selection-change="selectionChangeHandler">
            <el-table-column  v-if="contents.tableSelection"
                type="selection"
                header-align="center"
                align="center"
                width="50">
            </el-table-column>
            <el-table-column label="索引" v-if="contents.tableIndex" type="index" width="50" />
            	                                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                    prop="jiaoshigonghao"
                    header-align="center"
		    label="劳模工号">
		     <template slot-scope="scope">
                       {{scope.row.jiaoshigonghao}}
                     </template>
                </el-table-column>
                	                	                                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                    prop="jiaoshixingming"
                    header-align="center"
		    label="劳模姓名">
		     <template slot-scope="scope">
                       {{scope.row.jiaoshixingming}}
                     </template>
                </el-table-column>
                	                	                                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                    prop="xingbie"
                    header-align="center"
		    label="性别">
		     <template slot-scope="scope">
                       {{scope.row.xingbie}}
                     </template>
                </el-table-column>
                	                	                                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                    prop="lianxidianhua"
                    header-align="center"
		    label="联系电话">
		     <template slot-scope="scope">
                       {{scope.row.lianxidianhua}}
                     </template>
                </el-table-column>
                	                	                                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                    prop="shenfenzheng"
                    header-align="center"
		    label="身份证">
		     <template slot-scope="scope">
                       {{scope.row.shenfenzheng}}
                     </template>
                </el-table-column>
                	                	                                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                    prop="jiatingzhuzhi"
                    header-align="center"
		    label="家庭住址">
		     <template slot-scope="scope">
                       {{scope.row.jiatingzhuzhi}}
                     </template>
                </el-table-column>
                	                	                                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                    prop="zuigaoxueli"
                    header-align="center"
		    label="最高学历">
		     <template slot-scope="scope">
                       {{scope.row.zuigaoxueli}}
                     </template>
                </el-table-column>
                	                	                                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                    prop="zhengzhimianmao"
                    header-align="center"
		    label="政治面貌">
		     <template slot-scope="scope">
                       {{scope.row.zhengzhimianmao}}
                     </template>
                </el-table-column>
                	                	                                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                    prop="canjiadangpaishijian"
                    header-align="center"
		    label="参加党派时间">
		     <template slot-scope="scope">
                       {{scope.row.canjiadangpaishijian}}
                     </template>
                </el-table-column>
                	                	                                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                    prop="hunyuqingkuang"
                    header-align="center"
		    label="婚育情况">
		     <template slot-scope="scope">
                       {{scope.row.hunyuqingkuang}}
                     </template>
                </el-table-column>
                	                	                                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                    prop="canjiagongzuoshijian"
                    header-align="center"
		    label="参加工作时间">
		     <template slot-scope="scope">
                       {{scope.row.canjiagongzuoshijian}}
                     </template>
                </el-table-column>
                	                	                                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                    prop="benxiaorenzhishijian"
                    header-align="center"
		    label="本校任职时间">
		     <template slot-scope="scope">
                       {{scope.row.benxiaorenzhishijian}}
                     </template>
                </el-table-column>
                	                	                                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                    prop="zhicheng"
                    header-align="center"
		    label="职称">
		     <template slot-scope="scope">
                       {{scope.row.zhicheng}}
                     </template>
                </el-table-column>
                	                	                                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                    prop="gangwei"
                    header-align="center"
		    label="岗位">
		     <template slot-scope="scope">
                       {{scope.row.gangwei}}
                     </template>
                </el-table-column>
                	                	                                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                    prop="xinji"
                    header-align="center"
		    label="薪级">
		     <template slot-scope="scope">
                       {{scope.row.xinji}}
                     </template>
                </el-table-column>
                	                	                                      <el-table-column :sortable="contents.tableSortable" :align="contents.tableAlign" prop="dangancailiao"
                    header-align="center"
                    label="档案材料">
                    <template slot-scope="scope">
                      <el-button type="text" size="small" @click="download(scope.row.dangancailiao)">下载</el-button>
                    </template>
                  </el-table-column>
                	                	                                    	                	                                    	                                          <el-table-column :sortable="contents.tableSortable" :align="contents.tableAlign"
                  prop="shhf"
                  header-align="center"
                  label="审核回复">
              </el-table-column>
              <el-table-column :sortable="contents.tableSortable" :align="contents.tableAlign"
                  prop="sfsh"
                  header-align="center"
                  label="审核状态">
                  <template slot-scope="scope">
                    <span style="margin-right:10px">{{scope.row.sfsh=='是'?'通过':'未通过'}}</span>
                  </template>
              </el-table-column>
              <el-table-column :sortable="contents.tableSortable" :align="contents.tableAlign"
                  v-if="isAuth('gerendangan','审核')"
                  prop="sfsh"
                  header-align="center"
                  label="审核">
                  <template slot-scope="scope">
                    <el-button  type="text" icon="el-icon-edit" size="small" @click="shDialog(scope.row)">审核</el-button>
                  </template>
              </el-table-column>
                        <el-table-column width="300" :align="contents.tableAlign"
                header-align="center"
                label="操作">
                <template slot-scope="scope">
                                <el-button v-if="isAuth('gerendangan','查看') && contents.tableBtnIcon == 1 && contents.tableBtnIconPosition == 1" type="success" icon="el-icon-tickets" size="mini" @click="addOrUpdateHandler(scope.row.id,'info')">{{ contents.tableBtnFont == 1?'详情':'' }}</el-button>
                <el-button v-if="isAuth('gerendangan','查看') && contents.tableBtnIcon == 1 && contents.tableBtnIconPosition == 2" type="success" size="mini" @click="addOrUpdateHandler(scope.row.id,'info')">{{ contents.tableBtnFont == 1?'详情':'' }}<i class="el-icon-tickets el-icon--right" /></el-button>
                <el-button v-if="isAuth('gerendangan','查看') && contents.tableBtnIcon == 0" type="success" size="mini" @click="addOrUpdateHandler(scope.row.id,'info')">{{ contents.tableBtnFont == 1?'详情':'' }}</el-button>
                                                                <el-button v-if="isAuth('gerendangan','变动申请') && contents.tableBtnIcon == 1 && contents.tableBtnIconPosition == 1" type="success" icon="el-icon-tickets" size="mini" @click="danganbiandongCrossAddOrUpdateHandler(scope.row,'cross')">{{ contents.tableBtnFont == 1?'变动申请':'' }}</el-button>
                <el-button v-if="isAuth('gerendangan','变动申请') && contents.tableBtnIcon == 1 && contents.tableBtnIconPosition == 2" type="success" size="mini" @click="danganbiandongCrossAddOrUpdateHandler(scope.row,'cross')">{{ contents.tableBtnFont == 1?'变动申请':'' }}<i class="el-icon-tickets el-icon--right" /></el-button>
                <el-button v-if="isAuth('gerendangan','变动申请') && contents.tableBtnIcon == 0" type="success" size="mini" @click="danganbiandongCrossAddOrUpdateHandler(scope.row,'cross')">{{ contents.tableBtnFont == 1?'变动申请':'' }}</el-button>
                                                                <el-button v-if="isAuth('gerendangan','修改') && contents.tableBtnIcon == 1 && contents.tableBtnIconPosition == 1" type="primary" icon="el-icon-edit" size="mini" @click="addOrUpdateHandler(scope.row.id)">{{ contents.tableBtnFont == 1?'修改':'' }}</el-button>
                <el-button v-if="isAuth('gerendangan','修改') && contents.tableBtnIcon == 1 && contents.tableBtnIconPosition == 2" type="primary" size="mini" @click="addOrUpdateHandler(scope.row.id)">{{ contents.tableBtnFont == 1?'修改':'' }}<i class="el-icon-edit el-icon--right" /></el-button>
                <el-button v-if="isAuth('gerendangan','修改') && contents.tableBtnIcon == 0" type="primary" size="mini" @click="addOrUpdateHandler(scope.row.id)">{{ contents.tableBtnFont == 1?'修改':'' }}</el-button>




                <el-button v-if="isAuth('gerendangan','删除') && contents.tableBtnIcon == 1 && contents.tableBtnIconPosition == 1" type="danger" icon="el-icon-delete" size="mini" @click="deleteHandler(scope.row.id)">{{ contents.tableBtnFont == 1?'删除':'' }}</el-button>
                <el-button v-if="isAuth('gerendangan','删除') && contents.tableBtnIcon == 1 && contents.tableBtnIconPosition == 2" type="danger" size="mini" @click="deleteHandler(scope.row.id)">{{ contents.tableBtnFont == 1?'删除':'' }}<i class="el-icon-delete el-icon--right" /></el-button>
                <el-button v-if="isAuth('gerendangan','删除') && contents.tableBtnIcon == 0" type="danger" size="mini" @click="deleteHandler(scope.row.id)">{{ contents.tableBtnFont == 1?'删除':'' }}</el-button>
                </template>
            </el-table-column>
        </el-table>
                                                                                                                                                                                                                                                                                                                <el-pagination
          clsss="pages"
          :layout="layouts"
          @size-change="sizeChangeHandle"
          @current-change="currentChangeHandle"
          :current-page="pageIndex"
          :page-sizes="[10, 20, 50, 100]"
          :page-size="Number(contents.pageEachNum)"
          :total="totalPage"
          :small="contents.pageStyle"
          class="pagination-content"
          :background="contents.pageBtnBG"
          :style="{textAlign:contents.pagePosition==1?'left':contents.pagePosition==2?'center':'right'}"
        ></el-pagination>
      </div>
    </div>
    <!-- 添加/修改页面  将父组件的search方法传递给子组件-->
    <add-or-update v-if="addOrUpdateFlag" :parent="this" ref="addOrUpdate"></add-or-update>

            <danganbiandong-cross-add-or-update v-if="danganbiandongCrossAddOrUpdateFlag" :parent="this" ref="danganbiandongCrossaddOrUpdate"></danganbiandong-cross-add-or-update>
        
        <el-dialog
      title="审核"
      :visible.sync="sfshVisiable"
      width="50%">
      <el-form ref="form" :model="form" label-width="80px">
        <el-form-item label="审核状态">
          <el-select v-model="shForm.sfsh" placeholder="审核状态">
            <el-option label="通过" value="是"></el-option>
            <el-option label="不通过" value="否"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="内容">
          <el-input type="textarea" :rows="8" v-model="shForm.shhf"></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="shDialog">取 消</el-button>
        <el-button type="primary" @click="shHandler">确 定</el-button>
      </span>
    </el-dialog>
    
      </div>
</template>
<script>
import AddOrUpdate from "./add-or-update";
import danganbiandongCrossAddOrUpdate from "../danganbiandong/add-or-update";
export default {
  data() {
    return {
                                                                                                                                                                                                                                                                                                                                                                                                searchForm: {
        key: ""
      },
      dataList: [],
      pageIndex: 1,
      pageSize: 10,
      totalPage: 0,
      dataListLoading: false,
      dataListSelections: [],
      showFlag: true,
      sfshVisiable: false,
      shForm: {},
      chartVisiable: false,
      addOrUpdateFlag:false,
                  danganbiandongCrossAddOrUpdateFlag: false,
                  contents:{"searchBtnFontColor":"#333","pagePosition":"1","inputFontSize":"14px","inputBorderRadius":"22px","tableBtnDelFontColor":"#333","tableBtnIconPosition":"1","searchBtnHeight":"40px","inputIconColor":"rgba(66, 130, 129, 1)","searchBtnBorderRadius":"22px","tableStripe":false,"btnAdAllWarnFontColor":"#333","tableBtnDelBgColor":"rgba(244, 150, 150, 1)","searchBtnIcon":"1","tableSize":"medium","searchBtnBorderStyle":"solid","tableSelection":true,"searchBtnBorderWidth":"1px","tableContentFontSize":"14px","searchBtnBgColor":"rgba(153, 239, 237, 1)","inputTitleSize":"14px","btnAdAllBorderColor":"#DCDFE6","pageJumper":true,"btnAdAllIconPosition":"1","searchBoxPosition":"1","tableBtnDetailFontColor":"#333","tableBtnHeight":"40px","pagePager":true,"searchBtnBorderColor":"#DCDFE6","tableHeaderFontColor":"rgba(33, 34, 35, 1)","inputTitle":"1","tableBtnBorderRadius":"22px","btnAdAllFont":"1","btnAdAllDelFontColor":"rgba(21, 20, 20, 1)","tableBtnIcon":"1","btnAdAllHeight":"40px","btnAdAllWarnBgColor":"rgba(238, 236, 126, 1)","btnAdAllBorderWidth":"1px","tableStripeFontColor":"#606266","tableBtnBorderStyle":"solid","inputHeight":"40px","btnAdAllBorderRadius":"22px","btnAdAllDelBgColor":"rgba(234, 93, 93, 0.69)","pagePrevNext":true,"btnAdAllAddBgColor":"rgba(153, 239, 237, 1)","searchBtnFont":"1","tableIndex":true,"btnAdAllIcon":"1","tableSortable":true,"pageSizes":true,"tableFit":true,"pageBtnBG":true,"searchBtnFontSize":"14px","tableBtnEditBgColor":"rgba(240, 242, 124, 1)","inputBorderWidth":"1px","inputFontPosition":"1","inputFontColor":"#333","pageEachNum":10,"tableHeaderBgColor":"rgba(152, 129, 129, 1)","inputTitleColor":"#333","btnAdAllBoxPosition":"1","tableBtnDetailBgColor":"rgba(171, 239, 239, 1)","inputIcon":"0","searchBtnIconPosition":"1","btnAdAllFontSize":"14px","inputBorderStyle":"solid","inputBgColor":"rgba(197, 174, 174, 0.32)","pageStyle":false,"pageTotal":true,"btnAdAllAddFontColor":"#333","tableBtnFont":"1","tableContentFontColor":"rgba(22, 22, 23, 1)","inputBorderColor":"rgba(152, 129, 129, 1)","tableShowHeader":true,"tableBtnFontSize":"14px","tableBtnBorderColor":"rgba(196, 210, 244, 1)","inputIconPosition":"1","tableBorder":true,"btnAdAllBorderStyle":"solid","tableBtnBorderWidth":"1px","tableStripeBgColor":"rgba(213, 197, 197, 1)","tableBtnEditFontColor":"#333","tableAlign":"center"},
      layouts: '',

//导出excel
      json_fields: {
      "劳模工号": "jiaoshigonghao",    //常规字段
      "劳模姓名": "jiaoshixingming",    //常规字段
      "性别": "xingbie",    //常规字段
      "联系电话": "lianxidianhua",    //常规字段
      "身份证": "shenfenzheng",    //常规字段
      "家庭住址": "jiatingzhuzhi",    //常规字段
      "最高学历": "zuigaoxueli",    //常规字段
      "政治面貌": "zhengzhimianmao",    //常规字段
      "参加党派时间": "canjiadangpaishijian",    //常规字段
      "婚育情况": "hunyuqingkuang",    //常规字段
      "参加工作时间": "canjiagongzuoshijian",    //常规字段
      "本校任职时间": "benxiaorenzhishijian",    //常规字段
      "职称": "zhicheng",    //常规字段
      "岗位": "gangwei",    //常规字段
      "薪级": "xinji",    //常规字段
      "档案材料": "dangancailiao",    //常规字段
      "是否审核": "sfsh",    //常规字段
      "审核回复": "shhf",    //常规字段
      },
      json_meta: [
        [
          {
            " key ": " charset ",
            " value ": " utf- 8 "
          }
        ]
      ]

    };
  },
  created() {
    this.init();
    this.getDataList();
    this.contentStyleChange()
  },
  mounted() {

  },
  filters: {
    htmlfilter: function (val) {
      return val.replace(/<[^>]*>/g).replace(/undefined/g,'');
    }
  },
  components: {
    AddOrUpdate,
            danganbiandongCrossAddOrUpdate,
          },
  methods: {
    contentStyleChange() {
      this.contentSearchStyleChange()
      this.contentBtnAdAllStyleChange()
      this.contentSearchBtnStyleChange()
      this.contentTableBtnStyleChange()
      this.contentPageStyleChange()
    },
    contentSearchStyleChange() {
      this.$nextTick(()=>{
        document.querySelectorAll('.form-content .slt .el-input__inner').forEach(el=>{
          let textAlign = 'left'
          if(this.contents.inputFontPosition == 2) textAlign = 'center'
          if(this.contents.inputFontPosition == 3) textAlign = 'right'
          el.style.textAlign = textAlign
          el.style.height = this.contents.inputHeight
          el.style.lineHeight = this.contents.inputHeight
          el.style.color = this.contents.inputFontColor
          el.style.fontSize = this.contents.inputFontSize
          el.style.borderWidth = this.contents.inputBorderWidth
          el.style.borderStyle = this.contents.inputBorderStyle
          el.style.borderColor = this.contents.inputBorderColor
          el.style.borderRadius = this.contents.inputBorderRadius
          el.style.backgroundColor = this.contents.inputBgColor
        })
        if(this.contents.inputTitle) {
          document.querySelectorAll('.form-content .slt .el-form-item__label').forEach(el=>{
            el.style.color = this.contents.inputTitleColor
            el.style.fontSize = this.contents.inputTitleSize
            el.style.lineHeight = this.contents.inputHeight
          })
        }
        setTimeout(()=>{
          document.querySelectorAll('.form-content .slt .el-input__prefix').forEach(el=>{
            el.style.color = this.contents.inputIconColor
            el.style.lineHeight = this.contents.inputHeight
          })
          document.querySelectorAll('.form-content .slt .el-input__suffix').forEach(el=>{
            el.style.color = this.contents.inputIconColor
            el.style.lineHeight = this.contents.inputHeight
          })
          document.querySelectorAll('.form-content .slt .el-input__icon').forEach(el=>{
            el.style.lineHeight = this.contents.inputHeight
          })
        },10)

      })
    },
    // 搜索按钮
    contentSearchBtnStyleChange() {
      this.$nextTick(()=>{
        document.querySelectorAll('.form-content .slt .el-button--success').forEach(el=>{
          el.style.height = this.contents.searchBtnHeight
          el.style.color = this.contents.searchBtnFontColor
          el.style.fontSize = this.contents.searchBtnFontSize
          el.style.borderWidth = this.contents.searchBtnBorderWidth
          el.style.borderStyle = this.contents.searchBtnBorderStyle
          el.style.borderColor = this.contents.searchBtnBorderColor
          el.style.borderRadius = this.contents.searchBtnBorderRadius
          el.style.backgroundColor = this.contents.searchBtnBgColor
        })
      })
    },
    // 新增、批量删除
    contentBtnAdAllStyleChange() {
      this.$nextTick(()=>{
        document.querySelectorAll('.form-content .ad .el-button--success').forEach(el=>{
          el.style.height = this.contents.btnAdAllHeight
          el.style.color = this.contents.btnAdAllAddFontColor
          el.style.fontSize = this.contents.btnAdAllFontSize
          el.style.borderWidth = this.contents.btnAdAllBorderWidth
          el.style.borderStyle = this.contents.btnAdAllBorderStyle
          el.style.borderColor = this.contents.btnAdAllBorderColor
          el.style.borderRadius = this.contents.btnAdAllBorderRadius
          el.style.backgroundColor = this.contents.btnAdAllAddBgColor
        })
        document.querySelectorAll('.form-content .ad .el-button--danger').forEach(el=>{
          el.style.height = this.contents.btnAdAllHeight
          el.style.color = this.contents.btnAdAllDelFontColor
          el.style.fontSize = this.contents.btnAdAllFontSize
          el.style.borderWidth = this.contents.btnAdAllBorderWidth
          el.style.borderStyle = this.contents.btnAdAllBorderStyle
          el.style.borderColor = this.contents.btnAdAllBorderColor
          el.style.borderRadius = this.contents.btnAdAllBorderRadius
          el.style.backgroundColor = this.contents.btnAdAllDelBgColor
        })
        document.querySelectorAll('.form-content .ad .el-button--warning').forEach(el=>{
          el.style.height = this.contents.btnAdAllHeight
          el.style.color = this.contents.btnAdAllWarnFontColor
          el.style.fontSize = this.contents.btnAdAllFontSize
          el.style.borderWidth = this.contents.btnAdAllBorderWidth
          el.style.borderStyle = this.contents.btnAdAllBorderStyle
          el.style.borderColor = this.contents.btnAdAllBorderColor
          el.style.borderRadius = this.contents.btnAdAllBorderRadius
          el.style.backgroundColor = this.contents.btnAdAllWarnBgColor
        })
      })
    },
    // 表格
    rowStyle({ row, rowIndex}) {
      if (rowIndex % 2 == 1) {
        if(this.contents.tableStripe) {
          return {color:this.contents.tableStripeFontColor}
        }
      } else {
        return ''
      }
    },
    cellStyle({ row, rowIndex}){
      if (rowIndex % 2 == 1) {
        if(this.contents.tableStripe) {
          return {backgroundColor:this.contents.tableStripeBgColor}
        }
      } else {
        return ''
      }
    },
    headerRowStyle({ row, rowIndex}){
      return {color: this.contents.tableHeaderFontColor}
    },
    headerCellStyle({ row, rowIndex}){
      return {backgroundColor: this.contents.tableHeaderBgColor}
    },
    // 表格按钮
    contentTableBtnStyleChange(){
      // this.$nextTick(()=>{
      //   setTimeout(()=>{
      //     document.querySelectorAll('.table-content .tables .el-table__body .el-button--success').forEach(el=>{
      //       el.style.height = this.contents.tableBtnHeight
      //       el.style.color = this.contents.tableBtnDetailFontColor
      //       el.style.fontSize = this.contents.tableBtnFontSize
      //       el.style.borderWidth = this.contents.tableBtnBorderWidth
      //       el.style.borderStyle = this.contents.tableBtnBorderStyle
      //       el.style.borderColor = this.contents.tableBtnBorderColor
      //       el.style.borderRadius = this.contents.tableBtnBorderRadius
      //       el.style.backgroundColor = this.contents.tableBtnDetailBgColor
      //     })
      //     document.querySelectorAll('.table-content .tables .el-table__body .el-button--primary').forEach(el=>{
      //       el.style.height = this.contents.tableBtnHeight
      //       el.style.color = this.contents.tableBtnEditFontColor
      //       el.style.fontSize = this.contents.tableBtnFontSize
      //       el.style.borderWidth = this.contents.tableBtnBorderWidth
      //       el.style.borderStyle = this.contents.tableBtnBorderStyle
      //       el.style.borderColor = this.contents.tableBtnBorderColor
      //       el.style.borderRadius = this.contents.tableBtnBorderRadius
      //       el.style.backgroundColor = this.contents.tableBtnEditBgColor
      //     })
      //     document.querySelectorAll('.table-content .tables .el-table__body .el-button--danger').forEach(el=>{
      //       el.style.height = this.contents.tableBtnHeight
      //       el.style.color = this.contents.tableBtnDelFontColor
      //       el.style.fontSize = this.contents.tableBtnFontSize
      //       el.style.borderWidth = this.contents.tableBtnBorderWidth
      //       el.style.borderStyle = this.contents.tableBtnBorderStyle
      //       el.style.borderColor = this.contents.tableBtnBorderColor
      //       el.style.borderRadius = this.contents.tableBtnBorderRadius
      //       el.style.backgroundColor = this.contents.tableBtnDelBgColor
      //     })

      //   }, 50)
      // })
    },
    // 分页
    contentPageStyleChange(){
      let arr = []

      if(this.contents.pageTotal) arr.push('total')
      if(this.contents.pageSizes) arr.push('sizes')
      if(this.contents.pagePrevNext){
        arr.push('prev')
        if(this.contents.pagePager) arr.push('pager')
        arr.push('next')
      }
      if(this.contents.pageJumper) arr.push('jumper')
      this.layouts = arr.join()
      this.contents.pageEachNum = 10
    },

            danganbiandongCrossAddOrUpdateHandler(row,type){
      this.showFlag = false;
      this.addOrUpdateFlag = false;
      this.danganbiandongCrossAddOrUpdateFlag = true;
      this.$storage.set('crossObj',row);
      this.$storage.set('crossTable','gerendangan');
      this.$nextTick(() => {
        this.$refs.danganbiandongCrossaddOrUpdate.init(row.id,type);
      });
    },
                    init () {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            },
    search() {
      this.pageIndex = 1;
      this.getDataList();
    },
    // 获取数据列表
    getDataList() {
      this.dataListLoading = true;
      let params = {
        page: this.pageIndex,
        limit: this.pageSize,
        sort: 'id',
      }
                                          if(this.searchForm.jiaoshigonghao!='' && this.searchForm.jiaoshigonghao!=undefined){
            params['jiaoshigonghao'] = '%' + this.searchForm.jiaoshigonghao + '%'
          }
                                                            if(this.searchForm.jiaoshixingming!='' && this.searchForm.jiaoshixingming!=undefined){
            params['jiaoshixingming'] = '%' + this.searchForm.jiaoshixingming + '%'
          }
                                                                                                                                                                                                                                                                                        if(this.searchForm.zhicheng!='' && this.searchForm.zhicheng!=undefined){
            params['zhicheng'] = '%' + this.searchForm.zhicheng + '%'
          }
                                                            if(this.searchForm.gangwei!='' && this.searchForm.gangwei!=undefined){
            params['gangwei'] = '%' + this.searchForm.gangwei + '%'
          }
                                                                                                                      this.$http({
        url: "gerendangan/page",
        method: "get",
        params: params
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.dataList = data.data.list;
          this.totalPage = data.data.total;
        } else {
          this.dataList = [];
          this.totalPage = 0;
        }
        this.dataListLoading = false;
      });
    },
    // 每页数
    sizeChangeHandle(val) {
      this.pageSize = val;
      this.pageIndex = 1;
      this.getDataList();
    },
    // 当前页
    currentChangeHandle(val) {
      this.pageIndex = val;
      this.getDataList();
    },
    // 多选
    selectionChangeHandler(val) {
      this.dataListSelections = val;
    },
    // 添加/修改
    addOrUpdateHandler(id,type) {
      this.showFlag = false;
      this.addOrUpdateFlag = true;
      this.crossAddOrUpdateFlag = false;
      if(type!='info'){
        type = 'else';
      }
      this.$nextTick(() => {
        this.$refs.addOrUpdate.init(id,type);
      });
    },
    // 查看评论
        // 审核窗口
    shDialog(row){
      this.sfshVisiable = !this.sfshVisiable;
      if(row){
        this.shForm = {
                    jiaoshigonghao: row.jiaoshigonghao,
                    jiaoshixingming: row.jiaoshixingming,
                    xingbie: row.xingbie,
                    lianxidianhua: row.lianxidianhua,
                    shenfenzheng: row.shenfenzheng,
                    jiatingzhuzhi: row.jiatingzhuzhi,
                    zuigaoxueli: row.zuigaoxueli,
                    zhengzhimianmao: row.zhengzhimianmao,
                    canjiadangpaishijian: row.canjiadangpaishijian,
                    hunyuqingkuang: row.hunyuqingkuang,
                    canjiagongzuoshijian: row.canjiagongzuoshijian,
                    benxiaorenzhishijian: row.benxiaorenzhishijian,
                    zhicheng: row.zhicheng,
                    gangwei: row.gangwei,
                    xinji: row.xinji,
                    dangancailiao: row.dangancailiao,
                    sfsh: row.sfsh,
                    shhf: row.shhf,
                    id: row.id
        }
      }
    },
    // 审核
    shHandler(){
      this.$confirm(`确定操作?`, "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        this.$http({
          url: "gerendangan/update",
          method: "post",
          data: this.shForm
        }).then(({ data }) => {
          if (data && data.code === 0) {
            this.$message({
              message: "操作成功",
              type: "success",
              duration: 1500,
              onClose: () => {
                this.getDataList();
                this.shDialog()
              }
            });
          } else {
            this.$message.error(data.msg);
          }
        });
      });
    },
        // 下载
    download(file){
      window.open(`${file}`)
    },
    // 删除
    deleteHandler(id) {
      var ids = id
        ? [Number(id)]
        : this.dataListSelections.map(item => {
            return Number(item.id);
          });
      this.$confirm(`确定进行[${id ? "删除" : "批量删除"}]操作?`, "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        this.$http({
          url: "gerendangan/delete",
          method: "post",
          data: ids
        }).then(({ data }) => {
          if (data && data.code === 0) {
            this.$message({
              message: "操作成功",
              type: "success",
              duration: 1500,
              onClose: () => {
                this.search();
              }
            });
          } else {
            this.$message.error(data.msg);
          }
        });
      });
    },
    async printJson() {
      //通过getdata调用后台接口获取数据封装到res
      this.list = this.dataList;
      let data = []
      for (let i=0; i < this.list.length; i++) {
          data.push({
          jiaoshigonghao: this.list[i].jiaoshigonghao,
          jiaoshixingming: this.list[i].jiaoshixingming,
          xingbie: this.list[i].xingbie,
          lianxidianhua: this.list[i].lianxidianhua,
          shenfenzheng: this.list[i].shenfenzheng,
          jiatingzhuzhi: this.list[i].jiatingzhuzhi,
          zuigaoxueli: this.list[i].zuigaoxueli,
          zhengzhimianmao: this.list[i].zhengzhimianmao,
          canjiadangpaishijian: this.list[i].canjiadangpaishijian,
          hunyuqingkuang: this.list[i].hunyuqingkuang,
          canjiagongzuoshijian: this.list[i].canjiagongzuoshijian,
          benxiaorenzhishijian: this.list[i].benxiaorenzhishijian,
          zhicheng: this.list[i].zhicheng,
          gangwei: this.list[i].gangwei,
          xinji: this.list[i].xinji,
          sfsh: this.list[i].sfsh,
        })
      }
      printJS({
        printable: data,
        properties: [
	  {
		field: 'jiaoshigonghao',
		displayName: '劳模工号',
		columnSize: 1
	  },
	  {
		field: 'jiaoshixingming',
		displayName: '劳模姓名',
		columnSize: 1
	  },
	  {
		field: 'xingbie',
		displayName: '性别',
		columnSize: 1
	  },
	  {
		field: 'lianxidianhua',
		displayName: '联系电话',
		columnSize: 1
	  },
	  {
		field: 'shenfenzheng',
		displayName: '身份证',
		columnSize: 1
	  },
	  {
		field: 'jiatingzhuzhi',
		displayName: '家庭住址',
		columnSize: 1
	  },
	  {
		field: 'zuigaoxueli',
		displayName: '最高学历',
		columnSize: 1
	  },
	  {
		field: 'zhengzhimianmao',
		displayName: '政治面貌',
		columnSize: 1
	  },
	  {
		field: 'canjiadangpaishijian',
		displayName: '参加党派时间',
		columnSize: 1
	  },
	  {
		field: 'hunyuqingkuang',
		displayName: '婚育情况',
		columnSize: 1
	  },
	  {
		field: 'canjiagongzuoshijian',
		displayName: '参加工作时间',
		columnSize: 1
	  },
	  {
		field: 'benxiaorenzhishijian',
		displayName: '本校任职时间',
		columnSize: 1
	  },
	  {
		field: 'zhicheng',
		displayName: '职称',
		columnSize: 1
	  },
	  {
		field: 'gangwei',
		displayName: '岗位',
		columnSize: 1
	  },
	  {
		field: 'xinji',
		displayName: '薪级',
		columnSize: 1
	  },
	  {
		field: 'sfsh',
		displayName: '是否审核',
		columnSize: 1
	  },
        ],
        type: 'json',
        header: '个人档案',
        // 样式设置
        gridStyle: 'border: 2px solid #3971A5;',
        gridHeaderStyle: 'color: red;  border: 2px solid #3971A5;'
      })
    },
  }

};
</script>
<style lang="scss" scoped>
//导出excel
  .export-excel-wrapper{
    display: inline-block;
  }
  .slt {
    margin: 0 !important;
    display: flex;
  }

  .ad {
    margin: 0 !important;
    display: flex;
  }

  .pages {
    & /deep/ el-pagination__sizes{
      & /deep/ el-input__inner {
        height: 22px;
        line-height: 22px;
      }
    }
  }
  

  .el-button+.el-button {
    margin:0;
  } 

  .tables {
	& /deep/ .el-button--success {
		height: 40px;
		color: #333;
		font-size: 14px;
		border-width: 1px;
		border-style: solid;
		border-color: rgba(196, 210, 244, 1);
		border-radius: 22px;
		background-color: rgba(171, 239, 239, 1);
	}
	
	& /deep/ .el-button--primary {
		height: 40px;
		color: #333;
		font-size: 14px;
		border-width: 1px;
		border-style: solid;
		border-color: rgba(196, 210, 244, 1);
		border-radius: 22px;
		background-color: rgba(240, 242, 124, 1);
	}
	
	& /deep/ .el-button--danger {
		height: 40px;
		color: #333;
		font-size: 14px;
		border-width: 1px;
		border-style: solid;
		border-color: rgba(196, 210, 244, 1);
		border-radius: 22px;
		background-color: rgba(244, 150, 150, 1);
	}

    & /deep/ .el-button {
      margin: 4px;
    }
  }

</style>
