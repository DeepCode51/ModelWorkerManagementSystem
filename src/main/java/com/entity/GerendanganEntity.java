package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 个人档案
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2021-01-14 15:15:24
 */
@TableName("gerendangan")
public class GerendanganEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public GerendanganEntity() {
		
	}
	
	public GerendanganEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 劳模工号
	 */
					
	private String jiaoshigonghao;
	
	/**
	 * 劳模姓名
	 */
					
	private String jiaoshixingming;
	
	/**
	 * 性别
	 */
					
	private String xingbie;
	
	/**
	 * 联系电话
	 */
					
	private String lianxidianhua;
	
	/**
	 * 身份证
	 */
					
	private String shenfenzheng;
	
	/**
	 * 家庭住址
	 */
					
	private String jiatingzhuzhi;
	
	/**
	 * 最高学历
	 */
					
	private String zuigaoxueli;
	
	/**
	 * 政治面貌
	 */
					
	private String zhengzhimianmao;
	
	/**
	 * 参加党派时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date canjiadangpaishijian;
	
	/**
	 * 婚育情况
	 */
					
	private String hunyuqingkuang;
	
	/**
	 * 参加工作时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date canjiagongzuoshijian;
	
	/**
	 * 本校任职时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date benxiaorenzhishijian;
	
	/**
	 * 职称
	 */
					
	private String zhicheng;
	
	/**
	 * 岗位
	 */
					
	private String gangwei;
	
	/**
	 * 薪级
	 */
					
	private String xinji;
	
	/**
	 * 档案材料
	 */
					
	private String dangancailiao;
	
	/**
	 * 是否审核
	 */
					
	private String sfsh;
	
	/**
	 * 审核回复
	 */
					
	private String shhf;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：劳模工号
	 */
	public void setJiaoshigonghao(String jiaoshigonghao) {
		this.jiaoshigonghao = jiaoshigonghao;
	}
	/**
	 * 获取：劳模工号
	 */
	public String getJiaoshigonghao() {
		return jiaoshigonghao;
	}
	/**
	 * 设置：劳模姓名
	 */
	public void setJiaoshixingming(String jiaoshixingming) {
		this.jiaoshixingming = jiaoshixingming;
	}
	/**
	 * 获取：劳模姓名
	 */
	public String getJiaoshixingming() {
		return jiaoshixingming;
	}
	/**
	 * 设置：性别
	 */
	public void setXingbie(String xingbie) {
		this.xingbie = xingbie;
	}
	/**
	 * 获取：性别
	 */
	public String getXingbie() {
		return xingbie;
	}
	/**
	 * 设置：联系电话
	 */
	public void setLianxidianhua(String lianxidianhua) {
		this.lianxidianhua = lianxidianhua;
	}
	/**
	 * 获取：联系电话
	 */
	public String getLianxidianhua() {
		return lianxidianhua;
	}
	/**
	 * 设置：身份证
	 */
	public void setShenfenzheng(String shenfenzheng) {
		this.shenfenzheng = shenfenzheng;
	}
	/**
	 * 获取：身份证
	 */
	public String getShenfenzheng() {
		return shenfenzheng;
	}
	/**
	 * 设置：家庭住址
	 */
	public void setJiatingzhuzhi(String jiatingzhuzhi) {
		this.jiatingzhuzhi = jiatingzhuzhi;
	}
	/**
	 * 获取：家庭住址
	 */
	public String getJiatingzhuzhi() {
		return jiatingzhuzhi;
	}
	/**
	 * 设置：最高学历
	 */
	public void setZuigaoxueli(String zuigaoxueli) {
		this.zuigaoxueli = zuigaoxueli;
	}
	/**
	 * 获取：最高学历
	 */
	public String getZuigaoxueli() {
		return zuigaoxueli;
	}
	/**
	 * 设置：政治面貌
	 */
	public void setZhengzhimianmao(String zhengzhimianmao) {
		this.zhengzhimianmao = zhengzhimianmao;
	}
	/**
	 * 获取：政治面貌
	 */
	public String getZhengzhimianmao() {
		return zhengzhimianmao;
	}
	/**
	 * 设置：参加党派时间
	 */
	public void setCanjiadangpaishijian(Date canjiadangpaishijian) {
		this.canjiadangpaishijian = canjiadangpaishijian;
	}
	/**
	 * 获取：参加党派时间
	 */
	public Date getCanjiadangpaishijian() {
		return canjiadangpaishijian;
	}
	/**
	 * 设置：婚育情况
	 */
	public void setHunyuqingkuang(String hunyuqingkuang) {
		this.hunyuqingkuang = hunyuqingkuang;
	}
	/**
	 * 获取：婚育情况
	 */
	public String getHunyuqingkuang() {
		return hunyuqingkuang;
	}
	/**
	 * 设置：参加工作时间
	 */
	public void setCanjiagongzuoshijian(Date canjiagongzuoshijian) {
		this.canjiagongzuoshijian = canjiagongzuoshijian;
	}
	/**
	 * 获取：参加工作时间
	 */
	public Date getCanjiagongzuoshijian() {
		return canjiagongzuoshijian;
	}
	/**
	 * 设置：本校任职时间
	 */
	public void setBenxiaorenzhishijian(Date benxiaorenzhishijian) {
		this.benxiaorenzhishijian = benxiaorenzhishijian;
	}
	/**
	 * 获取：本校任职时间
	 */
	public Date getBenxiaorenzhishijian() {
		return benxiaorenzhishijian;
	}
	/**
	 * 设置：职称
	 */
	public void setZhicheng(String zhicheng) {
		this.zhicheng = zhicheng;
	}
	/**
	 * 获取：职称
	 */
	public String getZhicheng() {
		return zhicheng;
	}
	/**
	 * 设置：岗位
	 */
	public void setGangwei(String gangwei) {
		this.gangwei = gangwei;
	}
	/**
	 * 获取：岗位
	 */
	public String getGangwei() {
		return gangwei;
	}
	/**
	 * 设置：薪级
	 */
	public void setXinji(String xinji) {
		this.xinji = xinji;
	}
	/**
	 * 获取：薪级
	 */
	public String getXinji() {
		return xinji;
	}
	/**
	 * 设置：档案材料
	 */
	public void setDangancailiao(String dangancailiao) {
		this.dangancailiao = dangancailiao;
	}
	/**
	 * 获取：档案材料
	 */
	public String getDangancailiao() {
		return dangancailiao;
	}
	/**
	 * 设置：是否审核
	 */
	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}
	/**
	 * 获取：是否审核
	 */
	public String getSfsh() {
		return sfsh;
	}
	/**
	 * 设置：审核回复
	 */
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	/**
	 * 获取：审核回复
	 */
	public String getShhf() {
		return shhf;
	}

}
