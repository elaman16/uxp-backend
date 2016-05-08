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
	private int pinTypeId; //unsure of this field name, should be ? userExpertise ? String
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
	
	public UserExpertise(int pinTypeId, String programId, String locId) {
		
		this.pinTypeId = pinTypeId;
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
	public int getPinTypeId() {
		return pinTypeId;
	}
	public void setPinTypeId(int pinTypeId) {
		this.pinTypeId = pinTypeId;
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
		result = prime * result + pinTypeId;
		result = prime * result + ((timeUpdated == null) ? 0 : timeUpdated.hashCode());
		result = (int) (prime * result + updatedBy);
		result = prime * result + useStatus;
		result = (int) (prime * result + userId);
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
		if (pinTypeId != other.pinTypeId)
			return false;
		if (programId != other.programId)
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
		if (userId != other.userId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "UserExpertise [userId=" + userId + ", pinTypeId=" + pinTypeId + ", useStatus=" + useStatus
				+ ", programId=" + programId + ", LocId=" + LocId + ", timeUpdated=" + timeUpdated + ", updatedBy="
				+ updatedBy + "]";
	}
	
	
}
