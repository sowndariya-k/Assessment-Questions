package javaFundamentals;

import java.util.*;

public class Question3 {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.print("Enter a positive integer: ");
		int num=input.nextInt();
		System.out.println(num);
		
		//calculate perfect number 
		int sum=0;
	    if (num>0) {
	    	for (int i=1; i<=num/2; i++) {
		        if (num % i == 0) {
		        	sum += i;
		        }
		     }
		}

		
		if(sum==num) {
			System.out.println("The given number is perfect");
		}
		else {
			System.out.println("The given number is not perfect");
		}
		
		input.close();
	}

}
