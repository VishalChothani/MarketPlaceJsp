package com.Lab2.EzCart.Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Lab2.EzCart.Models.Category;
import com.Lab2.EzCart.Models.Products;
import com.Lab2.EzCart.WebServices.WebservicesProxy;

/**
 * Servlet implementation class Ajax_AddToCart
 */
@WebServlet("/Ajax_AddToCart")
public class Ajax_AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	WebservicesProxy proxy = new WebservicesProxy();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ajax_AddToCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Inside Get");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Inside Post");
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		
		String product_name = (String)request.getParameter("insert_product");
		String product_count = product_name.substring(product_name.indexOf(" "));
		
		String username = session.getAttribute("userName").toString();
		String product_name1 = product_name.substring(0,product_name.indexOf(" "));
		product_count = product_count.trim();
		int product_count1 = Integer.parseInt(product_count);
		
		System.out.println("ProductName :-"+product_name1+"\nproduct_count1:- "+product_count1);
		
		int product_prize = Integer.parseInt(request.getParameter("product_prize"));
		String seller_name = request.getParameter("seller_name");
		
		proxy.ajax_AddToCart(username,product_name1,product_count1,product_prize,seller_name);		 	
		
	}

}
