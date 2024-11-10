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


import com.dao.GerendanganDao;
import com.entity.GerendanganEntity;
import com.service.GerendanganService;
import com.entity.vo.GerendanganVO;
import com.entity.view.GerendanganView;

@Service("gerendanganService")
public class GerendanganServiceImpl extends ServiceImpl<GerendanganDao, GerendanganEntity> implements GerendanganService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GerendanganEntity> page = this.selectPage(
                new Query<GerendanganEntity>(params).getPage(),
                new EntityWrapper<GerendanganEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<GerendanganEntity> wrapper) {
		  Page<GerendanganView> page =new Query<GerendanganView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<GerendanganVO> selectListVO(Wrapper<GerendanganEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public GerendanganVO selectVO(Wrapper<GerendanganEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<GerendanganView> selectListView(Wrapper<GerendanganEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GerendanganView selectView(Wrapper<GerendanganEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
