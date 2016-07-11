package com.uxp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="suggestion")
public class Suggestion {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long suggestionId;
	private String suggestionType;
	private String suggestion;
	
	public Suggestion() {}
	
	public Suggestion(String suggestionType, String suggestion) {
		super();
		
		this.suggestionType = suggestionType;
		this.suggestion = suggestion;
	}
	
	
	@Override
	public String toString() {
		return "Suggestion [suggestionId=" + suggestionId + ", suggestionType=" + suggestionType + ", suggestion="
				+ suggestion + "]";
	}

	public long getSuggestionId() {
		return suggestionId;
	}
	public String getSuggestionType() {
		return suggestionType;
	}
	public void setSuggestionType(String suggestionType) {
		this.suggestionType = suggestionType;
	}
	public String getSuggestion() {
		return suggestion;
	}
	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}
	
}