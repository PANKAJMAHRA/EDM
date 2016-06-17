/*package com.edm.controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edm.dao.CommonDao;
import com.edm.model.CommonBean;

@WebServlet("/CommonController")
public class CommonController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String forward;
	CommonDao commondao;
	
	CommonBean commonbean=new CommonBean();
       

    public CommonController() {
    	super();
    	commondao=new CommonDao();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("inside CommonController");
		String action=request.getParameter("action");
		if(action.equalsIgnoreCase("listalldata")){
			//List<CommonBean> list=new ArrayList<CommonBean>();
			//list=commondao.viewAllData(id);
			System.out.println("inside list all data");
			//forward="/viewalldata.jsp";
			int id=Integer.parseInt(request.getParameter("ApplicationId"));
			System.out.println(".,.,.,.,");
			commonbean=commondao.viewAllData(id);
			
			ArrayList<CommonBean> list=new ArrayList<CommonBean>();
			list.add(commonbean);
			request.setAttribute("commonlist",list);
			//RequestDispatcher rd= request.getRequestDispatcher("viewalldata.jsp");
			//rd.include(request, response);
			forward="/viewalldata.jsp";
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}*/
