package com.uxp.model;

import java.util.Date;

public class UserResponse {
	private long userId;
	private String userName;
	private String userFirstName;
	private String userLastName;
	private String userPicURL;
	private String userEmail;
	private String userEmployer;
	private String userDesignation;
	private String userExpertise;
	private String userCity;
	private String userState;
	private String token;
	private Date lastUpdate;
	public UserResponse() {}
	
	public UserResponse(User user, UserProfile userProfile, UserExpertise ux) {
		this.userId = user.getUserId();
		this.userName = userProfile.getUserName();
		this.userFirstName = userProfile.getUserFirstName();
		this.userLastName = userProfile.getUserLastName();
		this.userPicURL = userProfile.getUserPicURL();
		this.userEmail = userProfile.getUserEmail();
		this.userEmployer = userProfile.getUserEmployer();
		this.userDesignation= userProfile.getUserDesignation();
		this.userExpertise = ux.getUserExpertise();
		this.userCity = userProfile.getUserCity();
		this.userState = userProfile.getUserState();
		this.lastUpdate = user.getTimeUpdated();
	}
	
	public UserResponse(User user, UserProfile userProfile, UserExpertise ux, String token) {
		this.userId = user.getUserId();
		this.userName = userProfile.getUserName();
		this.userFirstName = userProfile.getUserFirstName();
		this.userLastName = userProfile.getUserLastName();
		this.userPicURL = userProfile.getUserPicURL();
		this.userEmail = userProfile.getUserEmail();
		this.userEmployer = userProfile.getUserEmployer();
		this.userDesignation= userProfile.getUserDesignation();
		this.userExpertise = ux.getUserExpertise();
		this.userCity = userProfile.getUserCity();
		this.userState = userProfile.getUserState();
		this.token = token;
		this.lastUpdate = user.getTimeUpdated();
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

	public String getUserExpertise() {
		return userExpertise;
	}

	public void setUserExpertise(String userExpertise) {
		this.userExpertise = userExpertise;
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

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@Override
	public String toString() {
		return "UserResponse [userId=" + userId + ", userName=" + userName + ", userFirstName=" + userFirstName
				+ ", userLastName=" + userLastName + ", userPicURL=" + userPicURL + ", userEmail=" + userEmail
				+ ", userEmployer=" + userEmployer + ", userDesignation=" + userDesignation + ", userExpertise="
				+ userExpertise + ", userCity=" + userCity + ", userState=" + userState + ", token=" + token
				+ ", lastUpdate=" + lastUpdate + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lastUpdate == null) ? 0 : lastUpdate.hashCode());
		result = prime * result + ((token == null) ? 0 : token.hashCode());
		result = prime * result + ((userCity == null) ? 0 : userCity.hashCode());
		result = prime * result + ((userDesignation == null) ? 0 : userDesignation.hashCode());
		result = prime * result + ((userEmail == null) ? 0 : userEmail.hashCode());
		result = prime * result + ((userEmployer == null) ? 0 : userEmployer.hashCode());
		result = prime * result + ((userExpertise == null) ? 0 : userExpertise.hashCode());
		result = prime * result + ((userFirstName == null) ? 0 : userFirstName.hashCode());
		result = prime * result + (int) (userId ^ (userId >>> 32));
		result = prime * result + ((userLastName == null) ? 0 : userLastName.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + ((userPicURL == null) ? 0 : userPicURL.hashCode());
		result = prime * result + ((userState == null) ? 0 : userState.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserResponse other = (UserResponse) obj;
		if (lastUpdate == null) {
			if (other.lastUpdate != null)
				return false;
		} else if (!lastUpdate.equals(other.lastUpdate))
			return false;
		if (token == null) {
			if (other.token != null)
				return false;
		} else if (!token.equals(other.token))
			return false;
		if (userCity == null) {
			if (other.userCity != null)
				return false;
		} else if (!userCity.equals(other.userCity))
			return false;
		if (userDesignation == null) {
			if (other.userDesignation != null)
				return false;
		} else if (!userDesignation.equals(other.userDesignation))
			return false;
		if (userEmail == null) {
			if (other.userEmail != null)
				return false;
		} else if (!userEmail.equals(other.userEmail))
			return false;
		if (userEmployer == null) {
			if (other.userEmployer != null)
				return false;
		} else if (!userEmployer.equals(other.userEmployer))
			return false;
		if (userExpertise == null) {
			if (other.userExpertise != null)
				return false;
		} else if (!userExpertise.equals(other.userExpertise))
			return false;
		if (userFirstName == null) {
			if (other.userFirstName != null)
				return false;
		} else if (!userFirstName.equals(other.userFirstName))
			return false;
		if (userId != other.userId)
			return false;
		if (userLastName == null) {
			if (other.userLastName != null)
				return false;
		} else if (!userLastName.equals(other.userLastName))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (userPicURL == null) {
			if (other.userPicURL != null)
				return false;
		} else if (!userPicURL.equals(other.userPicURL))
			return false;
		if (userState == null) {
			if (other.userState != null)
				return false;
		} else if (!userState.equals(other.userState))
			return false;
		return true;
	}
	

}
