package com.aps.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "allowance_type")
public class AllowanceType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "allowance_type_id", unique = true, nullable = false)
	private Long allowanceTypeID;

	@Column(name = "type_name")
	private String typeName;

	@Column(name = "type_rate")
	private Long typeRate;

	@Column(name = "valid_flag", columnDefinition = "TINYINT(1)")
	private Boolean validFlag;

	public Long getAllowanceTypeID() {
		return allowanceTypeID;
	}

	public void setAllowanceTypeID(Long allowanceTypeID) {
		this.allowanceTypeID = allowanceTypeID;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Long getTypeRate() {
		return typeRate;
	}

	public void setTypeRate(Long typeRate) {
		this.typeRate = typeRate;
	}

	public Boolean getValidFlag() {
		return validFlag;
	}

	public void setValidFlag(Boolean validFlag) {
		this.validFlag = validFlag;
	}

	public AllowanceType(Long allowanceTypeID, String typeName, Long typeRate, Boolean validFlag) {
		super();
		this.allowanceTypeID = allowanceTypeID;
		this.typeName = typeName;
		this.typeRate = typeRate;
		this.validFlag = validFlag;
	}

	public AllowanceType() {
		super();
	}
}
