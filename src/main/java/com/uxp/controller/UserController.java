package com.uxp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import com.uxp.service.UserService;

@RestController
@RequestMapping(value="/user", method={RequestMethod.POST, RequestMethod.GET})
public class UserController {
	@Autowired
	private UserService userService;
	
	//*************************************POST REQUESTS***********************************
	
	/*
	 * POST to create a new user.
	 */
	@RequestMapping(value="", method=RequestMethod.POST, consumes= MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = "application/json")
	public @ResponseBody Object createUser(@RequestParam String userName, @RequestParam String userPassword, @RequestParam String userFirstName, 
			@RequestParam String userLastName, @RequestParam String userPicURL,@RequestParam String userEmail, @RequestParam String userEmployer,
			@RequestParam String userDesignation, @RequestParam String userCity, @RequestParam String userState, @RequestParam String programId, 
			@RequestParam long updatedBy, @RequestParam String userExpertise, @RequestParam String userRoleDescription,
			@RequestParam String userPermissionCode, @RequestParam String userPermissionDescription, HttpServletRequest request, HttpServletResponse response) {
		
		return userService.createUser(userName, userPassword, userFirstName, userLastName, userPicURL, userEmail, userEmployer, userDesignation, userCity, userState, programId, updatedBy, userExpertise, userRoleDescription, userPermissionCode, userPermissionDescription, request, response);
	}
	/*
	 * POST to Login
	 */
	@RequestMapping(value="/login", method=RequestMethod.POST, consumes= MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = "application/json")
	public @ResponseBody Object loginUser(@RequestParam String userName, @RequestParam String userPassword, HttpServletRequest request, HttpServletResponse response) {
		
		return userService.userLogin(userName, userPassword);
	}
	/*
	 * POST to update existing user profile
	 */
	@RequestMapping(value="/{userId}/userProfile", method=RequestMethod.POST, consumes= MediaType.APPLICATION_FORM_URLENCODED_VALUE )
	public @ResponseBody Object postUserProfile(@PathVariable("userId") long userId, @RequestParam String userName, @RequestParam String userPassword,
			@RequestParam String userFirstName, @RequestParam String userLastName, @RequestParam String userPicURL,@RequestParam String userEmail,
			@RequestParam String userEmployer, @RequestParam String userDesignation, @RequestParam String userCity, @RequestParam String userState,
			@RequestParam String programId, UriComponentsBuilder ucBuilder,  HttpServletResponse response,  HttpServletRequest request) {
		
		return userService.updateUserProfile(userId, userName, userPassword, userFirstName, userLastName, userPicURL, userEmail, userEmployer, userDesignation, userCity, userState, programId, response, request);
	}
	/*
	 * POST to change user password, old pass req'd
	 */
	@RequestMapping(value="/{userId}/userAccountSetting", method=RequestMethod.POST, consumes= MediaType.APPLICATION_FORM_URLENCODED_VALUE )
	public @ResponseBody Object postUserAccountSetting(@PathVariable("userId") long userId, @RequestParam String programId, 
		   @RequestParam String oldPass, @RequestParam String newPass, HttpServletResponse response,  HttpServletRequest request) {
		return userService.changeUserPass(userId, programId, oldPass, newPass, response, request);
	}
	
	/* STUBBED ENDPOINTS - Not sure if will need, at least for now.
	@RequestMapping(value="/userExpertise", method=RequestMethod.POST, consumes= MediaType.APPLICATION_FORM_URLENCODED_VALUE )
	public ResponseEntity<Void> postUserExpertise(@RequestParam String userExpertise) {
		
		System.out.println(userExpertise);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	@RequestMapping(value="/userRole", method=RequestMethod.POST, consumes= MediaType.APPLICATION_FORM_URLENCODED_VALUE )
	public ResponseEntity<Void> postUserRole(@RequestParam String userRole) {
		
		System.out.println(userRole);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	@RequestMapping(value="/userPermission", method=RequestMethod.POST, consumes= MediaType.APPLICATION_FORM_URLENCODED_VALUE )
	public ResponseEntity<Void> postUserPermission(@RequestParam String userPermission) {
		
		System.out.println(userPermission);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	*/
	//******************************************GET Requests******************************888
	/*@RequestMapping(value="/{userId}", method=RequestMethod.GET )
	public @ResponseBody Object getUserByUserId(@PathVariable("userId") long userId, @RequestHeader("programId") String programId,HttpServletResponse response, HttpServletRequest request) {
		UserResponse userResponse;
		try {
			User user = userDAO.findOne(userId);
			UserProfile userProfile = userProfileDAO.findOne(user.getUserProfileId());
			UserRole userRole = userRoleDAO.findOne(user.getUserRoleId());
			userResponse = new UserResponse(user, userRole, userProfile);
			UserActivityLog userActivityLog = new UserActivityLog(userId, "UserProfileFetched", programId, request.getRemoteAddr());
			userActivityLog.setUpdatedBy(userId);
			userActivityDAO.save(userActivityLog);
		}
		catch (Exception ex) {
		   System.out.println("An error occured: " + ex.toString());
		   response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		   return ex;
	    }
		if(userResponse.getUserName() == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return new ResponseMsg("error", "Not Found");
		} else {
			response.setStatus(HttpServletResponse.SC_OK);
			return userResponse;
		}
	}*/
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