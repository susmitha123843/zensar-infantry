package com.facebook3.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.facebook3.entity.FacebookEmployee;
import com.facebook3.service.Facebookservice;
import com.facebook3.service.FacebookserviceInterface;

/**
 * Servlet implementation class GlobalServlet
 */
public class GlobalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String option=request.getParameter("ac");
	response.setContentType("text/html");
	PrintWriter out=response.getWriter();
	out.println("<html><body>");
	if (option.equals("register"))
	{
		String name=request.getParameter("name");
		String pass=request.getParameter("pass");
		String email=request.getParameter("email");
		String address=request.getParameter("address");
		FacebookEmployee fe=new FacebookEmployee();
		fe.setName(name);
		fe.setPassword(pass);
		fe.setEmail(email);
		fe.setAddress(address);
		FacebookserviceInterface fs=Facebookservice.createObject();
		int i=fs.createProfile(fe);
		if(i>0)
		{
			out.println("profile created");
		}
		else
		{
			out.println("profile couldnt created");
		}
	}
	if (option.equals("login")){
		
	}
	if (option.equals("timeline")){
		
	}
	out.println("</body><</html>");
	}

	

}
