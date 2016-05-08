package com.uxp.model;

import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name = "userActivityLog")
public class UserActivityLog {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long activityId;
	@Column(name="activeUserId")
	private long activeUserId;
	@Column(name="lastLogin")
	private Date lastLogin;
	@Column(name="activityDescription")
	private String activityDescription;
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
	
	public UserActivityLog() {}
	
	public UserActivityLog(long activeUserId, String activityDescription, String programId, String locId) {
		this.activeUserId = activeUserId;
		this.lastLogin = new Date();
		this.activityDescription = activityDescription;
		this.useStatus = 'I';
		this.programId = programId;
		this.LocId = locId;
		this.timeUpdated = new Date();
		this.updatedBy = 0;
	}
	public long getActiveUserId() {
		return activeUserId;
	}
	public void setActiveUserId(long activeUserId) {
		this.activeUserId = activeUserId;
	}
	public long getActivityId() {
		return activityId;
	}

	public void setActivityId(long activityId) {
		this.activityId = activityId;
	}

	public Date getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	public String getActivityDescription() {
		return activityDescription;
	}
	public void setActivityDescription(String activityDescription) {
		this.activityDescription = activityDescription;
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
		result = (int) (prime * result + activeUserId);
		result = prime * result + ((activityDescription == null) ? 0 : activityDescription.hashCode());
		result = prime * result + ((lastLogin == null) ? 0 : lastLogin.hashCode());
		result = prime * result + ((programId == null) ? 0 : programId.hashCode());
		result = prime * result + ((timeUpdated == null) ? 0 : timeUpdated.hashCode());
		result = (int) (prime * result + updatedBy);
		result = prime * result + useStatus;
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
		UserActivityLog other = (UserActivityLog) obj;
		if (LocId == null) {
			if (other.LocId != null)
				return false;
		} else if (!LocId.equals(other.LocId))
			return false;
		if (activeUserId != other.activeUserId)
			return false;
		if (activityDescription == null) {
			if (other.activityDescription != null)
				return false;
		} else if (!activityDescription.equals(other.activityDescription))
			return false;
		if (lastLogin == null) {
			if (other.lastLogin != null)
				return false;
		} else if (!lastLogin.equals(other.lastLogin))
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
		return true;
	}
	@Override
	public String toString() {
		return "UserActivityLog [activeUserId=" + activeUserId + ", lastLogin=" + lastLogin + ", activityDescription="
				+ activityDescription + ", useStatus=" + useStatus + ", programId=" + programId + ", LocId=" + LocId
				+ ", timeUpdated=" + timeUpdated + ", updatedBy=" + updatedBy + "]";
	}
	
	
}
