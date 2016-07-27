package com.uxp.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class NotificationModule {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private long notificationTypeId;
	private long notificationFromUserId;
	private char useStatus;
	private String programId;
	private String LocId;
	private Date timeUpdated;
	private long updatedBy;
	
	NotificationModule() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getNotificationTypeId() {
		return notificationTypeId;
	}

	public void setNotificationTypeId(long notificationTypeId) {
		this.notificationTypeId = notificationTypeId;
	}

	public long getNotificationFromUserId() {
		return notificationFromUserId;
	}

	public void setNotificationFromUserId(long notificationFromUserId) {
		this.notificationFromUserId = notificationFromUserId;
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
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (int) (notificationFromUserId ^ (notificationFromUserId >>> 32));
		result = prime * result + (int) (notificationTypeId ^ (notificationTypeId >>> 32));
		result = prime * result + ((programId == null) ? 0 : programId.hashCode());
		result = prime * result + (int) (updatedBy ^ (updatedBy >>> 32));
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
		NotificationModule other = (NotificationModule) obj;
		if (LocId == null) {
			if (other.LocId != null)
				return false;
		} else if (!LocId.equals(other.LocId))
			return false;
		if (id != other.id)
			return false;
		if (notificationFromUserId != other.notificationFromUserId)
			return false;
		if (notificationTypeId != other.notificationTypeId)
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
		return true;
	}

	@Override
	public String toString() {
		return "NotificationModule [id=" + id + ", notificationTypeId=" + notificationTypeId
				+ ", notificationFromUserId=" + notificationFromUserId + ", useStatus=" + useStatus + ", programId="
				+ programId + ", LocId=" + LocId + ", updatedBy=" + updatedBy + "]";
	}
	
	
	
}
