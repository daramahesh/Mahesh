package com.hibernate;

import javax.persistence.*;

@Entity
@Table (name="EmployeeInfo")
public class Employee {
    @Id
    @Column (name="empno")
	private int eno;
    @Override
	public String toString() {
		return  eno + " " + ename + " " + esalary;
	}
	@Column (name="empname")
	private String ename;
    @Column (name="empsalary")
	private double esalary;
	public int getEno() {
		return eno;
	}
	public String getEname() {
		return ename;
	}
	public double getEsalary() {
		return esalary;
	}
	public void setEno(int eno) {
		this.eno = eno;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public void setEsalary(double esalary) {
		this.esalary = esalary;
	}
	
	
}
