package javaFundamentals;

import java.util.*;

public class Question2 {

	public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        
        //get three inputs
        System.out.print("Enter input1: ");
        int num1=input.nextInt();
        
        System.out.print("Enter input2: ");
        int num2=input.nextInt();
        
        System.out.print("Enter input3: ");
        int num3=input.nextInt();
        
        //extract digits
        //units
        int u1=num1%10;
        int u2=num2%10;
        int u3=num3%10;
        
        //tens
        int t1=(num1/10) %10;
        int t2=(num2/10) %10;
        int t3=(num3/10) %10;
        
        //hundred
        int h1=num1/100;
        int h2=num2/100;
        int h3=num3/100;
        
        //find smallest digit
        int units=Math.min(u1, Math.min(u2,  u3));
        int tens=Math.min(t1, Math.min(t2,  t3));
        int hundreds=Math.min(h1, Math.min(h2,  h3));
        
        //find the largest among all
        int maxDigit=0;
        int[] digits= {u1, u2, u3, t1, t2, t3, h1, h2, h3};
        
        for(int i=0; i<digits.length; i++) {
        	if(digits[i]>maxDigit) {
        		maxDigit=digits[i];
        	}
        }
        
        //create pin
        int pin=maxDigit*1000 + hundreds*100 + tens*10 + units;
        System.out.println("PIN = "+pin);
        input.close();
	}

}
