package Priority;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
public class Player {
	ArrayList<Integer> playerList = new ArrayList<Integer>();
	ArrayList<Integer> playercount = new ArrayList<Integer>();
	int  playerCompare[] = new int[11];
	public int AddCard(ArrayList<Integer> number, int randomN) {
		
	
		for(int i = 1; i <= 5; i++) {
			int random = (int)(Math.random()*randomN+0);
			playerList.add(number.get(random));
			number.remove(random);
			randomN = randomN-1;
		}
		return randomN;
		
	}
	
	public ArrayList<Integer> getPlayerList() {
		return playerList;
	}
	

	void ShowPrint() {
		System.out.print("Player : ");
		for(int i = 0; i < playerList.size(); i++) {
			System.out.print(playerList.get(i) + "  ");
		}
	}
	int Pchoice() {
		System.out.println("Player show!");
		System.out.print("Open Card : ");
		Scanner Q = new Scanner(System.in);
		int choice = Q.nextInt();
		System.out.println();
		int Pchoice = 0;
		Pchoice = playerList.get(--choice);
		System.out.println("Player Show : " + Pchoice);
		return Pchoice;
		
	}
	public ArrayList<Integer> PCompare() {
		
		playerList.sort(Comparator.naturalOrder());
		for(int i = 0; i <playerList.size(); i++) {
	           for(int j = i+1; j < playerList.size(); j++) {
	              if(playerList.get(i) == playerList.get(j)) {
	            	  playerList.remove(i);
	            	  playerList.remove(i);
	                 break;
	              }
	           }
	     }
		for(int i = 0; i <playerList.size(); i++) {
	           for(int j = i+1; j < playerList.size(); j++) {
	              if(playerList.get(i) == playerList.get(j)) {
	            	  playerList.remove(i);
	            	  playerList.remove(i);
	                 break;
	              }
	           }
	    }
		return playerList;
		
	}
	int UseGold() {
		Scanner Q = new Scanner(System.in);
		System.out.print("Use Gold : ");
		int gold = Q.nextInt();
		return gold;
	}
	
}
