package com.Lab2.MathSolver.Servlets;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Lab2.MathSolver.WebServices.WebServicesProxy;

/**
 * Servlet implementation class Prime
 */
@WebServlet("/Prime")
public class Prime extends HttpServlet {
	private static final long serialVersionUID = 1L;
	WebServicesProxy proxy = new WebServicesProxy();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Prime() {
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
		System.out.println("In do post");
		
		String checkingMethodName = (String) request.getParameter("method");
		int number;
		if(checkingMethodName.equals("all"))
		{
			number = Integer.parseInt(request.getParameter("allPrimeNumber"));				
			WebServicesProxy webservicesProxy = new WebServicesProxy();
			String result = webservicesProxy.primeSeries(number);
			request.setAttribute("result", result);
			request.getRequestDispatcher("Index.jsp").forward(request, response);
		}
		else
		{
			number = Integer.parseInt(request.getParameter("checkPrimeNumber"));
			System.out.println("Number --> " + number);
			
			WebServicesProxy webservicesProxy = new WebServicesProxy();
			String result = webservicesProxy.checkPrime(number);
			request.setAttribute("result", result);
			
			request.getRequestDispatcher("Index.jsp").forward(request, response);
		}
		
		/*
		int noOfCalls,choose;
		Random generator = new Random();		

		long startTime = System.currentTimeMillis();
		
		System.out.println("Start time for 1000 no of Calls is: - " + startTime);
		noOfCalls = 1000;
		for (int i = 0;i<noOfCalls;i++)
		{
			choose = generator.nextInt(2)+1;
			
			if(choose==1)
			{
				//System.out.println("Checking if number is prime");
				proxy.checkPrime(number);
			}
			else 
			{
				//System.out.println("All Prime number");
				proxy.primeSeries(number);
			}
		}
		
		long endTime = System.currentTimeMillis();
		System.out.println("End time for 1000 no of Calls: -" + endTime);
		float avgTime = endTime - startTime;
		System.out.println("Average time for 1000 no of Calls: - "+ avgTime/1000 +" ms");
		System.out.println("");
		System.out.println("=================================================");
		System.out.println("");
		startTime = System.currentTimeMillis();
		noOfCalls = 5000;
		System.out.println("Start time for 5000 no of Calls is: - " + startTime);
		
		for (int i = 0;i<noOfCalls;i++)
		{
			choose = generator.nextInt(2)+1;
			
			if(choose==1)
			{
				//System.out.println("Checking if number is prime");
				proxy.checkPrime(number);
			}
			else 
			{
				//System.out.println("All Prime number");
				proxy.primeSeries(number);
			}
		}
		
		endTime = System.currentTimeMillis();
		System.out.println("End time for 5000 no of Calls: - " + endTime);
		avgTime = endTime - startTime;
		System.out.println("Average time for 5000 no of Calls: - "+ avgTime/1000 +" ms"); */

	} 

}
