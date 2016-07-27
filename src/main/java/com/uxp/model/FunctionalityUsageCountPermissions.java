package com.uxp.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FunctionalityUsageCountPermissions {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private long functionalityId;
	private long userRoleId;
	private String usageReferrals;
	private String nextUsageCount;
	private char useStatus;
	private String programId;
	private String LocId;
	private Date timeUpdated;
	private long updatedBy;
	
	FunctionalityUsageCountPermissions() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getFunctionalityId() {
		return functionalityId;
	}

	public void setFunctionalityId(long functionalityId) {
		this.functionalityId = functionalityId;
	}

	public long getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(long userRoleId) {
		this.userRoleId = userRoleId;
	}

	public String getUsageReferrals() {
		return usageReferrals;
	}

	public void setUsageReferrals(String usageReferrals) {
		this.usageReferrals = usageReferrals;
	}

	public String getNextUsageCount() {
		return nextUsageCount;
	}

	public void setNextUsageCount(String nextUsageCount) {
		this.nextUsageCount = nextUsageCount;
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
		result = prime * result + (int) (functionalityId ^ (functionalityId >>> 32));
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((nextUsageCount == null) ? 0 : nextUsageCount.hashCode());
		result = prime * result + ((programId == null) ? 0 : programId.hashCode());
		result = prime * result + ((timeUpdated == null) ? 0 : timeUpdated.hashCode());
		result = prime * result + (int) (updatedBy ^ (updatedBy >>> 32));
		result = prime * result + ((usageReferrals == null) ? 0 : usageReferrals.hashCode());
		result = prime * result + useStatus;
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
		FunctionalityUsageCountPermissions other = (FunctionalityUsageCountPermissions) obj;
		if (LocId == null) {
			if (other.LocId != null)
				return false;
		} else if (!LocId.equals(other.LocId))
			return false;
		if (functionalityId != other.functionalityId)
			return false;
		if (id != other.id)
			return false;
		if (nextUsageCount == null) {
			if (other.nextUsageCount != null)
				return false;
		} else if (!nextUsageCount.equals(other.nextUsageCount))
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
		if (usageReferrals == null) {
			if (other.usageReferrals != null)
				return false;
		} else if (!usageReferrals.equals(other.usageReferrals))
			return false;
		if (useStatus != other.useStatus)
			return false;
		if (userRoleId != other.userRoleId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FunctionalityUsageCountPermissions [id=" + id + ", functionalityId=" + functionalityId + ", userRoleId="
				+ userRoleId + ", usageReferrals=" + usageReferrals + ", nextUsageCount=" + nextUsageCount
				+ ", useStatus=" + useStatus + ", programId=" + programId + ", LocId=" + LocId + ", timeUpdated="
				+ timeUpdated + ", updatedBy=" + updatedBy + "]";
	}
	
	
}
