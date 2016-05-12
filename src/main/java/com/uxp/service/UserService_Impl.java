package com.uxp.service;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
import com.uxp.model.UserRole;


@Service
@Transactional
public class UserService_Impl implements UserService {
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
	
	public Object createUser(String userName, String userPassword, String userFirstName, 
		   String userLastName, String userPicURL, String userEmail, String userEmployer,
		   String userDesignation, String userCity, String userState, String programId, 
		   long updatedBy, String userExpertise, String userRoleDescription, String userPermissionCode,
		   String userPermissionDescription, HttpServletRequest request, HttpServletResponse response) {
				long profileId;
			    try {	      
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
	
	public Object updateUserProfile(long userId, String userName, String userPassword,String userFirstName,
			String userLastName, String userPicURL, String userEmail, String userEmployer, String userDesignation,
			String userCity, String userState, String programId, HttpServletResponse response, 
			HttpServletRequest request) {
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
	
	public Object changeUserPass(long userId, String programId, String oldPass, String newPass, HttpServletResponse response,  HttpServletRequest request) {
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
}
