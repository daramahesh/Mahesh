package com.dao.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pojoclass.test.Employee;

public class EmployeeDAO {
	
	public static Connection getConnection() {
		Connection con=null;
		try {
		 Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "mahesh", "mahesh");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static int insert(Employee e) {
		Connection con = EmployeeDAO.getConnection();
		int status = 0;
		try {
			PreparedStatement pst = con.prepareStatement("insert into employees values(?,?,?,?)");
			pst.setInt(1, e.getId());
			pst.setString(2, e.getName());
			pst.setDouble(3, e.getSalary());
			pst.setString(4, e.getDesignation());
			status = pst.executeUpdate();
			con.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return status;
	}
	
	public static List<Employee> getAllEmployees() {
		List<Employee> list = new ArrayList<Employee>();
		
		try {
			Connection con = EmployeeDAO.getConnection();
			PreparedStatement pst = con.prepareStatement("Select * from employees");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Employee e = new Employee();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setSalary(rs.getDouble(3));
				e.setDesignation(rs.getString(4));
				list.add(e);
			}
			con.close();
			
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		return list;
	}
	
	public static Employee getEmployeeById(int id) {
		Employee e = new Employee();
		
		try {
			Connection con = EmployeeDAO.getConnection();
			PreparedStatement pst = con.prepareStatement("select * from employees where id = ?");
			pst.setInt(1, id);
			ResultSet rs  = pst.executeQuery();
			if(rs.next()) {
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setSalary(rs.getDouble(3));
				e.setDesignation(rs.getString(4));
			}
			con.close();
		} catch (SQLException e3) {
			e3.printStackTrace();
		}
		
		return e;
	}
	
	public static int updateEmployees(Employee e) {
		
		int status = 0;
		try {
			Connection con = EmployeeDAO.getConnection();
			PreparedStatement pst = con.prepareStatement("update Employees set name =?, salary=?, designation =? where id=?");
			pst.setString(1,e.getName());
			pst.setDouble(2, e.getSalary());
			pst.setString(3, e.getDesignation());
			pst.setInt(4, e.getId());
			status = pst.executeUpdate();
		    con.close();
		} catch (SQLException e4) {
			e4.printStackTrace();
		}
		return status;
	}
	
	public static int delete(int id) {
		int status =0;
		
		try {
			Connection con = EmployeeDAO.getConnection();
			PreparedStatement pst = con.prepareStatement("delete from employees where id = ?");
			pst.setInt(1, id);
			status=pst.executeUpdate();
			con.close();
		} catch (SQLException e3) {
			e3.printStackTrace();
		}
		
		return status;
	}
}
