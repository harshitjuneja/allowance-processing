package com.aps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aps.domain.Department;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, String> {
	@Query(value = "SELECT * FROM department where dept_name =?1", nativeQuery = true)
	List<Department> findByName(String departmentName);

	@Query(value = "SELECT * FROM department where dept_code =?1", nativeQuery = true)
	List<Department> findByCode(String departmentCode);

	@Query(value = "SELECT * FROM department where parent_dept_id==?1", nativeQuery = true)
	List<Department> findSubDept(Long departmentId); // here departmentId must
														// be same when clicked
														// expand on frontend

	@Query(value = "SELECT * FROM department d WHERE d.status = 1", nativeQuery = true)
	List<Department> findActiveDepartments();
}
