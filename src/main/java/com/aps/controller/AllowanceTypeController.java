package com.aps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.aps.domain.AllowanceType;
import com.aps.service.AllowanceTypeService;

@RestController
public class AllowanceTypeController {

	@Autowired
	private AllowanceTypeService allowancetypeservice;

	@GetMapping("/allowancetype/v1")
	public List<AllowanceType> getAllAllowanceType() {
		return allowancetypeservice.getAllAllowanceType();
	}
	@GetMapping("/allowancetypebyname/v1/{typeName}")
	public List<AllowanceType> getAllowanceByName(@PathVariable String typeName) {
		return allowancetypeservice.getAllowanceTypeByName(typeName);
	}
	
}
