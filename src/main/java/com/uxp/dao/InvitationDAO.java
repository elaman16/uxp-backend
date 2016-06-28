package com.uxp.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.uxp.model.InvitationRequest;

@Transactional
public interface InvitationDAO extends CrudRepository<InvitationRequest, Long> {
	List<InvitationRequest> findAllByEmail(String email);
}