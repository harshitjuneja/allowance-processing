package com.aps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aps.domain.AllowanceType;

@Repository
public interface AllowanceTypeRepository extends CrudRepository<AllowanceType, Integer> {
	@Query(value="SELECT * FROM allowance_type a WHERE a.type_name= ?1", nativeQuery = true)
	List<AllowanceType> viewAllowanceByName(String typeName);
}
