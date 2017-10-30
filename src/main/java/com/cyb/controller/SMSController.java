package com.cyb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 *  http://localhost:8088/mvc-2/toLogin.do
    http://localhost:8088/mvc-2/login.do
    短信洪流测试
 */
@RestController("sms")
public class SMSController {
	
	@RequestMapping("/send")
	public String send(String phone) {
		
		return "";
	}	
}
