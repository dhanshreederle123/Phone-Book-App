package com.BikkadIT.UserManagementApplication.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BikkadIT.UserManagementApplication.biding.LoginForm;
import com.BikkadIT.UserManagementApplication.entities.CityMasterEntity;
import com.BikkadIT.UserManagementApplication.entities.CountryMasterEntity;
import com.BikkadIT.UserManagementApplication.entities.StateMasterEntity;
import com.BikkadIT.UserManagementApplication.entities.UserAccountEntity;
import com.BikkadIT.UserManagementApplication.repositories.CityRepository;
import com.BikkadIT.UserManagementApplication.repositories.CountryRepository;
import com.BikkadIT.UserManagementApplication.repositories.StateRepository;
import com.BikkadIT.UserManagementApplication.repositories.UserAccountRepository;

@Service
public class UserServiceImpl implements UserServiceI {

	@Autowired
	private UserAccountRepository userAccountRepository;

	@Autowired
	private CountryRepository countryRepository;

	@Autowired
	private StateRepository stateRepository;

	@Autowired
	private CityRepository cityRepository;

	@Override
	public String loginCheck(LoginForm loginForm) {
		UserAccountEntity userAccountEntity = userAccountRepository.findByEmailAndPassword(loginForm.getEmail(), loginForm.getPassword());

		if (userAccountEntity != null) {
			String accStatus = userAccountEntity.getAccStatus();
			if (accStatus.equals("LOCKED")) {
				return "Your Account is locked";
			} else {
				return "Login successful. Welcome to Bikkad IT";
			}

		} else {
			return "Creditional Are invalid";
		}

	}

	@Override
	public Map<Integer, String> getCountries() {

		List<CountryMasterEntity> findAll = countryRepository.findAll();
		Map<Integer, String> countryMap = new HashMap<Integer, String>();
		for (CountryMasterEntity u : findAll) {
			countryMap.put(u.getCountryId(), u.getCountryName());
		}

		return countryMap;
	}

	@Override
	public Map<Integer, String> getStates(Integer countryId) {
		List<StateMasterEntity> states = stateRepository.findByCountryId(countryId);

		Map<Integer, String> statemap = new HashMap<Integer, String>();
		for (StateMasterEntity u : states) {
			statemap.put(u.getStateId(), u.getStateName());
		}
		return statemap;
	}

	@Override
	public Map<Integer, String> getCities(Integer stateId) {
		List<CityMasterEntity> findByStateId = cityRepository.findByStateId(stateId);

		Map<Integer, String> cityMap = new HashMap<Integer, String>();

		for (CityMasterEntity u : findByStateId) {
			cityMap.put(u.getCityId(), u.getCityname());
		}

		return cityMap;
	}
 

}
