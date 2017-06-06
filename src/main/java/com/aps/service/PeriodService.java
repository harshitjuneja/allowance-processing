package com.aps.service;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aps.domain.Period;
import com.aps.repository.PeriodRepository;

@Service
public class PeriodService {

	@Autowired
	private PeriodRepository periodRepository;

	public Iterable<Period> findByYear(Date year) {
		return periodRepository.findByYear(year);
	}
}
