package com.aps.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aps.domain.Period;

@Repository
public interface PeriodRepository extends CrudRepository<Period, Long> {

	@Query(value = "SELECT * FROM period p WHERE p.is_active = 1 AND p.period_year= ?1", nativeQuery = true)
	List<Period> findByYear(Date year);
}
