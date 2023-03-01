package com.jdbcoperations.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.test.EmployeeDAO;
import com.pojoclass.test.Employee;

@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		double salary = (double)Integer.parseInt(request.getParameter("salary"));
		String designation = request.getParameter("designation");
		
		Employee e = new Employee();
		e.setId(id);
		e.setName(name);
		e.setSalary(salary);
		e.setDesignation(designation);
		
		int status=EmployeeDAO.updateEmployees(e);
		if (status!=0) {
			response.sendRedirect("ViewServlet");
		}else {
			out.println("record not updated");
		}
	}
}
