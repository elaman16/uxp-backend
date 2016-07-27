package com.uxp.model;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserPlanStatus {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long ID;
	private long userId;
	private long premiumPlanId;
	private long userRoleId;
	private long administeredByUserId;
	private Date planStateDate;
	private Date planEndDate;
	private char planStatus;
	private char useStatus;
	private String programId;
	private String LocId;
	private Date timeUpdated;
	private long updatedBy;
	
	UserPlanStatus() {}

	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getPremiumPlanId() {
		return premiumPlanId;
	}

	public void setPremiumPlanId(long premiumPlanId) {
		this.premiumPlanId = premiumPlanId;
	}

	public long getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(long userRoleId) {
		this.userRoleId = userRoleId;
	}

	public long getAdministeredByUserId() {
		return administeredByUserId;
	}

	public void setAdministeredByUserId(long administeredByUserId) {
		this.administeredByUserId = administeredByUserId;
	}

	public Date getPlanStateDate() {
		return planStateDate;
	}

	public void setPlanStateDate(Date planStateDate) {
		this.planStateDate = planStateDate;
	}

	public Date getPlanEndDate() {
		return planEndDate;
	}

	public void setPlanEndDate(Date planEndDate) {
		this.planEndDate = planEndDate;
	}

	public char getPlanStatus() {
		return planStatus;
	}

	public void setPlanStatus(char planStatus) {
		this.planStatus = planStatus;
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
		result = prime * result + (int) (ID ^ (ID >>> 32));
		result = prime * result + ((LocId == null) ? 0 : LocId.hashCode());
		result = prime * result + (int) (administeredByUserId ^ (administeredByUserId >>> 32));
		result = prime * result + ((planEndDate == null) ? 0 : planEndDate.hashCode());
		result = prime * result + ((planStateDate == null) ? 0 : planStateDate.hashCode());
		result = prime * result + planStatus;
		result = prime * result + (int) (premiumPlanId ^ (premiumPlanId >>> 32));
		result = prime * result + ((programId == null) ? 0 : programId.hashCode());
		result = prime * result + ((timeUpdated == null) ? 0 : timeUpdated.hashCode());
		result = prime * result + (int) (updatedBy ^ (updatedBy >>> 32));
		result = prime * result + useStatus;
		result = prime * result + (int) (userId ^ (userId >>> 32));
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
		UserPlanStatus other = (UserPlanStatus) obj;
		if (ID != other.ID)
			return false;
		if (LocId == null) {
			if (other.LocId != null)
				return false;
		} else if (!LocId.equals(other.LocId))
			return false;
		if (administeredByUserId != other.administeredByUserId)
			return false;
		if (planEndDate == null) {
			if (other.planEndDate != null)
				return false;
		} else if (!planEndDate.equals(other.planEndDate))
			return false;
		if (planStateDate == null) {
			if (other.planStateDate != null)
				return false;
		} else if (!planStateDate.equals(other.planStateDate))
			return false;
		if (planStatus != other.planStatus)
			return false;
		if (premiumPlanId != other.premiumPlanId)
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
		if (userId != other.userId)
			return false;
		if (userRoleId != other.userRoleId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserPlanStatus [ID=" + ID + ", userId=" + userId + ", premiumPlanId=" + premiumPlanId + ", userRoleId="
				+ userRoleId + ", administeredByUserId=" + administeredByUserId + ", planStateDate=" + planStateDate
				+ ", planEndDate=" + planEndDate + ", planStatus=" + planStatus + ", useStatus=" + useStatus
				+ ", programId=" + programId + ", LocId=" + LocId + ", timeUpdated=" + timeUpdated + ", updatedBy="
				+ updatedBy + "]";
	}
	
	
}
