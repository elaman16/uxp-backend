package com.uxp.controller;

import java.util.Collections;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.uxp.model.User;
import com.uxp.service.AdminService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@RestController
@CrossOrigin
@RequestMapping(value="/admin", method={RequestMethod.POST, RequestMethod.GET})
public class AdminController {
	
	@Autowired
	AdminService admin;
	
	@RequestMapping(value="/disable/user/{userId}", method={RequestMethod.POST, RequestMethod.GET})
	public Object disableUser(@PathVariable("userId") long userId) {
		try {
			return admin.disableUser(userId);
		} catch (Exception e) {
			System.out.println("Error updating user account from admin");
			return Collections.singletonMap("error", "Could not update user " + userId + " account status.");
		}
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST, consumes=MediaType.MULTIPART_FORM_DATA_VALUE, produces = "application/json")
	public @ResponseBody Object loginUser(@RequestParam String userName, @RequestParam String userPassword, HttpServletRequest request, HttpServletResponse response) {	
		return new Object();
		//User user = userService.userLogin(userName, userPassword);
		/*if(user != null) {
			 long now = new Date().getTime();
			 long expires = now + 86400000;
			 if(user.getUseStatus() == 'B') {
				 return Collections.singletonMap("error", "This account has been disabled");
			 }
			 String s = Jwts.builder().setSubject(userName).setIssuer("UxP-Gll").setExpiration(new Date(expires)).setHeaderParam("user", user).signWith(SignatureAlgorithm.HS512, key).compact();
			 return userService.getUserByUserName(userName, s);
		 } else {
			 return Collections.singletonMap("response", "Invalid Username or Password");
		 }
	}) */
	}
	
}
