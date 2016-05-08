package com.uxp.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.uxp.model.AnnotationType;

@Transactional
public interface AnnotationTypeDAO extends CrudRepository<AnnotationType, Long> {
	
}
