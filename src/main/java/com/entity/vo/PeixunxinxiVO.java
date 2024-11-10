package com.entity.vo;

import com.entity.PeixunxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 培训信息
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2021-01-14 15:15:24
 */
public class PeixunxinxiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 类型
	 */
	
	private String leixing;
		
	/**
	 * 图片
	 */
	
	private String tupian;
		
	/**
	 * 培训时间
	 */
	
	private String peixunshijian;
		
	/**
	 * 培训地点
	 */
	
	private String peixundidian;
		
	/**
	 * 培训内容
	 */
	
	private String peixunneirong;
		
	/**
	 * 培训目标
	 */
	
	private String peixunmubiao;
		
	/**
	 * 授课讲师
	 */
	
	private String shoukejiangshi;
		
	/**
	 * 天数
	 */
	
	private Integer tianshu;
		
	/**
	 * 发布日期
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date faburiqi;
				
	
	/**
	 * 设置：类型
	 */
	 
	public void setLeixing(String leixing) {
		this.leixing = leixing;
	}
	
	/**
	 * 获取：类型
	 */
	public String getLeixing() {
		return leixing;
	}
				
	
	/**
	 * 设置：图片
	 */
	 
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}
				
	
	/**
	 * 设置：培训时间
	 */
	 
	public void setPeixunshijian(String peixunshijian) {
		this.peixunshijian = peixunshijian;
	}
	
	/**
	 * 获取：培训时间
	 */
	public String getPeixunshijian() {
		return peixunshijian;
	}
				
	
	/**
	 * 设置：培训地点
	 */
	 
	public void setPeixundidian(String peixundidian) {
		this.peixundidian = peixundidian;
	}
	
	/**
	 * 获取：培训地点
	 */
	public String getPeixundidian() {
		return peixundidian;
	}
				
	
	/**
	 * 设置：培训内容
	 */
	 
	public void setPeixunneirong(String peixunneirong) {
		this.peixunneirong = peixunneirong;
	}
	
	/**
	 * 获取：培训内容
	 */
	public String getPeixunneirong() {
		return peixunneirong;
	}
				
	
	/**
	 * 设置：培训目标
	 */
	 
	public void setPeixunmubiao(String peixunmubiao) {
		this.peixunmubiao = peixunmubiao;
	}
	
	/**
	 * 获取：培训目标
	 */
	public String getPeixunmubiao() {
		return peixunmubiao;
	}
				
	
	/**
	 * 设置：授课讲师
	 */
	 
	public void setShoukejiangshi(String shoukejiangshi) {
		this.shoukejiangshi = shoukejiangshi;
	}
	
	/**
	 * 获取：授课讲师
	 */
	public String getShoukejiangshi() {
		return shoukejiangshi;
	}
				
	
	/**
	 * 设置：天数
	 */
	 
	public void setTianshu(Integer tianshu) {
		this.tianshu = tianshu;
	}
	
	/**
	 * 获取：天数
	 */
	public Integer getTianshu() {
		return tianshu;
	}
				
	
	/**
	 * 设置：发布日期
	 */
	 
	public void setFaburiqi(Date faburiqi) {
		this.faburiqi = faburiqi;
	}
	
	/**
	 * 获取：发布日期
	 */
	public Date getFaburiqi() {
		return faburiqi;
	}
			
}
