package com.aps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aps.domain.Request;

@Repository
public interface RequestRepository extends CrudRepository<Request, Long> {

	// ----------------approver----------------

	@Query(value = "SELECT COUNT(request.request_status) FROM request, employee WHERE request.request_status=?1 AND employee.manager_id=?2 AND request.corp_id=employee.corp_id", nativeQuery = true)
	Long findByrequeststatusforApprover(String requeststatus, String corpID);

	@Query(value = "SELECT SUM(request.number_of_days) FROM request, employee WHERE request.allowance_type_id=?1 AND employee.manager_id=?2 AND request.corp_id=employee.corp_id", nativeQuery = true)
	Long findByallowanceTypeIDforApprover(int allowanceTypeID, String corpID);

	// ----------------requester----------------

	@Query(value = "SELECT COUNT(request.request_status) FROM request, employee WHERE request.request_status=?1 AND employee.corp_id=?2 AND request.corp_id=employee.corp_id", nativeQuery = true)
	Long findByrequeststatusforRequester(String requeststatus, String corpID);

	@Query(value = "SELECT SUM(request.number_of_days) FROM request, employee WHERE request.allowance_type_id=?1 AND employee.corp_id=?2 AND request.corp_id=employee.corp_id", nativeQuery = true)
	Long findByallowanceTypeIDforRequester(int allowanceTypeID, String corpID);

	// ----------------HR----------------
	@Query(value = "SELECT SUM(request.number_of_days) FROM request,employee WHERE employee.dept_id=?1 AND request.corp_id=employee.corp_id", nativeQuery = true)
	Long findnumberOfDaysBydepartmentIdforHR(int departmentId);
	
	//-------------LoginRole-------------
	
	@Query(value="SELECT role FROM employee WHERE corp_id=?1", nativeQuery=true)
	String findroleBycorpIDforLogin(String corpID);
	
	
	@Query(value = "SELECT * FROM request r WHERE r.request_status= ?1", nativeQuery = true)
	List<Request> findByStatus(String status);

	@Query(value = "SELECT * FROM request r WHERE NOT r.request_status = 'rejected' AND NOT r.request_status = ?1", nativeQuery = true)
	List<Request> findByNotStatus(String status);

	@Query(value = "SELECT * FROM request r WHERE r.corp_id= ?1", nativeQuery = true)
	List<Request> requesterViewRequests(String corpID);
}
