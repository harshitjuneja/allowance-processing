package com.aps.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aps.domain.Department;
import com.aps.repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	DepartmentRepository departmentrepository;

	public List<Department> getAllDepartments() {
		List<Department> dept = new ArrayList<>();
		departmentrepository.findAll().forEach(dept::add);
		return dept;
	}

	public void addDepartment(Department department) {
		department.setDepartmentId(null);
		departmentrepository.save(department);
	}

	public List<Department> findByName(String departmentName) {
		List<Department> dept = new ArrayList<>();
		departmentrepository.findByName(departmentName).forEach(dept::add);

		return dept;
	}

	public List<Department> findByCode(String departmentCode) {
		List<Department> dept = new ArrayList<>();
		departmentrepository.findByCode(departmentCode).forEach(dept::add);

		return dept;
	}

	public List<Department> findSubDept(Long departmentId) {
		List<Department> dept = new ArrayList<>();
		departmentrepository.findSubDept(departmentId).forEach(dept::add);

		return dept;

	}

	public Iterable<Department> getActiveDepartments() {
		return departmentrepository.findActiveDepartments();
	}
}
