package com.uxp.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="userProfile")
public class UserProfile implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userProfileId;
	@Column(name="userName")
	private String userName;
	@Column(name="userFirstName")
	private String userFirstName;
	@Column(name="userLastName")
	private String userLastName;
	@Column(name="userPicURL")
	private String userPicURL;
	@Column(name="userEmail")
	private String userEmail;
	@Column(name="userEmployer")
	private String userEmployer;
	@Column(name="userDesignation")
	private String userDesignation;
	@Column(name="userCity")
	private String userCity;
	@Column(name="userState")
	private String userState;
	@Column(name="useStatus")
	private char useStatus;
	@Column(name="programId")
	private String programId;
	@Column(name="locId")
	private String LocId;
	@Column(name="timeUpdated")
	private Date timeUpdated;
	@Column(name="updatedBy")
	private int updatedBy;
	
	public UserProfile() {}
	
	public UserProfile(String userName, String userFirstName, String userLastName, String userPicURL,
			String userEmail, String userEmployer, String userDesignation, String userCity, String userState,
			String programId, String locId) {
		this.userName = userName;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userPicURL = userPicURL;
		this.userEmail = userEmail;
		this.userEmployer = userEmployer;
		this.userDesignation = userDesignation;
		this.userCity = userCity;
		this.userState = userState;
		this.useStatus = 'I';
		this.programId = programId;
		this.LocId = locId;
		this.timeUpdated = new Date();
		this.updatedBy = 10;
	}
	
	public long getUserProfileId() {
		return userProfileId;
	}

	public void setUserProfileId(long userProfileId) {
		this.userProfileId = userProfileId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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
	public char getUseStatus() {
		return useStatus;
	}
	public void setUseStatus(char useStatus) {
		this.useStatus = useStatus;
	}
	public String getProgramId() {
		return programId;
	}
	public void setProgramId(String programId) {
		this.programId = programId;
	}
	public String getLocId() {
		return LocId;
	}
	public void setLocId(String locId) {
		this.LocId = locId;
	}
	public Date getTimeUpdated() {
		return timeUpdated;
	}
	public void setTimeUpdated(Date timeUpdated) {
		this.timeUpdated = timeUpdated;
	}
	public int getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((LocId == null) ? 0 : LocId.hashCode());
		result = prime * result + ((programId == null) ? 0 : programId.hashCode());
		result = prime * result + ((timeUpdated == null) ? 0 : timeUpdated.hashCode());
		result = prime * result + updatedBy;
		result = prime * result + useStatus;
		result = prime * result + ((userCity == null) ? 0 : userCity.hashCode());
		result = prime * result + ((userDesignation == null) ? 0 : userDesignation.hashCode());
		result = prime * result + ((userEmail == null) ? 0 : userEmail.hashCode());
		result = prime * result + ((userEmployer == null) ? 0 : userEmployer.hashCode());
		result = prime * result + ((userFirstName == null) ? 0 : userFirstName.hashCode());
		result = (int) (prime * result + userProfileId);
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
		UserProfile other = (UserProfile) obj;
		if (LocId == null) {
			if (other.LocId != null)
				return false;
		} else if (!LocId.equals(other.LocId))
			return false;
		if (programId == null) {
			if (other.programId != null)
				return false;
		} else if (!programId.equals(other.programId))
			return false;
		if (timeUpdated == null) {
			if (other.timeUpdated != null)
				return false;
		} else if (!timeUpdated.equals(other.timeUpdated))
			return false;
		if (updatedBy != other.updatedBy)
			return false;
		if (useStatus != other.useStatus)
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
		if (userFirstName == null) {
			if (other.userFirstName != null)
				return false;
		} else if (!userFirstName.equals(other.userFirstName))
			return false;
		if (userProfileId != other.userProfileId)
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
	@Override
	public String toString() {
		return "UserProfile [userId=" + userProfileId + ", userName=" + userName + ", userFirstName=" + userFirstName
				+ ", userLastName=" + userLastName + ", userPicURL=" + userPicURL + ", userEmail=" + userEmail
				+ ", userEmployer=" + userEmployer + ", userDesignation=" + userDesignation + ", userCity=" + userCity
				+ ", userState=" + userState + ", useStatus=" + useStatus + ", programId=" + programId + ", LocId="
				+ LocId + ", timeUpdated=" + timeUpdated + ", updatedBy=" + updatedBy + "]";
	}
	
	
}
