package com.aps.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aps.domain.Employee;
import com.aps.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	// public String validateUser(String corp_id, String password) {
	// return employeerepository.userValidate(corp_id, password);
	// }
	// public Iterable<Employee> validateUser(String corp_id, String password) {
	// return employeerepository.userValidate(corp_id, password);
	// }

	public List<Employee> getAllEmployee() {
		List<Employee> emp = new ArrayList<>();
		employeeRepository.findAll().forEach(emp::add);
		return emp;
	}

	public Boolean getValidUser(String CorpId, String Password) {
		// List<Employee> emp = new ArrayList<>();
		if (employeeRepository.getValidUser(CorpId, Password) != null) {
			return true;
		} else {
			return false;
		}
	}

	public List<Employee> getEmployeeById(String corpId) {
		List<Employee> emp = new ArrayList<>();
		emp = employeeRepository.getEmployeeById(corpId);
		return emp;
	}
	

	public void saveToDB(Employee empToSave) {
		employeeRepository.save(empToSave);
	}

	public void updateToDB(Employee empToUpdate) {
		// Employee employeeToDel =
		// addEmployeeRepository.findExistingEmployee(empToUpdate.getCorp_id());
		// addEmployeeRepository.delete(employeeToDel);
		// addEmployeeRepository.save(empToUpdate);
		employeeRepository.update(java.sql.Date.valueOf("2038-12-31"), empToUpdate.getCorpId());

	}

	public void checkForDuplicates(List<Employee> list_emp) {
		// TODO Auto-generated method stub
		// List<Integer> indexOfDuplicateElement = new ArrayList<>();

		for (int i = 0; i < list_emp.size(); i++) {
			Employee existing_emp = employeeRepository.findExistingEmployee(list_emp.get(i).getCorpId());
			if (existing_emp == null) {
				list_emp.get(i).setStartDate(java.sql.Date.valueOf(LocalDate.now()));
				list_emp.get(i).setEndDate(java.sql.Date.valueOf("2038-12-31"));
				saveToDB(list_emp.get(i));
			} else {
				existing_emp.setEndDate(java.sql.Date.valueOf(LocalDate.now()));
				updateToDB(existing_emp);
				list_emp.get(i).setStartDate(java.sql.Date.valueOf(LocalDate.now()));
				list_emp.get(i).setEndDate(java.sql.Date.valueOf("2038-12-31"));
				saveToDB(list_emp.get(i));
			}

			// indexOfDuplicateElement.add(i);
			// }
			//
			// for (int i = 0; i < indexOfDuplicateElement.size(); i++) {
			// list_emp.remove(indexOfDuplicateElement.get(i));
			// }
			//
			// return list_emp;

		}

		
	}
	
	
}
