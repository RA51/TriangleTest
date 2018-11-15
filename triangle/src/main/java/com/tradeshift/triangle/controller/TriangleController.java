package com.tradeshift.triangle.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
 * The purpose of this application to find 
 * whether triagle is equilateral, isosceles or scalene while user 
 * enters the three sides of triangle.
 */
/**
 * @author Roshan Akhtar
 *
 */
public class TriangleController {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.println("===Please enter the sides of triangle===");
		List<Double> sides= null;
		boolean wantsMoreTriangle=true;
       do
		{
    	   /**
    		 *  this loop will continue untill user does not
    		 *  want to exit
    		 *
    		 */
			sides= new ArrayList<Double>();
			for(int i=0;sides.size()!=3;i++)
			{
				System.out.print("Enter  sides of triangle :: ");
				String side=scanner.next();
				if(!isValidSide(side))
			    {
			    	System.out.println("try again");
			    	continue;
			    }
				else
				{
					sides.add(Double.valueOf(side));
				}
			}
			System.out.println("Types of triangle is :" +getTriangleTypes(sides));
			System.out.println("Are you want to continue : (type y for continue and n for discontinue)");
			if(scanner.next().equalsIgnoreCase("y"))
			{
				wantsMoreTriangle= true;
			}
			else
				wantsMoreTriangle= false;
		}while(wantsMoreTriangle==true);
	}
	/**
	 *  method is for validate types of triangle
	 *  as well three sides are making triagle or not
	 *  
	 */
	public static String  getTriangleTypes(List<Double> sides)
	{
		String isTriangle="";
		/**
		 *  user is allowed to enter negative numbers
		 * 
		 * so convert into positive  numbers
		 */
		double firstSide= Math.abs(sides.get(0).doubleValue());
		double secondSide= Math.abs(sides.get(1).doubleValue());;
		double thirdSide= Math.abs(sides.get(2).doubleValue());
		
		if(firstSide+secondSide<=thirdSide || firstSide+thirdSide<=secondSide || secondSide+thirdSide<=firstSide)
		{
			isTriangle ="not a triangle"; 
		}
		else if(firstSide==0||secondSide==0||thirdSide==0)
		{
			isTriangle ="not a triangle"; 
		}
		else if(firstSide==secondSide && secondSide==thirdSide && firstSide ==thirdSide)
		{
			isTriangle ="equilateral";
		}
		else if(firstSide==secondSide || secondSide==thirdSide || firstSide ==thirdSide)
		{
			isTriangle ="isosceles";	
		}
		else
		{
			isTriangle ="scalene";
		}
		return isTriangle;
	}
	/**
	 *  method is for validate the sides of triangle is valid or not
	 *  else it would tell to user for re-enter the values
	 *
	 */
	public static boolean isValidSide(Object side)  
	{
		boolean isValidSide = true;
		 String sideStr= side.toString();
		 try{
			  
			  Double sideDouble= Double.parseDouble(sideStr);
		  }catch(NumberFormatException e)
		  {
			  System.out.println("Please enter numbers");
			  isValidSide = false;
		  }

		return isValidSide;
	}
	 
}
