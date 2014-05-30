package com.Lab2.EzCart.Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Lab2.EzCart.WebServices.WebservicesProxy;

/**
 * Servlet implementation class Successful
 */
@WebServlet("/Successful")
public class Successful extends HttpServlet {
	private static final long serialVersionUID = 1L;
    WebservicesProxy proxy = new WebservicesProxy();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Successful() {
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
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("userName");
		
		String result = proxy.addToHistoryWS(username);
		
		request.getRequestDispatcher("Successful.jsp").forward(request, response);
	}

}
