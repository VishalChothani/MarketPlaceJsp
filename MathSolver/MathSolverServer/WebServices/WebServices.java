package com.Lab2.MathSolver.WebServices;

import javax.jws.WebService;

@WebService
public class WebServices {

	public String checkPrime(int userInput) 
	{
		String finalResult;
		boolean flagIsPrime=true;
		for(int iteration1 = 2; iteration1 <= userInput/2 ; iteration1++)
		{
			if(userInput % iteration1 == 0)
	        {
	            flagIsPrime = false;
	        }
	    }
		if(flagIsPrime == true)
		{
			finalResult = userInput+" is prime";
		}
		else
		{
			finalResult = userInput+" is not prime";
		}			
		return finalResult;
	}
	
	public String primeSeries(int userInput) 
	{
		String finalResult = "";
		if(userInput>1 && userInput<1000)
		{
			for (int iteration1 = 2; iteration1<userInput; iteration1++) 
			{
				boolean flagAllPrime = true;
				for (int iteration2 = 2; iteration2 < iteration1; iteration2++) 
				{
					if (iteration1 % iteration2 == 0) 
					{
						flagAllPrime = false;
						break;
					}
				}
				if (flagAllPrime) 
				{			
					finalResult = finalResult + iteration1 + " ";
				}
			}
			finalResult = finalResult + "\nThese are the prime numbers";
		}
		else
		{
			finalResult = "\nEnter the number between 1 to 1000";
		}
		return finalResult;
	}
}
