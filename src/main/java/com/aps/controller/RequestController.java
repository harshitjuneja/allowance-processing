package com.aps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aps.domain.Request;
import com.aps.service.RequestService;

@RestController
public class RequestController {

	@Autowired
	private RequestService requestservice;

	@GetMapping("/request/v1")
	public List<Request> getAllRequest() {
		return requestservice.getAllRequest();
	}

	@PostMapping(value = "/request/v1")
	public void addRequest(@RequestBody(required = true) Request request) {
		requestservice.addRequest(request);
	}

	@GetMapping("/request/user/v1")
	public Iterable<Request> viewRequests() {
		return requestservice.requesterView("A234567");
	}

}
