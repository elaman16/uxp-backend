package com.uxp.controller;


import java.security.Key;
import java.util.Collections;
import java.util.Date;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.util.UriComponentsBuilder;


import com.uxp.service.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;



@RestController
@CrossOrigin
@RequestMapping(value="/user", method={RequestMethod.POST, RequestMethod.GET})
@SessionAttributes("user")
public class UserController {
	@Autowired
	private UserService userService;
	
	private Key key = ControllerConfig.key;
	
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
		System.out.print(key);
		if(userService.userLogin(userName, userPassword)) {
			 long now = new Date().getTime();
			 long expires = now + 86400000;
			 String s = Jwts.builder().setSubject(userName).setIssuer("UxP-Gll").setExpiration(new Date(expires)).signWith(SignatureAlgorithm.HS512, key).compact();
			 return userService.getUserByUserName(userName, s);
		 } else {
			 return Collections.singletonMap("response", "Invalid Username or Password");
		 }
	}
	/*
	 * POST to update existing user profile
	 */
	@RequestMapping(value="/{userId}/userProfile", method=RequestMethod.POST, consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE )
	public @ResponseBody Object postUserProfile(@PathVariable("userId") long userId, @RequestParam String userName, @RequestParam String userPassword,
			@RequestParam String userFirstName, @RequestParam String userLastName, @RequestParam String userPicURL,@RequestParam String userEmail,
			@RequestParam String userEmployer, @RequestParam String userDesignation, @RequestParam String userCity, @RequestParam String userState,
			@RequestParam(required=false) String programId, UriComponentsBuilder ucBuilder,  HttpServletResponse response,  HttpServletRequest request, @RequestHeader(name="Authorization") String token) {
			try {
				if(Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody().getIssuer().equals("UxP-Gll")) {
					return userService.updateUserProfile(userId, userFirstName, userLastName, userPicURL, userEmployer, userDesignation, userCity, userState, programId, response, request);
				} else {
					return Collections.singletonMap("error", "Not Authorized");
				}
			} catch(SignatureException e) {
				return Collections.singletonMap("error", "Not Authorized");
			} catch(MalformedJwtException m) {
				return Collections.singletonMap("error", "Bad token");
			}
		
			
		
		
	}
	/*
	 * POST to change user password, old pass req'd
	 */
	@RequestMapping(value="/{userId}/userAccountSetting", method=RequestMethod.POST, consumes= MediaType.MULTIPART_FORM_DATA_VALUE )
	public @ResponseBody Object postUserAccountSetting(@PathVariable("userId") long userId, @RequestParam(required=false) String programId, 
		   @RequestParam String oldPass, @RequestParam String newPass, HttpServletResponse response,  HttpServletRequest request, HttpSession session, @RequestHeader(name="Authorization") String token) {
		try {
			if(Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody().getIssuer().equals("UxP-Gll")) {
				return userService.changeUserPass(userId, programId, oldPass, newPass, response, request);
			} else {
				return Collections.singletonMap("error", "Not Authorized");
			}
		} catch(SignatureException e) {
			return Collections.singletonMap("error", "Not Authorized");
		} catch(MalformedJwtException m) {
			return Collections.singletonMap("error", "Bad token");
		}
	}
	
	@RequestMapping(value="/{userId}/collections", method=RequestMethod.POST, consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public @ResponseBody Object postNewCollection(@PathVariable("userId") long userId, @RequestParam String annotations, @RequestParam String exportURI, @RequestHeader(name="Authorization") String token) {
		try {
			if(Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody().getIssuer().equals("UxP-Gll")) {
				return userService.postNewCollection(userId, annotations, exportURI);
			} else {
				return Collections.singletonMap("error", "Not Authorized");
			}
		} catch(SignatureException e) {
			return Collections.singletonMap("error", "Not Authorized");
		} catch(MalformedJwtException m) {
			return Collections.singletonMap("error", "Bad token");
		}
	}
	//******************************************GET Requests******************************888
	@RequestMapping(value="/{userName}", method=RequestMethod.GET )
	public @ResponseBody Object getUserByUserName(@PathVariable("userName") String userName, @RequestParam(required=false, name="programId") String programId, @RequestHeader(name="Authorization") String token, HttpServletResponse response, HttpServletRequest request) {
		try {
			if(Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody().getIssuer().equals("UxP-Gll")) {
				return userService.getUserByUserName(userName);
			} else {
				return Collections.singletonMap("error", "Not Authorized");
			}
		} catch(SignatureException e) {
			return Collections.singletonMap("error", "Not Authorized");
		} catch(MalformedJwtException m) {
			return Collections.singletonMap("error", "Bad token");
		}
	}
	@RequestMapping(value="/{userId}/collections", method=RequestMethod.GET)
	public @ResponseBody Object userCollections(@PathVariable("userId") long userId, @RequestHeader(name="Authorization") String token) {
		try {
			if(Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody().getIssuer().equals("UxP-Gll")) {
				return userService.findAllCollectionsByUserId(userId);
			} else {
				return Collections.singletonMap("error", "Not Authorized");
			}
		} catch(SignatureException e) {
			return Collections.singletonMap("error", "Not Authorized");
		} catch(MalformedJwtException m) {
			return Collections.singletonMap("error", "Bad token");
		}
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