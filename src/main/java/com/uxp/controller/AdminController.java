package com.uxp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@CrossOrigin
@RequestMapping(value="/admin", method={RequestMethod.POST, RequestMethod.GET})
public class AdminController {
	
	@RequestMapping(value="/login", method={RequestMethod.GET})
	public String loginPage() {
		return "adminlogin";
	}
	@RequestMapping(value="/dologin", method={RequestMethod.POST})
	public String adminLogin(@RequestParam String userName, @RequestParam String passWord) {
		if(userName.equals("admin") && passWord.equals("abc123")) {
			return "adminhome";
		} else {
			return "";
		}
	}
}
