package com.uxp.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProjectFiles {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long fileId;
	private long projectId;
	private String attachmentMediaDetail;
	private char useStatus;
	private String programId;
	private String LocId;
	private Date timeUpdated;
	private long updatedBy;
	
	
	ProjectFiles() {}


	public long getFileId() {
		return fileId;
	}


	public void setFileId(long fileId) {
		this.fileId = fileId;
	}


	public long getProjectId() {
		return projectId;
	}


	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}


	public String getAttachmentMediaDetail() {
		return attachmentMediaDetail;
	}


	public void setAttachmentMediaDetail(String attachmentMediaDetail) {
		this.attachmentMediaDetail = attachmentMediaDetail;
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
		result = prime * result + ((attachmentMediaDetail == null) ? 0 : attachmentMediaDetail.hashCode());
		result = prime * result + (int) (fileId ^ (fileId >>> 32));
		result = prime * result + ((programId == null) ? 0 : programId.hashCode());
		result = prime * result + (int) (projectId ^ (projectId >>> 32));
		result = prime * result + ((timeUpdated == null) ? 0 : timeUpdated.hashCode());
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
		ProjectFiles other = (ProjectFiles) obj;
		if (LocId == null) {
			if (other.LocId != null)
				return false;
		} else if (!LocId.equals(other.LocId))
			return false;
		if (attachmentMediaDetail == null) {
			if (other.attachmentMediaDetail != null)
				return false;
		} else if (!attachmentMediaDetail.equals(other.attachmentMediaDetail))
			return false;
		if (fileId != other.fileId)
			return false;
		if (programId == null) {
			if (other.programId != null)
				return false;
		} else if (!programId.equals(other.programId))
			return false;
		if (projectId != other.projectId)
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
		return "ProjectFiles [fileId=" + fileId + ", projectId=" + projectId + ", attachmentMediaDetail="
				+ attachmentMediaDetail + ", useStatus=" + useStatus + ", programId=" + programId + ", LocId=" + LocId
				+ ", timeUpdated=" + timeUpdated + ", updatedBy=" + updatedBy + "]";
	}
	
	
	
}
