<%@page import="com.Lab2.EzCart.Models.DisplayCart"%>

<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>EzCart ViewCart Page</title>
	
		<link rel="stylesheet" href="/EzCartClient/stylesheets/style.css" type="text/css" >
	    <link rel="stylesheet" href="/EzCartClient/stylesheets/header.css" type="text/css" >
	    <link rel="stylesheet" href="/EzCartClient/stylesheets/footer.css" type="text/css" >
	    <link rel="stylesheet" href="/EzCartClient/stylesheets/bootstrap.css" type="text/css" >
	    <link rel="stylesheet" href="/EzCartClient/stylesheets/dropdown.css" type="text/css" >
	    <link rel="stylesheet" href="/EzCartClient/stylesheets/error.css" type="text/css" >
	    
	    <script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
	    <script src="/EzCartClient/Javascript/signup_error.js"></script>
	    
	    
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
          				          				
      				</div>
      			</div>
     
    		</header>

    		<section class="adjust container">
    			<% DisplayCart[] displayCart =  (DisplayCart[]) request.getAttribute("displayCart");
        		if(request.getAttribute("Record") == "No")
        		{ %>
        			<p>No Record Found</p>
        		<% }
        		else
        		{ %>
        			<form class="container form-horizontal" action="" method="post">
          				<table class="table table-striped">          				
          					<thead>
            					<tr>            					
              						<th>Product Name</th>
              						<th>Seller Name</th>
					            	<th>Product Count</th>
						            <th>Price</th>
						            <th>Amount</th>
						            <th></th>
            					</tr>
          					</thead>
          					
          					<tbody>
          					
          					<%	for(int i=0;i<displayCart.length;i++) 	     					
          						{ %>
          							<tr>
          							<th><%= displayCart[i].getProduct_name() %></th>
          							<th><%= displayCart[i].getSeller_name() %></th>
          							<th><%= displayCart[i].getProduct_count() %></th>
          							<th><%= displayCart[i].getProduct_prize() %></th>
          							<th><%= displayCart[i].getProduct_count() * displayCart[i].getProduct_prize()  %></th>
          							<th><a href="/EzCartClient/DeleteFromCart?product_name=<%= displayCart[i].getProduct_name()%>&count=<%=displayCart[i].getProduct_count()%>" id="<%= displayCart[i].getProduct_name() %>">Delete</th>
          							</tr>
          						<% } %>
          					
                       	</tbody>                       	
                       	
                       	<tfoot>
                         	<td></td>
                         	<td></td>
                         	<td></td>
                         	<td class="bold">Total</td>
                         	<td class="bold total"></td>
                         	<td></td>
                         </tfoot>
                         
                         <% 
                       		int total=0;
                       		for(int i=0;i<displayCart.length;i++) 	     					
          					{ 
          						total = total + displayCart[i].getProduct_count() * displayCart[i].getProduct_prize();
          						
          					} 
          				%>
      					<script>
      						jQuery(".total").text(<%= total %>);
      					</script>
      					
    				</table>
    				
    				<a href="/EzCartClient/UserHomePage" title="Shop More" class="pull-left more_shop"><h4 class="clear-left">Wanna Shop more?</h4></a>
	    			<a href="/EzCartClient/Checkout" title="Checkout" class="pull-right more_shop"><h4 class="clear-left">CheckOut</h4></a>
    				
           		</form>
           		<% } %>
           		
    		</section>
    		
    		
    		
			<div class="push">
			</div>
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



