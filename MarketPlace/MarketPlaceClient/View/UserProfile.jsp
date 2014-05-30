<%@page import="com.Lab2.EzCart.Models.Category"%>
<%@page import="com.Lab2.EzCart.Models.Products"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>EzCart UserProfile Page</title>

	<link rel="stylesheet" href="/EzCartClient/stylesheets/style.css" type="text/css" >
	    <link rel="stylesheet" href="/EzCartClient/stylesheets/header.css" type="text/css" >
	    <link rel="stylesheet" href="/EzCartClient/stylesheets/footer.css" type="text/css" >
	    <link rel="stylesheet" href="/EzCartClient/stylesheets/bootstrap.css" type="text/css" >
	    <link rel="stylesheet" href="/EzCartClient/stylesheets/dropdown.css" type="text/css" >
	    <link rel="stylesheet" href="/EzCartClient/stylesheets/error.css" type="text/css" >
	    
	    <script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
	    <script src="/EzCartClient/Javascript/signup_error.js"></script>
	    
	    <script type="text/javascript">
			jQuery(document).ready(function()
			{			
			
				
	        	// Insert Products
	        	 
		        var temp = 0; 
	        	var temp1 = 0;
	        	var seller_name="";
	        	$('input[name="text[]"]').blur(function() 
	        	{    	        	
    				temp = $(this).val();
    				seller_name = $(this).attr("id");
    				
				});
	        
		        $(".add_to_cart").click(function () 
		        {     			
		        	$(".message_addToCart").empty();	        
		        	$('input[name="text[]"]').val('');
		        	
	        		if(temp==0)
	        		{	        			
	        			$(".message_addToCart").append("Enter the quantity");
	        			return false;
	        		}
	        		
		        	temp1 = temp;
 					temp=0;
		          	var ajax_url = "/EzCartClient/Ajax_AddToCart";				          	
				
		          	$.ajax({
		            	type: "POST",
		            	url:ajax_url,
		            	data: { 
		            		insert_product : $(this).attr("id"),
		            		input_no_of_products : temp1,
		            		seller_name : seller_name,
		            		product_prize : $('input[name="product_prize[]"]').attr("id")
		            	},
		            	success: function(output_string) 
		            	{			           	
		              		$(".message_addToCart").append("Successfully Added");	
		            	},
		            	error: function (error) {
                  			alert('Error');
              			}
		          	}); 
		    	});
	        	
	      	});
		</script>
