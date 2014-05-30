package com.Lab2.EzCart.Servlets;

import java.io.IOException;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Lab2.EzCart.Models.DisplayCart;
import com.Lab2.EzCart.WebServices.WebservicesProxy;

/**
 * Servlet implementation class Checkout
 */
@WebServlet("/Checkout")
public class Checkout extends HttpServlet {
	private static final long serialVersionUID = 1L;
	WebservicesProxy proxy = new WebservicesProxy();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Checkout() {
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
		displayCart = proxy.ajax_DisplayCart(username,"cart");
		
		if(displayCart == null) {
			//System.out.println("Products null");
			request.setAttribute("Record", "No");
		} else {
		//System.out.println("Length:-"+displayCart.length);
			request.setAttribute("Record", "Yes");
		}
		
		/*for(int i=0; i<displayCart.length;i++)
		{
			System.out.println("Cart Id:"+displayCart[i].getCart_id());
			System.out.println("Product Name:"+displayCart[i].getProduct_name());
			System.out.println("Product Count:"+displayCart[i].getProduct_count());
			System.out.println("Product_prize:"+displayCart[i].getProduct_prize());
			System.out.println("Username:"+displayCart[i].getUsername());
			System.out.println("Seller Name:"+displayCart[i].getSeller_name());
		}*/	
		request.setAttribute("name",username);
		request.setAttribute("displayCart", displayCart);
		request.getRequestDispatcher("Checkout.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Inside Post");
	}

}
