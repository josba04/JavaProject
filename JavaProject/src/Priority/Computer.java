package Priority;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Computer {
	ArrayList<Integer> computerList = new ArrayList<Integer>();
	
	public int AddCard(ArrayList<Integer> number, int randomN) {
		for(int i = 1; i <= 5; i++) {
			int random = (int)(Math.random()*randomN+0);
			computerList.add(number.get(random));
			number.remove(random);
			randomN = randomN-1;
		}
		return randomN;
		
	}
	void ShowPrint() {
		System.out.print("Computer : ");
		for(int i = 0; i < computerList.size(); i++) {
			System.out.print(computerList.get(i) + "  ");
		}
	}
	
	int Cchoice() {
		int Cchoice =  0;
		Cchoice = computerList.get(0);
		System.out.println("Computer show : " + Cchoice);
		return Cchoice;
	}
	
	public ArrayList<Integer> CCompare() {
		
		computerList.sort(Comparator.naturalOrder());
		for(int i = 0; i <computerList.size(); i++) {
	           for(int j = i+1; j < computerList.size(); j++) {
	              if(computerList.get(i) == computerList.get(j)) {
	            	  computerList.remove(i);
	            	  computerList.remove(i);
	                 break;
	              }
	           }
	     }
		for(int i = 0; i <computerList.size(); i++) {
	           for(int j = i+1; j < computerList.size(); j++) {
	              if(computerList.get(i) == computerList.get(j)) {
	            	  computerList.remove(i);
	            	  computerList.remove(i);
	                 break;
	              }
	           }
	    }
		return computerList;
		
	}
//	int UseGold(int PGold) {
//		int CGold = PGold;
//		return CGold;
//	}

	
}
