package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.PeixunbaomingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.PeixunbaomingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.PeixunbaomingView;


/**
 * 培训报名
 *
 * @author 
 * @email 
 * @date 2021-01-14 15:15:24
 */
public interface PeixunbaomingService extends IService<PeixunbaomingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<PeixunbaomingVO> selectListVO(Wrapper<PeixunbaomingEntity> wrapper);
   	
   	PeixunbaomingVO selectVO(@Param("ew") Wrapper<PeixunbaomingEntity> wrapper);
   	
   	List<PeixunbaomingView> selectListView(Wrapper<PeixunbaomingEntity> wrapper);
   	
   	PeixunbaomingView selectView(@Param("ew") Wrapper<PeixunbaomingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<PeixunbaomingEntity> wrapper);
   	
}

