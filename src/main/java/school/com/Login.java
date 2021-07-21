package school.com;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.database.AdminConnection;
import com.database.BatchConnection;
import com.database.ClassConnection;
import com.database.ClassCourseConnection;
import com.database.StudentConnection;
import com.database.SubjectConnection;
import com.database.TeacherConnection;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
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
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		
		AdminConnection database = new AdminConnection();
		ClassConnection classgrade=new ClassConnection();
		StudentConnection student=new StudentConnection();
		SubjectConnection subject=new SubjectConnection();
		TeacherConnection teacher=new TeacherConnection();
		BatchConnection batch=new BatchConnection();
		ClassCourseConnection classcourse=new ClassCourseConnection();
		
		if (database.validate(email, password)) {
			HttpSession session = request.getSession();
			session.setAttribute("email", email);
			List<GradeClass> grades=classgrade.getAllClasses();
			List<Student>students=student.getAllStudents();
			List<Subject>subjects=subject.getAllSubjects();
			List<Teacher>teachers=teacher.getAllTeachers();
			List<Batch>batches=batch.getBatch();
			List<ClassCourse>classcourses=classcourse.getAllClassSubj();
			session.setAttribute("classlist", grades);
			session.setAttribute("studentlist", students);
			session.setAttribute("subjectlist", subjects);
			session.setAttribute("teacherlist", teachers);
			session.setAttribute("classcourselist", classcourses);
			session.setAttribute("batchlist",batches);
			response.sendRedirect("Report.jsp");
			
		} else {
			request.setAttribute("error", "login failed please check you details");
			response.sendRedirect("login.jsp");
		}

	}

}
