package com.edm.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edm.dao.RegistrationDao;
import com.edm.model.RegistrationBean;

@WebServlet("/RegistrationController")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String New_Registration = "/register.jsp";
	private static String Login = "/login.jsp";
	String forward;
	RegistrationDao registrationdao;

	RegistrationBean registrationbean = new RegistrationBean();

	public RegistrationController() {
		super();
		registrationdao = new RegistrationDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("inside registration controller");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String action=request.getParameter("action");
		
	if(action.equalsIgnoreCase("login")){
		
		String userEmail=request.getParameter("txtuseremail");
		String userPassword=request.getParameter("txtuserpassword");
		
		registrationbean.setEmail(userEmail);
		registrationbean.setPassword(userPassword);
		 
		System.out.println("....");
		
		int checkuser=registrationdao.checkUser(registrationbean);
		if(checkuser==1){
			RequestDispatcher rd= request.getRequestDispatcher("meanu.html");
			rd.forward(request, response);
			//response.sendRedirect("meanu.html");
		}
		else{
			out.println("Sorry User Email or Password error!");
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
			rd.include(request,response);
			//response.sendRedirect("login.jsp"); 
		}
	}
	else if(action.equalsIgnoreCase("loginpage"))
	{
		forward=Login;
		RequestDispatcher requestdispacher = request.getRequestDispatcher(forward);
		requestdispacher.forward(request, response);
		
	}
	else if(action.equalsIgnoreCase("adduser1")){
		System.out.println("inside adduser1");
		forward=New_Registration;
		RequestDispatcher requestdispacher = request.getRequestDispatcher(forward);
		requestdispacher.forward(request, response);
		System.out.println("out adduser1");
	}
	
	else if(action.equalsIgnoreCase("adduser"))
	{
		System.out.println("inside the add user ");
		String fn=request.getParameter("fname");
		registrationbean.setFirstName(fn);
		String ln=request.getParameter("lname");
		registrationbean.setLastName(ln);
		String email=request.getParameter("useremail");
		registrationbean.setEmail(email);
		String password=request.getParameter("userpassword");
		registrationbean.setPassword(password);
		
		boolean bol=registrationdao.newRegistration(registrationbean);
		
		if(bol== true){
			System.out.println("inserted sucessfully");
			
			forward=Login;
			out.println("you are sucessfully registered");
			out.println("Please login!!");
			RequestDispatcher requestdispacher = request.getRequestDispatcher(forward);
			requestdispacher.include(request, response);
		}
		else {
			System.out.println("not inserted");
		}
		
		
	}
	else {
		System.out.println("inside else method");
	}
	//RequestDispatcher requestdispacher = request.getRequestDispatcher(forward);
	//requestdispacher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
