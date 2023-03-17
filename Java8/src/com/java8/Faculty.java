package com.java8;

public class Faculty {
	
	private int id;
	private String name;
	private int age;
	private String gender;
	private String city;
	private double salary;
	private Department department;
	
	public Faculty(int id, String name, int age, String gender, String city, double salary, Department department) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.city = city;
		this.salary = salary;
		this.department=department;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getGender() {
		return gender;
	}
	public String getCity() {
		return city;
	}
	public double getSalary() {
		return salary;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "Faculty [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", city=" + city
				+ ", salary=" + salary + ", department=" + department + "]";
	}
	
	
}
