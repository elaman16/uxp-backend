package com.uxp.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.uxp.model.AudioAnnotation;

@Transactional
public interface AudioAnnotationDAO extends CrudRepository<AudioAnnotation, Long> {
	
}
