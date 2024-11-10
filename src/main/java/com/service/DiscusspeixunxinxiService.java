package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscusspeixunxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscusspeixunxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscusspeixunxinxiView;


/**
 * 培训信息评论表
 *
 * @author 
 * @email 
 * @date 2021-01-14 15:15:24
 */
public interface DiscusspeixunxinxiService extends IService<DiscusspeixunxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusspeixunxinxiVO> selectListVO(Wrapper<DiscusspeixunxinxiEntity> wrapper);
   	
   	DiscusspeixunxinxiVO selectVO(@Param("ew") Wrapper<DiscusspeixunxinxiEntity> wrapper);
   	
   	List<DiscusspeixunxinxiView> selectListView(Wrapper<DiscusspeixunxinxiEntity> wrapper);
   	
   	DiscusspeixunxinxiView selectView(@Param("ew") Wrapper<DiscusspeixunxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusspeixunxinxiEntity> wrapper);
   	
}

