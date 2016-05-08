package com.uxp.model;


public class UserResponse {
	private long userId;
	private String userName;
	private String userFirstName;
	private String userLastName;
	private String userPicURL;
	private String userEmail;
	private String userEmployer;
	private String userDesignation;
	private String userRoleDesc;
	private String userCity;
	private String userState;
	
	public UserResponse() {}
	
	public UserResponse(User user, UserRole userRole, UserProfile userProfile) {
		this.userId = user.getUserId();
		this.userName = userProfile.getUserName();
		this.userFirstName = userProfile.getUserFirstName();
		this.userLastName = userProfile.getUserLastName();
		this.userPicURL = userProfile.getUserPicURL();
		this.userEmail = userProfile.getUserEmail();
		this.userEmployer = userProfile.getUserEmployer();
		this.userDesignation= userProfile.getUserDesignation();
		this.userRoleDesc = userRole.getUserRoleDescription();
		this.userCity = userProfile.getUserCity();
		this.userState = userProfile.getUserState();
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getUserPicURL() {
		return userPicURL;
	}

	public void setUserPicURL(String userPicURL) {
		this.userPicURL = userPicURL;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserEmployer() {
		return userEmployer;
	}

	public void setUserEmployer(String userEmployer) {
		this.userEmployer = userEmployer;
	}

	public String getUserDesignation() {
		return userDesignation;
	}

	public void setUserDesignation(String userDesignation) {
		this.userDesignation = userDesignation;
	}

	public String getUserRoleDesc() {
		return userRoleDesc;
	}

	public void setUserRoleDesc(String userRoleDesc) {
		this.userRoleDesc = userRoleDesc;
	}

	public String getUserCity() {
		return userCity;
	}

	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}

	public String getUserState() {
		return userState;
	}

	public void setUserState(String userState) {
		this.userState = userState;
	}

}
