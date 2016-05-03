package com.uxp.model;

import java.util.Date;

public class PremiumPlans {
	private int premiumPlanId;
	private String premiumPlanDescription;
	private double premiumPlanCost;
	private String premiumPlanCurrency;
	private String planConstraints;
	private int planEffectiveDays;
	private boolean planAutoRenewal;
	private char useStatus;
	private String programId;
	private String LocId;
	private Date timeUpdated;
	public PremiumPlans(int premiumPlanId, String premiumPlanDescription, double premiumPlanCost,
			String premiumPlanCurrency, String planConstraints, int planEffectiveDays, boolean planAutoRenewal,
			char useStatus, String programId, String locId, Date timeUpdated) {
		super();
		this.premiumPlanId = premiumPlanId;
		this.premiumPlanDescription = premiumPlanDescription;
		this.premiumPlanCost = premiumPlanCost;
		this.premiumPlanCurrency = premiumPlanCurrency;
		this.planConstraints = planConstraints;
		this.planEffectiveDays = planEffectiveDays;
		this.planAutoRenewal = planAutoRenewal;
		this.useStatus = useStatus;
		this.programId = programId;
		LocId = locId;
		this.timeUpdated = timeUpdated;
	}
	public int getPremiumPlanId() {
		return premiumPlanId;
	}
	public void setPremiumPlanId(int premiumPlanId) {
		this.premiumPlanId = premiumPlanId;
	}
	public String getPremiumPlanDescription() {
		return premiumPlanDescription;
	}
	public void setPremiumPlanDescription(String premiumPlanDescription) {
		this.premiumPlanDescription = premiumPlanDescription;
	}
	public double getPremiumPlanCost() {
		return premiumPlanCost;
	}
	public void setPremiumPlanCost(double premiumPlanCost) {
		this.premiumPlanCost = premiumPlanCost;
	}
	public String getPremiumPlanCurrency() {
		return premiumPlanCurrency;
	}
	public void setPremiumPlanCurrency(String premiumPlanCurrency) {
		this.premiumPlanCurrency = premiumPlanCurrency;
	}
	public String getPlanConstraints() {
		return planConstraints;
	}
	public void setPlanConstraints(String planConstraints) {
		this.planConstraints = planConstraints;
	}
	public int getPlanEffectiveDays() {
		return planEffectiveDays;
	}
	public void setPlanEffectiveDays(int planEffectiveDays) {
		this.planEffectiveDays = planEffectiveDays;
	}
	public boolean isPlanAutoRenewal() {
		return planAutoRenewal;
	}
	public void setPlanAutoRenewal(boolean planAutoRenewal) {
		this.planAutoRenewal = planAutoRenewal;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((LocId == null) ? 0 : LocId.hashCode());
		result = prime * result + (planAutoRenewal ? 1231 : 1237);
		result = prime * result + ((planConstraints == null) ? 0 : planConstraints.hashCode());
		result = prime * result + planEffectiveDays;
		long temp;
		temp = Double.doubleToLongBits(premiumPlanCost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((premiumPlanCurrency == null) ? 0 : premiumPlanCurrency.hashCode());
		result = prime * result + ((premiumPlanDescription == null) ? 0 : premiumPlanDescription.hashCode());
		result = prime * result + premiumPlanId;
		result = prime * result + ((programId == null) ? 0 : programId.hashCode());
		result = prime * result + ((timeUpdated == null) ? 0 : timeUpdated.hashCode());
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
		PremiumPlans other = (PremiumPlans) obj;
		if (LocId == null) {
			if (other.LocId != null)
				return false;
		} else if (!LocId.equals(other.LocId))
			return false;
		if (planAutoRenewal != other.planAutoRenewal)
			return false;
		if (planConstraints == null) {
			if (other.planConstraints != null)
				return false;
		} else if (!planConstraints.equals(other.planConstraints))
			return false;
		if (planEffectiveDays != other.planEffectiveDays)
			return false;
		if (Double.doubleToLongBits(premiumPlanCost) != Double.doubleToLongBits(other.premiumPlanCost))
			return false;
		if (premiumPlanCurrency == null) {
			if (other.premiumPlanCurrency != null)
				return false;
		} else if (!premiumPlanCurrency.equals(other.premiumPlanCurrency))
			return false;
		if (premiumPlanDescription == null) {
			if (other.premiumPlanDescription != null)
				return false;
		} else if (!premiumPlanDescription.equals(other.premiumPlanDescription))
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
		return true;
	}
	@Override
	public String toString() {
		return "PremiumPlans [premiumPlanId=" + premiumPlanId + ", premiumPlanDescription=" + premiumPlanDescription
				+ ", premiumPlanCost=" + premiumPlanCost + ", premiumPlanCurrency=" + premiumPlanCurrency
				+ ", planConstraints=" + planConstraints + ", planEffectiveDays=" + planEffectiveDays
				+ ", planAutoRenewal=" + planAutoRenewal + ", useStatus=" + useStatus + ", programId=" + programId
				+ ", LocId=" + LocId + ", timeUpdated=" + timeUpdated + "]";
	}
	
	
}
