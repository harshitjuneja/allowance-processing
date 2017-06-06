package com.aps.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aps.domain.Department;
import com.aps.domain.Period;
import com.aps.service.DepartmentService;
import com.aps.service.PeriodService;

@RestController
@RequestMapping(value = "/admin")
public class AdminInvoiceGenerationController {

	@Autowired
	private PeriodService periodService;

	@Autowired
	private DepartmentService departmentService;

	@GetMapping(path = "/invoice/{year}")
	public Iterable<Period> getPeriodForYear(@PathVariable String year) throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
		Date date = simpleDateFormat.parse(year);
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		return periodService.findByYear(sqlDate);
	}

	@GetMapping(path = "/invoice/department")
	public Iterable<Department> getActiveDepartment() {
		return departmentService.getActiveDepartments();
	}
}
