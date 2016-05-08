package com.uxp.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.uxp.model.AnnotationMedia;

@Transactional
public interface AnnotationMediaDAO extends CrudRepository<AnnotationMedia, Long> {
	
}
