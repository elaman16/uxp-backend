package com.uxp.model;

import java.util.Date;



public class AnnotationHashTag {
	private int annotationId;
	private int annotationHashtagId;
	private char useStatus;
	private String programId;
	private String LocId;
	private Date timeUpdated;
	private int updatedBy;
	
	public AnnotationHashTag(int annotationId, int annotationHashtagId, char useStatus, String programId, String locId,
			Date timeUpdated, int updatedBy) {
		super();
		this.annotationId = annotationId;
		this.annotationHashtagId = annotationHashtagId;
		this.useStatus = useStatus;
		this.programId = programId;
		LocId = locId;
		this.timeUpdated = timeUpdated;
		this.updatedBy = updatedBy;
	}
	public int getAnnotationId() {
		return annotationId;
	}
	public void setAnnotationId(int annotationId) {
		this.annotationId = annotationId;
	}
	public int getAnnotationHashtagId() {
		return annotationHashtagId;
	}
	public void setAnnotationHashtagId(int annotationHashtagId) {
		this.annotationHashtagId = annotationHashtagId;
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
		result = prime * result + annotationHashtagId;
		result = prime * result + annotationId;
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
		AnnotationHashTag other = (AnnotationHashTag) obj;
		if (LocId == null) {
			if (other.LocId != null)
				return false;
		} else if (!LocId.equals(other.LocId))
			return false;
		if (annotationHashtagId != other.annotationHashtagId)
			return false;
		if (annotationId != other.annotationId)
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
		return "AnnotationHashTag [annotationId=" + annotationId + ", annotationHashtagId=" + annotationHashtagId
				+ ", useStatus=" + useStatus + ", programId=" + programId + ", LocId=" + LocId + ", timeUpdated="
				+ timeUpdated + ", updatedBy=" + updatedBy + "]";
	}
	
	
}
