package com.aps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aps.service.RequestService;

@RestController
public class RequesterDashboardController {

	@Autowired
	private RequestService requestservice;

	@GetMapping("/dashboard/requester1")
	public Long getPendingRequestsforRequester() {
		return requestservice.getPendingRequestforRequester();
	}

	@GetMapping("/dashboard/requester2")
	public Long getApprovedRequestsforRequester() {
		return requestservice.getApprovedRequestforRequester();
	}

	@GetMapping("/dashboard/requester3")
	public Long getRejectedRequestsforRequester() {
		return requestservice.getRejectedRequestforRequester();
	}

	@GetMapping("/dashboard/requester4")
	public Long getShiftAllowanceDaysforRequester() {
		return requestservice.getShiftAllowanceDaysforRequester();
	}

	@GetMapping("/dashboard/requester5")
	public Long getOnCallDaysforRequester() {
		return requestservice.getOnCallDaysforRequester();
	}

}
