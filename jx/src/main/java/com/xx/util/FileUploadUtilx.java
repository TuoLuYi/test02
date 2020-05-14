package com.xx.util;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Component
public class FileUploadUtilx { 
	
	public String uploadTp(HttpServletRequest request,CommonsMultipartFile file){
		
		String pp = request.getSession().getServletContext().getRealPath("/");  
		pp = pp + "upload/";
			String name = new Date().getTime()+file.getOriginalFilename();
	        String path=pp+name;
	        File newFile=new File(path);
	        try {
				file.transferTo(newFile);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	      return "upload/"+name;
	}
	
}
