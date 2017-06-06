package com.aps.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aps.domain.Employee;
import com.aps.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeservice;

	@GetMapping("/employee/v1")
	public List<Employee> getAllEmployee() {
		return employeeservice.getAllEmployee();
	}

	@PostMapping("/login/v1")
	public Boolean getValidUser(String corpId, String pass) {
		return employeeservice.getValidUser(corpId, pass);
	}

	@PostMapping("/getById/v1")
	public List<Employee> getEmployeeById(String corpId) {
		return employeeservice.getEmployeeById(corpId);
	}

	//
	// // public void validateUser(@RequestParam(name="CorpId") String corp_id,
	// // @RequestParam(name="password") String password) {
	// // //requestservice.addRequest(request);
	// //
	// // String corpIDvalidate = employeeservice.validateUser(corp_id,
	// password);
	// // if(corpIDvalidate.equals(')){
	// // redirect
	// // }
	// @GetMapping(value = "/login/v1")
	// public Iterable<Employee> validateUser() {
	// // requestservice.addRequest(request);
	// return employeeservice.validateUser("A123455", "Hitesh@1");
	//// if (corpIDvalidate.equals(null)) {
	//// System.out.println("User not found");
	//// }
	//// else
	//// {
	//// System.out.println("User Found");
	//// }
	// }

	
	@RequestMapping(method = RequestMethod.POST, value = "/bulkAddEmployees")
	public void addEmployeeData(@RequestBody String bulkEmp) {
		try {

			
			ObjectMapper mapper = new ObjectMapper();
			List<Employee> list_emp = mapper.readValue(bulkEmp,
					TypeFactory.defaultInstance().constructCollectionType(List.class, Employee.class));
			
			// employeeService.addEmployeeData(list_emp);
			/*
			Iterator itr = list_emp.iterator();
			
			while(itr.hasNext()){
				Employee emp1 = (Employee) itr.next();
				System.out.println(emp1.getCorpId());
			}
			
			*/
			
			employeeservice.checkForDuplicates(list_emp);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
