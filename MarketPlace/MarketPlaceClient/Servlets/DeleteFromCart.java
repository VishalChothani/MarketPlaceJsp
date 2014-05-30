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
 * Servlet implementation class DeleteFromCart
 */
@WebServlet("/DeleteFromCart")
public class DeleteFromCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	WebservicesProxy proxy = new WebservicesProxy();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteFromCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		System.out.println("==========================");
		System.out.println("In Do Get");
		
		String product_name = (String) request.getParameter("product_name");
		System.out.println(product_name);
		
		int product_count = Integer.parseInt((String)request.getParameter("count"));
		System.out.println(product_count);
		
		String username = (String) session.getAttribute("userName");
		System.out.println("Username :-"+username);
		
		proxy.deleteProductsFromCart(username, product_name, product_count);
		
		DisplayCart[] displayCart;
		displayCart = proxy.ajax_DisplayCart(username,"cart");		
		
		request.setAttribute("name",username);
		request.setAttribute("displayCart", displayCart);
		request.getRequestDispatcher("ViewCart.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//System.out.println("vishal");
	}

}
