package com.cyb.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cyb.po.User;
import com.cyb.utils.CustomMapper;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * 返回值测试，包括返回页面、返回集合信息、json以及普通的类型值。
 * @author DHUser
 *
 */
@Controller
@RequestMapping("return")
public class StudyReturnValueController {
	//返回页面，测试视图配置文件 /return/jsp
	@RequestMapping(value = "/jsp", method = RequestMethod.GET)
	public String viewtest(@RequestParam(value = "error", required = false) boolean error,
			ModelMap model) {
		System.out.println("Received request to show inner jsp page of  web root  jsp");
		if (error == true) {
			model.put("error","You have entered an invalid username or password!");
		} else {
			model.put("error", "no error!");
		}
		model.put("ret", "chenyb");
		return "/to/show";
	}
	
	@RequestMapping(value = "/mav", method = RequestMethod.GET)
	public ModelAndView viemav() {
		ModelAndView mav = new ModelAndView();
		System.out.println("Received request to show inner jsp page of  web root  jsp");
		mav.addObject("ret", "attributeValue");	
		mav.setViewName("/to/show");
		return mav;
	}
	
	
	//study/jsonest 

	@ResponseBody   //返回json的时候，必须加  @responseBody注解
	@RequestMapping(value = "/jsonarr", method = RequestMethod.GET)
	public JSONArray jsontest() throws JsonProcessingException {
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "iechenyb");
		map.put("age", "20");
		map.put("empty", null);
		map.put("emptystr", "");
		System.out.println("map = "+map);
		System.out.println(JSONArray.fromObject(map));
		return JSONArray.fromObject(map);
	}
	
	@ResponseBody   //返回json的时候，必须加  @responseBody注解
	@RequestMapping(value = "/jsonstr", method = RequestMethod.GET)
	public String jsonstrtest() throws JsonProcessingException {
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "iechenyb");
		map.put("age", "20");
		map.put("empty", null);
		map.put("emptystr", "");
		System.out.println("map = "+map);
		System.out.println(JSONArray.fromObject(map));
		return JSONArray.fromObject(map).toString();
	}
	
	@ResponseBody
	@RequestMapping(value = "/jsonnull", method = RequestMethod.GET)
	public String JsonString() throws JsonProcessingException {
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "iechenyb");
		map.put("age", "20");
		map.put("empty", null);
		map.put("emptystr", "");
		System.out.println("map = "+map);
		CustomMapper mapper = new CustomMapper();
		String ret_val = mapper.writeValueAsString(map);//全局配置即可
		return ret_val;
	}
	
	@ResponseBody   //返回map的时候，必须加  @responseBody注解
	@RequestMapping(value = "/map", method = RequestMethod.GET)
	public Map<String, Object> maptest() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "iechenyb");
		map.put("age", "20");
		map.put("empty", null);
		map.put("emptystr", "");
		User user = new User();
		user.setName("");
		user.setPassword(null);
		user.setId("1");
		map.put("user", user);
		System.out.println("map = "+map);
		return map;
	}
	
	@ResponseBody   //返回list的时候，必须加  @responseBody注解
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<String> listtest() {
		List<String> list = new ArrayList<String>();
		list.add("1");list.add("");list.add(null);
		System.out.println("list = "+list);
		return list;
	}
	
	@ResponseBody   //返回string的时候，必须加  @responseBody注解
	@RequestMapping(value = "/string", method = RequestMethod.GET)
	public String strtest() {
		List<String> list = new ArrayList<String>();
		list.add("1");list.add("");list.add(null);
		System.out.println("list = "+list);
		return list.toString();
	}
	
	@ResponseBody   //返回string的时候，必须加  @responseBody注解
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public User user() {
		User user = new User();
		user.setName("");
		user.setPassword(null);
		user.setId("1");
		return user;
	}
}
