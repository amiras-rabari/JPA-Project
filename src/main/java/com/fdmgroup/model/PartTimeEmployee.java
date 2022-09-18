package com.fdmgroup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name ="PARTTIME_EMPLOYEE")
public class PartTimeEmployee extends Employee{

	@Column(name="WAGES",nullable = false)
	private double wages;

	
	
	public PartTimeEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PartTimeEmployee(String empName, String empDesignation) {
		super(empName, empDesignation);
		// TODO Auto-generated constructor stub
	}

	public PartTimeEmployee(String empName, String empDesignation, double wages) {
		super(empName, empDesignation);
		this.wages = wages;
	}

	public double getWages() {
		return wages;
	}

	public void setWages(double wages) {
		this.wages = wages;
	}

	@Override
	public String toString() {
		return "PartTimeEmployee [wages=" + wages + "]";
	}

	
	
}
