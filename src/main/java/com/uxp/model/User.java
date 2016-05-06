package com.uxp.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "users")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	@Column(name="useStatus")
	private char useStatus;
	@Column(name="programId")
	private String programId;
	@Column(name="LocId")
	private String LocId;
	@Column(name="timeUpdated")
	private Date timeUpdated;
	@Column(name="updatedBy")
	private int updatedBy;
	
	public User() {
		
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
		result = prime * result + ((timeUpdated == null) ? 0 : timeUpdated.hashCode());
		result = prime * result + updatedBy;
		result = prime * result + useStatus;
		result = (int) (prime * result + userId);
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
		User other = (User) obj;
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
		return true;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", useStatus=" + useStatus + ", programId=" + programId + ", LocId=" + LocId
				+ ", timeUpdated=" + timeUpdated + ", updatedBy=" + updatedBy + "]";
	}
	
	
}
