package com.uxp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TopSite {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long siteId;
	private long userId;
	private String url;
	private String title;
	
	public TopSite() {};
	
	public TopSite(String url, String title, long userId) {
		this.url = url;
		this.title = title;
		this.userId = userId;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
	
}
