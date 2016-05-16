package com.uxp.model;

import java.util.Date;

import javax.persistence.*;
@Entity
@Table(name="userExpertise")
public class UserExpertise {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userId;
	@Column(name="pinTypeId")
	private String userExpertise; 
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
	
	public UserExpertise() {}
	
	public UserExpertise(String userExpertise, String programId, String locId) {
		this.userExpertise = userExpertise;
		this.useStatus = 'I';
		this.programId = programId;
		this.LocId = locId;
		this.timeUpdated = new Date();
		this.updatedBy = 0;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserExpertise() {
		return userExpertise;
	}

	public void setUserExpertise(String userExpertise) {
		this.userExpertise = userExpertise;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((LocId == null) ? 0 : LocId.hashCode());
		result = prime * result + ((programId == null) ? 0 : programId.hashCode());
		result = prime * result + ((timeUpdated == null) ? 0 : timeUpdated.hashCode());
		result = prime * result + (int) (updatedBy ^ (updatedBy >>> 32));
		result = prime * result + useStatus;
		result = prime * result + ((userExpertise == null) ? 0 : userExpertise.hashCode());
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
		UserExpertise other = (UserExpertise) obj;
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
		if (userExpertise == null) {
			if (other.userExpertise != null)
				return false;
		} else if (!userExpertise.equals(other.userExpertise))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserExpertise [userId=" + userId + ", userExpertise=" + userExpertise + ", useStatus=" + useStatus
				+ ", programId=" + programId + ", LocId=" + LocId + ", timeUpdated=" + timeUpdated + ", updatedBy="
				+ updatedBy + "]";
	}
	
	
}
