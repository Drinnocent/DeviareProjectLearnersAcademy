package com.database;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import school.com.Student;
import school.com.Subject;

/**
 * Servlet implementation class addStudent
 */
@WebServlet("/addStudent")
public class addStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String studentNumber=request.getParameter("studentNumber");
		String classId=request.getParameter("classId");
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String idNumber=request.getParameter("idNumber");
		
		
		
		//PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		if(studentNumber==null || studentNumber.isEmpty() || classId==null || classId.isEmpty() || firstName==null || firstName.isEmpty() ||
				lastName==null || lastName.isEmpty() || idNumber==null || idNumber.isEmpty() ) 
		{
			request.setAttribute("error","All fields are compulsory");
			RequestDispatcher dispatcher=request.getRequestDispatcher("addStudent.jsp");
			dispatcher.forward(request, response);
		}
		else 
		{

			Student c=new Student(studentNumber,classId,firstName,lastName,idNumber);
			StudentConnection database=new StudentConnection();
			System.out.println(c);
			if(database.insertStudent(c))
			{
				System.out.println("inserted");
				response.sendRedirect("addStudent.jsp");
			}
			else 
			{
				System.out.println("insert failed");
				response.sendRedirect("addStudent.jsp");
			}
		}
		
	}

}
