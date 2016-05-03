package com.uxp.model;

import java.util.Date;

public class ParentDomain {
	private int parentDomainId;
	private String parentDomainName;
	private char useStatus;
	private String programId;
	private String LocId;
	private Date timeUpdated;
	private int updatedBy;
	
	public ParentDomain(int parentDomainId, String parentDomainName, char useStatus, String programId, String locId,
			Date timeUpdated, int updatedBy) {
		super();
		this.parentDomainId = parentDomainId;
		this.parentDomainName = parentDomainName;
		this.useStatus = useStatus;
		this.programId = programId;
		LocId = locId;
		this.timeUpdated = timeUpdated;
		this.updatedBy = updatedBy;
	}

	public int getParentDomainId() {
		return parentDomainId;
	}

	public void setParentDomainId(int parentDomainId) {
		this.parentDomainId = parentDomainId;
	}

	public String getParentDomainName() {
		return parentDomainName;
	}

	public void setParentDomainName(String parentDomainName) {
		this.parentDomainName = parentDomainName;
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
		result = prime * result + parentDomainId;
		result = prime * result + ((parentDomainName == null) ? 0 : parentDomainName.hashCode());
		result = prime * result + ((programId == null) ? 0 : programId.hashCode());
		result = prime * result + ((timeUpdated == null) ? 0 : timeUpdated.hashCode());
		result = prime * result + updatedBy;
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
		ParentDomain other = (ParentDomain) obj;
		if (LocId == null) {
			if (other.LocId != null)
				return false;
		} else if (!LocId.equals(other.LocId))
			return false;
		if (parentDomainId != other.parentDomainId)
			return false;
		if (parentDomainName == null) {
			if (other.parentDomainName != null)
				return false;
		} else if (!parentDomainName.equals(other.parentDomainName))
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
		return "ParentDomain [parentDomainId=" + parentDomainId + ", parentDomainName=" + parentDomainName
				+ ", useStatus=" + useStatus + ", programId=" + programId + ", LocId=" + LocId + ", timeUpdated="
				+ timeUpdated + ", updatedBy=" + updatedBy + "]";
	}
	
	
}
