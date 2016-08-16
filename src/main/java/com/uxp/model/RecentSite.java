package com.uxp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RecentSite {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long siteId;
	private long userId;
	private String lastVisitTime;
	private String title;
	private long typedCount;
	private String url;
	private long visitCount;
	private long id;
	public RecentSite() {}

	public RecentSite(long siteId, long userId, String lastVisitTime, String title, long typedCount, String url,
			long visitCount, long id) {
		super();
		this.siteId = siteId;
		this.userId = userId;
		this.lastVisitTime = lastVisitTime;
		this.title = title;
		this.typedCount = typedCount;
		this.url = url;
		this.visitCount = visitCount;
		this.id = id;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getSiteId() {
		return siteId;
	}

	public void setSiteId(long siteId) {
		this.siteId = siteId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getLastVisitTime() {
		return lastVisitTime;
	}

	public void setLastVisitTime(String lastVisitTime) {
		this.lastVisitTime = lastVisitTime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getTypedCount() {
		return typedCount;
	}

	public void setTypedCount(long typedCount) {
		this.typedCount = typedCount;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public long getVisitCount() {
		return visitCount;
	}

	public void setVisitCount(long visitCount) {
		this.visitCount = visitCount;
	}

	@Override
	public String toString() {
		return "RecentSite [siteId=" + siteId + ", userId=" + userId + ", lastVisitTime=" + lastVisitTime + ", title="
				+ title + ", typedCount=" + typedCount + ", url=" + url + ", visitCount=" + visitCount + "]";
	}
	
	
}
