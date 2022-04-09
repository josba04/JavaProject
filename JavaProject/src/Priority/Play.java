package Priority;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Comparator;


public class Play {
	static int total = 0;
	static int Ctotal = 0;
	static int Ptotal = 0;
	static int TotalGold = 0;
	static int Pbetting = 0;
	static int Cbetting = 0;
	static int PGold = 0;
	/*
	 * static void FirstWho(int Pchoice, int Cchoice) { if(Pchoice <= Cchoice) {
	 * System.out.print("Player First"); } else if(Cchoice < Pchoice) {
	 * System.out.println("Computer First!"); }
	 * 
	 * }
	 */

 static void ShowPrint(ArrayList<Integer> totalList) {
	System.out.print("Total : ");
	for(int i = 0; i < totalList.size(); i++) {
		System.out.print(totalList.get(i) + "  ");
	}
}
 static void TotalSum(ArrayList<Integer> totalList) {
	 total = 0;
	 for(int i = 0; i < totalList.size(); i++) {
			total += totalList.get(i);
		}
		
		//System.out.println("Total : " + total);
	
 }
 static void Winner(int ctotal, int ptotal, int giveup ) {
	 if(giveup == 0) {
		 System.out.print("Give up - Computer Win");
	 }
	 else 
		 if(ctotal > ptotal)
		 System.out.print("Computer Win!");
	 
	 else if(ptotal > ctotal)
		System.out.println("Player Win!");
	 
	 else if(ctotal == 21)
		 System.out.println("Player Win!");
	
	 else if(ptotal == 21)
		 System.out.println("Player Win!");
	 
	 
	 else System.out.println("SameSame!");
 }
static int PBetting(int PGold) {
	int RPGold = PGold - Pbetting;
	System.out.println("Rest Gold : " + RPGold);
	Pbetting = 0;
	System.out.print("Betting Gold : ");
	Scanner Q = new Scanner(System.in);
	Pbetting = Q.nextInt();
	while(Cbetting > Pbetting || PGold < Pbetting){
		if(PGold < Pbetting) {
			System.out.print("Less betting : ");
			Pbetting = Q.nextInt();
		}
		if(PGold < Cbetting) {
			Pbetting = 0;
			
		}
		else if(Pbetting == 0) {
//			System.out.print("Give Up");
			return 0;
		}
		System.out.print("More betting : ");
		Pbetting = Q.nextInt();
	}
	TotalGold += Pbetting;
	PGold -= Pbetting;
	return 1;
	
}
static void CBetting() {
	Cbetting = 0;
	Cbetting = (int)(Math.random()*((Pbetting+10) - Pbetting +1))+(Pbetting);
	TotalGold += Cbetting;
//	CGold -= Cbetting;
	System.out.print("Computer Betting : " + Cbetting);
}
static void BettingTotal(int PGold) {
	TotalGold = PGold * 2;
	System.out.println("Prize Gold : " + TotalGold);
}
//static void RestBetting(int PGold, int Pbetting) {
//	PGold -= Pbetting;
//	System.out.print("Rest Gold : " + PGold);
//}
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
		ArrayList<Integer> number = new ArrayList<Integer>();
		ArrayList<Integer> totalList = new ArrayList<Integer>();
		ArrayList<Integer> totalList_1 = new ArrayList<Integer>();
		ArrayList<Integer> totalList_2 = new ArrayList<Integer>();
		
		Player player = new Player();
		Computer computer = new Computer();
		Dealer dealer = new Dealer();
		
		int random;
		int randomN = 54;
		int Dcount = 0;
		int giveup;
		
		
		
		for(int i = 1; i <= 10; i++) {
			for (int j = 1; j <= i; j++) {
				number.add(i);
			}
		}
//		int PGold = 0;
		int CGold = 0;
		PGold = player.UseGold();

//		CGold = computer.UseGold(PGold);
//		System.out.println("PGlod : " + PGold);
//		System.out.println("CGlod : " + CGold);
		
		randomN = computer.AddCard(number, randomN);
//		computer.ShowPrint();
		
		System.out.println();
		
		randomN = player.AddCard(number, randomN);
		player.ShowPrint();
		System.out.println();
		
		randomN = dealer.AddCard(number, randomN);
//		dealer.ShowPrint();
		System.out.println();
		
		dealer.Dcard();
		System.out.println();
		int Pchoice = player.Pchoice();
		int Cchoice = computer.Cchoice();
//		FirstWho(Pchoice, Cchoice);
		System.out.println();
//		RestGold(PGold);
		giveup = PBetting(PGold);
		System.out.println();
		if(giveup == 1) {
		CBetting();
		System.out.println();
		System.out.println();
		
		dealer.Dcard();
		System.out.println();
//		RestGold(PGold);
		giveup = PBetting(PGold);
		if(giveup == 1) {
		CBetting();
		System.out.println();
		
		
		dealer.Dcard();
		System.out.println();
//		RestGold(PGold);
		giveup = PBetting(PGold);
		if(giveup == 1) {
		CBetting();
		System.out.println();
		
		System.out.println();
		totalList_1 = player.PCompare();
//		player.ShowPrint();
		System.out.println();
		
		
		totalList_2 = dealer.DCompare();
//		dealer.ShowPrint();
//		System.out.println();
		
		
		
		
		for(int i = 0; i < totalList_1.size(); i++) {
			totalList.add(totalList_1.get(i));
			
		}
		for(int i = 0; i < totalList_2.size(); i++) {
			totalList.add(totalList_2.get(i));
			
		}
		
		
		totalList.sort(Comparator.naturalOrder());
		for(int i = 0; i <totalList.size(); i++) {
	           for(int j = i+1; j < totalList.size(); j++) {
	              if(totalList.get(i) == totalList.get(j)) {
	            	  totalList.remove(i);
	            	  totalList.remove(i);
	                 break;
	              }
	           }
		}
//		System.out.println();
//		ShowPrint(totalList);
		
		TotalSum(totalList);
		Ptotal += total;
		System.out.println("Player Total : " + total);
 		
		totalList_1.clear();
		totalList.clear();
		
		totalList_1 = computer.CCompare();
		
		for(int i = 0; i < totalList_1.size(); i++) {
			totalList.add(totalList_1.get(i));
			
		}
		
		for(int i = 0; i < totalList_2.size(); i++) {
			totalList.add(totalList_2.get(i));
			
		}
		
		totalList.sort(Comparator.naturalOrder());
		for(int i = 0; i <totalList.size(); i++) {
	           for(int j = i+1; j < totalList.size(); j++) {
	              if(totalList.get(i) == totalList.get(j)) {
	            	  totalList.remove(i);
	            	  totalList.remove(i);
	                 break;
	              }
	           }
		}
		
//		System.out.println();
//		ShowPrint(totalList);
		
		TotalSum(totalList);
		Ctotal += total;
		System.out.println("Computer Total : " + total);
		
				
				}
			}
		}
		Winner(Ctotal, Ptotal, giveup);
		BettingTotal(PGold);
		
 	}
}
 