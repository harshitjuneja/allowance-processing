package com.aps.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aps.domain.Request;
import com.aps.repository.RequestRepository;

@Service
public class RequestService {

	@Autowired
	RequestRepository requestrepository;

	public List<Request> getAllRequest() {
		List<Request> req = new ArrayList<>();
		requestrepository.findAll().forEach(req::add);
		return req;
	}

	public void addRequest(Request request) {
		requestrepository.save(request);

	}

	// corpID obtained from session/login

		public String getroleforLogin() {
			return requestrepository.findroleBycorpIDforLogin("a999999");
		}
		
		// ----------------approver----------------

		public Long getPendingRequestforApprover() {
			return requestrepository.findByrequeststatusforApprover("submitted", "a999999");
		}

		public Long getShiftAllowanceDaysforApprover() {
			return requestrepository.findByallowanceTypeIDforApprover(1, "a999999");
		}

		public Long getOnCallDaysforApprover() {
			return requestrepository.findByallowanceTypeIDforApprover(2, "a999999");
		}

		// ----------------requester----------------

		public Long getPendingRequestforRequester() {
			return requestrepository.findByrequeststatusforRequester("submitted", "a999999");
		}

		public Long getApprovedRequestforRequester() {
			return requestrepository.findByrequeststatusforRequester("approved", "a999999");
		}

		public Long getRejectedRequestforRequester() {
			return requestrepository.findByrequeststatusforRequester("rejected", "a999999");
		}

		public Long getShiftAllowanceDaysforRequester() {
			return requestrepository.findByallowanceTypeIDforRequester(1, "a999999");
		}

		public Long getOnCallDaysforRequester() {
			return requestrepository.findByallowanceTypeIDforRequester(2, "a999999");
		}

		// ----------------HR----------------

		public Long findnumberOfDaysDeptID1forHR() {
			return requestrepository.findnumberOfDaysBydepartmentIdforHR(1);
		}
		
		
	public Iterable<Request> findRequestsByStatus(String status) {
		return requestrepository.findByStatus(status);
	}

	public Iterable<Request> findAllNonInvoicedRequests() {
		String status = "invoiced";
		return requestrepository.findByNotStatus(status);
	}

	public Iterable<Request> requesterView(String corpID) {
		return requestrepository.requesterViewRequests(corpID);
	}
}
