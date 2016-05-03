package com.uxp.model;

import java.util.Date;

public class Emoji {
	private String emojiDescription;
	private String emojiCode;
	private String emojiURI;
	private char useStatus;
	private String programId;
	private String LocId;
	private Date timeUpdated;
	private int updatedBy;
	
	
	public Emoji(String emojiDescription, String emojiCode, String emojiURI, char useStatus, String programId,
			String locId, Date timeUpdated, int updatedBy) {
		super();
		this.emojiDescription = emojiDescription;
		this.emojiCode = emojiCode;
		this.emojiURI = emojiURI;
		this.useStatus = useStatus;
		this.programId = programId;
		LocId = locId;
		this.timeUpdated = timeUpdated;
		this.updatedBy = updatedBy;
	}
	public String getEmojiDescription() {
		return emojiDescription;
	}
	public void setEmojiDescription(String emojiDescription) {
		this.emojiDescription = emojiDescription;
	}
	public String getEmojiCode() {
		return emojiCode;
	}
	public void setEmojiCode(String emojiCode) {
		this.emojiCode = emojiCode;
	}
	public String getEmojiURI() {
		return emojiURI;
	}
	public void setEmojiURI(String emojiURI) {
		this.emojiURI = emojiURI;
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
		result = prime * result + ((emojiCode == null) ? 0 : emojiCode.hashCode());
		result = prime * result + ((emojiDescription == null) ? 0 : emojiDescription.hashCode());
		result = prime * result + ((emojiURI == null) ? 0 : emojiURI.hashCode());
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
		Emoji other = (Emoji) obj;
		if (LocId == null) {
			if (other.LocId != null)
				return false;
		} else if (!LocId.equals(other.LocId))
			return false;
		if (emojiCode == null) {
			if (other.emojiCode != null)
				return false;
		} else if (!emojiCode.equals(other.emojiCode))
			return false;
		if (emojiDescription == null) {
			if (other.emojiDescription != null)
				return false;
		} else if (!emojiDescription.equals(other.emojiDescription))
			return false;
		if (emojiURI == null) {
			if (other.emojiURI != null)
				return false;
		} else if (!emojiURI.equals(other.emojiURI))
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
		return "Emoji [emojiDescription=" + emojiDescription + ", emojiCode=" + emojiCode + ", emojiURI=" + emojiURI
				+ ", useStatus=" + useStatus + ", programId=" + programId + ", LocId=" + LocId + ", timeUpdated="
				+ timeUpdated + ", updatedBy=" + updatedBy + "]";
	}
	
	
}
