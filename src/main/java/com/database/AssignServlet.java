package com.database;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import school.com.Batch;
import school.com.ClassCourse;

/**
 * Servlet implementation class AssignServlet
 */
@WebServlet("/AssignServlet")
public class AssignServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AssignServlet() {
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
		String grade = request.getParameter("class");
		String subjCode = request.getParameter("subject");
		// PrintWriter out =response.getWriter();
		response.setContentType("text/html");
			ClassCourseConnection conn = new ClassCourseConnection();
			int no = conn.getAllClassSubj().size() + 1;
			ClassCourse cc = new ClassCourse(no, grade, subjCode);

			if (conn.assignSubjectToGrade(cc)) {
				System.out.println("Assigned");
				response.sendRedirect("assign.jsp");
			} else {
				System.out.println("Failed either subject already exist in that class");
				response.sendRedirect("assign.jsp");
			}
		

	}

}
