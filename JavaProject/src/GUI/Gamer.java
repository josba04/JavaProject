package GUI;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Gamer {
	private ArrayList<Integer> G_card=new ArrayList<>(3);
	private List<Integer> resultList = new ArrayList<Integer>();
	private int golden; // 배팅할 아이템d
	
	public Gamer(int golden) {
		this.golden=golden;
	}
	public int getgolden() {
		return golden;
	}
	public void setgolden(int gold) {
		this.golden-=gold;
		//원래 골드에서 입력받은 골드를 빼줌
	}
	public ArrayList<Integer> getCard() {
		return G_card;
	}
	public void setCard(int n) {
		//n은 카드 번호
		G_card.add(n);
	}
	public int firstopen() {
		//System.out.println("첫번째 카드 오픈 : "+G_card.get(0));
		return G_card.get(0);
	}
	public int show(int index) {
		return G_card.get(index);
	}
	//테스트
	public void testshow() {
		System.out.print("Gamer : ");
		for(int a:G_card) {
			System.out.print(a+" ");
		}
		System.out.println();
	}
	public List<Integer> Deduplication() {
        resultList=(ArrayList<Integer>)G_card.clone();
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
	//배팅기능 구현
}
