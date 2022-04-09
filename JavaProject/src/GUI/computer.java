package GUI;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class computer {
	//someone
	private ArrayList<Integer> com_card=new ArrayList<>(3);
	private String name;
	private int golden; // 배팅할 아이템
	private List<Integer> resultList = new ArrayList<Integer>();
	// 중복제거된 값
	
	public computer(int golden) {
		this.golden=golden;
	}
	public int getgolden() {
		return golden;
	}
	public void setgolden(int gold) {
		this.golden-=gold;
		//원래 골드에서 입력받은 골드를 빼줌
	}
	public int randgolden(int num) {
		int end=num+10;
		int n=(int)(Math.random()*(end-num+1))+num; //(최댓값-최소값+1)+최소값
		return n;
	}
	public ArrayList<Integer> getCard() {
		return com_card;
	}
	public void setCard(int n) {
		//n은 카드 번호
		com_card.add(n);
	}
	public int show(int index) {
		return com_card.get(index);
	}
	public int firstopen() {
		//System.out.println("첫번째 카드 오픈 : "+com_card.get(0));
		return com_card.get(0);
	}
	public int putCard(int index) {
		//메인에서 비교
		return com_card.get(index);
	}
	//테스트
	public void testshow() {
		System.out.print("computer : ");
		for(int a:com_card) {
			System.out.print(a+" ");
		}
		System.out.println();
	}
	public List<Integer> Deduplication() { //중복값 제거
        resultList=(ArrayList<Integer>)com_card.clone();
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
