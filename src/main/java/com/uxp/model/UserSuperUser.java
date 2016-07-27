package com.uxp.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserSuperUser {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long userId;
	private char Status;
	private char useStatus;
	private String programId;
	private String LocId;
	private Date timeUpdated;
	private long updatedBy;
	
	UserSuperUser() {}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public char getStatus() {
		return Status;
	}

	public void setStatus(char status) {
		Status = status;
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
		result = prime * result + Status;
		result = prime * result + ((programId == null) ? 0 : programId.hashCode());
		result = prime * result + (int) (updatedBy ^ (updatedBy >>> 32));
		result = prime * result + useStatus;
		result = prime * result + (int) (userId ^ (userId >>> 32));
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
		UserSuperUser other = (UserSuperUser) obj;
		if (LocId == null) {
			if (other.LocId != null)
				return false;
		} else if (!LocId.equals(other.LocId))
			return false;
		if (Status != other.Status)
			return false;
		if (programId == null) {
			if (other.programId != null)
				return false;
		} else if (!programId.equals(other.programId))
			return false;
		if (updatedBy != other.updatedBy)
			return false;
		if (useStatus != other.useStatus)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserSuperUser [userId=" + userId + ", Status=" + Status + ", useStatus=" + useStatus + ", programId="
				+ programId + ", LocId=" + LocId + ", updatedBy=" + updatedBy + "]";
	}
	
	
}
