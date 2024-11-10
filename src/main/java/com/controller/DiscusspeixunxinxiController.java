package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.DiscusspeixunxinxiEntity;
import com.entity.view.DiscusspeixunxinxiView;

import com.service.DiscusspeixunxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 培训信息评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2021-01-14 15:15:24
 */
@RestController
@RequestMapping("/discusspeixunxinxi")
public class DiscusspeixunxinxiController {
    @Autowired
    private DiscusspeixunxinxiService discusspeixunxinxiService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscusspeixunxinxiEntity discusspeixunxinxi, HttpServletRequest request){
        EntityWrapper<DiscusspeixunxinxiEntity> ew = new EntityWrapper<DiscusspeixunxinxiEntity>();
		PageUtils page = discusspeixunxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discusspeixunxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscusspeixunxinxiEntity discusspeixunxinxi, HttpServletRequest request){
        EntityWrapper<DiscusspeixunxinxiEntity> ew = new EntityWrapper<DiscusspeixunxinxiEntity>();
		PageUtils page = discusspeixunxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discusspeixunxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscusspeixunxinxiEntity discusspeixunxinxi){
       	EntityWrapper<DiscusspeixunxinxiEntity> ew = new EntityWrapper<DiscusspeixunxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discusspeixunxinxi, "discusspeixunxinxi")); 
        return R.ok().put("data", discusspeixunxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscusspeixunxinxiEntity discusspeixunxinxi){
        EntityWrapper< DiscusspeixunxinxiEntity> ew = new EntityWrapper< DiscusspeixunxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discusspeixunxinxi, "discusspeixunxinxi")); 
		DiscusspeixunxinxiView discusspeixunxinxiView =  discusspeixunxinxiService.selectView(ew);
		return R.ok("查询培训信息评论表成功").put("data", discusspeixunxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscusspeixunxinxiEntity discusspeixunxinxi = discusspeixunxinxiService.selectById(id);
        return R.ok().put("data", discusspeixunxinxi);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscusspeixunxinxiEntity discusspeixunxinxi = discusspeixunxinxiService.selectById(id);
        return R.ok().put("data", discusspeixunxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscusspeixunxinxiEntity discusspeixunxinxi, HttpServletRequest request){
    	discusspeixunxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discusspeixunxinxi);
        discusspeixunxinxiService.insert(discusspeixunxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscusspeixunxinxiEntity discusspeixunxinxi, HttpServletRequest request){
    	discusspeixunxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discusspeixunxinxi);
        discusspeixunxinxiService.insert(discusspeixunxinxi);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody DiscusspeixunxinxiEntity discusspeixunxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discusspeixunxinxi);
        discusspeixunxinxiService.updateById(discusspeixunxinxi);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discusspeixunxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<DiscusspeixunxinxiEntity> wrapper = new EntityWrapper<DiscusspeixunxinxiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = discusspeixunxinxiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
