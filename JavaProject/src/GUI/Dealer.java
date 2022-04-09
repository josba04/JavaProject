package GUI;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Dealer {
	//����ī��
	private ArrayList<Integer> D_card=new ArrayList<>(4);
	private List<Integer> resultList = new ArrayList<Integer>();
	public ArrayList<Integer> getCard() {
		return D_card;
	}
	
	public void setCard(int n) {
		//n�� ī�� ��ȣ
		D_card.add(n);
	}
	
	public void testshow() {
		System.out.print("Dealer : ");
		for(int a:D_card) {
			System.out.print(a+" ");
		}
		System.out.println();
	}
	public int open(int index) {
		//int copy=index-1;
		//System.out.print("����ī�� ���� :");
		return D_card.get(index);
	}
	public List<Integer> Deduplication() {
        resultList=(ArrayList<Integer>)D_card.clone();
		resultList.sort(Comparator.naturalOrder());
        for(int i=0; i<resultList.size(); i++) {
        	for(int j=i+1; j<resultList.size(); j++) {
        		if(resultList.get(i)==resultList.get(j)) {
        			resultList.remove(i);
        			resultList.remove(i);
        			break;
        		}
        	}
        }
        return resultList;
	}
	public int putCard(int index) {
		//���ο��� ��
		return D_card.get(index);
	}
}
