package com.aps.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "Request_Details")
public class RequestDetails {
	@Id
	@Column(name = "request_details_id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long requestDetailsID;

	@ManyToOne
	@JoinColumn(name = "request_id")
	private Request requestID;

	@Column(name = "date")
	private Timestamp date;

	@ManyToOne
	@JoinColumn(name = "Shift_time_id")
	private ShiftTime shiftTimeID;

	public Long getRequestDetailsID() {
		return requestDetailsID;
	}

	public void setRequestDetailsID(Long requestDetailsID) {
		this.requestDetailsID = requestDetailsID;
	}

	public Request getRequestID() {
		return requestID;
	}

	public void setRequestID(Request requestID) {
		this.requestID = requestID;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public ShiftTime getShiftTimeID() {
		return shiftTimeID;
	}

	public void setShiftTimeID(ShiftTime shiftTimeID) {
		this.shiftTimeID = shiftTimeID;
	}

	public RequestDetails(Long requestDetailsID, Request requestID, Timestamp date, ShiftTime shiftTimeID) {
		super();
		this.requestDetailsID = requestDetailsID;
		this.requestID = requestID;
		this.date = date;
		this.shiftTimeID = shiftTimeID;
	}

	public RequestDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

}
