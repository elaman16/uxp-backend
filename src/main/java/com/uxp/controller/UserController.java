package com.uxp.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping(value="/user", method={RequestMethod.POST, RequestMethod.GET})
public class UserController {
	@RequestMapping(value="", method=RequestMethod.POST, consumes= MediaType.APPLICATION_FORM_URLENCODED_VALUE )
	public ResponseEntity<Void> postUser(@RequestParam String user, UriComponentsBuilder ucBuilder) {
		
		System.out.println(user);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
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