package Priority;

import java.util.Scanner;

public class Test {
	static void UpDown() {
	    Scanner Q = new Scanner(System.in);
	    int random = (int)(Math.random() * 30) + 1;
	    int input;
	    int game_cnt = 1;
	    int wingold = 100;
	    System.out.println("Up & Down Start!");
	    System.out.println("1 ~ 30");
	    while(game_cnt <= 5) {
	       System.out.print("Input Number : ");
	       input = Q.nextInt();
	       
	       if(input < random) {
	    	   System.out.println("Up!");
	       }
	       else if(input > random) {
	    	   System.out.println("Down!");
	       }
	       else {
	          System.out.println("Success in " + (game_cnt));
	          System.out.println("Prize Gold : " + wingold);
	          if(game_cnt <= 5)
	          break;
	       }  
	       game_cnt++;
	    }
	    if(game_cnt == 6) {
	    	System.out.println();
		    System.out.println("Fail");
		    System.out.println("Right Answer : " + random);
	    }
	 }
	public static void main(String[] args) {
		UpDown();
	}

}
