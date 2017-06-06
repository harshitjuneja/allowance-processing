package com.aps.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "department")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dept_id")
	private Long departmentId;

	@Column(name = "dept_name")
	private String departmentName;
	@Column(name = "dept_code")
	private String departmentCode;
	@Column(name = "hod")
	private String hod;

	@ManyToOne
	@JoinColumn(name = "parent_dept_id")
	private Department parentDepartmentId;

	@Column(name = "description")
	private String description;
	@Column(name = "status")
	private boolean status;
	@Column(name = "dept_coordinator")
	private String departmentCordinator;

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	public String getHod() {
		return hod;
	}

	public void setHod(String hod) {
		this.hod = hod;
	}

	public Department getParentDepartmentId() {
		return parentDepartmentId;
	}

	public void setParentDepartmentId(Department parentDepartmentId) {
		this.parentDepartmentId = parentDepartmentId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getDepartmentCordinator() {
		return departmentCordinator;
	}

	public void setDepartmentCordinator(String departmentCordinator) {
		this.departmentCordinator = departmentCordinator;
	}

}
