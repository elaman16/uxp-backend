package com.uxp.model;

import java.util.Date;

public class UserPermissions {
	private int userPermissionId;
	private int userRoleId;
	private String userPermissionCode;
	private String userPermissionDescription;
	private char useStatus;
	private String programId;
	private String LocId;
	private Date timeUpdated;
	private int updatedBy;
	public UserPermissions(int userPermissionId, int userRoleId, String userPermissionCode,
			String userPermissionDescription, char useStatus, String programId, String locId, Date timeUpdated,
			int updatedBy) {
		super();
		this.userPermissionId = userPermissionId;
		this.userRoleId = userRoleId;
		this.userPermissionCode = userPermissionCode;
		this.userPermissionDescription = userPermissionDescription;
		this.useStatus = useStatus;
		this.programId = programId;
		LocId = locId;
		this.timeUpdated = timeUpdated;
		this.updatedBy = updatedBy;
	}
	public int getUserPermissionId() {
		return userPermissionId;
	}
	public void setUserPermissionId(int userPermissionId) {
		this.userPermissionId = userPermissionId;
	}
	public int getUserRoleId() {
		return userRoleId;
	}
	public void setUserRoleId(int userRoleId) {
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
		result = prime * result + ((userPermissionCode == null) ? 0 : userPermissionCode.hashCode());
		result = prime * result + ((userPermissionDescription == null) ? 0 : userPermissionDescription.hashCode());
		result = prime * result + userPermissionId;
		result = prime * result + userRoleId;
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
