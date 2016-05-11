package com.uxp.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.uxp.model.AnnotationHashTag;

@Transactional
public interface AnnotationHashTagDAO extends CrudRepository<AnnotationHashTag, Long> {

	AnnotationHashTag findOneByAnnotationId(long annotationId);
	
}
