package com.edm.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edm.dao.ApplicationDao;
import com.edm.dao.ApplicationTypeDao;
import com.edm.dao.CommonDao;
import com.edm.model.ApplicationBean;
import com.edm.model.ApplicationTypeBean;
import com.edm.model.CommonBean;
import com.edm.model.EnvironmentBean;
import com.edm.model.NetworkDomainBean;
import com.edm.model.ServerBean;
import com.edm.model.ServerTypeBean;

@WebServlet("/UpdateController")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String List_Application = "/listapplication.jsp";
	private static String Add_Application = "/addapplication.jsp";
	
	
	String forward;
	ApplicationDao applicationdao;
	ApplicationTypeDao applicationtypedao;
	CommonDao commondao;
	
	CommonBean commonbean=new CommonBean();

	ApplicationBean ab = new ApplicationBean();
	ApplicationTypeBean atb = new ApplicationTypeBean();
	EnvironmentBean eb = new EnvironmentBean();
	NetworkDomainBean ndb = new NetworkDomainBean();
	ServerBean sb = new ServerBean();
	ServerTypeBean stb = new ServerTypeBean();
       
    public UpdateController() {
        super();
        applicationdao = new ApplicationDao();
		applicationtypedao= new ApplicationTypeDao();
		commondao=new CommonDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getParameter("action");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
