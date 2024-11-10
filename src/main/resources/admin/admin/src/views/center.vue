<template>
  <div>
    <el-form
      class="detail-form-content"
      ref="ruleForm"
      :model="ruleForm"
      label-width="80px"
    >
      <el-row>
        <el-col :span="12">
          <el-form-item
            v-if="flag == 'jiaoshi'"
            label="劳模工号"
            prop="jiaoshigonghao"
          >
            <el-input
              v-model="ruleForm.jiaoshigonghao"
              readonly
              placeholder="劳模工号"
              clearable
            ></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item v-if="flag == 'jiaoshi'" label="密码" prop="mima">
            <el-input
              v-model="ruleForm.mima"
              placeholder="密码"
              clearable
            ></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item
            v-if="flag == 'jiaoshi'"
            label="劳模姓名"
            prop="jiaoshixingming"
          >
            <el-input
              v-model="ruleForm.jiaoshixingming"
              placeholder="劳模姓名"
              clearable
            ></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item v-if="flag == 'jiaoshi'" label="性别" prop="xingbie">
            <el-select v-model="ruleForm.xingbie" placeholder="请选择性别">
              <el-option
                v-for="(item, index) in jiaoshixingbieOptions"
                v-bind:key="index"
                :label="item"
                :value="item"
              ></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="24">
          <el-form-item v-if="flag == 'jiaoshi'" label="照片" prop="zhaopian">
            <file-upload
              tip="点击上传照片"
              action="file/upload"
              :limit="3"
              :multiple="true"
              :fileUrls="ruleForm.zhaopian ? ruleForm.zhaopian : ''"
              @change="jiaoshizhaopianUploadChange"
            ></file-upload>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item
            v-if="flag == 'jiaoshi'"
            label="联系电话"
            prop="lianxidianhua"
          >
            <el-input
              v-model="ruleForm.lianxidianhua"
              placeholder="联系电话"
              clearable
            ></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item v-if="flag == 'jiaoshi'" label="邮箱" prop="youxiang">
            <el-input
              v-model="ruleForm.youxiang"
              placeholder="邮箱"
              clearable
            ></el-input>
          </el-form-item>
        </el-col>
        <el-form-item v-if="flag == 'users'" label="用户名" prop="username">
          <el-input v-model="ruleForm.username" placeholder="用户名"></el-input>
        </el-form-item>
        <el-col :span="24">
          <el-form-item>
            <el-button type="primary" @click="onUpdateHandler">修 改</el-button>
          </el-form-item>
        </el-col>
      </el-row>
    </el-form>
  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import {
  isNumber,
  isIntNumer,
  isEmail,
  isMobile,
  isURL,
  checkIdCard,
} from '@/utils/validate'

export default {
  data() {
    return {
      ruleForm: {},
      flag: '',
      usersFlag: false,
      jiaoshixingbieOptions: [],
    }
  },
  mounted() {
    var table = this.$storage.get('sessionTable')
    this.flag = table
    this.$http({
      url: `${this.$storage.get('sessionTable')}/session`,
      method: 'get',
    }).then(({ data }) => {
      if (data && data.code === 0) {
        this.ruleForm = data.data
      } else {
        this.$message.error(data.msg)
      }
    })
    this.jiaoshixingbieOptions = '男,女'.split(',')
  },
  methods: {
    jiaoshizhaopianUploadChange(fileUrls) {
      this.ruleForm.zhaopian = fileUrls
    },
    onUpdateHandler() {
      if (!this.ruleForm.jiaoshigonghao && 'jiaoshi' == this.flag) {
        this.$message.error('劳模工号不能为空')
        return
      }
      if (!this.ruleForm.mima && 'jiaoshi' == this.flag) {
        this.$message.error('密码不能为空')
        return
      }
      if (
        'jiaoshi' == this.flag &&
        this.ruleForm.youxiang &&
        !isEmail(this.ruleForm.youxiang)
      ) {
        this.$message.error(`邮箱应输入邮箱格式`)
        return
      }
      this.$http({
        url: `${this.$storage.get('sessionTable')}/update`,
        method: 'post',
        data: this.ruleForm,
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.$message({
            message: '修改信息成功',
            type: 'success',
            duration: 1500,
            onClose: () => {},
          })
        } else {
          this.$message.error(data.msg)
        }
      })
    },
  },
}
</script>
<style lang="scss" scoped></style>
