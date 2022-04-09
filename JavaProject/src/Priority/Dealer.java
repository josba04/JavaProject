package Priority;

import java.util.ArrayList;
import java.util.Comparator;

public class Dealer {

	ArrayList<Integer> dealerList = new ArrayList<Integer>();
	
	int AddCard(ArrayList<Integer> number, int randomN) {
		for(int i = 1; i <= 3; i++) {
			int random = (int)(Math.random()*randomN+0);
			dealerList.add(number.get(random));
			number.remove(random);
			randomN = randomN-1;
		}
		return randomN;
	}
	int n = 0;
	void Dcard() {
	System.out.print("Share Card : ");
	if(n == 0) {
		System.out.print(dealerList.get(n));
	}
	else if(n == 1) {
		System.out.print(dealerList.get(n-1) + " ");
		System.out.print(dealerList.get(n) + " ");
	}
	else if(n == 2) {
		System.out.print(dealerList.get(n-2) + " ");
		System.out.print(dealerList.get(n-1) + " ");
		System.out.print(dealerList.get(n) + " ");
	}
	
	n++;	
	}
	

	void ShowPrint() {
		System.out.print("Dealer : ");
		for(int i = 0; i < dealerList.size(); i++) {
			System.out.print(dealerList.get(i) + "  ");
		}
	}
	 
public ArrayList<Integer> DCompare() {
		
		dealerList.sort(Comparator.naturalOrder());
		for(int i = 0; i <dealerList.size(); i++) {
	           for(int j = i+1; j < dealerList.size(); j++) {
	              if(dealerList.get(i) == dealerList.get(j)) {
	            	  dealerList.remove(i);
	            	  dealerList.remove(i);
	                 break;
	              }
	           }
	     }
		
		return dealerList;
		
	}
}
