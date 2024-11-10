package com.dao;

import com.entity.JiangchengxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JiangchengxinxiVO;
import com.entity.view.JiangchengxinxiView;


/**
 * 奖惩信息
 * 
 * @author 
 * @email 
 * @date 2021-01-14 15:15:24
 */
public interface JiangchengxinxiDao extends BaseMapper<JiangchengxinxiEntity> {
	
	List<JiangchengxinxiVO> selectListVO(@Param("ew") Wrapper<JiangchengxinxiEntity> wrapper);
	
	JiangchengxinxiVO selectVO(@Param("ew") Wrapper<JiangchengxinxiEntity> wrapper);
	
	List<JiangchengxinxiView> selectListView(@Param("ew") Wrapper<JiangchengxinxiEntity> wrapper);

	List<JiangchengxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<JiangchengxinxiEntity> wrapper);
	
	JiangchengxinxiView selectView(@Param("ew") Wrapper<JiangchengxinxiEntity> wrapper);
	
}
