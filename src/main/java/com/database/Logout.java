package com.database;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Logout
 */
@WebServlet("/logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Profile do get");
        PrintWriter out = response.getWriter();
        HttpSession session=request.getSession();
        String email = (String) session.getAttribute("email");
      
        
        session.removeAttribute("email");
        session.invalidate();
        Cookie cookies[]=request.getCookies();
        for(Cookie cookie:cookies) 
        {
        	System.out.println(cookie.getName()+" : "+cookie.getValue());
        	if(cookie.getName().equals(("JSESSSIONID")))
        	{
        		cookie.setMaxAge(0);
        		response.addCookie(cookie);
        	}
        }
        out.println("<p><a href='login.jsp'>Go to Login</a></p>");
        out.println("</body></html>");

	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
