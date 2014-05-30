<%@page import="com.Lab2.EzCart.Models.Category"%>
<!DOCTYPE html>

<html>
  	<head>
    	<title>Ez Shopping Cart Admin Page</title>


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
			
			
		    	/* =========================== Insert Product ======================== */
		    	
		    	var name_result = 1;
				var price_result = 1;
				var no_result = 1;
				var desc_result = 1;

		    	jQuery("#insert_product").click( function()
        		{
            
            		/* ------------- Name ------------------ */
		            var name = jQuery("#insert_product_name").val();
		            if(name=="")
		            {
		               name_result=1;		               
		            }
		            else
		            {
		               name_result=0;     		               
		            }
		            
		            /* ---------------- Prize ------------------ */
		            var price = jQuery("#insert_product_price").val();
		            if(price=="")
		            {
		               price_result=1;		               
		            }
		            else
		            {
		               price_result=0;		               
		            }
		            
		            
		            /* ---------------- No of products ------------------ */
		            var no = jQuery("#insert_no_of_product").val();
		            if(no=="")
		            {
		               no_result=1;		               
		            }
		            else
		            {
		               no_result=0;     		               
		            }
		            
		             /* ---------------- Products Desc ------------------ */
		            var desc = jQuery("#insert_product_desc").val();
		            if(desc=="")
		            {
		               desc_result=1;		               
		            }
		            else
		            {
		             	desc_result=0;		                
		            }
		            
		            
		            if(name_result==1 || price_result==1 || no_result==1 || desc_result==1 )
		            {
		                
		                jQuery("#insert_product_error").text("Please complete the form");
		                return false;
		            }
		            else
		            {		                
		                jQuery("#insert_product_error").text("");		                
		            }
		            
		          	var ajax_url = "/EzCartClient/Ajax_AddProduct";		

		          	 $.ajax({
		            	type: "POST",
		            	url:ajax_url,
		            	data: {
		            		category_list : $(".category_list_product").val(),
				          	insert_product_name : $("#insert_product_name").val(),
				          	insert_product_price : $("#insert_product_price").val(),
				          	insert_no_of_product : $("#insert_no_of_product").val(),
				          	insert_product_desc : $("#insert_product_desc").val()
		            	},		            			            	
		            	success: function(output_string) 
		            	{			           	
		              		jQuery("#insert_product_error").text("Product is Successfully Added");	
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
					                  	<a href="/EzCartClient/UserHomePage" title="home" class="">Home</a>
					                </li>
					                <li>
					                  	<a href="/EzCartClient/AddProducts" title="addProducts" class="active">Add Products</a>
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
    		
    		<section class="adjust">
       			<article class="container ">
        			<div class="span10 clear-left pull-left">
          				<div class="tabbable tabs-left pull-left">
	            			<ul class="nav nav-tabs admin_sidebar">
	              				<li id="2" ><a href="#lB" data-toggle="tab">Add Product</a></li>
	                       	</ul>
	                    </div>
                	
	                	
	                	<div class="tab-content">	  
	                	   
	                	
	                			<!---add product-->
      					<div class="pull-left" id="lB">
        					<div class="form-horizontal" >
        					
          						<div class="select_category">
          							<div class="control-group">
            							<label class="control-label">Select Category</label>
            							<div class="controls">            							
              								<select name="category_list_product" class="category_list_product">
              									<%  
													// retrieve your list from the request, with casting 
													Category[] list =  (Category[]) request.getAttribute("categoryList");	
													// print the information about every category of the list
													for(int i=0;i<list.length;i++) 
													{ %>
              											<option value="<%= list[i].getCategory_name() %>"><%= list[i].getCategory_name() %></option>
              									<% } %>
              								</select>
            							</div>
          							</div>                   
            					</div>
            					
          						<div class="enable_product">
          							<div class="control-group">
            							<label class="control-label">Name</label>
            							<div class="controls">
              								<input type="text" id="insert_product_name" name="insert_product_name" placeholder="Product Name">
            							</div>
          							</div>
          						</div>
          							          						
          						<div class="control-group">
            						<label class="control-label">Price</label>
            						<div class="controls">
              							<input type="text" id="insert_product_price" name="insert_product_price" placeholder="Product Price">
            						</div>
          						</div>

          						<div class="control-group">
            						<label class="control-label">No of Products</label>
            						<div class="controls">
              							<input type="text" id="insert_no_of_product" name="insert_no_of_product" placeholder="Product Count">
            						</div>
          						</div>

                            	<div class="control-group">
            						<label class="control-label">Products Description</label>
            						<div class="controls">
              							<input type="text" id="insert_product_desc" name="insert_product_desc" placeholder="Products Description">
            						</div>

          						</div>
          						
              					<div class="control-group">
            						<div class="controls">
              							<input type="submit" id="insert_product" name="insert_product" value="Add">
            							<label id="insert_product_error"></label>              							
            						</div>
          						</div>          						
          					</div>          					
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
	          				<strong><a href="" title="home" >EZCart.com</a></strong>
	        			</p>	
	      			</div>
	    		</footer>
			</div>
		</div>
  	</body>
</html>