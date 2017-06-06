package com.aps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aps.service.RequestService;

@RestController
public class HRDashboardController {

	@Autowired
	private RequestService requestservice;

	 @GetMapping("/dashboard/hr1")
	 public Long getnumberOfDaysDeptID1forHR() {
	 return requestservice.findnumberOfDaysDeptID1forHR();
	 }
	 
}
