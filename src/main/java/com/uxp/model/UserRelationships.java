package com.uxp.model;

import java.util.Date;

public class UserRelationships {
	private int sourceUserId;
	private int targetUserId;
	private int relationshipId;
	private char useStatus;
	private String programId;
	private String LocId;
	private Date timeUpdated;
	private int updatedBy;
	public UserRelationships(int sourceUserId, int targetUserId, int relationshipId, char useStatus, String programId,
			String locId, Date timeUpdated, int updatedBy) {
		super();
		this.sourceUserId = sourceUserId;
		this.targetUserId = targetUserId;
		this.relationshipId = relationshipId;
		this.useStatus = useStatus;
		this.programId = programId;
		LocId = locId;
		this.timeUpdated = timeUpdated;
		this.updatedBy = updatedBy;
	}
	public int getSourceUserId() {
		return sourceUserId;
	}
	public void setSourceUserId(int sourceUserId) {
		this.sourceUserId = sourceUserId;
	}
	public int getTargetUserId() {
		return targetUserId;
	}
	public void setTargetUserId(int targetUserId) {
		this.targetUserId = targetUserId;
	}
	public int getRelationshipId() {
		return relationshipId;
	}
	public void setRelationshipId(int relationshipId) {
		this.relationshipId = relationshipId;
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
		result = prime * result + relationshipId;
		result = prime * result + sourceUserId;
		result = prime * result + targetUserId;
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
		UserRelationships other = (UserRelationships) obj;
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
		if (relationshipId != other.relationshipId)
			return false;
		if (sourceUserId != other.sourceUserId)
			return false;
		if (targetUserId != other.targetUserId)
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
		return "UserRelationships [sourceUserId=" + sourceUserId + ", targetUserId=" + targetUserId
				+ ", relationshipId=" + relationshipId + ", useStatus=" + useStatus + ", programId=" + programId
				+ ", LocId=" + LocId + ", timeUpdated=" + timeUpdated + ", updatedBy=" + updatedBy + "]";
	}
	
	
}
