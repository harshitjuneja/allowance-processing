package com.aps.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aps.domain.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

	@Query(value = "SELECT * FROM employee e WHERE e.corp_id= ?1 AND e.password=?2", nativeQuery = true)
	List<Employee> getValidUser(String corpID, String password);

	@Query(value = "SELECT * FROM employee e WHERE e.corp_id=?1", nativeQuery = true)
	List<Employee> getEmployeeById(String corpId);
	

	@Query(value = "SELECT * FROM EMPLOYEE where Corp_ID =?1 AND End_Date =2038-12-31", nativeQuery = true)
	Employee findExistingEmployee(String corp_id);

	@Query(value = "UPDATE EMPLOYEE SET End_Date =?1  WHERE Corp_ID=?2", nativeQuery = true)
	void update(Date endDate, String corp_id);
}
