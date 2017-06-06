package com.aps.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "invoice")
public class Invoice {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "invoice_id", unique = true, nullable = false)
	private Long invoiceID;

	@ManyToOne
	@JoinColumn(name = "dept_id")
	private Department departmentID;

	@ManyToOne
	@JoinColumn(name = "period_id")
	private Period periodID;

	@Column(name = "total_amt")
	private Float totalAmount;

	@Column(name = "adjustments")
	private Float adjustments;

	@Column(name = "generated_date")
	private Timestamp generatedDate;

	@Column(name = "status")
	private Boolean status;

	@Column(name = "generated_by")
	private String generatedBy;

	@Column(name = "comments")
	private String comments;

	public Invoice(Long invoiceID, Department departmentID, Period periodID, Float totalAmount, Float adjustments,
			Timestamp generatedDate, Boolean status, String generatedBy, String comments) {
		super();
		this.invoiceID = invoiceID;
		this.departmentID = departmentID;
		this.periodID = periodID;
		this.totalAmount = totalAmount;
		this.adjustments = adjustments;
		this.generatedDate = generatedDate;
		this.status = status;
		this.generatedBy = generatedBy;
		this.comments = comments;
	}

	public Invoice() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getInvoiceID() {
		return invoiceID;
	}

	public void setInvoiceID(Long invoiceID) {
		this.invoiceID = invoiceID;
	}

	public Department getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(Department departmentID) {
		this.departmentID = departmentID;
	}

	public Period getPeriodID() {
		return periodID;
	}

	public void setPeriodID(Period periodID) {
		this.periodID = periodID;
	}

	public Float getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Float totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Float getAdjustments() {
		return adjustments;
	}

	public void setAdjustments(Float adjustments) {
		this.adjustments = adjustments;
	}

	public Timestamp getGeneratedDate() {
		return generatedDate;
	}

	public void setGeneratedDate(Timestamp generatedDate) {
		this.generatedDate = generatedDate;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getGeneratedBy() {
		return generatedBy;
	}

	public void setGeneratedBy(String generatedBy) {
		this.generatedBy = generatedBy;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

}