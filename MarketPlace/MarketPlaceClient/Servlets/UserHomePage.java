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
 * Servlet implementation class UserHomePage
 */
@WebServlet("/UserHomePage")
public class UserHomePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	WebservicesProxy proxy = new WebservicesProxy();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserHomePage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Inside DoPost UserHomePage");		
		response.setContentType("text/html");
				 
		 try
		 {	
			
			HttpSession session = request.getSession();
			session.setAttribute("userSession", session);
			
			String username = session.getAttribute("userName").toString();
			String last_login = session.getAttribute("last_login").toString();
			
			request.setAttribute("name", username);
			
			request.setAttribute("last_login",last_login);
			Category[] category;
			Products[] products;
				 
			category = proxy.getCategoryResultSet();
			/*for (int i=0;i<category.length;i++)
			{
				System.out.println(category[i].getCategory_id());
				System.out.println(category[i].getCategory_name());
			}*/
			request.setAttribute("categoryList", category);
						
				 
			products = proxy.getProductsResultSet(username);
			
			/*for (int i=0;i<products.length;i++)
			 {
				 System.out.println(products[i].getProduct_id());
				 System.out.println(products[i].getProduct_name());
				 System.out.println(products[i].getProduct_price());
				 System.out.println(products[i].getNo_of_product());
				 System.out.println(products[i].getProduct_desc());					 
				 System.out.println(products[i].getCategory_name());
			 }*/
			request.setAttribute("productsList", products); 
			request.setAttribute("selectedCategory", "all");				 
			request.getRequestDispatcher("UserProfile.jsp").forward(request, response);			
		 }
		 catch (Exception e)
	     {
			 e.printStackTrace();
	     }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Inside DoPost UserHomePage");		
		response.setContentType("text/html");
		System.out.println("1");
		String qdone;		 
		 try
		 {	
			 System.out.println("2");
			 String username = request.getParameter("username");
			 String password = request.getParameter("password");
			 
			 System.out.println("3");
			 
			 //proxy.setEndpoint("http://localhost:8080/EzCart/webservices/Webservices");
			 qdone = proxy.loginUser(username,password);
			 System.out.println("4");
			 HttpSession session = request.getSession();
			 
			 if(qdone.substring(0,4).equals("true") || qdone.contains("PDT"))
			 {
				 
				 session.setAttribute("userSession", session);
				 session.setAttribute("userName", username);
				 session.setAttribute("last_login", qdone);
				 
				 request.setAttribute("name", username);				
			
				 request.setAttribute("last_login",qdone);
				 Category[] category;
				 Products[] products;
				 
				 category = proxy.getCategoryResultSet();
				 /*for (int i=0;i<category.length;i++)
				 {
					 System.out.println(category[i].getCategory_id());
					 System.out.println(category[i].getCategory_name());
				 }*/
				 request.setAttribute("categoryList", category);
				 
				 products = proxy.getProductsResultSet(username);
				 /*for (int i=0;i<products.length;i++)
				 {
					 System.out.println(products[i].getProduct_id());
					 System.out.println(products[i].getProduct_name());
					 System.out.println(products[i].getProduct_price());
					 System.out.println(products[i].getNo_of_product());
					 System.out.println(products[i].getProduct_desc());					 
					 System.out.println(products[i].getCategory_name());
				 }*/
				 request.setAttribute("productsList", products);
				 request.setAttribute("selectedCategory", "all");
				 request.getRequestDispatcher("UserProfile.jsp").forward(request, response);
			 }
			 else
			 {
				 request.setAttribute("wrong_credential", "Wrong Credential");
				 request.getRequestDispatcher("HomePageLogin.jsp").forward(request, response);				
			 }
		 }
		 catch (Exception e)
	     {
			 e.printStackTrace();
	     }	
	}
}
