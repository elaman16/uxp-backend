package com.uxp.model;

import java.util.Date;

public class Payment {
	private int paymentId;
	private Date paymentDate;
	private double paymentAmount;
	private String paymentCurrency;
	private String paymentGateway;
	private String paymentStatus;
	private String paymentReferenceToken;
	private int premiumPlanId;
	private int userId;
	private char useStatus;
	private String programId;
	private String LocId;
	private Date timeUpdated;
	private int updatedBy;
	public Payment(int paymentId, Date paymentDate, double paymentAmount, String paymentCurrency, String paymentGateway,
			String paymentStatus, String paymentReferenceToken, int premiumPlanId, int userId, char useStatus,
			String programId, String locId, Date timeUpdated, int updatedBy) {
		super();
		this.paymentId = paymentId;
		this.paymentDate = paymentDate;
		this.paymentAmount = paymentAmount;
		this.paymentCurrency = paymentCurrency;
		this.paymentGateway = paymentGateway;
		this.paymentStatus = paymentStatus;
		this.paymentReferenceToken = paymentReferenceToken;
		this.premiumPlanId = premiumPlanId;
		this.userId = userId;
		this.useStatus = useStatus;
		this.programId = programId;
		LocId = locId;
		this.timeUpdated = timeUpdated;
		this.updatedBy = updatedBy;
	}
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	public double getPaymentAmount() {
		return paymentAmount;
	}
	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	public String getPaymentCurrency() {
		return paymentCurrency;
	}
	public void setPaymentCurrency(String paymentCurrency) {
		this.paymentCurrency = paymentCurrency;
	}
	public String getPaymentGateway() {
		return paymentGateway;
	}
	public void setPaymentGateway(String paymentGateway) {
		this.paymentGateway = paymentGateway;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public String getPaymentReferenceToken() {
		return paymentReferenceToken;
	}
	public void setPaymentReferenceToken(String paymentReferenceToken) {
		this.paymentReferenceToken = paymentReferenceToken;
	}
	public int getPremiumPlanId() {
		return premiumPlanId;
	}
	public void setPremiumPlanId(int premiumPlanId) {
		this.premiumPlanId = premiumPlanId;
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
		long temp;
		temp = Double.doubleToLongBits(paymentAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((paymentCurrency == null) ? 0 : paymentCurrency.hashCode());
		result = prime * result + ((paymentDate == null) ? 0 : paymentDate.hashCode());
		result = prime * result + ((paymentGateway == null) ? 0 : paymentGateway.hashCode());
		result = prime * result + paymentId;
		result = prime * result + ((paymentReferenceToken == null) ? 0 : paymentReferenceToken.hashCode());
		result = prime * result + ((paymentStatus == null) ? 0 : paymentStatus.hashCode());
		result = prime * result + premiumPlanId;
		result = prime * result + ((programId == null) ? 0 : programId.hashCode());
		result = prime * result + ((timeUpdated == null) ? 0 : timeUpdated.hashCode());
		result = prime * result + updatedBy;
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
		Payment other = (Payment) obj;
		if (LocId == null) {
			if (other.LocId != null)
				return false;
		} else if (!LocId.equals(other.LocId))
			return false;
		if (Double.doubleToLongBits(paymentAmount) != Double.doubleToLongBits(other.paymentAmount))
			return false;
		if (paymentCurrency == null) {
			if (other.paymentCurrency != null)
				return false;
		} else if (!paymentCurrency.equals(other.paymentCurrency))
			return false;
		if (paymentDate == null) {
			if (other.paymentDate != null)
				return false;
		} else if (!paymentDate.equals(other.paymentDate))
			return false;
		if (paymentGateway == null) {
			if (other.paymentGateway != null)
				return false;
		} else if (!paymentGateway.equals(other.paymentGateway))
			return false;
		if (paymentId != other.paymentId)
			return false;
		if (paymentReferenceToken == null) {
			if (other.paymentReferenceToken != null)
				return false;
		} else if (!paymentReferenceToken.equals(other.paymentReferenceToken))
			return false;
		if (paymentStatus == null) {
			if (other.paymentStatus != null)
				return false;
		} else if (!paymentStatus.equals(other.paymentStatus))
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
		return "Payment [paymentId=" + paymentId + ", paymentDate=" + paymentDate + ", paymentAmount=" + paymentAmount
				+ ", paymentCurrency=" + paymentCurrency + ", paymentGateway=" + paymentGateway + ", paymentStatus="
				+ paymentStatus + ", paymentReferenceToken=" + paymentReferenceToken + ", premiumPlanId="
				+ premiumPlanId + ", userId=" + userId + ", useStatus=" + useStatus + ", programId=" + programId
				+ ", LocId=" + LocId + ", timeUpdated=" + timeUpdated + ", updatedBy=" + updatedBy + "]";
	}
	
	
}
