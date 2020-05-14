package com.xx.control;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xx.bean.Student;
import com.xx.bean.Teacher;
import com.xx.dao.TeacherDao;
import com.xx.util.FileUploadUtilx;

@Controller
@RequestMapping("teacher")
public class TeacherControl {
	@Resource
	TeacherDao td;
	
	@Resource
	FileUploadUtilx fu;

	@RequestMapping("getListDynamic")
	@ResponseBody
	public Map<String, Object> getListDynamic(Integer page, Integer rows, Teacher te){
		Map<String, Object> map = new HashMap<String, Object>();
		PageHelper.startPage(page, rows);
		List<Teacher> list = td.getList(te);
		PageInfo<Teacher> pa = new PageInfo<Teacher>(list);
		map.put("rows", list); //此处必须写"rows",因为前台模板默认为rows
		map.put("total", pa.getTotal());
		return map;
	}
	
	
	@RequestMapping("getList")
	@ResponseBody
	public List getList(){
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<Teacher> list = td.getList(null); 
		 
		return list;
	}
	
	
	
	@RequestMapping("add")
	@ResponseBody
	public Map<String, Object> add(Teacher te,@RequestParam("tezp1") CommonsMultipartFile file,HttpServletRequest request){
		Map<String, Object> map = new HashMap<String, Object>();
		
		String tezp = fu.uploadTp(request, file);
		te.setTezp(tezp);
		int n = td.add(te);
		map.put("code", n);
		return map;
	}
	
	@RequestMapping("delete")
	@ResponseBody
	public Map<String, Object> delete(Integer teid){
		Map<String, Object> map = new HashMap<String, Object>();
		int n = td.delete(teid);
		map.put("code", n);
		return map;
	}
	
	@RequestMapping("update")
	@ResponseBody
	public Map<String, Object> update(Teacher te,@RequestParam("tezp1") CommonsMultipartFile file,HttpServletRequest request){
		Map<String, Object> map = new HashMap<String, Object>();
		if (!file.isEmpty()) {//判断是否上传了新的图片
			String tezp = fu.uploadTp(request, file);
			te.setTezp(tezp);
		} 
		int n = td.update(te);
		map.put("code", n);
		return map;
	}
	
	
}
