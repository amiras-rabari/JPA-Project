package com.fdmgroup.App;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.fdmgroup.model.Department;
import com.fdmgroup.model.Employee;
import com.fdmgroup.model.FullTimeEmployee;
import com.fdmgroup.model.PartTimeEmployee;

public class MainApp {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Amiras_Rabari_Project");
		EntityManager e = emf.createEntityManager();
		
		Department dpt1 = new Department("Academy");
		Department dpt2 = new Department("Sales");
		
		Employee emp1 = new Employee("John Doe", "Trainer");
		Employee emp2 = new Employee("Jane Doe", "Executive");
		Employee emp3 = new Employee("James Smith", "Trainer");
		
		emp1.setDpt(dpt1);
		
		emp2.setDpt(dpt2);
		
		emp3.setDpt(dpt1);
		
		FullTimeEmployee femp1 =new FullTimeEmployee(emp1.getEmpName(),emp1.getEmpDesignation(),100000);
		femp1.setDpt(dpt1);

		
		FullTimeEmployee femp2 =new FullTimeEmployee(emp2.getEmpName(),emp2.getEmpDesignation(),120000);
		femp2.setDpt(dpt2);

		
		
		
		PartTimeEmployee pemp1 = new PartTimeEmployee(emp3.getEmpName(),emp3.getEmpDesignation(),80);
		pemp1.setDpt(dpt1);

		
		e.getTransaction().begin();
		
		e.persist(dpt1);
		e.persist(dpt2);
		
		e.persist(emp1);
		e.persist(emp2);
		e.persist(emp3);
	
		
		e.persist(femp1);
		e.persist(femp2);
		
		e.persist(pemp1);
		
		e.getTransaction().commit();
		
		Query query = e.createNamedQuery("Department.findByDeptName",Department.class).setParameter("name", "Academy");
		Department d = (Department) query.getSingleResult();
		
		Query query2 = e.createQuery("Select e From Employee e Where e.dpt Like :dpt").setParameter("dpt",d);
		List<Employee> empList = new ArrayList <>();
		empList = query2.getResultList();
		
		for(Employee emp : empList)
		System.out.println(emp);
	}
	
	

	

}
