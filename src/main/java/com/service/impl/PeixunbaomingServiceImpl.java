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


import com.dao.PeixunbaomingDao;
import com.entity.PeixunbaomingEntity;
import com.service.PeixunbaomingService;
import com.entity.vo.PeixunbaomingVO;
import com.entity.view.PeixunbaomingView;

@Service("peixunbaomingService")
public class PeixunbaomingServiceImpl extends ServiceImpl<PeixunbaomingDao, PeixunbaomingEntity> implements PeixunbaomingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<PeixunbaomingEntity> page = this.selectPage(
                new Query<PeixunbaomingEntity>(params).getPage(),
                new EntityWrapper<PeixunbaomingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<PeixunbaomingEntity> wrapper) {
		  Page<PeixunbaomingView> page =new Query<PeixunbaomingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<PeixunbaomingVO> selectListVO(Wrapper<PeixunbaomingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public PeixunbaomingVO selectVO(Wrapper<PeixunbaomingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<PeixunbaomingView> selectListView(Wrapper<PeixunbaomingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public PeixunbaomingView selectView(Wrapper<PeixunbaomingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
