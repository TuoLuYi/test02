package com.xx.control;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xx.bean.News;
import com.xx.dao.NewsDao;

@Controller
@RequestMapping("news")
public class NewsControl {

	@Resource
	NewsDao nd;
	
	@RequestMapping("getList")
	@ResponseBody
	public Map<String, Object> getListDynamic(Integer page, Integer rows, News n){
		Map<String, Object> map = new HashMap<String, Object>();
		PageHelper.startPage(page, rows);
		List<News> list = nd.getList(n);
		PageInfo<News> pa = new PageInfo<News>(list);
		map.put("rows", list); //此处必须写"rows",因为前台模板默认为rows
		map.put("total", pa.getTotal());
		return map;
	}
	
	@RequestMapping("add")
	@ResponseBody
	public Map<String, Object> add(News news){
		Map<String, Object> map = new HashMap<String, Object>();
		int n = nd.add(news);
		map.put("code", n);
		return map;
	}
	
	@RequestMapping("delete")
	@ResponseBody
	public Map<String, Object> delete(Integer neid){
		Map<String, Object> map = new HashMap<String, Object>();
		int n = nd.delete(neid);
		map.put("code", n);
		return map;
	}
	
	@RequestMapping("update")
	@ResponseBody
	public Map<String, Object> update(News news){
		Map<String, Object> map = new HashMap<String, Object>();
		int n = nd.update(news);
		map.put("code", n);
		return map;
	}
	
	
}
