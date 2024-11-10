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


import com.dao.DiscusspeixunxinxiDao;
import com.entity.DiscusspeixunxinxiEntity;
import com.service.DiscusspeixunxinxiService;
import com.entity.vo.DiscusspeixunxinxiVO;
import com.entity.view.DiscusspeixunxinxiView;

@Service("discusspeixunxinxiService")
public class DiscusspeixunxinxiServiceImpl extends ServiceImpl<DiscusspeixunxinxiDao, DiscusspeixunxinxiEntity> implements DiscusspeixunxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusspeixunxinxiEntity> page = this.selectPage(
                new Query<DiscusspeixunxinxiEntity>(params).getPage(),
                new EntityWrapper<DiscusspeixunxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusspeixunxinxiEntity> wrapper) {
		  Page<DiscusspeixunxinxiView> page =new Query<DiscusspeixunxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscusspeixunxinxiVO> selectListVO(Wrapper<DiscusspeixunxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusspeixunxinxiVO selectVO(Wrapper<DiscusspeixunxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusspeixunxinxiView> selectListView(Wrapper<DiscusspeixunxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusspeixunxinxiView selectView(Wrapper<DiscusspeixunxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
