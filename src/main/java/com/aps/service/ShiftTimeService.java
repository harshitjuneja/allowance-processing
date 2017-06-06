package com.aps.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.aps.domain.ShiftTime;
import com.aps.repository.ShiftTimeRepository;

@org.springframework.stereotype.Service
public class ShiftTimeService {

	@Autowired
	ShiftTimeRepository shifttimerepository;

	public List<ShiftTime> getAllShiftTime() {
		List<ShiftTime> shift = new ArrayList<>();
		shifttimerepository.findAll().forEach(shift::add);
		return shift;
	}

}