package com.hibernate;

import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmployeeUpdate {

	public static void main(String[] args) {

		Configuration cfg = new  Configuration();
		cfg.configure("/hibernate.cfg.xml");
		@SuppressWarnings("deprecation")
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		
		//method 1
		/*
		 * Employee emp = (Employee) s.get(Employee.class, 222); emp.setEsalary(18000);
		 * s.update(emp);
		 */
		
		//method 2 - using HQL
		Query query = s.createQuery("update Employee set esalary=:esalary where ename=:ename");
		query.setParameter("esalary", 17000.0);
		query.setParameter("ename", "Mahesh");
		query.executeUpdate();
		
		tx.commit();
		s.close();
	}

}
