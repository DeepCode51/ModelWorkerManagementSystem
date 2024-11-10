<template>
  <div class="addEdit-block">
    <el-form
      class="detail-form-content"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="80px"
	  :style="{backgroundColor:addEditForm.addEditBoxColor}"
    >
      <el-row>
                        <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="劳模工号" prop="jiaoshigonghao">
          <el-input v-model="ruleForm.jiaoshigonghao" 
              placeholder="劳模工号" clearable  :readonly="ro.jiaoshigonghao"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="劳模工号" prop="jiaoshigonghao">
              <el-input v-model="ruleForm.jiaoshigonghao" 
                placeholder="劳模工号" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="劳模姓名" prop="jiaoshixingming">
          <el-input v-model="ruleForm.jiaoshixingming" 
              placeholder="劳模姓名" clearable  :readonly="ro.jiaoshixingming"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="劳模姓名" prop="jiaoshixingming">
              <el-input v-model="ruleForm.jiaoshixingming" 
                placeholder="劳模姓名" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="性别" prop="xingbie">
          <el-input v-model="ruleForm.xingbie" 
              placeholder="性别" clearable  :readonly="ro.xingbie"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="性别" prop="xingbie">
              <el-input v-model="ruleForm.xingbie" 
                placeholder="性别" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="联系电话" prop="lianxidianhua">
          <el-input v-model="ruleForm.lianxidianhua" 
              placeholder="联系电话" clearable  :readonly="ro.lianxidianhua"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="联系电话" prop="lianxidianhua">
              <el-input v-model="ruleForm.lianxidianhua" 
                placeholder="联系电话" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="身份证" prop="shenfenzheng">
          <el-input v-model="ruleForm.shenfenzheng" 
              placeholder="身份证" clearable  :readonly="ro.shenfenzheng"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="身份证" prop="shenfenzheng">
              <el-input v-model="ruleForm.shenfenzheng" 
                placeholder="身份证" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="家庭住址" prop="jiatingzhuzhi">
          <el-input v-model="ruleForm.jiatingzhuzhi" 
              placeholder="家庭住址" clearable  :readonly="ro.jiatingzhuzhi"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="家庭住址" prop="jiatingzhuzhi">
              <el-input v-model="ruleForm.jiatingzhuzhi" 
                placeholder="家庭住址" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="最高学历" prop="zuigaoxueli">
          <el-input v-model="ruleForm.zuigaoxueli" 
              placeholder="最高学历" clearable  :readonly="ro.zuigaoxueli"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="最高学历" prop="zuigaoxueli">
              <el-input v-model="ruleForm.zuigaoxueli" 
                placeholder="最高学历" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="select" v-if="type!='info'"  label="政治面貌" prop="zhengzhimianmao">
          <el-select v-model="ruleForm.zhengzhimianmao" placeholder="请选择政治面貌">
            <el-option
                v-for="(item,index) in zhengzhimianmaoOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="政治面貌" prop="zhengzhimianmao">
	      <el-input v-model="ruleForm.zhengzhimianmao"
                placeholder="政治面貌" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="date" v-if="type!='info'" label="参加党派时间" prop="canjiadangpaishijian">
            <el-date-picker
                format="yyyy 年 MM 月 dd 日"
                value-format="yyyy-MM-dd"
                v-model="ruleForm.canjiadangpaishijian" 
                type="date"
                placeholder="参加党派时间">
            </el-date-picker> 
        </el-form-item>
        <div v-else>
          <el-form-item class="input" v-if="ruleForm.canjiadangpaishijian" label="参加党派时间" prop="canjiadangpaishijian">
              <el-input v-model="ruleForm.canjiadangpaishijian" 
                placeholder="参加党派时间" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="select" v-if="type!='info'"  label="婚育情况" prop="hunyuqingkuang">
          <el-select v-model="ruleForm.hunyuqingkuang" placeholder="请选择婚育情况">
            <el-option
                v-for="(item,index) in hunyuqingkuangOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="婚育情况" prop="hunyuqingkuang">
	      <el-input v-model="ruleForm.hunyuqingkuang"
                placeholder="婚育情况" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="date" v-if="type!='info'" label="参加工作时间" prop="canjiagongzuoshijian">
            <el-date-picker
                format="yyyy 年 MM 月 dd 日"
                value-format="yyyy-MM-dd"
                v-model="ruleForm.canjiagongzuoshijian" 
                type="date"
                placeholder="参加工作时间">
            </el-date-picker> 
        </el-form-item>
        <div v-else>
          <el-form-item class="input" v-if="ruleForm.canjiagongzuoshijian" label="参加工作时间" prop="canjiagongzuoshijian">
              <el-input v-model="ruleForm.canjiagongzuoshijian" 
                placeholder="参加工作时间" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="date" v-if="type!='info'" label="本校任职时间" prop="benxiaorenzhishijian">
            <el-date-picker
                format="yyyy 年 MM 月 dd 日"
                value-format="yyyy-MM-dd"
                v-model="ruleForm.benxiaorenzhishijian" 
                type="date"
                placeholder="本校任职时间">
            </el-date-picker> 
        </el-form-item>
        <div v-else>
          <el-form-item class="input" v-if="ruleForm.benxiaorenzhishijian" label="本校任职时间" prop="benxiaorenzhishijian">
              <el-input v-model="ruleForm.benxiaorenzhishijian" 
                placeholder="本校任职时间" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="职称" prop="zhicheng">
          <el-input v-model="ruleForm.zhicheng" 
              placeholder="职称" clearable  :readonly="ro.zhicheng"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="职称" prop="zhicheng">
              <el-input v-model="ruleForm.zhicheng" 
                placeholder="职称" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="岗位" prop="gangwei">
          <el-input v-model="ruleForm.gangwei" 
              placeholder="岗位" clearable  :readonly="ro.gangwei"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="岗位" prop="gangwei">
              <el-input v-model="ruleForm.gangwei" 
                placeholder="岗位" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="薪级" prop="xinji">
          <el-input v-model="ruleForm.xinji" 
              placeholder="薪级" clearable  :readonly="ro.xinji"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="薪级" prop="xinji">
              <el-input v-model="ruleForm.xinji" 
                placeholder="薪级" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="24">  
        <el-form-item class="upload" v-if="type!='info'" label="档案材料" prop="dangancailiao">
          <file-upload
          tip="点击上传档案材料"
          action="file/upload"
          :limit="1"
          :multiple="true"
          :fileUrls="ruleForm.dangancailiao?ruleForm.dangancailiao:''"
          @change="dangancailiaoUploadChange"
          ></file-upload>
        </el-form-item>  
        <div v-else>
          <el-form-item v-if="ruleForm.dangancailiao" label="档案材料" prop="dangancailiao">
            <el-button type="text" size="small" @click="download(ruleForm.dangancailiao)">下载</el-button>
          </el-form-item>
        </div>    
      </el-col>      
                                                                                          </el-row>
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          <el-form-item class="btn">
                <el-button v-if="type!='info'" type="primary" class="btn-success" @click="onSubmit">提交</el-button>
        <el-button v-if="type!='info'" class="btn-close" @click="back()">取消</el-button>
        <el-button v-if="type=='info'" class="btn-close" @click="back()">返回</el-button>
      </el-form-item>
    </el-form>
    
    
  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isPhone, isMobile,isURL,checkIdCard } from "@/utils/validate";
