package com.uxp.dao;

import org.springframework.data.repository.CrudRepository;

import com.uxp.model.CreateCustomerRequest;

public interface CreateCustomerRequestDAO extends CrudRepository<CreateCustomerRequest, Long>{

}
