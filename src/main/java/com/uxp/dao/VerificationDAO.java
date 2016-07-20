package com.uxp.dao;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.uxp.model.Verification;

@Transactional
public interface VerificationDAO extends CrudRepository<Verification, Long> {

	Verification findOneByUserId(long userId);

	Verification findOneByUuid(String uuid);

	
	
}