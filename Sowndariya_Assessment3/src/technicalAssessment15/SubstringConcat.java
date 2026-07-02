package technicalAssessment15;

import java.util.Scanner;

public class SubstringConcat {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("Enter the String:");
		String str=input.nextLine();
		
		String result="";
		
		//check the length>=2
		if(str.length()>=2) {
			result=str.substring(0,2);
		}//length==1
		else if(str.length()==1) {
			result=str.concat("@");
		}//length==0
		else {
			result="@@";
		}
		System.out.println("String after concat:");
		System.out.println(result);
		input.close();
	}

}
