package com.cyb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
    短信洪流测试
 */
@RestController("sms")
public class SMSController {
	
	@RequestMapping("/send")
	public String send(String phone) {
		
		return "";
	}	
}
