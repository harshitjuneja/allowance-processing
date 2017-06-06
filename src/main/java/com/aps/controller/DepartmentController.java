package com.aps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.aps.domain.Department;
import com.aps.service.DepartmentService;

@RestController
public class DepartmentController {

	@Autowired
	private DepartmentService departmentservice;

	@GetMapping("/department/v1")
	public List<Department> getAllDepartment() {
		return departmentservice.getAllDepartments();
	}

	@PostMapping("/department/v2")
	public void addDepartment(@RequestBody(required = true) Department department) {
		departmentservice.addDepartment(department);
	}

	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST }, value = "/department/v3")
	public List<Department> findByName(String departmentName) {
		return departmentservice.findByName(departmentName);
	}

	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST }, value = "/department/v4")
	public List<Department> findByCode(String departmentCode) {
		return departmentservice.findByName(departmentCode);
	}

	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST }, value = "/department/v5")
	public List<Department> findSubDept(Long departmentId) {
		return departmentservice.findSubDept(departmentId);
	}

}