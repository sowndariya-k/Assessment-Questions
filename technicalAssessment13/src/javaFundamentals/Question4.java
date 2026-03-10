package javaFundamentals;

import java.util.*;

public class Question4 {
	
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.print("Enter the Starting Number: ");
		int start=input.nextInt();
		
		System.out.print("Enter the Ending Number: ");
		int end=input.nextInt();
		
		for(int i=start; i<=end; i++) {
			//divisible by 10 'dong'
			if(i%10==0) {
				System.out.print("dong ");
			}
			//divisible by 5 'ding'
			else if(i%5==0) {
				System.out.print("ding ");
			}
			else {
				System.out.print(i+" ");
			}
		}
		input.close();

}
}
