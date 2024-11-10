package com.dao;

import com.entity.PeixunbaomingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.PeixunbaomingVO;
import com.entity.view.PeixunbaomingView;


/**
 * 培训报名
 * 
 * @author 
 * @email 
 * @date 2021-01-14 15:15:24
 */
public interface PeixunbaomingDao extends BaseMapper<PeixunbaomingEntity> {
	
	List<PeixunbaomingVO> selectListVO(@Param("ew") Wrapper<PeixunbaomingEntity> wrapper);
	
	PeixunbaomingVO selectVO(@Param("ew") Wrapper<PeixunbaomingEntity> wrapper);
	
	List<PeixunbaomingView> selectListView(@Param("ew") Wrapper<PeixunbaomingEntity> wrapper);

	List<PeixunbaomingView> selectListView(Pagination page,@Param("ew") Wrapper<PeixunbaomingEntity> wrapper);
	
	PeixunbaomingView selectView(@Param("ew") Wrapper<PeixunbaomingEntity> wrapper);
	
}
