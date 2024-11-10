package com.dao;

import com.entity.PeixunxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.PeixunxinxiVO;
import com.entity.view.PeixunxinxiView;


/**
 * 培训信息
 * 
 * @author 
 * @email 
 * @date 2021-01-14 15:15:24
 */
public interface PeixunxinxiDao extends BaseMapper<PeixunxinxiEntity> {
	
	List<PeixunxinxiVO> selectListVO(@Param("ew") Wrapper<PeixunxinxiEntity> wrapper);
	
	PeixunxinxiVO selectVO(@Param("ew") Wrapper<PeixunxinxiEntity> wrapper);
	
	List<PeixunxinxiView> selectListView(@Param("ew") Wrapper<PeixunxinxiEntity> wrapper);

	List<PeixunxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<PeixunxinxiEntity> wrapper);
	
	PeixunxinxiView selectView(@Param("ew") Wrapper<PeixunxinxiEntity> wrapper);
	
}
