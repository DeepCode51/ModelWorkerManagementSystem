package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.GerendanganEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.GerendanganVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.GerendanganView;


/**
 * 个人档案
 *
 * @author 
 * @email 
 * @date 2021-01-14 15:15:24
 */
public interface GerendanganService extends IService<GerendanganEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GerendanganVO> selectListVO(Wrapper<GerendanganEntity> wrapper);
   	
   	GerendanganVO selectVO(@Param("ew") Wrapper<GerendanganEntity> wrapper);
   	
   	List<GerendanganView> selectListView(Wrapper<GerendanganEntity> wrapper);
   	
   	GerendanganView selectView(@Param("ew") Wrapper<GerendanganEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<GerendanganEntity> wrapper);
   	
}

