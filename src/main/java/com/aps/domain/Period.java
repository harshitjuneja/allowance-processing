package com.aps.domain;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "period")
public class Period {
	@Id
	@Column(name = "period_id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long periodID;

	@Column(name = "period_name")
	private String periodName;

	@Column(name = "period_year")
	private Date year;

	@Column(name = "start_date")
	private Timestamp startDate;

	@Column(name = "end_date")
	private Timestamp endDate;

	@Column(name = "is_active")
	private Boolean isActive;

	public Long getPeriodID() {
		return periodID;
	}

	public Period() {
		super();
	}

	public Period(Long periodID, String periodName, Date year, Timestamp startDate, Timestamp endDate,
			Boolean isActive) {
		super();
		this.periodID = periodID;
		this.periodName = periodName;
		this.year = year;
		this.startDate = startDate;
		this.endDate = endDate;
		this.isActive = isActive;
	}

	public String getPeriodName() {
		return periodName;
	}

	public void setPeriodName(String periodName) {
		this.periodName = periodName;
	}

	public Date getYear() {
		return year;
	}

	public void setYear(Date year) {
		this.year = year;
	}

	public Timestamp getStartDate() {
		return startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public Timestamp getEndDate() {
		return endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public void setPeriodID(Long periodID) {
		this.periodID = periodID;
	}

}
