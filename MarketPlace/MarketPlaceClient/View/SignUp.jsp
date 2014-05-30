<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
		<title>EzCart SignUp Page</title>
	
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
	            		<div class="pull-right">
				         	<nav class="navbar clear-right pull-right">
					           	<ul class="nav nav-pills">                <!-- Header NavBar -->
					                <li>
					                    <a href="/EzCartClient/HomePageLogin.jsp" title="Login" class="">Login</a>
					                </li>
					                <li>
					                    <a href="/EzCartClient/SignUp.jsp" title="Sign" class="active">Sign up</a>
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
	            		<h3>SignUp</h3>
	          		</nav>
	        	</div>
	    	</header>
	    	
	    	<section class="adjust">
      
      <form class="container form-horizontal" action="SignUp" method="post">
        
        
         <div class="control-group signup">
          <label class="control-label" >First name*</label>
          <div class="controls">
            <input type="text" id="firstname" placeholder="firstname" name="firstname" value="">
          </div>
          
          <label id="firstname_error"></label>
        </div>
        
         <div class="control-group signup">
          <label class="control-label" >Last name*</label>
          <div class="controls">
            <input type="text" id="lastname" placeholder="lastname" name="lastname" value="">
          </div>
          
          <label id="lastname_error"></label>
        </div>
        
        <div class="control-group signup">
          <label class="control-label" >Username*</label>
          <div class="controls">
            <input type="text" id="username" placeholder="username" name="username" value="">
          </div>
          
          <label id="username_error"></label>
        </div>
        
        
        <div class="control-group signup">
          <label class="control-label" for="inputPassword">Password*</label>
          <div class="controls">
            <input type="password" id="password" name="password" placeholder="Password"  value="">
          </div>
          <label id="password_error"></label>
        </div>
        
        <div class="control-group signup">
          <label class="control-label" name="address">Address*</label>
          <div class="controls">
            <input type="text" id="address" name="address" placeholder="Address"  value="" >
          </div>
          <label id="address_error"></label>
        </div>
        
        <div class="control-group signup">
          <label class="control-label" for="inputEmail">Email*</label>
          <div class="controls">
            <input type="text" id="email" name="email" placeholder="Email"  value="" >
          </div>
          <label id="email_error"></label>
        </div>

        <span class="username_present"></span>


        <div class="control-group signup">
          <div class="controls">
            <button type="submit" class="btn" name="signup" id="signup">Sign up</button>
            <label id="form_error">
            	<% 	if(request.getAttribute("error")!=null)
					{ %>
						<%= request.getAttribute("error") %>
				<% 	}
				%>
            </label>
          </div>
        </div>              
      
      
      </form>
          
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
	</body>
</html>