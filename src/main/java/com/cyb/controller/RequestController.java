package com.cyb.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cyb.po.User;
import com.cyb.utils.RequestUtils;

@RestController("req")
public class RequestController {
	@RequestMapping("/infor")
	public String infor(HttpServletRequest request) {
		StringBuffer sb = new StringBuffer();
		sb.append("romoteIp:" + RequestUtils.getRemoteHost(request) + ",");
		sb.append("is ajax request:" + RequestUtils.isAjaxRequest(request) + ",");
		sb.append("is req from mobile:" + RequestUtils.JudgeIsMoblie(request));
		return sb.toString();
	}

	@ResponseBody // 返回string的时候，必须加 @responseBody注解
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public User get(String id) {
		User user = new User();
		user.setName(id);
		user.setPassword(null);
		user.setId("1");
		return user;
	}
	@ResponseBody // 返回string的时候，必须加 @responseBody注解
	@RequestMapping(value = "/post", method = RequestMethod.POST)
	public User post(String id) {
		User user = new User();
		user.setName(id);
		user.setPassword(null);
		user.setId("1");
		return user;
	}
	@ResponseBody // 返回string的时候，必须加 @responseBody注解
	@RequestMapping(value = "/put", method = RequestMethod.PUT)
	public User put(String id) {
		User user = new User();
		user.setName(id);
		user.setPassword(null);
		user.setId("1");
		return user;
	}
	@ResponseBody // 返回string的时候，必须加 @responseBody注解
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public User delete(String id) {
		User user = new User();
		user.setName(id);
		user.setPassword(null);
		user.setId("1");
		return user;
	}
}
