package com.adil.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "JPA_OTM_PHONES")
@Setter
@Getter
//@NoArgsConstructor
@RequiredArgsConstructor
public class PhoneNumber {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer regNo;
	@NonNull
	private Long mobileNumber;
	@Column(length = 30)
	@NonNull
	private String provider;
	@Column(length = 30)
	@NonNull
	private String numberType;
	// for building many to one association
	@ManyToOne(targetEntity = Customer.class,fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "cno")
	private Customer cust;
	
	public PhoneNumber() {
		System.out.println("PhoneNumber() ::- 0 param constructor"+this.getClass());
	}
	

	// toString
	@Override
	public String toString() {
		return "PhoneNumber [regNo=" + regNo + ", mobuleNumber=" + mobileNumber + ", provider=" + provider
				+ ", numberType=" + numberType + "]";
	}

}
