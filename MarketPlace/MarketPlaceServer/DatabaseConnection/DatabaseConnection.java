package com.Lab2.EzCart.DatabaseConnection;

import java.sql.*;
import java.util.Date;

public class DatabaseConnection 
{
	Connection con = null;
	static ResultSet rs;
    Statement stmt = null;
	
	public DatabaseConnection(){		
		try {			
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/EzCart","root","");
				stmt = con.createStatement();
				if(!con.isClosed())
					System.out.println("Successfully Connected!!!");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}		

	public String SignUpUser(String firstname, String lastname, String username, String password, String address, String email )
	{
		Date date = new Date();
		String last_login = date.toString();
		String result = "";
		
		int rowcount;
		try 
		{	
			String querySelect = "select username from users where username='"+username+"'";
			ResultSet rs=stmt.executeQuery(querySelect);
			
			if(!rs.next() ) 
			{    
				 				
				String query = "INSERT INTO users(firstname,lastname,username,password,address,email,last_login) values('"+firstname+"','"+lastname+"','"+username+"','"+password+"','"+address+"','"+email+"','"+last_login+"')";
				rowcount=stmt.executeUpdate(query);
				if(rowcount > 0)
				{
					result="true";
					System.out.println("Insert Successful");					
				}
				else
				{
					result="false: The data could not be inserted in the database.";
				}
			}
			else
			{
				result="Username Already Present";
			}
		} 
		catch (SQLException e) 
		{			
			e.printStackTrace();
		}
		return result;
	}
	
	
	
	public String loginUser(String username, String password)
	{
		Date date = new Date();
		String last_login = date.toString();
		String result = "";
		
		int rowcount;
		try 
		{	
			String querySelect = "select username,last_login from users where username='"+username+"' and password='"+password+"'";
			ResultSet rs=stmt.executeQuery(querySelect);
			
			if(rs.next()) 
			{    
				String last_loginRetrieve = rs.getString("last_login");			
				String query = "Update users set last_login='"+last_login+"' where username='"+username+"'";
				rowcount=stmt.executeUpdate(query);
				if(rowcount > 0)
				{					
					result=last_loginRetrieve;
					System.out.println("Updated Successful");					
				}
				else
				{
					result="false: The data could not be inserted in the database.";
				}
			}
			else
			{
				result="Wrong Credential";
			}
		} 
		catch (SQLException e) 
		{			
			e.printStackTrace();
		}
		return result;
	}
	
	public ResultSet GetCategory()
	{				
		ResultSet resultSetCategory = null;		
		try 
		{	
			String sqlGetCategory = "select category_id,category_name from category;";
			resultSetCategory = stmt.executeQuery(sqlGetCategory);									
		} 
		catch (SQLException e) 
		{			
			e.printStackTrace();
		}		
		return resultSetCategory;
	}
	
	public ResultSet GetParticularProducts(String category_name,String username)
	{		
		ResultSet resultSetGetParticularProducts = null;		
		try 
		{	
			String sqlGetParticularProducts = "select * from product where category_name='"+category_name+"' and seller_name!='"+username+"';";
			resultSetGetParticularProducts = stmt.executeQuery(sqlGetParticularProducts);									
		} 
		catch (SQLException e) 
		{			
			e.printStackTrace();
		}		
		return resultSetGetParticularProducts;
	}
	
	public ResultSet GetProducts(String username)
	{		
		ResultSet resultSetGetProducts = null;		
		try 
		{	
			String sqlGetProducts = "select * from product where product_id not in (select product_id from product where seller_name='"+username+"');";
			resultSetGetProducts = stmt.executeQuery(sqlGetProducts);									
		} 
		catch (SQLException e) 
		{			
			e.printStackTrace();
		}		
		return resultSetGetProducts;
	}
	
	public String AddToCart(String username, String product_name, int product_count, int product_prize, String seller_name )
	{		
		System.out.println(seller_name+"inside database connection ADD to Cart"+product_name);
		String result = "";
				
		try 
		{	
			String querySelect = "select product_price,no_of_product from product where product_name='"+product_name+"' and seller_name='"+seller_name+"'";
			ResultSet rs=stmt.executeQuery(querySelect);
			//System.out.println("rs.getString-no_of_product"+rs.getString("no_of_product"));
			if(rs.next()) 
			{    
				System.out.println("1");
				int New_no_of_product = Integer.parseInt(rs.getString("no_of_product")) - product_count;
				System.out.println("2");
				String sqlUpdate = "Update product set no_of_product='"+New_no_of_product+"' where product_name='"+product_name+"' and seller_name='"+seller_name+"'";
				stmt.execute(sqlUpdate);
				System.out.println("3");
				System.out.println("Product_name :- "+product_name);
				System.out.println("seller_name :- "+seller_name);
				System.out.println("username :- "+username);
				String sqlCheck = "select * from cart where product_name='"+product_name+"' and seller_name='"+seller_name+"' and username='"+username+"' and order_status=0";
				ResultSet rsInfoFromCart = stmt.executeQuery(sqlCheck);
				
				if(rsInfoFromCart.next()) 
				{
					System.out.println("5");
					int new_product_count = Integer.parseInt(rsInfoFromCart.getString("product_count")) + product_count;
					System.out.println("6");
					String sqlUpdateCart1 = "Update cart set product_count='"+new_product_count+"' where username='"+username+"' and product_name='"+product_name+"'";					
					stmt.executeUpdate(sqlUpdateCart1);
					
				}
				else
				{
					System.out.println("4");
					String query = "INSERT INTO cart(username,product_name,product_count,product_prize,seller_name,order_status) values('"+username+"','"+product_name+"','"+product_count+"','"+product_prize+"','"+seller_name+"',0)";
					stmt.executeUpdate(query);
				}
				result="true";
			}
			else
			{
				result="false";
			}
		} 
		catch (SQLException e) 
		{			
			e.printStackTrace();
		}
		System.out.println("Result:- "+result);
		return result;
	}
	
	public ResultSet displayCart(String username, String page)
	{
		System.out.println("CART/HISToRY"+page);
		int order_status = 0;
		if(page.contains("cart"))
		{
			System.out.println("InsideCart");
			order_status = 0;
		}
		else
		{
			System.out.println("History");
			order_status = 1;
		}
		System.out.println("order_status"+order_status);
		
		System.out.println("inside database connection Display Cart");		
		ResultSet result = null;
		try
		{
			String querySelect = "select * from cart where username='"+username+"' and order_status='"+order_status+"'";
			result = stmt.executeQuery(querySelect);
		}
		catch (SQLException e) 
		{			
			e.printStackTrace();
		}
		return result; 
	}
	
	public ResultSet displaySellProductsItems(String username)
	{
		int order_status = 1;
		System.out.println("inside database connection displaySellProductsItems");		
		ResultSet result = null;
		try
		{
			String querySelect = "select * from cart where seller_name='"+username+"' and order_status='"+order_status+"'";
			result = stmt.executeQuery(querySelect);
		}
		catch (SQLException e) 
		{			
			e.printStackTrace();
		}
		return result; 
	}
	
	public String deleteProductsFromCart(String username,String product_name,int product_count)
	{
		System.out.println("inside database connection Delee from Cart");
		String result = "";
		
		try 
		{	
			String queryDelete = "delete from cart where username='"+username+"' and product_name='"+product_name+"'";
			stmt.execute(queryDelete);
			
			String sqlCheck = "select no_of_product from product where product_name='"+product_name+"'";
			ResultSet rsInfoFromProducts = stmt.executeQuery(sqlCheck);
			
			if(rsInfoFromProducts.next()) 
			{    				
				int New_no_of_product = Integer.parseInt(rsInfoFromProducts.getString("no_of_product")) + product_count;
				String sqlUpdateCart1 = "Update cart set product_count='"+New_no_of_product+"' where username='"+username+"' and product_name='"+product_name+"'";					
				stmt.executeUpdate(sqlUpdateCart1);
			}
			
			
		}
		catch (SQLException e) 
		{			
			e.printStackTrace();
		}
		return result; 
	}
	
	public String addToHistory(String username)
	{
		System.out.println("inside database connection addToHistory");
		String result = "";
		int order_status = 1;		
		try 
		{	
			String sqlUpdate = "Update cart set order_status='"+order_status+"' where username='"+username+"'";
			stmt.execute(sqlUpdate);
		}
		
		catch (SQLException e) 
		{			
			e.printStackTrace();
		}
		return result; 
	}

	public void addProduct(String product_name, int product_prize,int no_of_product, String product_desc, String category_name,String seller_name) 
	{
		// TODO Auto-generated method stub
		System.out.println("inside database connection addProduct");
		try 
		{	
			String sqladdProduct = "INSERT INTO product(product_name,product_price,no_of_product,product_desc,category_name,seller_name) values('"+product_name+"','"+product_prize+"','"+no_of_product+"','"+product_desc+"','"+category_name+"','"+seller_name+"')";
			stmt.execute(sqladdProduct);
		}
		
		catch (SQLException e) 
		{			
			e.printStackTrace();
		}
	}
}
