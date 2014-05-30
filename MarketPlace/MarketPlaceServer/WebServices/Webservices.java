package com.Lab2.EzCart.WebServices;

import java.sql.SQLException;

import javax.jws.WebService;

import com.Lab2.EzCart.DatabaseConnection.DatabaseConnection;
import com.Lab2.EzCart.Models.*;

@WebService
public class Webservices {
	DatabaseConnection db=new DatabaseConnection();
	
	public String signUpUser(String firstname, String lastname, String username, String password, String address, String email )
	{
		System.out.println("Inside Signup");
		String result;		
		
		/* This space is left for validation and manipulation of 
		input values entered by the user as a part of the server side validation */	
		
		result = db.SignUpUser(firstname,lastname,username,password,address,email);
		return result; //this value is returned to the calling servlet
	}
	
	public String loginUser(String username, String password)
	{
		System.out.println("Inside LoginUser");
		String result;		
		
		/* This space is left for validation and manipulation of 
		input values entered by the user as a part of the server side validation */	
		
		result = db.loginUser(username,password);
		return result; //this value is returned to the calling servlet
	}
	
	public Category[] getCategoryResultSet() throws SQLException
	{
		System.out.println("Inside fetchlog");
		int rowcount = 0;
		
		java.sql.ResultSet resultSetCategory;
		resultSetCategory = db.GetCategory();

		if(resultSetCategory != null)
		{
			try 
			{
				resultSetCategory.beforeFirst();
				resultSetCategory.last();
				rowcount = resultSetCategory.getRow();
				resultSetCategory.beforeFirst();
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}					
		}
				
		Category[] category = new Category[rowcount];
		int i = 0;
		
		while(resultSetCategory.next())
		{	
			Category c = new Category();			
			c.setCategory_id(resultSetCategory.getString("category_id"));
			c.setCategory_name(resultSetCategory.getString("category_name"));
			category[i] = c;
			i++;
		}		
		return category;		
	}
	
