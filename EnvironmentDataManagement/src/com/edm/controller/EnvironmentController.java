/*package com.edm.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edm.dao.EnvironmentDao;
import com.edm.model.EnvironmentBean;

@WebServlet("/EnvironmentController")
public class EnvironmentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String forward;
	EnvironmentDao environmentdao;
	
	EnvironmentBean eb=new EnvironmentBean();
       
    public EnvironmentController() {
        super();
        environmentdao= new EnvironmentDao();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String action=request.getParameter("action");
		if (action.equalsIgnoreCase("listenvironment")){
		List<EnvironmentBean> list=new ArrayList<EnvironmentBean>();
		list= environmentdao.
				
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
*/