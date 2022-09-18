package com.fdmgroup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name ="EMPLOYEE")
public class Employee {
	
	@Id
	@SequenceGenerator(name = "EMP_ID", sequenceName = "EMP_ID")
	@GeneratedValue (strategy = GenerationType.SEQUENCE,generator = "EMP_ID")
	@Column(name ="EMP_ID",nullable = false)
	private int empId;
	
	@Column(name ="EMP_NAME",nullable = false,updatable = false)
	private String empName;
	
	@Column(name ="EMP_DESIGNATION",nullable = false)
	private String empDesignation;
	
	@ManyToOne
	@JoinColumn(name="FK_DEPT_D",nullable = false)
	private Department dpt;

	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String empName, String empDesignation) {
		super();
		this.empName = empName;
		this.empDesignation = empDesignation;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpDesignation() {
		return empDesignation;
	}

	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
	}

	public Department getDpt() {
		return dpt;
	}

	public void setDpt(Department dpt) {
		this.dpt = dpt;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empDesignation=" + empDesignation + ", dpt="
				+ dpt + "]";
	}
	
	 
	
	

}
