package com.aps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aps.domain.ShiftTime;
import com.aps.service.ShiftTimeService;

@RestController
public class ShiftTimeController {

	@Autowired
	private ShiftTimeService shifttimeservice;

	@GetMapping("/shifttime/v1")
	public List<ShiftTime> getAllShiftTime() {
		return shifttimeservice.getAllShiftTime();
	}
}