</head>
<body>

	<div class="wrapper">
    		<header>
	      		<div class="header-top">
	        		<div class="container">
          				<div class="welcome_name pull-left">
            				<h3>Welcome <%= request.getAttribute("name")  %></h3>
            			</div>
          				<div class="pull-right">
            				<nav class="navbar clear-right pull-right">
              					<ul class="nav nav-pills">                <!-- Header NavBar -->
					                <li>
					                  	<a href="/EzCartClient/UserHomePage" title="home" class="active">Home</a>
					                </li>
					                <li>
					                  	<a href="/EzCartClient/AddProducts" title="addProducts" class="">Add Products</a>
					                </li>
                  					<li>
                  						<a href="/EzCartClient/History" title="My History" class="">My History</a>
                					</li>

				                  	<li>
				                    	<a href="/EzCartClient/Logout" title="logout" class="">Logout</a>
				                	</li>				                	
              					</ul>
            				</nav>
          				</div>
        			</div>
      			</div>

      			<div class="header-bottom">
        			<div class="container">
          				<div class="logo">        <!-- Header Logo and Search -->
            				<a href="/EzCartClient/UserHomePage" title="home" class="pull-left"><img src="/EzCartClient/Images/logo.jpg" alt="Logo" /></a>
            				<a href="/EzCartClient/UserHomePage" title="home" class="pull-left"><h1 class="clear-left">Cart</h1></a>
          				</div>

          				<div class="search pull-right">          				
          					<div class="shopping-cart pull-right nav nav-pills ">     
          						<form action="/EzCartClient/Ajax_DisplayCart" method="post" class="display_cart pull-right">     		
	                				<img src="/EzCartClient/Images/cart_icon.png" class="cart_image">
	                				
	                				<input type="submit" class="btn pull-right" name="view_cart" value="View cart"/>
	                			</form>
                				                				
                			</div>  
                			<label class="last_login">Last Login: <%= request.getAttribute("last_login") %></label>              
			           </div>
      				</div>
      			</div>
     
    		</header>
    		
    		<section class="adjust">
       			<article class="container ">
        			<nav class="products-menu">
        				<ul class="nav nav-list generic_category">
          					<li>          					
                				<a href='/EzCartClient/UserHomePage' class='active all'>
                  					ALL
                				</a>
	                		</li>
	                		<%  
							// retrieve your list from the request, with casting 
							Category[] list =  (Category[]) request.getAttribute("categoryList");	
							// print the information about every category of the list
							for(int i=0;i<list.length;i++) 
							{
							%>
			    				<li>
				    				<a href="/EzCartClient/ParticularCategory?Category_name=<%= list[i].getCategory_name() %>" class="<%= list[i].getCategory_name() %>"> <%= list[i].getCategory_name() %> </a>				    				
			    				</li>
			    				
			    				<% if(request.getAttribute("selectedCategory").equals(list[i].getCategory_name())) 
	                			{%>
	                				
	                				<script>
	                					$(".<%= request.getAttribute("selectedCategory") %>").addClass('active');
    									$(".all").removeClass('active');
    								</script>
	                			<% } %>
							<%}%>
	                	<!-- selectedCategory -->
          				</ul>
          			</nav>
          			
          			<div class="product_content pull-right">
        				<h3>Products
        					<span class="message_addToCart"></span>
        				</h3>
        				<div class="rows-container">        				
        					<% Products[] productsList =  (Products[]) request.getAttribute("productsList");
        					
        					if(request.getAttribute("Record") == "No")
        					{ %>
        						<p>No Record Found</p>
        					<% } 
        					else
        					{
	     						for(int i=0;i<productsList.length;i++) 
	     						{     								
									%>
	
	  									<div class="span3 pull-left">
	    									<p><strong>Name: </strong><%= productsList[i].getProduct_name() %></p>
	    									<p><strong>Price: </strong><%= productsList[i].getProduct_price() %>$</p>
	    									<p><strong>Details: </strong><%= productsList[i].getProduct_desc() %></p>
	    									<p><strong>Seller Name: </strong><%= productsList[i].getSeller_name() %></p>
	    									<% if(productsList[i].getNo_of_product() < 1) 
											{     								
												%>
												<p><strong>Out of Stock </strong></p>
	    									<% } 
	    									else
	    									{ 
	    										%>
	    										<p><strong>Available "<%= productsList[i].getNo_of_product() %>" </strong></p>                                   
	      										<form method="post" action="">	
	        										<input type="text" id="<%= productsList[i].getSeller_name() %>" class="input_no_of_products" name="text[]" value=""/>
							                    	<input type="button" class="btn add_to_cart" id="<%= productsList[i].getProduct_name() %>  <%= productsList[i].getProduct_price() %>" name="add_to_cart" value="Add To Cart"/>
							                    	<input type="hidden" id="<%= productsList[i].getProduct_price() %>" name="product_prize[]" class="product_prize">			                    
	      										</form>
	                        
	      										
	    									<% } %>
	  									</div>
									<% 
	        					}  
	        				}   %>
      					</div>
      				</div>
      				
          		</article>
          	</section> 
          	  		
    	
		<div class="push"></div>
		</div>

    	<div class="footer">
    		<footer>
      			<div class="container">
        			<p class="copyright">
          				Copyright 2014 for
          				<strong><a href="/UserHomePage" title="home" >EZCart.com</a></strong>
        			</p>

      			</div>
    		</footer>
		</div>

	
</body>
</html>