package com.uxp.controller;


import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import com.uxp.dao.UserAccountSettingDAO;
import com.uxp.dao.UserActivityDAO;
import com.uxp.dao.UserDAO;
import com.uxp.dao.UserExpertiseDAO;
import com.uxp.dao.UserPermissionDAO;
import com.uxp.dao.UserProfileDAO;
import com.uxp.dao.UserRoleDAO;
import com.uxp.model.ResponseMsg;
import com.uxp.model.User;
import com.uxp.model.UserAccountSetting;
import com.uxp.model.UserActivityLog;
import com.uxp.model.UserExpertise;
import com.uxp.model.UserPermissions;
import com.uxp.model.UserProfile;
import com.uxp.model.UserResponse;
import com.uxp.model.UserRole;

@RestController
@RequestMapping(value="/user", method={RequestMethod.POST, RequestMethod.GET})
public class UserController {
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private UserProfileDAO userProfileDAO;
	@Autowired 
	private UserRoleDAO userRoleDAO;
	@Autowired
	private UserActivityDAO userActivityDAO;
	@Autowired
	private UserAccountSettingDAO userAccountSettingDAO;
	@Autowired
	private UserExpertiseDAO userExpertiseDAO;
	@Autowired
	private UserPermissionDAO userPermissionDAO;
	
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
		
		long profileId;
	    try {
	     /* User user = new User(programId, request.getRemoteAddr());
	      System.out.print(user);
	      userDAO.save(user); 
	      userId = Long.valueOf(user.getUserId());
	      */
	      
	      UserAccountSetting userAccountSetting = new UserAccountSetting(userPassword, programId, request.getRemoteAddr());
	      userAccountSettingDAO.save(userAccountSetting);
	      
	      UserRole userRole = new UserRole(userRoleDescription, programId, request.getRemoteAddr());
	      userRoleDAO.save(userRole);
	      
	      UserProfile userProfile = new UserProfile(userName, userFirstName, userLastName, userPicURL,
			userEmail, userEmployer, userDesignation, userCity, userState,
			programId, request.getRemoteAddr());
	      userProfileDAO.save(userProfile);
	      
	      UserExpertise _userExpertise = new UserExpertise(userExpertise, programId, request.getRemoteAddr());
	      userExpertiseDAO.save(_userExpertise);
	      
	      UserPermissions userPermission = new UserPermissions(userPermissionCode, userPermissionDescription, userRole.getUserRoleId(), programId, request.getRemoteAddr());
	      userPermissionDAO.save(userPermission);
	      
	      User user = new User(userAccountSetting.getUserId(), userRole.getUserRoleId(), userProfile.getUserId(), _userExpertise.getUserId(), userPermission.getUserPermissionId(), programId, request.getRemoteAddr());
	      UserActivityLog userActivityLog = new UserActivityLog(user.getUserId(), "newUserCreated", programId, request.getRemoteAddr());
	      user.setUserActivityId(userActivityLog.getActivityId());
	      
	      
	      userActivityDAO.save(userActivityLog);
	      userDAO.save(user);
	      profileId = user.getUserId();
	    }
	    catch (Exception ex) {
	      System.out.println("Error creating the user: " + ex.toString());
	      response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		  return new ResponseMsg("Error", "Could not create user");
	    }
	    response.setStatus(HttpServletResponse.SC_CREATED);
	    return new ResponseMsg("Success", "User " + profileId + " Created!");
	}
	/*
	 * POST to update existing user profile
	 */
	@RequestMapping(value="/{userId}/userProfile", method=RequestMethod.POST, consumes= MediaType.APPLICATION_FORM_URLENCODED_VALUE )
	public @ResponseBody Object postUserProfile(@PathVariable("userId") long userId, @RequestParam String userName, @RequestParam String userPassword,
			@RequestParam String userFirstName, @RequestParam String userLastName, @RequestParam String userPicURL,@RequestParam String userEmail,
			@RequestParam String userEmployer, @RequestParam String userDesignation, @RequestParam String userCity, @RequestParam String userState,
			@RequestParam String programId, UriComponentsBuilder ucBuilder,  HttpServletResponse response,  HttpServletRequest request) {
		
		try {
			User foundUser = userDAO.findOne(userId);
			UserActivityLog userActivityLog = new UserActivityLog(userId, "profileChanged", programId, request.getRemoteAddr());
			userActivityLog.setUpdatedBy(userId);
			userActivityDAO.save(userActivityLog);
			UserProfile storedProfile = userProfileDAO.findOne(foundUser.getUserProfileId());
			storedProfile.setUserName(userName);
			storedProfile.setUserFirstName(userFirstName);
			storedProfile.setUserLastName(userLastName);
			storedProfile.setUserPicURL(userPicURL);
			storedProfile.setUserEmail(userEmail);
			storedProfile.setUserEmployer(userEmployer);
			storedProfile.setUserDesignation(userDesignation);
			storedProfile.setUserCity(userCity);
			storedProfile.setUserState(userState);
			storedProfile.setProgramId(programId);
			storedProfile.setLocId(request.getRemoteAddr());
			storedProfile.setTimeUpdated(new Date());
			storedProfile.setUpdatedBy(10);
			userProfileDAO.save(storedProfile);
		} catch (Exception ex) {
		      System.out.println("Error updating the user profile: " + ex.toString());
		      response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			  return new ResponseMsg("Error", "Could not update user profile");
		    }
		response.setStatus(HttpServletResponse.SC_ACCEPTED);
		return new ResponseMsg("Message", "User " + userId + " profile updated.");
	}
	/*
	 * POST to change user password, old pass req'd
	 */
	@RequestMapping(value="/{userId}/userAccountSetting", method=RequestMethod.POST, consumes= MediaType.APPLICATION_FORM_URLENCODED_VALUE )
	public @ResponseBody Object postUserAccountSetting(@PathVariable("userId") long userId, @RequestParam String programId, 
		   @RequestParam String oldPass, @RequestParam String newPass, HttpServletResponse response,  HttpServletRequest request) {
		try {
			User foundUser = userDAO.findOne(userId);
			UserAccountSetting storedAccount = userAccountSettingDAO.findOne(foundUser.getAccountSettingId());
			if(storedAccount.checkForMatch(oldPass)) {
				storedAccount.setUserPassword(newPass);
				UserActivityLog userActivityLog = new UserActivityLog(userId, "passChangeOK", programId, request.getRemoteAddr());
				userActivityLog.setUpdatedBy(userId);
				userActivityDAO.save(userActivityLog);
				userAccountSettingDAO.save(storedAccount);
			} else {
				UserActivityLog userActivityLog = new UserActivityLog(userId, "passChangeFail", programId, request.getRemoteAddr());
				userActivityLog.setUpdatedBy(userId);
				userActivityDAO.save(userActivityLog);
				response.setStatus(HttpServletResponse.SC_FORBIDDEN);
				return new ResponseMsg("Error", "Password mismatch");
			}
		} catch (Exception ex) {
		    System.out.println("Error updating the user password: " + ex.toString());
	        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		    return new ResponseMsg("Error", "Could not update user profile");
		  }
		response.setStatus(HttpServletResponse.SC_OK);
		return new ResponseMsg("Message", "User " + userId + " Account Settings updated.");
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
	@RequestMapping(value="/{userId}", method=RequestMethod.GET )
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