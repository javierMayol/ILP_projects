package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.ChicagoArchitecture;
import com.service.ChicagoArchitectureService;


/**
 * Servlet implementation class MiniWebServlet
 */
public class MiniWebWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public MiniWebWriteServlet() {
        // TODO Auto-generated constructor stub
    	super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ChicagoArchitecture ca = new ChicagoArchitecture();
		
		ca.setBuildingName(request.getParameter("building_name"));
		ca.setArchitects(request.getParameter("architects"));
		ca.setAddress(request.getParameter("address"));
		ca.setYearBuilt(Integer.parseInt(request.getParameter("year_built")));
		
		String action = request.getParameter("action");
		
		System.out.println(ca);
		
		// We're decoupling the dao from the servlet via a service
		ChicagoArchitectureService ssvc = new ChicagoArchitectureService();
		if (action.equals("add")) {
			// see DynamicWebInsert on how to do this.
			 ssvc.save(ca);
			
			HttpSession session = request.getSession();
			session.setAttribute("message", "Building added!");
			
			/* Uncomment this to call getAll()
			   Then see DynamicSelectAll on how to make this work! */
			request.getRequestDispatcher("/").forward(request, response);

			
		} else if (action.equals("update")) {
			
			ca.setBuildingId(Integer.parseInt(request.getParameter("building_id")));
			System.out.println("Update "+ca);
			ssvc.update(ca);

			HttpSession session = request.getSession();
			session.setAttribute("message", "Databse updated.");

			// uncomment to call findAll()
			request.getRequestDispatcher("/").forward(request, response);
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("error", "Adding building "+action+" failed.");
			request.getRequestDispatcher("${pageContext.request.contextPath}/Pages/Error.jsp").forward(request, response);
		}
		
	}

}
