package com.aps.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "shift_time_details")
public class ShiftTime {
	@Id
	@Column(name = "shift_time_id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long shiftTimeID;

	@ManyToOne
	@JoinColumn(name = "allowance_type_id")
	private AllowanceType allowanceTypeID;

	@Column(name = "start_time")
	private Timestamp startTime;

	@Column(name = "end_time")
	private Timestamp endTime;

	@Column(name = "valid_flag")
	private Boolean validFlag;

	public Long getShiftTimeID() {
		return shiftTimeID;
	}

	public void setShiftTimeID(Long shiftTimeID) {
		this.shiftTimeID = shiftTimeID;
	}

	public AllowanceType getAllowanceTypeID() {
		return allowanceTypeID;
	}

	public void setAllowanceTypeID(AllowanceType allowanceTypeID) {
		this.allowanceTypeID = allowanceTypeID;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public Boolean getValidFlag() {
		return validFlag;
	}

	public void setValidFlag(Boolean validFlag) {
		this.validFlag = validFlag;
	}

	public ShiftTime() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ShiftTime(Long shiftTimeID, AllowanceType allowanceTypeID, Timestamp startTime, Timestamp endTime,
			Boolean validFlag) {
		super();
		this.shiftTimeID = shiftTimeID;
		this.allowanceTypeID = allowanceTypeID;
		this.startTime = startTime;
		this.endTime = endTime;
		this.validFlag = validFlag;
	}

}
