package com.entity.view;

import com.entity.GerendanganEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 个人档案
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-01-14 15:15:24
 */
@TableName("gerendangan")
public class GerendanganView  extends GerendanganEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public GerendanganView(){
	}
 
 	public GerendanganView(GerendanganEntity gerendanganEntity){
 	try {
			BeanUtils.copyProperties(this, gerendanganEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
