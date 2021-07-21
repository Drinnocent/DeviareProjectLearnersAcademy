package com.database;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import school.com.Batch;


/**
 * Servlet implementation class AssignTeacherServlet
 */
@WebServlet("/AssignTeacherServlet")
public class AssignTeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AssignTeacherServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String grade2 = request.getParameter("class2");
		String subjCode2 = request.getParameter("subject2");
		String teacher = request.getParameter("teacher");
		
	
			BatchConnection con = new BatchConnection();
			int sz = con.getBatch().size() + 1;
			Batch b = new Batch(sz, grade2, subjCode2, teacher);

			if (con.assignTeacher(b)) {
				System.out.println("Techer Assigned");
				response.sendRedirect("assign.jsp");
			} else {
				System.out.println("TeacherFailed to be assigned");
				response.sendRedirect("assign.jsp");
			}

		
		
	
	}

}
