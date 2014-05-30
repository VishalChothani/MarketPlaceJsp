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
 * Servlet implementation class SignUp
 */
@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	WebservicesProxy proxy = new WebservicesProxy();
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Inside DoGET");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Inside DoPost");		
		response.setContentType("text/html");
		String qdone;		 
		 try
		 {			
			 String firstname = request.getParameter("firstname");
			 String lastname = request.getParameter("lastname");
			 String username = request.getParameter("username");
			 String password = request.getParameter("password");
			 String address = request.getParameter("address");
			 String email = request.getParameter("email");
			 	
			 //proxy.setEndpoint("http://localhost:8080/EzCart/webservices/Webservices");
			 qdone = proxy.signUpUser(firstname,lastname,username,password,address,email);
			 HttpSession session = request.getSession();
			 System.out.println("QDone :- "+qdone);
			 
			 if(qdone.substring(0,4).equals("true"))
			 {
				 session.setAttribute("userSession", session);
				 request.setAttribute("name", username);
				 session.setAttribute("userName", username);
				 request.setAttribute("last_login","You have Login for 1st time");
				 session.setAttribute("last_login", "You have Login for 1st time");
				 Category[] category;
				 Products[] products;
				 
				 category = proxy.getCategoryResultSet();
				 for (int i=0;i<category.length;i++)
				 {
					 System.out.println(category[i].getCategory_id());
					 System.out.println(category[i].getCategory_name());
				 }
				 request.setAttribute("categoryList", category);
				 System.out.println("Going to UserProfile.jsp");
				 //System.out.println(request.getAttribute("categoryList"));
				 
				 products = proxy.getProductsResultSet(username);
				 for (int i=0;i<products.length;i++)
				 {
					 System.out.println(products[i].getProduct_id());
					 System.out.println(products[i].getProduct_name());
					 System.out.println(products[i].getProduct_price());
					 System.out.println(products[i].getNo_of_product());
					 System.out.println(products[i].getProduct_desc());					 
					 System.out.println(products[i].getCategory_name());
				 }
				 request.setAttribute("productsList", products);
				 System.out.println("Going to UserProfile.jsp");
				 System.out.println(request.getAttribute("productsList"));

				 request.setAttribute("selectedCategory", "all");
				 
				 request.getRequestDispatcher("UserProfile.jsp").forward(request, response);
			 }
			 else
			 {
				 request.setAttribute("error", "Username already Present");
				 request.getRequestDispatcher("SignUp.jsp").forward(request, response);				
			 }
		 }
		 catch (Exception e)
	     {
			 e.printStackTrace();
	     }	
	}
}
