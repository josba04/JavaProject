package GUI;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class computer {
	//someone
	private ArrayList<Integer> com_card=new ArrayList<>(3);
	private String name;
	private int golden; // ������ ������
	private List<Integer> resultList = new ArrayList<Integer>();
	// �ߺ����ŵ� ��
	
	public computer(int golden) {
		this.golden=golden;
	}
	public int getgolden() {
		return golden;
	}
	public void setgolden(int gold) {
		this.golden-=gold;
		//���� ��忡�� �Է¹��� ��带 ����
	}
	public int randgolden(int num) {
		int end=num+10;
		int n=(int)(Math.random()*(end-num+1))+num; //(�ִ�-�ּҰ�+1)+�ּҰ�
		return n;
	}
	public ArrayList<Integer> getCard() {
		return com_card;
	}
	public void setCard(int n) {
		//n�� ī�� ��ȣ
		com_card.add(n);
	}
	public int show(int index) {
		return com_card.get(index);
	}
	public int firstopen() {
		//System.out.println("ù��° ī�� ���� : "+com_card.get(0));
		return com_card.get(0);
	}
	public int putCard(int index) {
		//���ο��� ��
		return com_card.get(index);
	}
	//�׽�Ʈ
	public void testshow() {
		System.out.print("computer : ");
		for(int a:com_card) {
			System.out.print(a+" ");
		}
		System.out.println();
	}
	public List<Integer> Deduplication() { //�ߺ��� ����
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
	
	//���ñ�� ����
	
}
