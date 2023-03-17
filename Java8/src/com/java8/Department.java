package com.java8;

public class Department {

	private String departmentName;
	private int noOfFaculty;
	public Department(String departmentName, int noOfFaculty) {
		super();
		this.departmentName = departmentName;
		this.noOfFaculty = noOfFaculty;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public int getNoOfFaculty() {
		return noOfFaculty;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public void setNoOfFaculty(int noOfFaculty) {
		this.noOfFaculty = noOfFaculty;
	}
	
	public String toString() {
		return departmentName;
	}
}
