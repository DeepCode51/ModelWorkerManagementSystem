package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.DanganbiandongDao;
import com.entity.DanganbiandongEntity;
import com.service.DanganbiandongService;
import com.entity.vo.DanganbiandongVO;
import com.entity.view.DanganbiandongView;

@Service("danganbiandongService")
public class DanganbiandongServiceImpl extends ServiceImpl<DanganbiandongDao, DanganbiandongEntity> implements DanganbiandongService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DanganbiandongEntity> page = this.selectPage(
                new Query<DanganbiandongEntity>(params).getPage(),
                new EntityWrapper<DanganbiandongEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DanganbiandongEntity> wrapper) {
		  Page<DanganbiandongView> page =new Query<DanganbiandongView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DanganbiandongVO> selectListVO(Wrapper<DanganbiandongEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DanganbiandongVO selectVO(Wrapper<DanganbiandongEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DanganbiandongView> selectListView(Wrapper<DanganbiandongEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DanganbiandongView selectView(Wrapper<DanganbiandongEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
