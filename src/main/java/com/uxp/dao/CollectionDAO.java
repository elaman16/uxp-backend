package com.uxp.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.uxp.model.Collection;


@Transactional
public interface CollectionDAO extends CrudRepository<Collection, Long> {

	public Object findAllByUserName(String userName);
    	
}
