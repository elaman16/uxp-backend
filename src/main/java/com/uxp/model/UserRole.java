package com.uxp.model;

import java.util.Date;
import javax.persistence.*;

@Entity
public class UserRole {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int userRoleId;
	
	private String userRoleDescription;
	private char useStatus;
	private String programId;
	private String LocId;
	private Date timeUpdated;
	private int updatedBy;
	public UserRole(int userRoleId, String userRoleDescription, char useStatus, String programId, String locId,
			Date timeUpdated, int updatedBy) {
		super();
		this.userRoleId = userRoleId;
		this.userRoleDescription = userRoleDescription;
		this.useStatus = useStatus;
		this.programId = programId;
		LocId = locId;
		this.timeUpdated = timeUpdated;
		this.updatedBy = updatedBy;
	}
	public int getUserRoleId() {
		return userRoleId;
	}
	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}
	public String getUserRoleDescription() {
		return userRoleDescription;
	}
	public void setUserRoleDescription(String userRoleDescription) {
		this.userRoleDescription = userRoleDescription;
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
		result = prime * result + ((userRoleDescription == null) ? 0 : userRoleDescription.hashCode());
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
		UserRole other = (UserRole) obj;
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
		if (userRoleDescription == null) {
			if (other.userRoleDescription != null)
				return false;
		} else if (!userRoleDescription.equals(other.userRoleDescription))
			return false;
		if (userRoleId != other.userRoleId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "UserRole [userRoleId=" + userRoleId + ", userRoleDescription=" + userRoleDescription + ", useStatus="
				+ useStatus + ", programId=" + programId + ", LocId=" + LocId + ", timeUpdated=" + timeUpdated
				+ ", updatedBy=" + updatedBy + "]";
	}
	
	
}
