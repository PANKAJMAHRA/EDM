package com.edm.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edm.dao.ApplicationDao;
import com.edm.model.ApplicationBean;
import com.edm.model.ApplicationTypeBean;
import com.edm.model.EnvironmentBean;
import com.edm.model.NetworkDomainBean;
import com.edm.model.ServerBean;
import com.edm.model.ServerTypeBean;

@WebServlet("/EDMController")
public class EDMController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String List_Application = "/listapplication.jsp";
	private static String Add_Application = "/addapplication.jsp";

	String forward;
	ApplicationDao applicationdao;

	ApplicationBean ab = new ApplicationBean();
	ApplicationTypeBean atb = new ApplicationTypeBean();
	EnvironmentBean eb = new EnvironmentBean();
	NetworkDomainBean ndb = new NetworkDomainBean();
	ServerBean sb = new ServerBean();
	ServerTypeBean stb = new ServerTypeBean();

	public EDMController() {
		super();
		applicationdao = new ApplicationDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		System.out.println("inside controller");
		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("listapplication")) {
			System.out.println("in list calling");
			List<ApplicationBean> list = new ArrayList<ApplicationBean>();
			list = applicationdao.getAllApplication();
			request.setAttribute("applicationlist", list);
			forward = List_Application;

		} else if (action.equalsIgnoreCase("addapplication")) {
			System.out.println("inside add application");
			forward = Add_Application;
			System.out.println("outside add application");

		} else if (action.equals("addapplication1")) {
			// ApplicationBean applicationbean
			int id = Integer.parseInt(request.getParameter("id"));
			ab.setId(id);
			String name = request.getParameter("name");
			ab.setName(name);
			String dl = request.getParameter("deploymentlocation");
			ab.setDeploymentLocation(dl);
			String lt = request.getParameter("logtype");
			ab.setLogType(lt);

			boolean bol = applicationdao.addApplication(ab);
			if (bol == true) {
				System.out.println("inserted sucessfully");

				List<ApplicationBean> list = new ArrayList<ApplicationBean>();
				list = applicationdao.getAllApplication();
				request.setAttribute("applicationlist", list);
				forward = List_Application;
			} else {
				System.out.println("insertion failed");
			}
		} else if (action.equalsIgnoreCase("editapplication")) {

			forward = "/applicationedit.jsp";
			System.out.println("inside edit application");

			int id = Integer.parseInt(request.getParameter("ApplicationId"));
			ab = applicationdao.getApplicationById(id);
			ArrayList<ApplicationBean> applicationlist = new ArrayList<ApplicationBean>();
			applicationlist.add(ab);
			request.setAttribute("applicationlist", applicationlist);
			RequestDispatcher rd = request.getRequestDispatcher("applicationedit.jsp");
			System.out.println(".....");
			rd.include(request, response);

		}

		else if (action.equalsIgnoreCase("updateapplication")) {
			System.out.println("inside update application");
			int id = Integer.parseInt(request.getParameter("id"));

			String name = request.getParameter("name");// values as in
														// applicationedit name
			ab.setName(name);
			String dl = request.getParameter("deploc");// values as in
														// applicationedit
														// deploc
			ab.setDeploymentLocation(dl);
			String lt = request.getParameter("logtype");
			ab.setLogType(lt);
			ab.setId(id);
			boolean bol = applicationdao.updateApplication(ab);
			System.out.println("update application!!!!");
			if (bol == true) {
				System.out.println("updated sucessfully");
				List<ApplicationBean> list = new ArrayList<ApplicationBean>();
				list = applicationdao.getAllApplication();
				request.setAttribute("applicationlist", list);
				forward = List_Application;

			} else {
				System.out.println("update failed");
			}
		}else if(action.equalsIgnoreCase("deleteapplication")){
			//forward="/applicationedit.jsp";
			int id =Integer.parseInt(request.getParameter("ApplicationId"));
			ab.setId(id);
			boolean bol=applicationdao.deleteApplication(ab);
			if(bol==true){
				System.out.println("deleteappplication executed");
				List<ApplicationBean> list=new ArrayList<ApplicationBean>();
				list=applicationdao.getAllApplication();
				request.setAttribute("applicationlist",list);
				System.out.println("in servlet after method calling");
				forward=List_Application;
			}
		}

		else {
			System.out.println("inside else method");
		}
		RequestDispatcher requestdispacher = request.getRequestDispatcher(forward);
		requestdispacher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
