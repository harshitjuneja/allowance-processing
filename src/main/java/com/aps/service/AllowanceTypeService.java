package com.aps.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.aps.domain.AllowanceType;
import com.aps.repository.AllowanceTypeRepository;

@org.springframework.stereotype.Service
public class AllowanceTypeService {

	@Autowired
	AllowanceTypeRepository allowancetyperepository;

	public List<AllowanceType> getAllAllowanceType() {
		List<AllowanceType> alltype = new ArrayList<>();
		allowancetyperepository.findAll().forEach(alltype::add);

		return alltype;
	}

	public List<AllowanceType> getAllowanceTypeByName(String typeName) {

		return allowancetyperepository.viewAllowanceByName(typeName);

	}
}
