<!DOCTYPE html>

<html>
  	<head>
    	<title>Ez Shopping Cart Login Page</title>

	    <link rel="stylesheet" href="/EzCartClient/stylesheets/style.css" type="text/css" >
	    <link rel="stylesheet" href="/EzCartClient/stylesheets/header.css" type="text/css" >
	    <link rel="stylesheet" href="/EzCartClient/stylesheets/footer.css" type="text/css" >
	    <link rel="stylesheet" href="/EzCartClient/stylesheets/bootstrap.css" type="text/css" >
	    <link rel="stylesheet" href="/EzCartClient/stylesheets/dropdown.css" type="text/css" >
	    <link rel="stylesheet" href="/EzCartClient/stylesheets/error.css" type="text/css" >
  	</head>
  
  	<body>
    	<div class="wrapper">
      		<header>
        		<div class="header-top">
          			<div class="container">
            			<div class="pull-right">
              				<nav class="navbar clear-right pull-right">
              					<ul class="nav nav-pills">                <!-- Header NavBar -->
                					<li>
                    					<a href="/EzCartClient/HomePageLogin.jsp" title="Login" class="active">Login</a>
                					</li>
                					
					                <li>
					                    <a href="/EzCartClient/SignUp.jsp" title="Sign" class="">Sign up</a>
					                </li>

                				</ul>
              				</nav>
           				</div>
         			</div>
      			</div>
        
      			<div class="header-bottom">
        			<div class="container">
          				<div class="logo">        <!-- Header Logo and Search -->
            				<a href="" title="home" class="pull-left"><img src="/EzCartClient/Images/logo.jpg" alt="Logo" /></a>
            				<a href="" title="home" class="pull-left"><h1 class="clear-left">Cart</h1></a>
          				</div>         
        			</div>
      			</div>
      			
      			<div class="container ">
          			<nav id="dropdown_nav">
            			<h3>Login</h3>
          			</nav>
        		</div>
    		</header>

    		<section class="adjust">
      
	      		<form class="container form-horizontal" action="UserHomePage" method="post">
	        		<div class="control-group">
	          			<label class="control-label" for="inputEmail">Username</label>
	          			<div class="controls">
	            			<input type="text" id="username" name="username" placeholder="Username" value="">
	          			</div>
					</div>
	        
	        		<div class="control-group">
	          			<label class="control-label" for="inputPassword">Password</label>
	          			<div class="controls">
	            			<input type="password" id="password" name="password" placeholder="Password" value="">
	          			</div>
	        		</div>
	        		
	        		<div class="control-group">
	          			<div class="controls">
	              			<label class="">Not a member? 
	              				<a href="/EzCartClient/SignUp.jsp" title="forget-password">Sign Up</a> to register
	            			</label>
	            			<button type="submit" class="btn" >Sign in</button>
	          			</div>
						<span class="wrong_credential">
							<% 	if(request.getAttribute("wrong_credential")!=null)
							{ %>
									<%= request.getAttribute("wrong_credential") %>
							<% 	}
							%>
						</span>
	        		</div>
	        		
	      		</form>
	      		
	      		
	    	</section>
    	
			<div class="push">
			</div>
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
  	</body>
</html>