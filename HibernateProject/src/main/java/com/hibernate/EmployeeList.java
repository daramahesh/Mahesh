package com.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmployeeList {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("/hibernate.cfg.xml");
		@SuppressWarnings("deprecation")
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Query query = s.createQuery("from Employee");
		List<Employee> empList = query.list();
		//for(Employee emp : empList)
			//System.out.println(emp);
		//added in Java 8 version
		empList.forEach(emp -> System.out.println(emp));
		empList.forEach(System.out::println);//method reference		
		s.close();
		
	}

}
