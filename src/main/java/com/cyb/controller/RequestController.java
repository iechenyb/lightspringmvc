package com.cyb.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cyb.utils.RequestUtils;

@RestController("req") 
public class RequestController {
	 @RequestMapping("/infor")  
     public String infor(HttpServletRequest request) {  
		StringBuffer sb = new StringBuffer();
		sb.append("romoteIp:"+RequestUtils.getRemoteHost(request)+",");
		sb.append("is ajax request:"+RequestUtils.isAjaxRequest(request)+",");
		sb.append("is req from mobile:"+RequestUtils.JudgeIsMoblie(request)); 
       return sb.toString();  
   }  
}
