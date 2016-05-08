package com.uxp.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.uxp.model.AnnotationContentType;

@Transactional
public interface AnnotationContentTypeDAO extends CrudRepository<AnnotationContentType, Long> {
	
}
