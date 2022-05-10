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
public class MiniWebReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public MiniWebReadServlet() {
        // TODO Auto-generated constructor stub
    	super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idString = request.getParameter("id");
		String sortData = request.getParameter("radio");
		
		if (idString != null) {
			Integer id=Integer.parseInt(idString);
			
			//StudentService service = new StudentService(url);
			ChicagoArchitectureService service = new ChicagoArchitectureService();
			ChicagoArchitecture s = service.findById(id);		
			HttpSession session = request.getSession();
			session.setAttribute("building", s);
			request.getRequestDispatcher("/Pages/EditDisplay.jsp").forward(request, response);
			
		}
		else if(sortData != null)
		{	
			ChicagoArchitectureService service = new ChicagoArchitectureService();
			ArrayList<ChicagoArchitecture> buildings = service.sort(sortData);	
			HttpSession session = request.getSession();
			session.setAttribute("buildings", buildings);
			request.getRequestDispatcher("../Pages/DisplayBuildings.jsp").forward(request, response);
			System.out.println("Sorted !");
		}
		
		else {
			ChicagoArchitectureService service = new ChicagoArchitectureService();
			ArrayList<ChicagoArchitecture> buildings=service.findAll();
			HttpSession session = request.getSession();
			session.setAttribute("buildings", buildings);
			request.getRequestDispatcher("../Pages/DisplayBuildings.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);	
	}

}
