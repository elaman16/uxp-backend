package com.uxp.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="userPermission")
public class UserPermissions {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userPermissionId;
	
	@Column(name="userRoleId")
	private long userRoleId;
	@Column(name="userPermissionCode")
	private String userPermissionCode;
	@Column(name="userPermissionDescription")
	private String userPermissionDescription;
	@Column(name="useStatus")
	private char useStatus;
	@Column(name="programId")
	private String programId;
	@Column(name="locId")
	private String LocId;
	@Column(name="timeUpdated")
	private Date timeUpdated;
	@Column(name="updatedBy")
	private long updatedBy;
	
	public UserPermissions(String userPermissionCode, String userPermissionDescription, 
		   long userRoleId, String programId, String locId) {
	
		this.userRoleId = userRoleId;
		this.userPermissionCode = userPermissionCode;
		this.userPermissionDescription = userPermissionDescription;
		this.useStatus = 'I';
		this.programId = programId;
		LocId = locId;
		this.timeUpdated = new Date();
		this.updatedBy = 0;
		
	}
	public long getUserPermissionId() {
		return userPermissionId;
	}
	public void setUserPermissionId(long userPermissionId) {
		this.userPermissionId = userPermissionId;
	}
	public long getUserRoleId() {
		return userRoleId;
	}
	public void setUserRoleId(long userRoleId) {
		this.userRoleId = userRoleId;
	}
	public String getUserPermissionCode() {
		return userPermissionCode;
	}
	public void setUserPermissionCode(String userPermissionCode) {
		this.userPermissionCode = userPermissionCode;
	}
	public String getUserPermissionDescription() {
		return userPermissionDescription;
	}
	public void setUserPermissionDescription(String userPermissionDescription) {
		this.userPermissionDescription = userPermissionDescription;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((LocId == null) ? 0 : LocId.hashCode());
		result = prime * result + ((programId == null) ? 0 : programId.hashCode());
		result = prime * result + ((timeUpdated == null) ? 0 : timeUpdated.hashCode());
		result = (int) (prime * result + updatedBy);
		result = prime * result + useStatus;
		result = prime * result + ((userPermissionCode == null) ? 0 : userPermissionCode.hashCode());
		result = prime * result + ((userPermissionDescription == null) ? 0 : userPermissionDescription.hashCode());
		result = (int) (prime * result + userPermissionId);
		result = (int) (prime * result + userRoleId);
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
		UserPermissions other = (UserPermissions) obj;
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
		if (userPermissionCode == null) {
			if (other.userPermissionCode != null)
				return false;
		} else if (!userPermissionCode.equals(other.userPermissionCode))
			return false;
		if (userPermissionDescription == null) {
			if (other.userPermissionDescription != null)
				return false;
		} else if (!userPermissionDescription.equals(other.userPermissionDescription))
			return false;
		if (userPermissionId != other.userPermissionId)
			return false;
		if (userRoleId != other.userRoleId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "UserPermissions [userPermissionId=" + userPermissionId + ", userRoleId=" + userRoleId
				+ ", userPermissionCode=" + userPermissionCode + ", userPermissionDescription="
				+ userPermissionDescription + ", useStatus=" + useStatus + ", programId=" + programId + ", LocId="
				+ LocId + ", timeUpdated=" + timeUpdated + ", updatedBy=" + updatedBy + "]";
	}
	
	
}
