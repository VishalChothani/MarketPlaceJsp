package com.Lab2.EzCart.Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.Lab2.EzCart.Models.Products;
import com.Lab2.EzCart.Models.Category;
import com.Lab2.EzCart.WebServices.WebservicesProxy;

/**
 * Servlet implementation class ParticularCategory
 */
@WebServlet("/ParticularCategory")
public class ParticularCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	WebservicesProxy proxy = new WebservicesProxy();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ParticularCategory() {
        super();
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String category_name = (String) request.getParameter("Category_name");
		System.out.println(category_name);
		System.out.println("vishal");
		
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
						
				 
			products = proxy.getParticularProductsResultSet(category_name,username);
			if(products == null) {
				System.out.println("Products null");
				request.setAttribute("Record", "No");
			} else {
			System.out.println("Length:-"+products.length);
			request.setAttribute("Record", "Yes");
			
			}
			/*String len = (String)products.length;
			if(products.length.toString()==null)
			{
				request.setAttribute("productsList", products);
				request.setAttribute("selectedCategory", category_name);
								 
				request.getRequestDispatcher("UserProfile.jsp").forward(request, response);		
			}
			for (int i=0;i<products.length;i++)
			 {
				 System.out.println("Seller Name:"+products[i].getSeller_name());
			 }*/
			
			request.setAttribute("productsList", products);
			request.setAttribute("selectedCategory", category_name);
							 
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
		
	}

}
