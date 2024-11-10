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


import com.dao.JiangchengxinxiDao;
import com.entity.JiangchengxinxiEntity;
import com.service.JiangchengxinxiService;
import com.entity.vo.JiangchengxinxiVO;
import com.entity.view.JiangchengxinxiView;

@Service("jiangchengxinxiService")
public class JiangchengxinxiServiceImpl extends ServiceImpl<JiangchengxinxiDao, JiangchengxinxiEntity> implements JiangchengxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JiangchengxinxiEntity> page = this.selectPage(
                new Query<JiangchengxinxiEntity>(params).getPage(),
                new EntityWrapper<JiangchengxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JiangchengxinxiEntity> wrapper) {
		  Page<JiangchengxinxiView> page =new Query<JiangchengxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<JiangchengxinxiVO> selectListVO(Wrapper<JiangchengxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JiangchengxinxiVO selectVO(Wrapper<JiangchengxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JiangchengxinxiView> selectListView(Wrapper<JiangchengxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JiangchengxinxiView selectView(Wrapper<JiangchengxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
