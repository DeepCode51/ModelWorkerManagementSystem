package com.entity.view;

import com.entity.DiscusspeixunxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 培训信息评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-01-14 15:15:24
 */
@TableName("discusspeixunxinxi")
public class DiscusspeixunxinxiView  extends DiscusspeixunxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscusspeixunxinxiView(){
	}
 
 	public DiscusspeixunxinxiView(DiscusspeixunxinxiEntity discusspeixunxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, discusspeixunxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
