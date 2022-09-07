package com.BikkadIT.UserManagementApplication.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.BikkadIT.UserManagementApplication.entities.CityMasterEntity;

@Repository
public interface CityRepository {
	public List<CityMasterEntity> findByStateId(Integer stateId);


}
