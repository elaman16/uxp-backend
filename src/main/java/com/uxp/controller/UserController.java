package com.uxp.controller;

import java.io.Serializable;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.uxp.dao.UserDAO;
import com.uxp.model.User;


@RestController
@RequestMapping(value="/user", method={RequestMethod.POST, RequestMethod.GET})
public class UserController {
	@Autowired
	private UserDAO userDAO;
	@RequestMapping(value="", method=RequestMethod.POST, consumes= MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = "application/json")
	public ResponseEntity<String> createUser(@RequestParam char useStatus, @RequestParam String programId, @RequestParam String LocId, @RequestParam int updatedBy, UriComponentsBuilder ucBuilder) {
		
		String userId = "";
	    try {
	      User user = new User();
	      user.setLocId(LocId);
	      user.setProgramId(programId);
	      user.setTimeUpdated(new Date());
	      user.setUpdatedBy(user.getUserId());
	      user.setUseStatus(useStatus);
	      userDAO.save(user);
	      userId = String.valueOf(user.getUserId());
	    }
	    catch (Exception ex) {
	      System.out.println("Error creating the user: " + ex.toString());
	      HttpHeaders headers = new HttpHeaders();
		  return new ResponseEntity<String>("{'error':'Could not create user!'}", headers, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<String>("User " + userId + " created!", headers, HttpStatus.CREATED);
	}
	@RequestMapping(value="/userProfile", method=RequestMethod.POST, consumes= MediaType.APPLICATION_FORM_URLENCODED_VALUE )
	public ResponseEntity<Void> postUserProfile(@RequestParam String userProfile, UriComponentsBuilder ucBuilder) {
		
		System.out.println(userProfile);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	@RequestMapping(value="/userAccountSetting", method=RequestMethod.POST, consumes= MediaType.APPLICATION_FORM_URLENCODED_VALUE )
	public ResponseEntity<Void> postUserAccountSetting(@RequestParam String userAccountSetting, UriComponentsBuilder ucBuilder) {
		
		System.out.println(userAccountSetting);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	@RequestMapping(value="/userExpertise", method=RequestMethod.POST, consumes= MediaType.APPLICATION_FORM_URLENCODED_VALUE )
	public ResponseEntity<Void> postUserExpertise(@RequestParam String userExpertise, UriComponentsBuilder ucBuilder) {
		
		System.out.println(userExpertise);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	@RequestMapping(value="/userRole", method=RequestMethod.POST, consumes= MediaType.APPLICATION_FORM_URLENCODED_VALUE )
	public ResponseEntity<Void> postUserRole(@RequestParam String userRole, UriComponentsBuilder ucBuilder) {
		
		System.out.println(userRole);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	@RequestMapping(value="/userPermission", method=RequestMethod.POST, consumes= MediaType.APPLICATION_FORM_URLENCODED_VALUE )
	public ResponseEntity<Void> postUserPermission(@RequestParam String userPermission, UriComponentsBuilder ucBuilder) {
		
		System.out.println(userPermission);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	@RequestMapping(value="/userActivityLog", method=RequestMethod.POST, consumes= MediaType.APPLICATION_FORM_URLENCODED_VALUE )
	public ResponseEntity<Void> postUserActivityLog(@RequestParam String userActivityLog, UriComponentsBuilder ucBuilder) {
		
		System.out.println(userActivityLog);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
}