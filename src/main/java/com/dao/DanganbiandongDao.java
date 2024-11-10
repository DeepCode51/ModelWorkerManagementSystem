package com.dao;

import com.entity.DanganbiandongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DanganbiandongVO;
import com.entity.view.DanganbiandongView;


/**
 * 档案变动
 * 
 * @author 
 * @email 
 * @date 2021-01-14 15:15:24
 */
public interface DanganbiandongDao extends BaseMapper<DanganbiandongEntity> {
	
	List<DanganbiandongVO> selectListVO(@Param("ew") Wrapper<DanganbiandongEntity> wrapper);
	
	DanganbiandongVO selectVO(@Param("ew") Wrapper<DanganbiandongEntity> wrapper);
	
	List<DanganbiandongView> selectListView(@Param("ew") Wrapper<DanganbiandongEntity> wrapper);

	List<DanganbiandongView> selectListView(Pagination page,@Param("ew") Wrapper<DanganbiandongEntity> wrapper);
	
	DanganbiandongView selectView(@Param("ew") Wrapper<DanganbiandongEntity> wrapper);
	
}
