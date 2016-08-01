package com.uxp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;


import com.uxp.model.UserPlanLicense;
@Transactional
public interface UserPlanLicenseDAO extends CrudRepository<UserPlanLicense, Long> {

}
