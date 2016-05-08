package com.uxp.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.uxp.model.PinType;

@Transactional
public interface PinTypeDAO extends CrudRepository<PinType, Long> {
	
}
