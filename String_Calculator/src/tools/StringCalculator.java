package tools;

import java.util.ArrayList;
import java.util.regex.Pattern;

import customException.NegativeNumberException;

public class StringCalculator {
	
	
	/* 	this will be the main ADD function that has been developed based on case 1-4 + Bonus case
	 *  junit test cases are available and the main class will call this ADD function as well 
	 * */
	@SuppressWarnings("finally")
	public static int add(String numbers)  {
		int result = 0;
		String[] splits;
		ArrayList<Integer> negNum = new ArrayList<Integer>();
				
		//check if data has a custom delimiter (case #3)
		if(numbers.startsWith("//")) {
			
			//get the delimiter
			String delimiter = numbers.substring(2, numbers.indexOf("\n")).trim();
			numbers = numbers.split("\n")[1];
			
			//check if delimiter is more than 1 (Bonus case)
			if(delimiter.contains(",")) {
				String[] delimiters = delimiter.split(",");
				
				//build newDelimiters for bonus case
			    String newDelimiters="";
			    
			    int i=0;
			    for (String string : delimiters) {
					newDelimiters += Pattern.quote(string);
					if(i!=0 || i<delimiters.length)
						newDelimiters += "|";
				} 
			   
				splits = numbers.split(newDelimiters);
			}else {
				splits = numbers.split(Pattern.quote(delimiter));  // use Pattern.quote() to ignore regex metacharacter
			}
		}
		//if numbers doesn't have custom delimiter, use default delimiter.
		else {
			//splits = numbers.split(",");  //split string based on , (case #1)
			splits = numbers.split("(\\n)?,(\\n)?");  //split string with , and optional \n (case #2)
		}
		
		for (String string : splits) {
			//remove whitespace in the beginning and end of string to mitigate potential issue
			int value = numberValue(string.trim());
			if(value<0)
				negNum.add(value);
			else
				if(value<=1000) //bonus case, ignore numbers larger than 1000
					result += value;
		}
		
		//check if number has negative values (case #4)
		if(negNum.isEmpty())
			return result; 
		else {
			try {
				createNegativeNumberException(negNum);
			} catch (NegativeNumberException e) {
				System.out.println(e.getMessage());
			} finally {
				return result;
			}
		}
	}
	

	public static void createNegativeNumberException(ArrayList<Integer> negNum) throws NegativeNumberException {
		String message = "Negatives not allowed :";
		for (Integer neg : negNum) {
			message += " "+neg;
		}
		throw new NegativeNumberException(message);
	}
		
	public static boolean isEmpty(String numbers) {
		//empty strings will return false
		if(null == numbers || numbers.isEmpty() || numbers.length()==0)
			return true;
				
		return false;	
	}
	
	public static int numberValue(String s) {
		if (s == null) 
	        return 0;
	    
		//init default value
		int i=0; 
		
		//parse to int
	    try {
	         i = Integer.parseInt(s);    
	    } catch (NumberFormatException ex) {
	    	ex.getMessage();
	    	return 0;
	    }
	    
	    return i;		
	}
	
}


