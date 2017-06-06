package com.aps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aps.domain.Request;
import com.aps.service.RequestService;

@RestController
@RequestMapping("/admin")
public class AdminViewRequestsContoller {

	@Autowired
	private RequestService requestService;

	@GetMapping(path = "/requests/pending")
	public Iterable<Request> getPendingRequests(String status) {
		return requestService.findRequestsByStatus(status = "submitted");
	}

	@GetMapping(path = "/requests/all")
	public Iterable<Request> getAllRequests() {
		return requestService.findAllNonInvoicedRequests();
	}
}
