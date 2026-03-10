package javaFundamentals;

import java.util.*;
public class Question1 {
	
	public static int digitSum(int num) {
		//last digit then add
		int sum = 0;
		while (num > 0) {
			sum += num % 10;
			num /= 10;
		}
		
		return sum;
	}
	
	
	public static void main(String[] args) {
		/*Scanner input = new Scanner(System.in);
		 
		System.out.print("No of Participants: ");
		int n = input.nextInt();
		int[] tokens = new int[n];
		 
		System.out.println("Enter token numbers:");
		for (int i=0; i<n; i++) {
			tokens[i] = input.nextInt();
		 }*/
		
		 int[] tokens = {1234, 2345, 3456, 4567, 7891, 1000, 1200, 9999, 7777, 1224};
	        int n = tokens.length;
	        
		 
		 
		int first = -1, second = -1, third = -1;
		for (int i = 0; i < n; i++) {
			int sum = digitSum(tokens[i]);
			
			//first prize condition sum of digits=7 and not yet wining 
			//if multiple sum with same value only take the first as win other values ignored 
			if (sum==7 && first==-1) {
				 first = tokens[i];
			}
			//second prize condition, sum of digits=5 and not yet wining 
			else if (sum==5 && second==-1) {
				 second = tokens[i];
			}
			//third prize condition, sum of digits=3 and not yet wining
		    else if (sum==3 && third==-1) {
		         third = tokens[i];
		    }
		}
		 
		//selected for first then token changed . 
		if (first!=-1)
			System.out.println("First Prize is to token: " +first);
		else
		    System.out.println("First Prize: Not found");

		if (second!=-1)
		    System.out.println("Second Prize is to token: " +second);
		else
		    System.out.println("Second Prize: Not found");

		if (third!=-1)
		    System.out.println("Third Prize is to token: " +third);
		else
		    System.out.println("Third Prize: Not found");

		 //input.close();
	}

}
