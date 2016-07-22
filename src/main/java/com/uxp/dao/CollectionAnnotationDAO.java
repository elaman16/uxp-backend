package com.uxp.dao;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.uxp.model.CollectionAnnotation;

@Transactional
public interface CollectionAnnotationDAO extends CrudRepository<CollectionAnnotation, Long> {

	ArrayList<CollectionAnnotation> findAllByCollectionId(long collectionId);

}