	public Products[] getProductsResultSet(String username) throws SQLException
	{
		System.out.println("Inside getProducts");
		int rowcount = 0;
		
		java.sql.ResultSet resultSetProducts;
		resultSetProducts = db.GetProducts(username);

		if(resultSetProducts != null)
		{
			try 
			{
				resultSetProducts.beforeFirst();
				resultSetProducts.last();
				rowcount = resultSetProducts.getRow();
				resultSetProducts.beforeFirst();
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
						
		}
				
		Products[] Products = new Products[rowcount];
		int i = 0;
		
		while(resultSetProducts.next())
		{	
			Products c = new Products();
			c.setProduct_id(resultSetProducts.getInt("product_id"));
			c.setProduct_name(resultSetProducts.getString("product_name"));
			c.setProduct_price(resultSetProducts.getInt("product_price"));
			c.setNo_of_product(resultSetProducts.getInt("no_of_product"));
			c.setProduct_desc(resultSetProducts.getString("product_desc"));
			c.setCategory_name(resultSetProducts.getString("category_name"));
			c.setSeller_name(resultSetProducts.getString("seller_name"));
			Products[i] = c;
			i++;
		}		
		return Products;		
	}
	
	public Products[] getParticularProductsResultSet(String category_name,String username) throws SQLException
	{
		System.out.println("Inside getProducts");
		int rowcount = 0;
		
		java.sql.ResultSet resultSetProducts;
		resultSetProducts = db.GetParticularProducts(category_name,username);

		if(resultSetProducts != null)
		{
			try 
			{
				resultSetProducts.beforeFirst();
				resultSetProducts.last();
				rowcount = resultSetProducts.getRow();
				resultSetProducts.beforeFirst();
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
						
		}
				
		Products[] Products = new Products[rowcount];
		int i = 0;
		
		while(resultSetProducts.next())
		{	
			Products c = new Products();
			c.setProduct_id(resultSetProducts.getInt("product_id"));
			c.setProduct_name(resultSetProducts.getString("product_name"));
			c.setProduct_price(resultSetProducts.getInt("product_price"));
			c.setNo_of_product(resultSetProducts.getInt("no_of_product"));
			c.setProduct_desc(resultSetProducts.getString("product_desc"));
			c.setCategory_name(resultSetProducts.getString("category_name"));
			c.setSeller_name(resultSetProducts.getString("seller_name"));
			Products[i] = c;
			i++;
		}		
		return Products;		
	}
	
	public String ajax_AddToCart(String username, String product_name, int product_count, int product_prize, String seller_name)
	{
		System.out.println("Inside AddToCart");
		String result;		
		
		result = db.AddToCart(username,product_name,product_count,product_prize,seller_name);
		return result; //this value is returned to the calling servlet
	}
	
	public DisplayCart[] ajax_DisplayCart(String username,String page) throws SQLException
	{
		System.out.println("Inside Ajax Display Cart");
		
		int rowcount = 0;
		
		java.sql.ResultSet resultSendToCart;
		resultSendToCart = db.displayCart(username,page);
		
		if(resultSendToCart != null)
		{
			try 
			{
				resultSendToCart.beforeFirst();
				resultSendToCart.last();
				rowcount = resultSendToCart.getRow();
				resultSendToCart.beforeFirst();
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
						
		}
				
		DisplayCart[] displayCart = new DisplayCart[rowcount];
		int i = 0;
		
		while(resultSendToCart.next())
		{	
			DisplayCart cart = new DisplayCart();
			cart.setCart_id(resultSendToCart.getInt("cart_id"));			
			cart.setUsername(resultSendToCart.getString("username"));
			cart.setProduct_name(resultSendToCart.getString("product_name"));	
			cart.setProduct_count(resultSendToCart.getInt("product_count"));
			cart.setProduct_prize(resultSendToCart.getInt("product_prize"));
			cart.setSeller_name(resultSendToCart.getString("seller_name"));
			displayCart[i] = cart;
			i++;
		}	
		//System.out.println(displayCart);
		return displayCart;
	}
	
	public DisplayCart[] displaySellProducts(String username) throws SQLException
	{
		System.out.println("Inside Ajax Display Cart");
		
		int rowcount = 0;
		
		java.sql.ResultSet resultSendToCart;
		resultSendToCart = db.displaySellProductsItems(username);
		
		if(resultSendToCart != null)
		{
			try 
			{
				resultSendToCart.beforeFirst();
				resultSendToCart.last();
				rowcount = resultSendToCart.getRow();
				resultSendToCart.beforeFirst();
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
						
		}
				
		DisplayCart[] displayCart = new DisplayCart[rowcount];
		int i = 0;
		
		while(resultSendToCart.next())
		{	
			DisplayCart cart = new DisplayCart();
			cart.setCart_id(resultSendToCart.getInt("cart_id"));			
			cart.setUsername(resultSendToCart.getString("username"));
			cart.setProduct_name(resultSendToCart.getString("product_name"));	
			cart.setProduct_count(resultSendToCart.getInt("product_count"));
			cart.setProduct_prize(resultSendToCart.getInt("product_prize"));
			cart.setSeller_name(resultSendToCart.getString("seller_name"));
			displayCart[i] = cart;
			i++;
		}	
		//System.out.println(displayCart);
		return displayCart;
	}
	
	public String deleteProductsFromCart(String username, String product_name,int product_count)
	{
		System.out.println("Inside deleteProductsFromCart");
		String result;		
		
		result = db.deleteProductsFromCart(username,product_name,product_count);
		return result; //this value is returned to the calling servlet
	}
	
	public String addToHistoryWS(String username)
	{
		System.out.println("Inside addToHistoryWS");
		String result;		
		
		result = db.addToHistory(username);
		return result; //this value is returned to the calling servlet
	}
	
	public void addProductWS(String product_name,int product_prize, int no_of_product, String product_desc,String category_name, String seller_name)
	{
		System.out.println("Inside addProductWS");
		
		db.addProduct(product_name,product_prize,no_of_product,product_desc,category_name,seller_name);
		
	}
	
}

