package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DanganbiandongEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DanganbiandongVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DanganbiandongView;


/**
 * 档案变动
 *
 * @author 
 * @email 
 * @date 2021-01-14 15:15:24
 */
public interface DanganbiandongService extends IService<DanganbiandongEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DanganbiandongVO> selectListVO(Wrapper<DanganbiandongEntity> wrapper);
   	
   	DanganbiandongVO selectVO(@Param("ew") Wrapper<DanganbiandongEntity> wrapper);
   	
   	List<DanganbiandongView> selectListView(Wrapper<DanganbiandongEntity> wrapper);
   	
   	DanganbiandongView selectView(@Param("ew") Wrapper<DanganbiandongEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DanganbiandongEntity> wrapper);
   	
}

