/* Validation */
var name_result = 1;
var pass_result = 1;
var repass_result = 1;
var email_result = 1;
var add_result = 1;
var lastname_result=1;
var firstname_result=1;


jQuery(document).ready( function()
{

	function email_validate(e)
	{
		var eid = /[A-Za-z0-9._%-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,4}/;
		if(e.match(eid))  
	      	{  
	      		return 0;
	      	}  
	      	else  
	      	{  		
			return 1;
		}
	}	
    
    function user_check(username)
    {
      var check = /[a-zA-Z]/;
      if(username.match(check))  
	      	{  
	      		return 0;
	      	}  
	      	else  
	      	{  		
			return 1;
		}
    }

	function test(str)
	{
		var re = /^[a-zA-Z0-9!@#$%^&*]{4,10}$/;
		if(str.match(re))  
	  	{  
	  		return 0;
	  	}  
	  	else  
	  	{  		
			return 1;
		}
	}

	jQuery("#username").blur(function() 
	{
		var user = jQuery("#username").val();
        if(user_check(user))
        { 
          
            jQuery("#username_error").text("Please Enter only alphabets"); 	
			name_result=1;
      	 	return false;
        }
		if(user=="")
		{
			name_result=1;
			jQuery("#username_error").text("Please Enter User Name");   
			return false;  
		}
		else	
		{
			name_result=0;
			jQuery("#username_error").text("");     
		}
	});
	
	jQuery("#firstname").blur(function() 
	{
		var user = jQuery("#firstname").val();
        if(user_check(user))
        { 
          
            jQuery("#firstname_error").text("Please Enter only alphabets"); 	
            firstname_result=1;
      	 	return false;
        }
		if(user=="")
		{
			firstname_result=1;
			jQuery("#firstname_error").text("Please Enter First Name");   
			return false;  
		}
		else	
		{
			firstname_result=0;
			jQuery("#firstname_error").text("");     
		}
	});
	
	jQuery("#lastname").blur(function() 
			{
				var user = jQuery("#lastname").val();
		        if(user_check(user))
		        { 
		          
		            jQuery("#lastname_error").text("Please Enter only alphabets"); 	
		            lastname_result=1;
		      	 	return false;
		        }
				if(user=="")
				{
					lastname_result=1;
					jQuery("#lastname_error").text("Please Enter First Name");   
					return false;  
				}
				else	
				{
					lastname_result=0;
					jQuery("#lastname_error").text("");     
				}
			});

	
	jQuery("#password").blur(function() 
	{

		var user = jQuery("#password").val();
		if(test(user))
       	{
       		jQuery("#password_error").text("Please Enter 4 to 10 characters"); 	
			pass_result=1;
      	 	return false;
  		}
		else
		{	
			if(user=="")
			{
				pass_result=1;
				jQuery("#password_error").text("Please Enter Password"); 
				return false;    
			}
			else	
			{
				pass_result=0;
				jQuery("#password_error").text("");     
			}
		}
	});
    
    jQuery("#re-password").blur(function() 
	{

		var user = jQuery("#re-password").val();
		if(test(user) )
       	{
       		jQuery("#re-password_error").text("Please Enter 4 to 10 characters"); 	
			repass_result=1;
      	 	return false;
  		}
		else
		{	
			if(user=="")
			{
				repass_result=1;
				jQuery("#re-password_error").text("Please Enter Password"); 
				return false;    
			}
			else	
			{
				repass_result=0;
				jQuery("#re-password_error").text("");     
			}
		}
	});
    
    jQuery("#address").blur(function() 
	{
		var user = jQuery("#address").val();	
		if(user=="")
		{
			address_result=1;
			jQuery("#address_error").text("Please Enter Address");   
			return false;  
		}
		else	
		{
			address_result=0;
			jQuery("#address_error").text("");     
		}
	});

    jQuery("#email").blur(function()
	{
		var e = jQuery("#email").val();	
		email_result = email_validate(e);
		
		if(email_result===0)  
	    {  
			jQuery("#email_error").text("");     
	    }  
	    else  
	    {  		
			jQuery("#email_error").text("Please Enter Valid ID");     
			return false;
		}
	});


	jQuery("#signup").click(function()
	{
		if(name_result==1 || pass_result==1 || firstname_result==1 || lastname_result==1 || address_result==1 || email_result==1)
		{
			jQuery("#form_error").text("Please fill the form correctly");     
			return false;
		}		
		
	});
});


