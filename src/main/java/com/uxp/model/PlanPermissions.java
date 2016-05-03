package com.uxp.model;

import java.util.Date;

public class PlanPermissions {
	private int planPermissionId;
	private String planPermissionCode;
	private int premiumPlanId;
	private String planPermissionDescription;
	private char useStatus;
	private String programId;
	private String LocId;
	private Date timeUpdated;
	private int userId;
	public PlanPermissions(int planPermissionId, String planPermissionCode, int premiumPlanId,
			String planPermissionDescription, char useStatus, String programId, String locId, Date timeUpdated,
			int userId) {
		super();
		this.planPermissionId = planPermissionId;
		this.planPermissionCode = planPermissionCode;
		this.premiumPlanId = premiumPlanId;
		this.planPermissionDescription = planPermissionDescription;
		this.useStatus = useStatus;
		this.programId = programId;
		LocId = locId;
		this.timeUpdated = timeUpdated;
		this.userId = userId;
	}
	public int getPlanPermissionId() {
		return planPermissionId;
	}
	public void setPlanPermissionId(int planPermissionId) {
		this.planPermissionId = planPermissionId;
	}
	public String getPlanPermissionCode() {
		return planPermissionCode;
	}
	public void setPlanPermissionCode(String planPermissionCode) {
		this.planPermissionCode = planPermissionCode;
	}
	public int getPremiumPlanId() {
		return premiumPlanId;
	}
	public void setPremiumPlanId(int premiumPlanId) {
		this.premiumPlanId = premiumPlanId;
	}
	public String getPlanPermissionDescription() {
		return planPermissionDescription;
	}
	public void setPlanPermissionDescription(String planPermissionDescription) {
		this.planPermissionDescription = planPermissionDescription;
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
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((LocId == null) ? 0 : LocId.hashCode());
		result = prime * result + ((planPermissionCode == null) ? 0 : planPermissionCode.hashCode());
		result = prime * result + ((planPermissionDescription == null) ? 0 : planPermissionDescription.hashCode());
		result = prime * result + planPermissionId;
		result = prime * result + premiumPlanId;
		result = prime * result + ((programId == null) ? 0 : programId.hashCode());
		result = prime * result + ((timeUpdated == null) ? 0 : timeUpdated.hashCode());
		result = prime * result + useStatus;
		result = prime * result + userId;
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
		PlanPermissions other = (PlanPermissions) obj;
		if (LocId == null) {
			if (other.LocId != null)
				return false;
		} else if (!LocId.equals(other.LocId))
			return false;
		if (planPermissionCode == null) {
			if (other.planPermissionCode != null)
				return false;
		} else if (!planPermissionCode.equals(other.planPermissionCode))
			return false;
		if (planPermissionDescription == null) {
			if (other.planPermissionDescription != null)
				return false;
		} else if (!planPermissionDescription.equals(other.planPermissionDescription))
			return false;
		if (planPermissionId != other.planPermissionId)
			return false;
		if (premiumPlanId != other.premiumPlanId)
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
		if (useStatus != other.useStatus)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PlanPermissions [planPermissionId=" + planPermissionId + ", planPermissionCode=" + planPermissionCode
				+ ", premiumPlanId=" + premiumPlanId + ", planPermissionDescription=" + planPermissionDescription
				+ ", useStatus=" + useStatus + ", programId=" + programId + ", LocId=" + LocId + ", timeUpdated="
				+ timeUpdated + ", userId=" + userId + "]";
	}
	
	
}
