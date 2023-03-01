package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmployeeDelete {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("/hibernate.cfg.xml");
		@SuppressWarnings("deprecation")
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		Employee emp = new Employee();
		emp.setEno(444);
		s.delete(emp);
		tx.commit();
		s.close();
		
	}

}
