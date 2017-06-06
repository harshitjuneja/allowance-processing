package com.aps.domain;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "request")
public class Request {

	private enum request_Status {
		saved, submitted, approved, rejected, invoiced
	};

	@Id
	@Column(name = "request_id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long requestID;

	@ManyToOne
	@JoinColumn(name = "allowance_type_id")
	private AllowanceType allowanceTypeID;

	@ManyToOne
	@JoinColumn(name = "invoice_id", nullable = true)
	private Invoice invoiceID;

	@ManyToOne
	@JoinColumn(name = "corp_id")
	private Employee corpID;

	@Column(name = "period_start_date")
	private Timestamp periodStartDate;
	@Column(name = "period_end_date")
	private Timestamp periodEndDate;
	@Column(name = "number_of_days")
	private Long numberOfDays;
	@Column(name = "submitted_date")
	private Date submittedDate;

	@Column(name = "status_start_date")
	private Timestamp statusStartDate;
	@Column(name = "status_end_date")
	private Timestamp statusEndDate;
	@Column(name = "submitted_by")
	private String submittedBy;
	@Column(name = "amount")
	private float amount;
	@Column(name = "comments")
	private String comments;
	@Column(name = "exception", columnDefinition = "TINYINT(1)")
	private boolean isException;

	@Column(name = "request_status", nullable = true)
	@Enumerated(EnumType.STRING)
	private request_Status requeststatus;

	public Request() {
		super();
	}

	public Request(Long requestID, AllowanceType allowanceTypeID, Invoice invoiceID, Employee corpID,
			Timestamp periodStartDate, Timestamp periodEndDate, Long numberOfDays, Date submittedDate,
			Timestamp statusStartDate, Timestamp statusEndDate, String submittedBy, float amount, String comments,
			boolean isException, request_Status requeststatus) {
		super();
		this.requestID = requestID;
		this.allowanceTypeID = allowanceTypeID;
		this.invoiceID = invoiceID;
		this.corpID = corpID;
		this.periodStartDate = periodStartDate;
		this.periodEndDate = periodEndDate;
		this.numberOfDays = numberOfDays;
		this.submittedDate = submittedDate;
		this.statusStartDate = statusStartDate;
		this.statusEndDate = statusEndDate;
		this.submittedBy = submittedBy;
		this.amount = amount;
		this.comments = comments;
		this.isException = isException;
		this.requeststatus = requeststatus;
	}

	public Long getRequestID() {
		return requestID;
	}

	public void setRequestID(Long requestID) {
		this.requestID = requestID;
	}

	public AllowanceType getAllowanceTypeID() {
		return allowanceTypeID;
	}

	public void setAllowanceTypeID(AllowanceType allowanceTypeID) {
		this.allowanceTypeID = allowanceTypeID;
	}

	public Invoice getInvoiceID() {
		return invoiceID;
	}

	public void setInvoiceID(Invoice invoiceID) {
		this.invoiceID = invoiceID;
	}

	public Employee getCorpID() {
		return corpID;
	}

	public void setCorpID(Employee corpID) {
		this.corpID = corpID;
	}

	public Timestamp getPeriodStartDate() {
		return periodStartDate;
	}

	public void setPeriodStartDate(Timestamp periodStartDate) {
		this.periodStartDate = periodStartDate;
	}

	public Timestamp getPeriodEndDate() {
		return periodEndDate;
	}

	public void setPeriodEndDate(Timestamp periodEndDate) {
		this.periodEndDate = periodEndDate;
	}

	public Long getNumberOfDays() {
		return numberOfDays;
	}

	public void setNumberOfDays(Long numberOfDays) {
		this.numberOfDays = numberOfDays;
	}

	public Date getSubmittedDate() {
		return submittedDate;
	}

	public void setSubmittedDate(Date submittedDate) {
		this.submittedDate = submittedDate;
	}

	public Timestamp getStatusStartDate() {
		return statusStartDate;
	}

	public void setStatusStartDate(Timestamp statusStartDate) {
		this.statusStartDate = statusStartDate;
	}

	public Timestamp getStatusEndDate() {
		return statusEndDate;
	}

	public void setStatusEndDate(Timestamp statusEndDate) {
		this.statusEndDate = statusEndDate;
	}

	public String getSubmittedBy() {
		return submittedBy;
	}

	public void setSubmittedBy(String submittedBy) {
		this.submittedBy = submittedBy;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public boolean isException() {
		return isException;
	}

	public void setException(boolean IsException) {
		this.isException = IsException;
	}

	public request_Status getRequeststatus() {
		return requeststatus;
	}

	public void setRequeststatus(request_Status requeststatus) {
		this.requeststatus = requeststatus;
	}

}
