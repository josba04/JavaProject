package GUI;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Gamer {
	private ArrayList<Integer> G_card=new ArrayList<>(3);
	private List<Integer> resultList = new ArrayList<Integer>();
	private int golden; // ������ ������d
	
	public Gamer(int golden) {
		this.golden=golden;
	}
	public int getgolden() {
		return golden;
	}
	public void setgolden(int gold) {
		this.golden-=gold;
		//���� ��忡�� �Է¹��� ��带 ����
	}
	public ArrayList<Integer> getCard() {
		return G_card;
	}
	public void setCard(int n) {
		//n�� ī�� ��ȣ
		G_card.add(n);
	}
	public int firstopen() {
		//System.out.println("ù��° ī�� ���� : "+G_card.get(0));
		return G_card.get(0);
	}
	public int show(int index) {
		return G_card.get(index);
	}
	//�׽�Ʈ
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
	//���ñ�� ����
}
