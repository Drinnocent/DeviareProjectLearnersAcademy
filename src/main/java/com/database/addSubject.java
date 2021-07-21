package com.database;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import school.com.Subject;

/**
 * Servlet implementation class addSubject
 */
@WebServlet("/addSubject")
public class addSubject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addSubject() {
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
		String subjectCode=request.getParameter("subjectCode");
		String subjectName=request.getParameter("subjectName");
		
		//PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		if(subjectCode==null || subjectCode.isEmpty() || subjectName==null || subjectName.isEmpty()) 
		{
			request.setAttribute("error","All fields are compulsory");
			RequestDispatcher dispatcher=request.getRequestDispatcher("addSubject.jsp");
			dispatcher.forward(request, response);
		}
		else 
		{

			Subject c=new Subject(subjectCode,subjectName);
			SubjectConnection database=new SubjectConnection();
			System.out.println(c);
			if(database.insertSubject(c))
			{
				System.out.println("inserted");
				response.sendRedirect("addSubject.jsp");
			}
			else 
			{
				System.out.println("insert failed");
				response.sendRedirect("addSubject.jsp");
			}
		}
	}

}
