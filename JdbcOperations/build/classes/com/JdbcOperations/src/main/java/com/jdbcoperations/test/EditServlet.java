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

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
   
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<h1>Update Employee</h1>");
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		Employee e = EmployeeDAO.getEmployeeById(id);
		
		 out.print("<form action='EditServlet2' method='post'>");  
	        out.print("<table>");  
	        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+e.getId()+"'></td></tr>");  
	        out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+e.getName()+"'></td></tr>");  
	        out.print("<tr><td>SALARY:</td><td><input type='number' name='salary' value='"+e.getSalary()+"'></td></tr>");  
	        out.print("<tr><td>DESIGNATION:</td><td><input type='text' name='designation' value='"+e.getDesignation()+"'></td></tr>");  
	        out.print("<tr><td colspan='1'></td><td><input type ='submit' value='Edit&Save'></td></tr>");
	        out.print("</table>");
	        out.print("</form>");
		
	}
}