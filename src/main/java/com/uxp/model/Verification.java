package com.uxp.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="email-verification")
public class Verification {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long verifyId;
	private long userId;
	private UUID uuid;
	private boolean verified;
	
	public Verification() {}

	public Verification(long userId) {
		super();
		this.userId = userId;
		this.uuid = UUID.randomUUID();
		this.verified = false;
	}

	public long getVerifyId() {
		return verifyId;
	}

	public void setVerifyId(long verifyId) {
		this.verifyId = verifyId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public boolean isVerified() {
		return verified;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (userId ^ (userId >>> 32));
		result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
		result = prime * result + (verified ? 1231 : 1237);
		result = prime * result + (int) (verifyId ^ (verifyId >>> 32));
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
		Verification other = (Verification) obj;
		if (userId != other.userId)
			return false;
		if (uuid == null) {
			if (other.uuid != null)
				return false;
		} else if (!uuid.equals(other.uuid))
			return false;
		if (verified != other.verified)
			return false;
		if (verifyId != other.verifyId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Verification [verifyId=" + verifyId + ", userId=" + userId + ", uuid=" + uuid + ", verified=" + verified
				+ "]";
	}
	
	
	
}
