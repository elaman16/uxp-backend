package com.uxp.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "users")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userId;
	@Column(name="useStatus")
	private char useStatus;
	@Column(name="programId")
	private String programId;
	@Column(name="LocId")
	private String LocId;
	@Column(name="timeUpdated")
	private Date timeUpdated;
	@Column(name="updatedBy")
	private long updatedBy;
	
	// new fields to tie in other tables. User is created last and has reference to other tables via IDs
	@Column(name="accountSettingId")
	private long accountSettingId;
	@Column(name="userActivityId")
	private long userActivityId;
	@Column(name="userRoleId")
	private long userRoleId;
	@Column(name="userProfileId")
	private long userProfileId;
	@Column(name="userExpertiseId")
	private long userExpertiseId;
	@Column(name="userPermissionId")
	private long userPermissionId;
	
	public User() {}
	
	public User(long accountSettingId, long userRoleId, long userProfileId, long userExpertiseId, long userPermissionId, String programId, String LocId) {
		this.accountSettingId = accountSettingId;
		this.userRoleId = userRoleId;
		this.userProfileId = userProfileId;
		this.userExpertiseId = userExpertiseId;
		this.userPermissionId = userPermissionId;
		this.useStatus = 'I';
		this.programId = programId;
		this.LocId = LocId;
		this.timeUpdated = new Date();
		this.updatedBy = 0;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
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
		LocId = locId;
	}

	public Date getTimeUpdated() {
		return timeUpdated;
	}

	public void setTimeUpdated(Date timeUpdated) {
		this.timeUpdated = timeUpdated;
	}

	public long getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(long updatedBy) {
		this.updatedBy = updatedBy;
	}

	public long getAccountSettingId() {
		return accountSettingId;
	}

	public void setAccountSettingId(long accountSettingId) {
		this.accountSettingId = accountSettingId;
	}

	public long getUserActivityId() {
		return userActivityId;
	}

	public void setUserActivityId(long userActivityId) {
		this.userActivityId = userActivityId;
	}

	public long getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(long userRoleId) {
		this.userRoleId = userRoleId;
	}

	public long getUserProfileId() {
		return userProfileId;
	}

	public void setUserProfileId(long userProfileId) {
		this.userProfileId = userProfileId;
	}

	public long getUserExpertiseId() {
		return userExpertiseId;
	}

	public void setUserExpertiseId(long userExpertiseId) {
		this.userExpertiseId = userExpertiseId;
	}

	public long getUserPermissionId() {
		return userPermissionId;
	}

	public void setUserPermissionId(long userPermissionId) {
		this.userPermissionId = userPermissionId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((LocId == null) ? 0 : LocId.hashCode());
		result = prime * result + (int) (accountSettingId ^ (accountSettingId >>> 32));
		result = prime * result + ((programId == null) ? 0 : programId.hashCode());
		result = prime * result + ((timeUpdated == null) ? 0 : timeUpdated.hashCode());
		result = prime * result + (int) (updatedBy ^ (updatedBy >>> 32));
		result = prime * result + useStatus;
		result = prime * result + (int) (userActivityId ^ (userActivityId >>> 32));
		result = prime * result + (int) (userExpertiseId ^ (userExpertiseId >>> 32));
		result = prime * result + (int) (userId ^ (userId >>> 32));
		result = prime * result + (int) (userPermissionId ^ (userPermissionId >>> 32));
		result = prime * result + (int) (userProfileId ^ (userProfileId >>> 32));
		result = prime * result + (int) (userRoleId ^ (userRoleId >>> 32));
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
		User other = (User) obj;
		if (LocId == null) {
			if (other.LocId != null)
				return false;
		} else if (!LocId.equals(other.LocId))
			return false;
		if (accountSettingId != other.accountSettingId)
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
		if (userActivityId != other.userActivityId)
			return false;
		if (userExpertiseId != other.userExpertiseId)
			return false;
		if (userId != other.userId)
			return false;
		if (userPermissionId != other.userPermissionId)
			return false;
		if (userProfileId != other.userProfileId)
			return false;
		if (userRoleId != other.userRoleId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", useStatus=" + useStatus + ", programId=" + programId + ", LocId=" + LocId
				+ ", timeUpdated=" + timeUpdated + ", updatedBy=" + updatedBy + ", accountSettingId=" + accountSettingId
				+ ", userActivityId=" + userActivityId + ", userRoleId=" + userRoleId + ", userProfileId="
				+ userProfileId + ", userExpertiseId=" + userExpertiseId + ", userPermissionId=" + userPermissionId
				+ "]";
	}

	
		
}
