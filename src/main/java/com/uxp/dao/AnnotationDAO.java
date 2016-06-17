package com.uxp.dao;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.uxp.model.Annotation;

@Transactional
public interface AnnotationDAO extends CrudRepository<Annotation, Long> {

	List<Annotation> findAllByUserName(String userName);
	
	@Query(value = "SELECT * FROM annotation WHERE user_name = :userName LIMIT :page, 10", nativeQuery = true)
	List<Annotation> userAnnotationsPaged(@Param("userName") String userName, @Param("page") Integer page);
	
	@Query(value = "SELECT * FROM annotation LIMIT ?1, 10", nativeQuery = true)
	List<Annotation> allAnnotationsPaged(Integer page);
	
}
