package com.uxp.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FunctionalityPermissions {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long functionalityId;
	private long userRoleId;
	private char permanentLock;
	private char startingLock;
	private char usageLock;
	private int unlockReferralsCount;
	private int startingUsageCount;
	private char useStatus;
	private String programId;
	private String LocId;
	private Date timeUpdated;
	private long updatedBy;
	
	FunctionalityPermissions() {}
	
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
	public char getPermanentLock() {
		return permanentLock;
	}
	public void setPermanentLock(char permanentLock) {
		this.permanentLock = permanentLock;
	}
	public char getStartingLock() {
		return startingLock;
	}
	public void setStartingLock(char startingLock) {
		this.startingLock = startingLock;
	}
	public char getUsageLock() {
		return usageLock;
	}
	public void setUsageLock(char usageLock) {
		this.usageLock = usageLock;
	}
	public int getUnlockReferralsCount() {
		return unlockReferralsCount;
	}
	public void setUnlockReferralsCount(int unlockReferralsCount) {
		this.unlockReferralsCount = unlockReferralsCount;
	}
	public int getStartingUsageCount() {
		return startingUsageCount;
	}
	public void setStartingUsageCount(int startingUsageCount) {
		this.startingUsageCount = startingUsageCount;
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
		result = prime * result + permanentLock;
		result = prime * result + ((programId == null) ? 0 : programId.hashCode());
		result = prime * result + startingLock;
		result = prime * result + startingUsageCount;
		result = prime * result + ((timeUpdated == null) ? 0 : timeUpdated.hashCode());
		result = prime * result + unlockReferralsCount;
		result = prime * result + (int) (updatedBy ^ (updatedBy >>> 32));
		result = prime * result + usageLock;
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
		FunctionalityPermissions other = (FunctionalityPermissions) obj;
		if (LocId == null) {
			if (other.LocId != null)
				return false;
		} else if (!LocId.equals(other.LocId))
			return false;
		if (functionalityId != other.functionalityId)
			return false;
		if (permanentLock != other.permanentLock)
			return false;
		if (programId == null) {
			if (other.programId != null)
				return false;
		} else if (!programId.equals(other.programId))
			return false;
		if (startingLock != other.startingLock)
			return false;
		if (startingUsageCount != other.startingUsageCount)
			return false;
		if (timeUpdated == null) {
			if (other.timeUpdated != null)
				return false;
		} else if (!timeUpdated.equals(other.timeUpdated))
			return false;
		if (unlockReferralsCount != other.unlockReferralsCount)
			return false;
		if (updatedBy != other.updatedBy)
			return false;
		if (usageLock != other.usageLock)
			return false;
		if (useStatus != other.useStatus)
			return false;
		if (userRoleId != other.userRoleId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FunctionalityPermissions [functionalityId=" + functionalityId + ", userRoleId=" + userRoleId
				+ ", permanentLock=" + permanentLock + ", startingLock=" + startingLock + ", usageLock=" + usageLock
				+ ", unlockReferralsCount=" + unlockReferralsCount + ", startingUsageCount=" + startingUsageCount
				+ ", useStatus=" + useStatus + ", programId=" + programId + ", LocId=" + LocId + ", timeUpdated="
				+ timeUpdated + ", updatedBy=" + updatedBy + "]";
	}
	
	
	
}
