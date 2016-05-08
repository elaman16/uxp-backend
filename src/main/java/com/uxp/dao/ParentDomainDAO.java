package com.uxp.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.uxp.model.ParentDomain;

@Transactional
public interface ParentDomainDAO extends CrudRepository<ParentDomain, Long> {
	
}
