<!DOCTYPE html>

<html>
	<head>
		<title>MathSolver</title>
		<link rel='stylesheet' href='style.css' />
		<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
	</head>
	
	<body>
		<header>
			<h1 align="center">Prime Number</h1>
		</header>

		<div class="inputArea">
			<h2 align="center">Input Area</h2>
			<form class="formInput" action="Prime?method=all" method="post">
				<span> 
					<label>Please Enter the Number for All Prime Numbers</label> 
					<input type="text" name="allPrimeNumber" id="inputNumber1" value="">
				</span> 
				<input type="submit" class="button allPrimeButton" value="All">
			</form>

			<form class="formInput" action="Prime?method=check" method="post">
				<span> 
					<label>Check whether the Number is Prime or not</label> 
					<input type="text" name="checkPrimeNumber" id="inputNumber2" value="">
				</span> 
				<input type="submit" class="button IsPrimeButton" value="Check">
			</form>
		</div>

		<aside>
			<h2 align="center">Ouptut Area</h2>
			<textarea rows="5" columns="5">
				<% 	if(request.getAttribute("result")!=null)
					{ %>
						<%= request.getAttribute("result") %>
				<% 	}
				%>
			</textarea>
			<label id="error" class="clear-left"></label>
		</aside>
		
		
		<script>
		jQuery(document).ready( function()
		{
			
			function num_validate(num)
			{
				var number = /^([0-9])$/;  	
				if(num.match(number))  
			    {  
			  		return 0;
		      	}  
		      	else  
		      	{  		
					return 1;
				}
			};
			
			jQuery(".IsPrimeButton").click(function()
			{
				var number = jQuery("#inputNumber2").val();
				if(number=="")
				{
					jQuery("#error").text("Please enter Value");
					return false;
				}
				if(!isNaN(number))
				{
					  jQuery("#error").text("");
				}
				else
				{
					jQuery("#error").text("Please enter integer only");
					return false;
				}
			
			});
			
			jQuery(".allPrimeButton").click(function()
			{
				var number = jQuery("#inputNumber1").val();	
				if(number=="")
				{
					jQuery("#error").text("Please enter Value");
					return false;
				}
				
				if(!isNaN(number))
				{
					  jQuery("#error").text("");
				}
				else
				{
					jQuery("#error").text("Please enter integer only");
					return false;
				}
			
			});
		});
		</script>
				
	</body>
</html>