package com.aps.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity(name = "employee")
public class Employee {

	@Id
	@Column(name = "corp_id",unique=true, nullable = false)
	private String corpId;

	@ManyToOne
	@JoinColumn(name = "dept_id")
	private Department departmentId;

	@Column(name = "emp_name")
	private String name;

	@ManyToOne
	@JoinColumn(name = "manager_id")
	private Employee manager;

	@Column(name = "email_id")
	private String emailId;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "role")
	private String role;
	
	@Column(name = "benefit_level")
	private Long benefitLevel;
	
	@Column(name = "phone_no")
	private Long phoneNo;

	@Column(name = "status", columnDefinition = "TINYINT(1)")
	private Boolean status;
	
	@Column(name = "start_date")
	private Date startDate;
	
	@Column(name = "end_date")
	private Date endDate;
	
	@Column(name = "updated_by")
	private String updatedBy;
	
	@Column(name = "designation")
	private String designation;

	public Employee(String corpId, String name, String emailId, String password, String role, Long benefitLevel,
			Long phoneNo, Boolean status, Date startDate, Date endDate, String updatedBy, String designation,
			Employee manager, Department departmentId) {
		super();
		this.corpId = corpId;
		this.name = name;
		this.emailId = emailId;
		this.password = password;
		this.role = role;
		this.benefitLevel = benefitLevel;
		this.phoneNo = phoneNo;
		this.status = status;
		this.startDate = startDate;
		this.endDate = endDate;
		this.updatedBy = updatedBy;
		this.designation = designation;
		this.manager = manager;
		this.departmentId = departmentId;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCorpId() {
		return corpId;
	}

	public void setCorpId(String corpId) {
		this.corpId = corpId;
	}

	public Department getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Department departmentId) {
		this.departmentId = departmentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Long getBenefitLevel() {
		return benefitLevel;
	}

	public void setBenefitLevel(Long benefitLevel) {
		this.benefitLevel = benefitLevel;
	}

	public Long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Boolean isStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

}
