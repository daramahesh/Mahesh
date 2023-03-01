package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmployeeInsert {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("/hibernate.cfg.xml");
		@SuppressWarnings("deprecation")
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		Employee emp = new Employee();
		emp.setEno(222);
		emp.setEname("Nikhil");
		emp.setEsalary(16400);
		s.save(emp);
		tx.commit();
		s.close();
		
	}

}
