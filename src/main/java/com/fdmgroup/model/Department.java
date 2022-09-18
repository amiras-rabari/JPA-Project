package com.fdmgroup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name ="DEPARTMENT")
@NamedQuery(name = "Department.findByDeptName", query = "Select d From Department d "
		+ "Where d.deptName Like :name ") 
public class Department {
	
	
	@Id
	@SequenceGenerator(name = "DEPT_ID", sequenceName = "ID")
	@GeneratedValue (strategy = GenerationType.SEQUENCE,generator = "DEPT_ID")
	@Column(name ="DEPT_ID",nullable = false)
	private int deptId;
	
	@Column(name ="DEPT_NAME",nullable = false,unique = true)
	private String deptName;

	
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Department(String deptName) {
		super();
		this.deptName = deptName;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName + "]";
	}
	
	 
	
	

}
