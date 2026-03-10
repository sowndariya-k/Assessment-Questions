package javaFundamentals;
import java.util.*;

public class Question5 {

	public static void AssignScore(int score[]) {
	    int newScore[] = new int[score.length];

	    for (int i=0; i<score.length; i++) {
	    	int max=-1;
	    	//even
	    	if (score[i] % 2 == 0)
	            max = Math.max(max, 0);
	    	
	    	//odd
	        if (score[i] % 2!=0)
	            max = Math.max(max, 1);
	            
	        //divisible by 8
	        if (score[i] % 8==0)
	            max = Math.max(max, 2);
	            
	        //last digit 3
	        if (score[i] % 10==3)
	            max = Math.max(max, 3);
	            
	        //divisible by 9
	        if (score[i] % 9==0)
	            max = Math.max(max, 4);
	        
	        newScore[i] = max;
	    	
	    }
	    System.out.print("Scores after processing: ");
	    for (int i=0; i<newScore.length; i++) {
	        System.out.print(newScore[i] + " ");
	    }
	}


    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);

        int[] score=new int[10];
        int count=0;

        System.out.println("Enter the scores (enter a negative number to stop input):");
        for (int i = 0; i < count; i++) {
            System.out.print(score[i] + " ");
        }
        System.out.println();
        while (true) {
            int value=input.nextInt();
            System.out.print(value+" ");
            //negative number break
            if (value<0)
                break;
            
            score[count++]=value;
        }


        System.out.print("Scores before processing: ");
        for (int i = 0; i < count; i++) {
            System.out.print(score[i] + " ");
        }

        System.out.println();
        AssignScore(Arrays.copyOf(score, count));

        input.close();
    }
}
