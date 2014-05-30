<%@page import="com.Lab2.EzCart.Models.DisplayCart"%>

<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>EzCart History Page</title>
	
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
					                  	<a href="/EzCartClient/UserHomePage" title="home" class="">Home</a>
					                </li>
					                <li>
					                  	<a href="/EzCartClient/AddProducts" title="addProducts" class="">Add Products</a>
					                </li>
                  					<li>
                  						<a href="/EzCartClient/History" title="My History" class="active">My History</a>
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
      			
      			<div class="container ">
          			<nav id="dropdown_nav">
            			<h3>Purchased</h3>
          			</nav>
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
        			<form class="container form-horizontal" action="/EzCartClient/Successful" method="post">
          				<table class="table table-striped">          				
          					<thead>
            					<tr>            					
              						<th>Product Name</th>
              						<th>Seller Name</th>
					            	<th>Product Count</th>
						            <th>Price</th>
						            <th>Amount</th>
						            
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
          							</tr>
          						<% } %>
          					
                       	</tbody>                       	
                       	
                       	<tfoot>
                         	<td></td>
                         	<td></td>
                         	<td></td>
                         	<td class="bold">Total</td>
                         	<td class="bold total1"></td>                         	
                         </tfoot>
                         
                         <% 
                       		int total1=0;
                       		for(int i=0;i<displayCart.length;i++) 	     					
          					{ 
          						total1 = total1 + displayCart[i].getProduct_count() * displayCart[i].getProduct_prize();
          						
          					} 
          				%>
      					<script>
      						jQuery(".total1").text(<%= total1 %>);
      					</script>
      					
    				</table>
    							
           		</form>
           		<% } %>
           		
    		</section>
    		
    		<div class="container ">
          			<nav id="dropdown_nav">
            			<h3>Sold</h3>
          			</nav>
        		</div>
    		
    		<section class="adjust container">
    			<% DisplayCart[] displayCartSell =  (DisplayCart[]) request.getAttribute("displayCartSell");
        		if(request.getAttribute("RecordSell") == "No")
        		{ %>
        			<p>No Record Found</p>
        		<% }
        		else
        		{ %>
        			<form class="container form-horizontal" action="/EzCartClient/Successful" method="post">
          				<table class="table table-striped">          				
          					<thead>
            					<tr>            					
              						<th>Product Name</th>
              						<th>Buyer Name</th>
					            	<th>Product Count</th>
						            <th>Price</th>
						            <th>Amount</th>
						            
            					</tr>
          					</thead>
          					
          					<tbody>
          					
          					<%	for(int i=0;i<displayCartSell.length;i++) 	     					
          						{ %>
          							<tr>
          							<th><%= displayCartSell[i].getProduct_name() %></th>
          							<th><%= displayCartSell[i].getUsername() %></th>
          							<th><%= displayCartSell[i].getProduct_count() %></th>
          							<th><%= displayCartSell[i].getProduct_prize() %></th>
          							<th><%= displayCartSell[i].getProduct_count() * displayCartSell[i].getProduct_prize()  %></th>
          							</tr>
          						<% } %>
          					
                       	</tbody>                       	
                       	
                       	<tfoot>
                         	<td></td>
                         	<td></td>
                         	<td></td>
                         	<td class="bold">Total</td>
                         	<td class="bold total"></td>                         	
                         </tfoot>
                         
                         <% 
                       		int total=0;
                       		for(int i=0;i<displayCartSell.length;i++) 	     					
          					{ 
          						total = total + displayCartSell[i].getProduct_count() * displayCartSell[i].getProduct_prize();
          						
          					} 
          				%>
      					<script>
      						jQuery(".total").text(<%= total %>);
      					</script>
      					
    				</table>
    							
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



