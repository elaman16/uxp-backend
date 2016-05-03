package com.uxp.model;

import java.util.Date;

public class Relationships {
	private int relationshipId;
	private String relationshipDescription;
	private char useStatus;
	private String programId;
	private String LocId;
	private Date timeUpdated;
	private String updatedBy;
	public Relationships(int relationshipId, String relationshipDescription, char useStatus, String programId,
			String locId, Date timeUpdated, String updatedBy) {
		super();
		this.relationshipId = relationshipId;
		this.relationshipDescription = relationshipDescription;
		this.useStatus = useStatus;
		this.programId = programId;
		LocId = locId;
		this.timeUpdated = timeUpdated;
		this.updatedBy = updatedBy;
	}
	public int getRelationshipId() {
		return relationshipId;
	}
	public void setRelationshipId(int relationshipId) {
		this.relationshipId = relationshipId;
	}
	public String getRelationshipDescription() {
		return relationshipDescription;
	}
	public void setRelationshipDescription(String relationshipDescription) {
		this.relationshipDescription = relationshipDescription;
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
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((LocId == null) ? 0 : LocId.hashCode());
		result = prime * result + ((programId == null) ? 0 : programId.hashCode());
		result = prime * result + ((relationshipDescription == null) ? 0 : relationshipDescription.hashCode());
		result = prime * result + relationshipId;
		result = prime * result + ((timeUpdated == null) ? 0 : timeUpdated.hashCode());
		result = prime * result + ((updatedBy == null) ? 0 : updatedBy.hashCode());
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
		Relationships other = (Relationships) obj;
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
		if (relationshipDescription == null) {
			if (other.relationshipDescription != null)
				return false;
		} else if (!relationshipDescription.equals(other.relationshipDescription))
			return false;
		if (relationshipId != other.relationshipId)
			return false;
		if (timeUpdated == null) {
			if (other.timeUpdated != null)
				return false;
		} else if (!timeUpdated.equals(other.timeUpdated))
			return false;
		if (updatedBy == null) {
			if (other.updatedBy != null)
				return false;
		} else if (!updatedBy.equals(other.updatedBy))
			return false;
		if (useStatus != other.useStatus)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Relationships [relationshipId=" + relationshipId + ", relationshipDescription="
				+ relationshipDescription + ", useStatus=" + useStatus + ", programId=" + programId + ", LocId=" + LocId
				+ ", timeUpdated=" + timeUpdated + ", updatedBy=" + updatedBy + "]";
	}
	
	
}
