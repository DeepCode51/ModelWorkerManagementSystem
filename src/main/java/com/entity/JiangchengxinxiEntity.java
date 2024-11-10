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
 * 奖惩信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2021-01-14 15:15:24
 */
@TableName("jiangchengxinxi")
public class JiangchengxinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public JiangchengxinxiEntity() {
		
	}
	
	public JiangchengxinxiEntity(T t) {
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
	 * 获奖时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date huojiangshijian;
	
	/**
	 * 获奖内容
	 */
					
	private String huojiangneirong;
	
	/**
	 * 惩罚时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date chengfashijian;
	
	/**
	 * 惩罚内容
	 */
					
	private String chengfaneirong;
	
	
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
	 * 设置：获奖时间
	 */
	public void setHuojiangshijian(Date huojiangshijian) {
		this.huojiangshijian = huojiangshijian;
	}
	/**
	 * 获取：获奖时间
	 */
	public Date getHuojiangshijian() {
		return huojiangshijian;
	}
	/**
	 * 设置：获奖内容
	 */
	public void setHuojiangneirong(String huojiangneirong) {
		this.huojiangneirong = huojiangneirong;
	}
	/**
	 * 获取：获奖内容
	 */
	public String getHuojiangneirong() {
		return huojiangneirong;
	}
	/**
	 * 设置：惩罚时间
	 */
	public void setChengfashijian(Date chengfashijian) {
		this.chengfashijian = chengfashijian;
	}
	/**
	 * 获取：惩罚时间
	 */
	public Date getChengfashijian() {
		return chengfashijian;
	}
	/**
	 * 设置：惩罚内容
	 */
	public void setChengfaneirong(String chengfaneirong) {
		this.chengfaneirong = chengfaneirong;
	}
	/**
	 * 获取：惩罚内容
	 */
	public String getChengfaneirong() {
		return chengfaneirong;
	}

}
