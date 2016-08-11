package com.uxp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	@RequestMapping(value="/dologin", method={RequestMethod.POST}, consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public String adminLogin(@RequestParam String userName, @RequestParam String passWord, Model model, HttpServletRequest request, HttpServletResponse response) {
		if(userName.equals("admin") && passWord.equals("abc123")) {
			return "adminhome";
		} else {
			model.addAttribute("err", "Invalid Username or Password.");
			System.out.println("Bad Auth: ip=" + request.getRemoteAddr());
			return "adminlogin";
		}
	}
}
