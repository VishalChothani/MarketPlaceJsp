package com.Lab2.EzCart.Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Lab2.EzCart.Models.Category;
import com.Lab2.EzCart.WebServices.WebservicesProxy;

/**
 * Servlet implementation class Ajax_AddProduct
 */
@WebServlet("/Ajax_AddProduct")
public class Ajax_AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	WebservicesProxy proxy = new WebservicesProxy();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ajax_AddProduct() {
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
		String username = (String) session.getAttribute("userName");
		request.setAttribute("name",username);
		
		String category_name = (String)request.getParameter("category_list");
		String insert_product_name = (String)request.getParameter("insert_product_name");
		int insert_product_price = Integer.parseInt(request.getParameter("insert_product_price"));
		int insert_no_of_product = Integer.parseInt(request.getParameter("insert_no_of_product"));
		String insert_product_desc = (String)request.getParameter("insert_product_desc");
		
		/*System.out.println("category_list"+category_list);
		System.out.println("insert_product_name"+insert_product_name);
		System.out.println("insert_product_price"+insert_product_price);
		System.out.println("insert_no_of_product"+insert_no_of_product);
		System.out.println("insert_product_desc"+insert_product_desc);*/
		
		proxy.addProductWS(insert_product_name, insert_product_price, insert_no_of_product, insert_product_desc, category_name, username);
		
		try
		{
			Category[] category;			
				 
			category = proxy.getCategoryResultSet();
			
			request.setAttribute("categoryList", category);
		}
		catch(Exception e)
		{
			
		}
	}

}
