package com.uxp.controller;

import java.security.Key;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.session.SessionRepository;
import org.springframework.session.data.redis.RedisOperationsSessionRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.util.UriComponentsBuilder;

import com.uxp.model.ResponseMsg;
import com.uxp.model.UserProfile;
import com.uxp.service.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

@RestController
@CrossOrigin
@RequestMapping(value="/user", method={RequestMethod.POST, RequestMethod.GET})
@SessionAttributes("user")
public class UserController {
	@Autowired
	private UserService userService;
	Key key = MacProvider.generateKey();
	
	//*************************************POST REQUESTS***********************************
	
	/*
	 * POST to create a new user.
	 */
	@RequestMapping(value="", method=RequestMethod.POST, consumes=MediaType.MULTIPART_FORM_DATA_VALUE, produces = "application/json")
	public @ResponseBody Object createUser(@RequestParam String userName, @RequestParam String userPassword, @RequestParam String userFirstName, 
			@RequestParam String userLastName, @RequestParam String userPicURL,@RequestParam String userEmail, @RequestParam String userEmployer,
			@RequestParam String userDesignation, @RequestParam String userCity, @RequestParam String userState, @RequestParam(required=false) String programId, 
			@RequestParam long updatedBy, @RequestParam String userExpertise, @RequestParam String userRoleDescription,
			@RequestParam String userPermissionCode, @RequestParam String userPermissionDescription, HttpServletRequest request, HttpServletResponse response) {
		return userService.createUser(userName, userPassword, userFirstName, userLastName, userPicURL, userEmail, userEmployer, userDesignation, userCity, userState, programId, updatedBy, userExpertise, userRoleDescription, userPermissionCode, userPermissionDescription, request, response);
	}
	/*
	 * POST to Login
	 */
	@RequestMapping(value="/login", method=RequestMethod.POST, consumes=MediaType.MULTIPART_FORM_DATA_VALUE, produces = "application/json")
	public @ResponseBody Object loginUser(@RequestParam String userName, @RequestParam String userPassword, HttpServletRequest request, HttpServletResponse response) {	
		
		if(userService.userLogin(userName, userPassword)) {
			 UserProfile user = userService.getUserProfile(userName);
			 String s = Jwts.builder().setSubject(userName).signWith(SignatureAlgorithm.HS512, key).compact();
			 return userService.getUserByUserName(userName, s);
		 } else {
			 return Collections.singletonMap("response", "Invalid Username or Password");
		 }
	}
	/*
	 * POST to Log Out
	 */
	@RequestMapping(value="/logout", method=RequestMethod.POST, consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = "application/json")
	public @ResponseBody void logoutUser(HttpServletRequest request, HttpServletResponse response) {	
		
	}
	/*
	 * POST to update existing user profile
	 */
	@RequestMapping(value="/{userId}/userProfile", method=RequestMethod.POST, consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE )
	public @ResponseBody Object postUserProfile(@PathVariable("userId") long userId, @RequestParam String userName, @RequestParam String userPassword,
			@RequestParam String userFirstName, @RequestParam String userLastName, @RequestParam String userPicURL,@RequestParam String userEmail,
			@RequestParam String userEmployer, @RequestParam String userDesignation, @RequestParam String userCity, @RequestParam String userState,
			@RequestParam(required=false) String programId, UriComponentsBuilder ucBuilder,  HttpServletResponse response,  HttpServletRequest request) {
		
	
			return userService.updateUserProfile(userId, userName, userPassword, userFirstName, userLastName, userPicURL, userEmail, userEmployer, userDesignation, userCity, userState, programId, response, request);
		
		
	}
	/*
	 * POST to change user password, old pass req'd
	 */
	@RequestMapping(value="/{userId}/userAccountSetting", method=RequestMethod.POST, consumes= MediaType.MULTIPART_FORM_DATA_VALUE )
	public @ResponseBody Object postUserAccountSetting(@PathVariable("userId") long userId, @RequestParam(required=false) String programId, 
		   @RequestParam String oldPass, @RequestParam String newPass, HttpServletResponse response,  HttpServletRequest request, HttpSession session) {
		
		return userService.changeUserPass(userId, programId, oldPass, newPass, response, request);
	}
	
	@RequestMapping(value="/{userId}/collections", method=RequestMethod.POST, consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public @ResponseBody Object postNewCollection(@PathVariable("userId") long userId, @RequestParam String annotations, @RequestParam String exportURI) {
		
		return userService.postNewCollection(userId, annotations, exportURI);
		
	}
	//******************************************GET Requests******************************888
	@RequestMapping(value="/{userName}", method=RequestMethod.GET )
	public @ResponseBody Object getUserByUserName(@PathVariable("userName") String userName, @RequestParam(required=false, name="programId") String programId,HttpServletResponse response, HttpServletRequest request) {
		
		
			return userService.getUserByUserName(userName);
		
	}
	@RequestMapping(value="/{userId}/collections", method=RequestMethod.GET)
	public @ResponseBody Object userCollections(@PathVariable("userId") long userId) {
		
		return userService.findAllCollectionsByUserId(userId);
		
	}
	/*@RequestMapping(value="/{userId}/userActivityLog", method=RequestMethod.GET)
	public @ResponseBody Object postUserActivityLog(@PathVariable("userId") long userId, @RequestHeader("programId") String programId, HttpServletResponse response,  HttpServletRequest request) {
		try {
			List<UserActivityLog> userActions = userActivityDAO.findByActiveUserId(userId);
			UserActivityLog userActivityLog = new UserActivityLog(userId, "UserActivityFetched", programId, request.getRemoteAddr());
			userActivityLog.setUpdatedBy(userId);
			userActivityDAO.save(userActivityLog);
			response.setStatus(HttpServletResponse.SC_OK);
			return userActions;
			
		} catch (Exception ex) {
		    System.out.println("User action lookup failed: " + ex.toString());
	        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		    return new ResponseMsg("Error", "Could not find any user actions");
	 }
	}
	*/
}