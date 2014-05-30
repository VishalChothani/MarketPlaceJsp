package com.Lab2.MathSolver.Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Lab2.MathSolver.WebServices.WebServicesProxy;

/**
 * Servlet implementation class AllPrime
 */
@WebServlet("/AllPrime")
public class AllPrime extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllPrime() {
        super();               
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Inside prime series");
		int number = Integer.parseInt(request.getParameter("allPrimeNumber"));				
		WebServicesProxy webservicesProxy = new WebServicesProxy();
		String result = webservicesProxy.primeSeries(number);
		request.setAttribute("result", result);
		request.getRequestDispatcher("Index.jsp").forward(request, response);
	}

}
