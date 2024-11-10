package com.dao;

import com.entity.DiscusspeixunxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscusspeixunxinxiVO;
import com.entity.view.DiscusspeixunxinxiView;


/**
 * 培训信息评论表
 * 
 * @author 
 * @email 
 * @date 2021-01-14 15:15:24
 */
public interface DiscusspeixunxinxiDao extends BaseMapper<DiscusspeixunxinxiEntity> {
	
	List<DiscusspeixunxinxiVO> selectListVO(@Param("ew") Wrapper<DiscusspeixunxinxiEntity> wrapper);
	
	DiscusspeixunxinxiVO selectVO(@Param("ew") Wrapper<DiscusspeixunxinxiEntity> wrapper);
	
	List<DiscusspeixunxinxiView> selectListView(@Param("ew") Wrapper<DiscusspeixunxinxiEntity> wrapper);

	List<DiscusspeixunxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusspeixunxinxiEntity> wrapper);
	
	DiscusspeixunxinxiView selectView(@Param("ew") Wrapper<DiscusspeixunxinxiEntity> wrapper);
	
}