export default {
  data() {
    let self = this
    var validateIdCard = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!checkIdCard(value)) {
        callback(new Error("请输入正确的身份证号码"));
      } else {
        callback();
      }
    };
    var validateUrl = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isURL(value)) {
        callback(new Error("请输入正确的URL地址"));
      } else {
        callback();
      }
    };
    var validateMobile = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isMobile(value)) {
        callback(new Error("请输入正确的手机号码"));
      } else {
        callback();
      }
    };
    var validatePhone = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isPhone(value)) {
        callback(new Error("请输入正确的电话号码"));
      } else {
        callback();
      }
    };
    var validateEmail = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isEmail(value)) {
        callback(new Error("请输入正确的邮箱地址"));
      } else {
        callback();
      }
    };
    var validateNumber = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isNumber(value)) {
        callback(new Error("请输入数字"));
      } else {
        callback();
      }
    };
    var validateIntNumber = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isIntNumer(value)) {
        callback(new Error("请输入整数"));
      } else {
        callback();
      }
    };
    return {
	  addEditForm: {"btnSaveFontColor":"#fff","selectFontSize":"14px","btnCancelBorderColor":"rgba(152, 129, 129, 1)","inputBorderRadius":"22px","inputFontSize":"14px","textareaBgColor":"#fff","btnSaveFontSize":"14px","textareaBorderRadius":"22px","uploadBgColor":"#fff","textareaBorderStyle":"solid","btnCancelWidth":"88px","textareaHeight":"120px","dateBgColor":"#fff","btnSaveBorderRadius":"22px","uploadLableFontSize":"14px","textareaBorderWidth":"1px","inputLableColor":"#606266","addEditBoxColor":"rgba(210, 194, 194, 0.29)","dateIconFontSize":"14px","btnSaveBgColor":"#409EFF","uploadIconFontColor":"#8c939d","textareaBorderColor":"rgba(152, 129, 129, 1)","btnCancelBgColor":"rgba(143, 222, 143, 1)","selectLableColor":"#606266","btnSaveBorderStyle":"solid","dateBorderWidth":"1px","dateLableFontSize":"14px","dateBorderRadius":"22px","btnCancelBorderStyle":"solid","selectLableFontSize":"14px","selectBorderStyle":"solid","selectIconFontColor":"#C0C4CC","btnCancelHeight":"44px","inputHeight":"40px","btnCancelFontColor":"#606266","dateBorderColor":"rgba(152, 129, 129, 1)","dateIconFontColor":"#C0C4CC","uploadBorderStyle":"solid","dateBorderStyle":"solid","dateLableColor":"#606266","dateFontSize":"14px","inputBorderWidth":"1px","uploadIconFontSize":"28px","selectHeight":"40px","inputFontColor":"#606266","uploadHeight":"148px","textareaLableColor":"#606266","textareaLableFontSize":"14px","btnCancelFontSize":"14px","inputBorderStyle":"solid","btnCancelBorderRadius":"22px","inputBgColor":"rgba(252, 250, 250, 1)","inputLableFontSize":"14px","uploadLableColor":"#606266","uploadBorderRadius":"22px","btnSaveHeight":"44px","selectBgColor":"#fff","btnSaveWidth":"88px","selectIconFontSize":"14px","dateHeight":"40px","selectBorderColor":"rgba(152, 129, 129, 1)","inputBorderColor":"rgba(152, 129, 129, 1)","uploadBorderColor":"rgba(152, 129, 129, 1)","textareaFontColor":"#606266","selectBorderWidth":"1px","dateFontColor":"#606266","btnCancelBorderWidth":"1px","uploadBorderWidth":"1px","textareaFontSize":"14px","selectBorderRadius":"22px","selectFontColor":"#606266","btnSaveBorderColor":"#409EFF","btnSaveBorderWidth":"1px"},
      id: '',
      type: '',
      ro:{
	jiaoshigonghao : false,
	jiaoshixingming : false,
	xingbie : false,
	lianxidianhua : false,
	shenfenzheng : false,
	jiatingzhuzhi : false,
	zuigaoxueli : false,
	zhengzhimianmao : false,
	canjiadangpaishijian : false,
	hunyuqingkuang : false,
	canjiagongzuoshijian : false,
	benxiaorenzhishijian : false,
	zhicheng : false,
	gangwei : false,
	xinji : false,
	dangancailiao : false,
	sfsh : false,
	shhf : false,
      },
            ruleForm: {
                	        jiaoshigonghao: '',
	                        	        jiaoshixingming: '',
	                        	        xingbie: '',
	                        	        lianxidianhua: '',
	                        	        shenfenzheng: '',
	                        	        jiatingzhuzhi: '',
	                        	        zuigaoxueli: '',
	                        	        zhengzhimianmao: '',
	                        	        canjiadangpaishijian: '',
	                        	        hunyuqingkuang: '',
	                        	        canjiagongzuoshijian: '',
	                        	        benxiaorenzhishijian: '',
	                        	        zhicheng: '',
	                        	        gangwei: '',
	                        	        xinji: '',
	                        	        dangancailiao: '',
	                        	                        	        shhf: '',
	                      },
                                                                                                                          zhengzhimianmaoOptions: [],
                                              hunyuqingkuangOptions: [],
                                                                                                                                    rules: {
                  jiaoshigonghao: [
                                    	                                                              ],
                  jiaoshixingming: [
                                    	                                                              ],
                  xingbie: [
                                    	                                                              ],
                  lianxidianhua: [
                                    	                                                              ],
                  shenfenzheng: [
                                    	                                                        { validator: validateIdCard, trigger: 'blur' },
                                  ],
                  jiatingzhuzhi: [
                                    	                                                              ],
                  zuigaoxueli: [
                                    	                                                              ],
                  zhengzhimianmao: [
                                    	                                                              ],
                  canjiadangpaishijian: [
                                    	                                                              ],
                  hunyuqingkuang: [
                                    	                                                              ],
                  canjiagongzuoshijian: [
                                    	                                                              ],
                  benxiaorenzhishijian: [
                                    	                                                              ],
                  zhicheng: [
                                    	                                                              ],
                  gangwei: [
                                    	                                                              ],
                  xinji: [
                                    	                                                              ],
                  dangancailiao: [
                                    	                                                              ],
                  sfsh: [
                                    	                                                              ],
                  shhf: [
                                    	                                                              ],
              }
    };
  },
  props: ["parent"],
  computed: {
                                                                                                                                                                                                                              },
  created() {
	this.addEditStyleChange()
	this.addEditUploadStyleChange()
  },
  methods: {
        // 下载
    download(file){
      window.open(`${file}`)
    },
    // 初始化
    init(id,type) {
      if (id) {
        this.id = id;
        this.type = type;
      }
      if(this.type=='info'||this.type=='else'){
        this.info(id);
      }else if(this.type=='cross'){
        var obj = this.$storage.getObj('crossObj');
        for (var o in obj){
          	            if(o=='jiaoshigonghao'){
            this.ruleForm.jiaoshigonghao = obj[o];
	    this.ro.jiaoshigonghao = true;
            continue;
          }
	            	            if(o=='jiaoshixingming'){
            this.ruleForm.jiaoshixingming = obj[o];
	    this.ro.jiaoshixingming = true;
            continue;
          }
	            	            if(o=='xingbie'){
            this.ruleForm.xingbie = obj[o];
	    this.ro.xingbie = true;
            continue;
          }
	            	            if(o=='lianxidianhua'){
            this.ruleForm.lianxidianhua = obj[o];
	    this.ro.lianxidianhua = true;
            continue;
          }
	            	            if(o=='shenfenzheng'){
            this.ruleForm.shenfenzheng = obj[o];
	    this.ro.shenfenzheng = true;
            continue;
          }
	            	            if(o=='jiatingzhuzhi'){
            this.ruleForm.jiatingzhuzhi = obj[o];
	    this.ro.jiatingzhuzhi = true;
            continue;
          }
	            	            if(o=='zuigaoxueli'){
            this.ruleForm.zuigaoxueli = obj[o];
	    this.ro.zuigaoxueli = true;
            continue;
          }
	            	            if(o=='zhengzhimianmao'){
            this.ruleForm.zhengzhimianmao = obj[o];
	    this.ro.zhengzhimianmao = true;
            continue;
          }
	            	            if(o=='canjiadangpaishijian'){
            this.ruleForm.canjiadangpaishijian = obj[o];
	    this.ro.canjiadangpaishijian = true;
            continue;
          }
	            	            if(o=='hunyuqingkuang'){
            this.ruleForm.hunyuqingkuang = obj[o];
	    this.ro.hunyuqingkuang = true;
            continue;
          }
	            	            if(o=='canjiagongzuoshijian'){
            this.ruleForm.canjiagongzuoshijian = obj[o];
	    this.ro.canjiagongzuoshijian = true;
            continue;
          }
	            	            if(o=='benxiaorenzhishijian'){
            this.ruleForm.benxiaorenzhishijian = obj[o];
	    this.ro.benxiaorenzhishijian = true;
            continue;
          }
	            	            if(o=='zhicheng'){
            this.ruleForm.zhicheng = obj[o];
	    this.ro.zhicheng = true;
            continue;
          }
	            	            if(o=='gangwei'){
            this.ruleForm.gangwei = obj[o];
	    this.ro.gangwei = true;
            continue;
          }
	            	            if(o=='xinji'){
            this.ruleForm.xinji = obj[o];
	    this.ro.xinji = true;
            continue;
          }
	            	            if(o=='dangancailiao'){
            this.ruleForm.dangancailiao = obj[o];
	    this.ro.dangancailiao = true;
            continue;
          }
	            	            	                    }
                                                                                                                                                                                                                                                                                                              }
            // 获取用户信息
      this.$http({
        url: `${this.$storage.get('sessionTable')}/session`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
          var json = data.data;
                      		if(json.jiaoshigonghao!=''&&json.jiaoshigonghao){
              		this.ruleForm.jiaoshigonghao = json.jiaoshigonghao
		}
                                  		if(json.jiaoshixingming!=''&&json.jiaoshixingming){
              		this.ruleForm.jiaoshixingming = json.jiaoshixingming
		}
                                  		if(json.xingbie!=''&&json.xingbie){
              		this.ruleForm.xingbie = json.xingbie
		}
                                  		if(json.lianxidianhua!=''&&json.lianxidianhua){
              		this.ruleForm.lianxidianhua = json.lianxidianhua
		}
                                                                                                                                                                                                                                                                                                                                                  } else {
          this.$message.error(data.msg);
        }
      });
                                                                                                                                                                        this.zhengzhimianmaoOptions = "中共党员,中共预备党员,共青团员,群众".split(',')
                                                          this.hunyuqingkuangOptions = "已婚已育,已婚未育,未婚未育".split(',')
                                                                                                                                                                            },
                                                                                                                                                        // 多级联动参数
                                                                                                                                                                                                info(id) {
      this.$http({
        url: `gerendangan/info/${id}`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.ruleForm = data.data;
        } else {
          this.$message.error(data.msg);
        }
      });
    },
        // 提交
    onSubmit() {
                  // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                                                                                                                                                                                                                                                                                                                                                                        this.$refs["ruleForm"].validate(valid => {
        if (valid) {
          this.$http({
            url: `gerendangan/${!this.ruleForm.id ? "save" : "update"}`,
            method: "post",
            data: this.ruleForm
          }).then(({ data }) => {
            if (data && data.code === 0) {
              this.$message({
                message: "操作成功",
                type: "success",
                duration: 1500,
                onClose: () => {
                  this.parent.showFlag = true;
                  this.parent.addOrUpdateFlag = false;
                  this.parent.gerendanganCrossAddOrUpdateFlag = false;
                  this.parent.search();
                  this.parent.contentStyleChange();
                }
              });
            } else {
              this.$message.error(data.msg);
            }
          });
        }
      });
    },
    // 获取uuid
    getUUID () {
      return new Date().getTime();
    },
    // 返回
    back() {
      this.parent.showFlag = true;
      this.parent.addOrUpdateFlag = false;
      this.parent.gerendanganCrossAddOrUpdateFlag = false;
      this.parent.contentStyleChange();
    },
                                                                                                                                                                                                            dangancailiaoUploadChange(fileUrls) {
                this.ruleForm.dangancailiao = fileUrls;
				this.addEditUploadStyleChange()
            },
                                    	addEditStyleChange() {
	  this.$nextTick(()=>{
	    // input
	    document.querySelectorAll('.addEdit-block .input .el-input__inner').forEach(el=>{
	      el.style.height = this.addEditForm.inputHeight
	      el.style.color = this.addEditForm.inputFontColor
	      el.style.fontSize = this.addEditForm.inputFontSize
	      el.style.borderWidth = this.addEditForm.inputBorderWidth
	      el.style.borderStyle = this.addEditForm.inputBorderStyle
	      el.style.borderColor = this.addEditForm.inputBorderColor
	      el.style.borderRadius = this.addEditForm.inputBorderRadius
	      el.style.backgroundColor = this.addEditForm.inputBgColor
	    })
	    document.querySelectorAll('.addEdit-block .input .el-form-item__label').forEach(el=>{
	      el.style.lineHeight = this.addEditForm.inputHeight
	      el.style.color = this.addEditForm.inputLableColor
	      el.style.fontSize = this.addEditForm.inputLableFontSize
	    })
	    // select
	    document.querySelectorAll('.addEdit-block .select .el-input__inner').forEach(el=>{
	      el.style.height = this.addEditForm.selectHeight
	      el.style.color = this.addEditForm.selectFontColor
	      el.style.fontSize = this.addEditForm.selectFontSize
	      el.style.borderWidth = this.addEditForm.selectBorderWidth
	      el.style.borderStyle = this.addEditForm.selectBorderStyle
	      el.style.borderColor = this.addEditForm.selectBorderColor
	      el.style.borderRadius = this.addEditForm.selectBorderRadius
	      el.style.backgroundColor = this.addEditForm.selectBgColor
	    })
	    document.querySelectorAll('.addEdit-block .select .el-form-item__label').forEach(el=>{
	      el.style.lineHeight = this.addEditForm.selectHeight
	      el.style.color = this.addEditForm.selectLableColor
	      el.style.fontSize = this.addEditForm.selectLableFontSize
	    })
	    document.querySelectorAll('.addEdit-block .select .el-select__caret').forEach(el=>{
	      el.style.color = this.addEditForm.selectIconFontColor
	      el.style.fontSize = this.addEditForm.selectIconFontSize
	    })
	    // date
	    document.querySelectorAll('.addEdit-block .date .el-input__inner').forEach(el=>{
	      el.style.height = this.addEditForm.dateHeight
	      el.style.color = this.addEditForm.dateFontColor
	      el.style.fontSize = this.addEditForm.dateFontSize
	      el.style.borderWidth = this.addEditForm.dateBorderWidth
	      el.style.borderStyle = this.addEditForm.dateBorderStyle
	      el.style.borderColor = this.addEditForm.dateBorderColor
	      el.style.borderRadius = this.addEditForm.dateBorderRadius
	      el.style.backgroundColor = this.addEditForm.dateBgColor
	    })
	    document.querySelectorAll('.addEdit-block .date .el-form-item__label').forEach(el=>{
	      el.style.lineHeight = this.addEditForm.dateHeight
	      el.style.color = this.addEditForm.dateLableColor
	      el.style.fontSize = this.addEditForm.dateLableFontSize
	    })
	    document.querySelectorAll('.addEdit-block .date .el-input__icon').forEach(el=>{
	      el.style.color = this.addEditForm.dateIconFontColor
	      el.style.fontSize = this.addEditForm.dateIconFontSize
	      el.style.lineHeight = this.addEditForm.dateHeight
	    })
	    // upload
	    let iconLineHeight = parseInt(this.addEditForm.uploadHeight) - parseInt(this.addEditForm.uploadBorderWidth) * 2 + 'px'
	    document.querySelectorAll('.addEdit-block .upload .el-upload--picture-card').forEach(el=>{
	      el.style.width = this.addEditForm.uploadHeight
	      el.style.height = this.addEditForm.uploadHeight
	      el.style.borderWidth = this.addEditForm.uploadBorderWidth
	      el.style.borderStyle = this.addEditForm.uploadBorderStyle
	      el.style.borderColor = this.addEditForm.uploadBorderColor
	      el.style.borderRadius = this.addEditForm.uploadBorderRadius
	      el.style.backgroundColor = this.addEditForm.uploadBgColor
	    })
	    document.querySelectorAll('.addEdit-block .upload .el-form-item__label').forEach(el=>{
	      el.style.lineHeight = this.addEditForm.uploadHeight
	      el.style.color = this.addEditForm.uploadLableColor
	      el.style.fontSize = this.addEditForm.uploadLableFontSize
	    })
	    document.querySelectorAll('.addEdit-block .upload .el-icon-plus').forEach(el=>{
	      el.style.color = this.addEditForm.uploadIconFontColor
	      el.style.fontSize = this.addEditForm.uploadIconFontSize
	      el.style.lineHeight = iconLineHeight
	      el.style.display = 'block'
	    })
	    // 多文本输入框
	    document.querySelectorAll('.addEdit-block .textarea .el-textarea__inner').forEach(el=>{
	      el.style.height = this.addEditForm.textareaHeight
	      el.style.color = this.addEditForm.textareaFontColor
	      el.style.fontSize = this.addEditForm.textareaFontSize
	      el.style.borderWidth = this.addEditForm.textareaBorderWidth
	      el.style.borderStyle = this.addEditForm.textareaBorderStyle
	      el.style.borderColor = this.addEditForm.textareaBorderColor
	      el.style.borderRadius = this.addEditForm.textareaBorderRadius
	      el.style.backgroundColor = this.addEditForm.textareaBgColor
	    })
	    document.querySelectorAll('.addEdit-block .textarea .el-form-item__label').forEach(el=>{
	      // el.style.lineHeight = this.addEditForm.textareaHeight
	      el.style.color = this.addEditForm.textareaLableColor
	      el.style.fontSize = this.addEditForm.textareaLableFontSize
	    })
	    // 保存
	    document.querySelectorAll('.addEdit-block .btn .btn-success').forEach(el=>{
	      el.style.width = this.addEditForm.btnSaveWidth
	      el.style.height = this.addEditForm.btnSaveHeight
	      el.style.color = this.addEditForm.btnSaveFontColor
	      el.style.fontSize = this.addEditForm.btnSaveFontSize
	      el.style.borderWidth = this.addEditForm.btnSaveBorderWidth
	      el.style.borderStyle = this.addEditForm.btnSaveBorderStyle
	      el.style.borderColor = this.addEditForm.btnSaveBorderColor
	      el.style.borderRadius = this.addEditForm.btnSaveBorderRadius
	      el.style.backgroundColor = this.addEditForm.btnSaveBgColor
	    })
	    // 返回
	    document.querySelectorAll('.addEdit-block .btn .btn-close').forEach(el=>{
	      el.style.width = this.addEditForm.btnCancelWidth
	      el.style.height = this.addEditForm.btnCancelHeight
	      el.style.color = this.addEditForm.btnCancelFontColor
	      el.style.fontSize = this.addEditForm.btnCancelFontSize
	      el.style.borderWidth = this.addEditForm.btnCancelBorderWidth
	      el.style.borderStyle = this.addEditForm.btnCancelBorderStyle
	      el.style.borderColor = this.addEditForm.btnCancelBorderColor
	      el.style.borderRadius = this.addEditForm.btnCancelBorderRadius
	      el.style.backgroundColor = this.addEditForm.btnCancelBgColor
	    })
	  })
	},
	addEditUploadStyleChange() {
		this.$nextTick(()=>{
		  document.querySelectorAll('.addEdit-block .upload .el-upload-list--picture-card .el-upload-list__item').forEach(el=>{
			el.style.width = this.addEditForm.uploadHeight
			el.style.height = this.addEditForm.uploadHeight
			el.style.borderWidth = this.addEditForm.uploadBorderWidth
			el.style.borderStyle = this.addEditForm.uploadBorderStyle
			el.style.borderColor = this.addEditForm.uploadBorderColor
			el.style.borderRadius = this.addEditForm.uploadBorderRadius
			el.style.backgroundColor = this.addEditForm.uploadBgColor
		  })
	  })
	},
  }
};
</script>
<style lang="scss">
.editor{
  height: 500px;
  
  & /deep/ .ql-container {
	  height: 310px;
  }
}
.amap-wrapper {
  width: 100%;
  height: 500px;
}
.search-box {
  position: absolute;
}
.addEdit-block {
	margin: -10px;
}
.detail-form-content {
	padding: 12px;
}
.btn .el-button {
  padding: 0;
}
</style>
