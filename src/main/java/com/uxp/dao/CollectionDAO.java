package com.uxp.dao;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.uxp.model.Collection;


@Transactional
public interface CollectionDAO extends CrudRepository<Collection, Long> {

	public List<Collection> findAllByUserName(String userName);
	
	@Query(value = "SELECT * FROM collection WHERE concat_ws('|', `export_uri`, `annotations`) LIKE %:term% AND use_status <> 'D' AND user_name = :userName ORDER BY annotation_id DESC", nativeQuery = true)
	public List<Collection> searchUserCollections(@Param("term") String term, @Param("userName") String userName);
    	
}
