package com.entity.view;

import com.entity.DanganbiandongEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 档案变动
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-01-14 15:15:24
 */
@TableName("danganbiandong")
public class DanganbiandongView  extends DanganbiandongEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DanganbiandongView(){
	}
 
 	public DanganbiandongView(DanganbiandongEntity danganbiandongEntity){
 	try {
			BeanUtils.copyProperties(this, danganbiandongEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
