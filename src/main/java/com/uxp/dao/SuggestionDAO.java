package com.uxp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.uxp.model.Suggestion;

@Transactional
public interface SuggestionDAO extends CrudRepository<Suggestion, Long> {
	
}