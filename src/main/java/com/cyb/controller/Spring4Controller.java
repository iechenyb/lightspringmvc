package com.cyb.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.Callable;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;

import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.util.SocketUtils;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.AsyncRestTemplate;

import com.cyb.po.User;
//http://localhost:8088/springmvc/test.php
/**
 * 路径spring4在请求里边不用写
 * @author DHUser
 *
 */
@RestController("spring4") 
public class Spring4Controller {
	 @RequestMapping("/test")  
     public User view() {  
       User user = new User();  
       user.setName("haha");  
       return user;  
   }  
 
   @RequestMapping("/test2")  
   public String view2() {  
       return "{\"id\" : 1}";  
   }  

   public TimeZone determineDefaultTimeZone(HttpServletRequest request) { 
	   SocketUtils.findAvailableTcpPort();
	   SocketUtils.findAvailableTcpPort(1000, 2000) ;
	   SocketUtils.findAvailableUdpPort();
	   //https://github.com/zhangkaitao
	   /*Year year = Year.now();  
	   YearMonth yearMonth = YearMonth.now();  
	   MonthDay monthDay = MonthDay.now();  
	     
	   System.out.println(year);//年  
	   System.out.println(yearMonth); //年-月  
	   System.out.println(monthDay); // 月-日  
	     
	   //周期，如表示10天前  3年5个月钱  
	   Period period1 = Period.ofDays(10);  
	   System.out.println(period1);  
	   Period period2 = Period.of(3, 5, 0);  
	   System.out.println(period2);*/   
	   return null;  
	} 
   //localhost:9080/spring4/test?dateTime=2013-11-11 11:11:11&date=2013-11-11&time=12:12:12
   @RequestMapping("/test1")  
   public String test(@ModelAttribute("entity") User entity) {  
       return "test";  
   }  
   @RequestMapping("/api")  
   public Callable<User> api() {  
     System.out.println("=====hello");  
     return new Callable<User>() {  
         @Override  
         public User call() throws Exception {  
             Thread.sleep(10L * 1000); //暂停两秒  
             User user = new User();  
             user.setName("haha");  
             return user;  
         }  
     };  
 }  //study/jsonest 
	@RequestMapping(value = "/json", method = RequestMethod.GET)
	public JSONArray jsontest() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "iechenyb");
		map.put("age", "20");
		System.out.println("map = "+map);
		return JSONArray.fromObject(map);
	}
	
	@RequestMapping(value = "/map", method = RequestMethod.GET)
	public Map<String, String> maptest() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "iechenyb");
		map.put("age", "20");
		System.out.println("map = "+map);
		return map;
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Integer> listtest() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);list.add(2);list.add(3);
		System.out.println("list = "+list);
		return list;
	}
	
	@RequestMapping(value = "/string", method = RequestMethod.GET)
	public String strtest() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(343441);list.add(33332);list.add(44443);
		System.out.println("list = "+list);
		return list.toString();
	}
   public static void main(String[] args) {  
	    AsyncRestTemplate template = new AsyncRestTemplate();  
	    //调用完后立即返回（没有阻塞）  
	    ListenableFuture<ResponseEntity<User>> future = template.getForEntity("http://localhost:8088/springmvc/api.php", User.class);  
	    //设置异步回调  
	    future.addCallback(new ListenableFutureCallback<ResponseEntity<User>>() {  
	        @Override  
	        public void onSuccess(ResponseEntity<User> result) {  
	            System.out.println("======client get result : " + result.getBody());  
	        }  
	  
	        @Override  
	        public void onFailure(Throwable t) {  
	            System.out.println("======client failure : " + t);  
	        }  
	    });  
	    System.out.println("==no wait");  
	} 
}
