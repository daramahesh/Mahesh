package com.jdbcoperations.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.test.EmployeeDAO;
import com.pojoclass.test.Employee;

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		out.println("<a href='index.html'>Add New Employee</a>");
		out.println("<br> <h1>Employee List</h1>");
		
		List<Employee> list = EmployeeDAO.getAllEmployees();
		out.print("<table border='1px'>");
		out.print("<tr><td>ID</td><td>NAME</td><td>SALARY</td><td>DESIGNATION</td><td>EDIT</td><td>DELETE</td></tr>");
		for(Employee e:list) {
			out.print("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getSalary()+"</td><td>"+e.getDesignation()+"</td><td><a href='EditServlet?id="+e.getId()+"'>Edit</a></td><td><a href='DeleteServlet?id="+e.getId()+"'>Delete</a></td></tr>");
		}
		out.print("</table>");
	}

}
