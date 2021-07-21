package com.database;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import school.com.Student;
import school.com.Teacher;

/**
 * Servlet implementation class addTeacher
 */
@WebServlet("/addTeacher")
public class addTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addTeacher() {
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
		String teacherId=request.getParameter("teacherId");
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String idNumber=request.getParameter("idNumber");
		
		
		
		//PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		if(teacherId==null || teacherId.isEmpty() ||  firstName==null || firstName.isEmpty() ||
				lastName==null || lastName.isEmpty() || idNumber==null || idNumber.isEmpty() ) 
		{
			request.setAttribute("error","All fields are compulsory");
			RequestDispatcher dispatcher=request.getRequestDispatcher("addStudent.jsp");
			dispatcher.forward(request, response);
		}
		else 
		{

			Teacher c=new Teacher(teacherId,firstName,lastName,idNumber);
			TeacherConnection database=new TeacherConnection();
			System.out.println(c);
			if(database.insertTeacher(c))
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
