package com.Lab2.EzCart.Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Lab2.EzCart.Models.DisplayCart;
import com.Lab2.EzCart.WebServices.WebservicesProxy;

/**
 * Servlet implementation class History
 */
@WebServlet("/History")
public class History extends HttpServlet {
	private static final long serialVersionUID = 1L;
    WebservicesProxy proxy =new WebservicesProxy(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public History() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Inside Get");
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		String username = session.getAttribute("userName").toString();
		System.out.println(username);
		
		DisplayCart[] displayCart;
		DisplayCart[] displayCartSell;
		displayCart = proxy.ajax_DisplayCart(username,"history");
		displayCartSell = proxy.displaySellProducts(username);
		
		if(displayCart == null) {			
			request.setAttribute("Record", "No");
		} else {
			request.setAttribute("Record", "Yes");
		}
		
		if(displayCartSell == null) {			
			request.setAttribute("RecordSell", "No");
		} else {
			request.setAttribute("RecordSell", "Yes");
		}
					
		request.setAttribute("name",username);
		request.setAttribute("displayCart", displayCart);
		request.setAttribute("displayCartSell", displayCartSell);
		request.getRequestDispatcher("History.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
