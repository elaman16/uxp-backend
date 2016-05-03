package com.uxp.model;

import java.util.Date;

public class Reactions {
	private int reactionId;
	private int reactionTypeId;
	private int annotationId;
	private String reactionValue;
	private int reactionBy;
	private char useStatus;
	private String programId;
	private String LocId;
	private Date timeUpdated;
	private int updatedBy;
	public Reactions(int reactionId, int reactionTypeId, int annotationId, String reactionValue, int reactionBy,
			char useStatus, String programId, String locId, Date timeUpdated, int updatedBy) {
		super();
		this.reactionId = reactionId;
		this.reactionTypeId = reactionTypeId;
		this.annotationId = annotationId;
		this.reactionValue = reactionValue;
		this.reactionBy = reactionBy;
		this.useStatus = useStatus;
		this.programId = programId;
		LocId = locId;
		this.timeUpdated = timeUpdated;
		this.updatedBy = updatedBy;
	}
	public int getReactionId() {
		return reactionId;
	}
	public void setReactionId(int reactionId) {
		this.reactionId = reactionId;
	}
	public int getReactionTypeId() {
		return reactionTypeId;
	}
	public void setReactionTypeId(int reactionTypeId) {
		this.reactionTypeId = reactionTypeId;
	}
	public int getAnnotationId() {
		return annotationId;
	}
	public void setAnnotationId(int annotationId) {
		this.annotationId = annotationId;
	}
	public String getReactionValue() {
		return reactionValue;
	}
	public void setReactionValue(String reactionValue) {
		this.reactionValue = reactionValue;
	}
	public int getReactionBy() {
		return reactionBy;
	}
	public void setReactionBy(int reactionBy) {
		this.reactionBy = reactionBy;
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
		result = prime * result + annotationId;
		result = prime * result + ((programId == null) ? 0 : programId.hashCode());
		result = prime * result + reactionBy;
		result = prime * result + reactionId;
		result = prime * result + reactionTypeId;
		result = prime * result + ((reactionValue == null) ? 0 : reactionValue.hashCode());
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
		Reactions other = (Reactions) obj;
		if (LocId == null) {
			if (other.LocId != null)
				return false;
		} else if (!LocId.equals(other.LocId))
			return false;
		if (annotationId != other.annotationId)
			return false;
		if (programId == null) {
			if (other.programId != null)
				return false;
		} else if (!programId.equals(other.programId))
			return false;
		if (reactionBy != other.reactionBy)
			return false;
		if (reactionId != other.reactionId)
			return false;
		if (reactionTypeId != other.reactionTypeId)
			return false;
		if (reactionValue == null) {
			if (other.reactionValue != null)
				return false;
		} else if (!reactionValue.equals(other.reactionValue))
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
		return "Reactions [reactionId=" + reactionId + ", reactionTypeId=" + reactionTypeId + ", annotationId="
				+ annotationId + ", reactionValue=" + reactionValue + ", reactionBy=" + reactionBy + ", useStatus="
				+ useStatus + ", programId=" + programId + ", LocId=" + LocId + ", timeUpdated=" + timeUpdated
				+ ", updatedBy=" + updatedBy + "]";
	}
	
	
}
