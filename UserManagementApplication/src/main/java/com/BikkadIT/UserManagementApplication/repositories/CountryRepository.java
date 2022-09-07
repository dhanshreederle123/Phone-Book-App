package com.BikkadIT.UserManagementApplication.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BikkadIT.UserManagementApplication.entities.CountryMasterEntity;

public interface CountryRepository extends JpaRepository<CountryMasterEntity, Serializable>{

}
