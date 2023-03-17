package com.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) {

		Department CSE = new Department("CSE", 3);
		Department ECE = new Department("ECE", 4);
		Department EEE = new Department("EEE", 2);
		Department IT = new Department("IT", 4);
	
		
		List<Faculty> facultyList = Arrays.asList(new Faculty(111, "vijay", 45, "male", "kakinada", 45000, CSE),
				                    new Faculty(122, "vijaya", 35, "female", "tuni", 40000, ECE),
				                    new Faculty(133, "nikhil", 47, "male", "anakapalli", 42000, EEE),
				                    new Faculty(144, "nikhila", 37, "female", "kakinada", 44000, IT),
				                    new Faculty(155, "pawan", 38, "male", "anakapalli", 47000, CSE),
				                    new Faculty(166, "gopal", 36, "male", "visakapatnam", 43000, CSE),
				                    new Faculty(177, "sai", 39, "male", "tuni", 48000, ECE),
				                    new Faculty(188, "sai", 35, "female", "visakapatnam", 46000, EEE),
				                    new Faculty(199, "manasa", 30, "female", "kakinada", 45000, IT),
				                    new Faculty(200, "ramesh", 32, "male", "tuni", 49000, ECE),
				                    new Faculty(211, "suresh", 45, "male", "kakinada", 45500, IT),
				                    new Faculty(222, "sirisha", 29, "female", "anakapalli", 41000, ECE),
				                    new Faculty(233, "hareesh", 49, "male", "visakapatnam", 39999, IT));
		
	
		//male and female faculty in college
		System.out.println("male and female faculty in college");
		Map<String, Long> noOfMalesAndFemales = facultyList.stream().collect(Collectors.groupingBy(Faculty::getGender, Collectors.counting()));
		System.out.println(noOfMalesAndFemales);
		
		System.out.println("===============================================");
		
		//distinct department names that faculty are teaching
		System.out.println("distinct dept names that faculty are teaching");
		facultyList.stream().map(e->e.getDepartment().getDepartmentName()).distinct().forEach(System.out::println);
		
		System.out.println("===============================================");
		
		//getting no of faculty in each department
		System.out.println("getting no of faculty in each department");
		Map<Department, Long> employeeCountByDepartment = facultyList.stream().collect(Collectors.groupingBy(Faculty::getDepartment, Collectors.counting()));
		for(Map.Entry<Department, Long> s: employeeCountByDepartment.entrySet()) {
			System.out.println(s.getKey() + ":" + s.getValue());
		}
		
		System.out.println("===============================================");
		
		//getting no of employees in all dept
		System.out.println("getting no of employees in all dept");
		long l = facultyList.stream().map(e->e.getDepartment().getNoOfFaculty()).count();
		System.out.println(l);
		
		System.out.println("===============================================");
		
		//faculty living in kakinada
		System.out.println("faculty living in kakinada");
		facultyList.stream().filter(e->e.getCity().equals("kakinada")).forEach(e->System.out.println(e.getName()));
		
		System.out.println("===============================================");
		
		//average salary of male and female
		System.out.println("average salary of male and female");
		Map<String, Double> aveSalOfMaleAndFemale = facultyList.stream().collect(Collectors.groupingBy(Faculty::getGender, Collectors.averagingDouble(Faculty::getSalary)));
		System.out.println(aveSalOfMaleAndFemale);
		
		System.out.println("===============================================");
		
		//getting list of faculty in each department
		Map<Department, List<Faculty>> flbd = facultyList.stream().collect(Collectors.groupingBy(Faculty::getDepartment));
		for(Map.Entry<Department, List<Faculty>> m : flbd.entrySet()) {
			System.out.println("--------------------------");
			System.out.println(m.getKey());
			System.out.println("--------------------------");
			List<Faculty> list = m.getValue();
			for(Faculty f : list) {
				System.out.println(f);
			}
		}
	}

}
