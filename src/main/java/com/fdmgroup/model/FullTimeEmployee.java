package com.fdmgroup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name ="FULLTIME_EMPLOYEE")
public class FullTimeEmployee extends Employee{
	
	

	@Column(name="SALARY",nullable = false)
	private double salary;
	
	

	public FullTimeEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}



	public FullTimeEmployee(String empName, String empDesignation, double salary) {
		super(empName, empDesignation);
		this.salary = salary;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}



	@Override
	public String toString() {
		return "FullTimeEmployee [salary=" + salary + "]";
	}

	
	
 
}
