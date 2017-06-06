package com.aps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aps.service.RequestService;

@RestController
public class ApproverDashboardController {

	@Autowired
	private RequestService requestservice;

	@GetMapping("/dashboard/approver1")
	public Long getPendingRequestsforApprover() {
		return requestservice.getPendingRequestforApprover();
	}

	@GetMapping("/dashboard/approver2")
	public Long getShiftAllowanceDaysforApprover() {
		return requestservice.getShiftAllowanceDaysforApprover();
	}

	@GetMapping("/dashboard/approver3")
	public Long getOnCallDaysforApprover() {
		return requestservice.getOnCallDaysforApprover();
	}

}
