package GUI;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Priority.IntroMusic;
import Priority.Music;

import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;

public class App {

	private JFrame frame;
	private static JTextField idField;
	private static JPasswordField passField;
	private ImagePanel loginPanel;
	private JTextField idField_join;
	private JPasswordField passField_join;
	static String id;
	static String pw;
	static String Gold;
	static String saveid;
	static String savepw;
	static int gold_total;
	static int c_golden;
	static int g_golden;
	static int g_bet=1, c_bet=1;
	/**
	 * Launch the application.
	 */
	static int bet(Gamer g, computer c) { //�����Լ�
		Scanner sc = new Scanner(System.in);
		c_golden=c.getgolden();
		g_golden=g.getgolden();
		
		System.out.println("�����ִ� ��� �� : "+g_golden);
		System.out.print("������ �ݾ��� �Է��� �ּ��� : ");
		g_bet = sc.nextInt();
		/*
		 * while(c_bet>g_bet) { System.out.println(c_bet+"�̻����θ� �����Ͻ� �� �ֽ��ϴ�. ");
		 * System.out.print("������ �ݾ��� �ٽ� �Է��� �ּ��� : "); g_bet = sc.nextInt(); }
		 */
		while(g_bet>g_golden||c_bet>g_bet) {
			if(c_bet>g_bet)System.out.println(c_bet+"�̻����θ� �����Ͻ� �� �ֽ��ϴ�. ");
			else if(g_bet>g_golden)System.out.println("�����ִ� ��� ������ ũ�� �Է��ϼ̽��ϴ�.");
			System.out.print("������ �ݾ��� �ٽ� �Է��� �ּ��� (0�� �Է��ϸ� ����): ");
			g_bet = sc.nextInt();
			if(g_bet==0) {
				System.out.println("������ �����ϼ̽��ϴ�. �����Ͻø� �� ���� ������ ����� �ٽ� �������� �� �����ϴ�.");
				return 0;
			}
		}
		g.setgolden(g_bet);
		gold_total+=g_bet;
		
		System.out.println("someone ���� �ݾ� �Է���...");
		c_bet=c.randgolden(g_bet);
		System.out.println("someone�� ���ñݾ� : "+c_bet);
		gold_total+=c_bet;
		return 1;
	}

	public static void main(String[] args) {
		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public App() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		String Gold="500";
		String Id="mirim";
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImagePanel mainPanel = new ImagePanel(new ImageIcon("src\\CARD_IMG\\main.png").getImage());
		ImagePanel loginPanel = new ImagePanel(new ImageIcon("src\\CARD_IMG\\LOGIN.png").getImage());
		ImagePanel joinPanel = new ImagePanel(new ImageIcon("src\\CARD_IMG\\JOIN.png").getImage());
		ImagePanel homePanel = new ImagePanel(new ImageIcon("src\\CARD_IMG\\home1.png").getImage());
		ImagePanel rainbowPanel = new ImagePanel(new ImageIcon("src\\CARD_IMG\\rainbow.png").getImage());
		//ImagePanel rainbowPanel = new ImagePanel(new ImageIcon("E:\\java_2211\\GOLDEN_CARD\\Rainbow_holdem\\CARD_IMG\\Home.png").getImage());
		//Intro
		
		new IntroMusic();
		Music introMusic = new Music("bensound-creepy.mp3", true);
		introMusic.start();
		frame.getContentPane().add(mainPanel);
		frame.getContentPane().add(loginPanel);
		frame.getContentPane().add(joinPanel);
		frame.getContentPane().add(homePanel);
		frame.getContentPane().add(rainbowPanel);
		//frame.getContentPane().add(rainbowPanel);
		
		loginPanel.setVisible(false); //login�������� �Ⱥ��̰� ����(���̰� ������ true)
		homePanel.setVisible(false);
		joinPanel.setVisible(false);
		rainbowPanel.setVisible(false);
		
		frame.setSize(mainPanel.getDim());
		frame.setPreferredSize(mainPanel.getDim());
		
		//main
		JButton loginbtn = new JButton("");
		loginbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//JOptionPane.showMessageDialog(null, "�α��� �������� �̵�!!");
				mainPanel.setVisible(false);
				loginPanel.setVisible(true);
			}
		});
		loginbtn.setBounds(485, 464, 579, 83);
		mainPanel.add(loginbtn);
		loginbtn.setIcon(new ImageIcon("src\\CARD_IMG\\mainbtn1.png"));
		loginbtn.setPressedIcon(new ImageIcon("src\\CARD_IMG\\mainbtn"+"1_2"+".png"));
		loginbtn.setBorder(null);
		frame.pack();
		
		JButton joinbtn = new JButton("");
		joinbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//JOptionPane.showMessageDialog(null, "ȸ������ �������� �̵�!!");
				mainPanel.setVisible(false);
				joinPanel.setVisible(true);
			}
		});
		joinbtn.setBounds(485, 601, 579, 83);
		mainPanel.add(joinbtn);
		joinbtn.setIcon(new ImageIcon("src\\CARD_IMG\\mainbtn2.png"));
		joinbtn.setPressedIcon(new ImageIcon("src\\CARD_IMG\\mainbtn2_2.png"));
		joinbtn.setBorder(null);
		frame.pack();
		//main-end
		
		//login
		idField = new JTextField();
		idField.setFont(new Font("����", Font.PLAIN, 30));
		idField.setBounds(526, 496, 418, 63);
		loginPanel.add(idField);
		idField.setColumns(10);
		idField.setBorder(null);
		
		passField = new JPasswordField();
		passField.setFont(new Font("����", Font.PLAIN, 30));
		passField.setBounds(526, 617, 418, 63);
		passField.setBorder(null);
		loginPanel.add(passField);
		
		JButton login_btn = new JButton("");
		login_btn.setBounds(968, 481, 166, 205);
		loginPanel.add(login_btn);
		login_btn.setIcon(new ImageIcon("src\\CARD_IMG\\login_btn1.png"));
		login_btn.setPressedIcon(new ImageIcon("src\\CARD_IMG\\login_btn2.png"));
		login_btn.setBorder(null);
		login_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int pass = 0;

				System.out.print("Input ID : ");
				id = idField.getText();
				System.out.print("Input PassWord : ");
				pw = passField.getText();
				
				File file = new File("E:\\�б�\\JAVA\\Project\\MemberDB.txt");
				try {
					FileReader filereader = new FileReader(file);
					BufferedReader bufReader = new BufferedReader(filereader);
					String Gold = "500";
					try {
						Gold = bufReader.readLine();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					String line = "";
					try {
						while((line = bufReader.readLine()) != null) {
							System.out.println(line.indexOf(id) + "\t" + line.indexOf(pw)  + "\t" + line.indexOf(Gold) );
							int passId = line.indexOf(id);
							int passPw = line.indexOf(pw);
//							int Gold = line.indexOf(gold);
							
							if(passId != -1 && passPw != -1) {
//								System.out.println(Gold);
								System.out.println("LogIn Finish");
								
								pass = 1;
							}
						}
						if(pass == 0) {
							System.out.println("Not LogIn");
						}
						bufReader.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				
				JOptionPane.showMessageDialog(null, "You are logged In!");
				  loginPanel.setVisible(false);
				  homePanel.setVisible(true);
				  
				/*
				 * if(saveid.equals(idField.getText()) && savepw.equals(passField.getText())) {
				 * 
				 * } else { JOptionPane.showMessageDialog(null, "fail"); }
				 */
			}
		});
		
		
		//�ڷΰ��� ��ư
		JButton main_backbtn = new JButton("");
		main_backbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginPanel.setVisible(false);
				mainPanel.setVisible(true);
			}
		});
		main_backbtn.setBounds(1314, 752, 148, 75);
		loginPanel.add(main_backbtn);
		main_backbtn.setIcon(new ImageIcon("src\\CARD_IMG\\backbtn1.png"));
		main_backbtn.setPressedIcon(new ImageIcon("src\\CARD_IMG\\backbtn2.png"));
		main_backbtn.setBorder(null);
		//login-end
		
		//join
		idField_join = new JTextField();
		idField_join.setFont(new Font("����", Font.PLAIN, 30));
		idField_join.setColumns(10);
		idField_join.setBounds(530, 497, 413, 61);
		joinPanel.add(idField_join);
		idField_join.setBorder(null);
		
		passField_join = new JPasswordField();
		passField_join.setFont(new Font("����", Font.PLAIN, 30));
		passField_join.setBounds(529, 617, 414, 61);
		joinPanel.add(passField_join);
		passField_join.setBorder(null);
		
		//ȸ������ �Ϸ��ư
		JButton join_btn = new JButton("");
		join_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				File file = new File("E:\\�б�\\JAVA\\Project\\MemberDB.txt");
				try {
					FileWriter filewriter = new FileWriter(file, true);
					if(file.isFile() && file.canWrite()) {
						System.out.print("ID : ");
						filewriter.write(idField.getText());
						filewriter.write("\t");
						System.out.print("Password : ");
						filewriter.write(idField.getText());
						filewriter.write("\t");
						
//						System.out.print("Gold : ");
//						filewriter.append("500");
//						filewriter.append("\r");
						
						String Gold = "500";
						filewriter.write(Gold);
						
						System.out.println("Join Finish");
					}
					filewriter.close();
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
				
				JOptionPane.showMessageDialog(null, "ȸ�������� �Ϸ��ϼ̽��ϴ�! �α������� �Ѿ�ϴ�!");
				joinPanel.setVisible(false);
				loginPanel.setVisible(true);
			}
		});
		join_btn.setBounds(960, 482, 169, 218);
		joinPanel.add(join_btn);
		join_btn.setIcon(new ImageIcon("src\\CARD_IMG\\joinbtn1.png"));
		join_btn.setPressedIcon(new ImageIcon("src\\CARD_IMG\\joinbtn2.png"));
		join_btn.setBorder(null);
		
		//�ڷΰ��� ��ư
		JButton join_backbtn = new JButton("");
		join_backbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				joinPanel.setVisible(false);
				mainPanel.setVisible(true);
			}
		});
		join_backbtn.setBounds(1314, 752, 148, 75);
		joinPanel.add(join_backbtn);
		join_backbtn.setIcon(new ImageIcon("src\\CARD_IMG\\backbtn1.png"));
		join_backbtn.setPressedIcon(new ImageIcon("src\\CARD_IMG\\backbtn2.png"));
		join_backbtn.setBorder(null);
		frame.pack();
		
		//home
		JLabel information = new JLabel("Id : "+ Id +"                  "+"Gold : "+Gold);
		information.setFont(new Font("����", Font.PLAIN, 26));
		information.setForeground(Color.WHITE);
		information.setBounds(590, 35, 612, 60);
		homePanel.add(information);
		frame.pack();
		
		JButton rainbowbtn = new JButton("");
		rainbowbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				homePanel.setVisible(false);
				rainbowPanel.setVisible(true);
			}
		});
		
		rainbowbtn.setBounds(472, 410, 469, 70);
		homePanel.add(rainbowbtn);
		rainbowbtn.setIcon(new ImageIcon("src\\CARD_IMG\\rainbowbtn.png"));
		rainbowbtn.setPressedIcon(new ImageIcon("src\\CARD_IMG\\rainbowbtn2.png"));
		rainbowbtn.setBorder(null);
		frame.pack();
		
		JButton rainbowwhobtn = new JButton("");
		rainbowwhobtn.setBounds(1071, 410, 131, 70);
		homePanel.add(rainbowwhobtn);
		rainbowwhobtn.setIcon(new ImageIcon("src\\CARD_IMG\\Howtoplay.png"));
		rainbowwhobtn.setPressedIcon(new ImageIcon("src\\CARD_IMG\\Howtoplay2.png"));
		rainbowwhobtn.setBorder(null);
		
		JButton prioritybtn = new JButton("");
		prioritybtn.setBounds(472, 574, 469, 70);
		prioritybtn.setIcon(new ImageIcon("src\\CARD_IMG\\prioritybtn.png"));
		prioritybtn.setPressedIcon(new ImageIcon("src\\CARD_IMG\\prioritybtn2.png"));
		prioritybtn.setBorder(null);
		homePanel.add(prioritybtn);
		
		JButton priorityhowbtn = new JButton("");
		priorityhowbtn.setBounds(1071, 574, 131, 70);
		priorityhowbtn.setIcon(new ImageIcon("src\\CARD_IMG\\Howtoplay.png"));
		priorityhowbtn.setPressedIcon(new ImageIcon("src\\CARD_IMG\\Howtoplay2.png"));
		priorityhowbtn.setBorder(null);
		homePanel.add(priorityhowbtn);
		
		JButton goldcollectbtn = new JButton("");
		goldcollectbtn.setBorder(null);
		goldcollectbtn.setBounds(472, 737, 469, 70);
		goldcollectbtn.setIcon(new ImageIcon("src\\CARD_IMG\\goldcollectbtn.png"));
		goldcollectbtn.setPressedIcon(new ImageIcon("src\\CARD_IMG\\goldcollectbtn2.png"));
		homePanel.add(goldcollectbtn);
		
		JButton goldcollecthowbtn = new JButton("");
		goldcollecthowbtn.setBorder(null);
		goldcollecthowbtn.setBounds(1071, 737, 131, 70);
		goldcollecthowbtn.setIcon(new ImageIcon("src\\CARD_IMG\\Howtoplay.png"));
		goldcollecthowbtn.setPressedIcon(new ImageIcon("src\\CARD_IMG\\Howtoplay2.png"));
		homePanel.add(goldcollecthowbtn);
		
		
		
		//home-end
		
		//rainbow
		new IntroMusic();
		Music IntroMusic = new Music("MP_Code Number B.mp3", true);
		IntroMusic.start();
		JLabel messageLabel = new JLabel("Gold : "+Gold);
		messageLabel.setForeground(Color.WHITE);
		messageLabel.setFont(new Font("����", Font.PLAIN, 27));
		messageLabel.setBounds(1251, 254, 265, 187);
		rainbowPanel.add(messageLabel);
		
		JButton D1_card = new JButton("");
		D1_card.setBounds(297, 207, 139, 208);
		rainbowPanel.add(D1_card);
		D1_card.setIcon(new ImageIcon("src\\CARD_IMG\\Card_Front1.png"));
		
		JButton D2_card = new JButton("");
		D2_card.setBounds(505, 207, 139, 208);
		rainbowPanel.add(D2_card);
		D2_card.setIcon(new ImageIcon("scr\\CARD_IMG\\Card_Front1.png"));
		
		JButton D3_card = new JButton("");
		D3_card.setBounds(727, 210, 139, 205);
		rainbowPanel.add(D3_card);
		D3_card.setIcon(new ImageIcon("src\\CARD_IMG\\Card_Front1.png"));
		
		JButton D4_card = new JButton("");
		D4_card.setBounds(946, 209, 139, 206);
		rainbowPanel.add(D4_card);
		D4_card.setIcon(new ImageIcon("src\\CARD_IMG\\Card_Front1.png"));
		
		JButton C1_card = new JButton("");
		C1_card.setBounds(49, 594, 139, 208);
		rainbowPanel.add(C1_card);
		C1_card.setIcon(new ImageIcon("src\\CARD_IMG\\Card_Front1.png"));
		
		JButton C2_card = new JButton("");
		C2_card.setBounds(202, 594, 139, 208);
		rainbowPanel.add(C2_card);
		C2_card.setIcon(new ImageIcon("src\\CARD_IMG\\Card_Front1.png"));
		
		JButton C3_card = new JButton("");
		C3_card.setBounds(355, 594, 139, 208);
		rainbowPanel.add(C3_card);
		C3_card.setIcon(new ImageIcon("src\\CARD_IMG\\Card_Front1.png"));

		JButton G1_card = new JButton("");
		G1_card.setBounds(579, 575, 148, 227);
		rainbowPanel.add(G1_card);
		G1_card.setIcon(new ImageIcon("src\\CARD_IMG\\Card_Front1.png"));

		JButton G2_card = new JButton("");
		G2_card.setBounds(805, 575, 148, 227);
		rainbowPanel.add(G2_card);
		G2_card.setIcon(new ImageIcon("src\\CARD_IMG\\Card_Front1.png"));

		JButton G3_card = new JButton("");
		G3_card.setBounds(1016, 575, 148, 227);
		rainbowPanel.add(G3_card);
		G3_card.setIcon(new ImageIcon("src\\CARD_IMG\\Card_Front1.png"));

		JButton Startbtn = new JButton("Start");
		Startbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//messageLabel.setText("�⺻���� �꿡 ���� \nó������ ��� 1�� �����ϰڽ��ϴ�.");
				ArrayList<Integer> cardlist = new ArrayList<Integer>();
				for(int i=1; i<=10; i++) {
					for(int j=1; j<=i; j++) {
						cardlist.add(i);
					}
				}
				int g_gold=500; // game�� �����ִ� ���ð�� ��
				System.out.println("gamer�� ���� �ִ� ��� �� : "+g_gold);
				

				Gamer gamer = new Gamer(g_gold);
				Dealer dealer = new Dealer();
				computer computer1 = new computer(g_gold);
				
				int index;
				int n;
				int size=cardlist.size();
				
				//�� ��ü ArrayList �� �ʱ�ȭ(�޼ҵ�� ������)
				for(int i=0; i<3; i++) {
					index=(int)(Math.random()*size);
					n=cardlist.get(index);
					computer1.setCard(n);
					cardlist.remove(index);
					--size;
					
					index=(int)(Math.random()*size);
					n=cardlist.get(index);
					gamer.setCard(n);
					cardlist.remove(index);
					--size;
					
				}
				for(int i=0; i<4; i++) {
					index=(int)(Math.random()*size);
					n=cardlist.get(index);
					dealer.setCard(n);
					cardlist.remove(index);
					--size;
				}
				/*
				 * �����Ҷ� ����
				 * ��뺸�� �̻��� ���� �����Ѵ�
				 * �ڱⰡ ���� ���ñݾ��� ������ gameover��
				 * ��ǻ�ʹ� �÷��̾ �� �ݾ� ���� +10 �ȿ��� ������ ���� �����Ѵ�.*/
				//int g_bet=1, c_bet=1;
				int d_index=0;
				int over; //���� ���� ����
				String card;
				game:while(true) {
					JOptionPane.showMessageDialog(null, "������ �����ϰڽ��ϴ�.");
					JOptionPane.showMessageDialog(null, "�⺻���� �꿡 ���� \nó������ ��� 1�� �����ϰڽ��ϴ�.");
					gamer.setgolden(g_bet);
					computer1.setgolden(c_bet);
					messageLabel.setText("��� �� : "+g_gold);
					JOptionPane.showMessageDialog(null, "�� ī�� Ȯ��");
					System.out.println("�� ī�� ����");
					gamer.testshow();
					card=String.valueOf(gamer.show(0));
					G1_card.setIcon(new ImageIcon("src\\CARD_IMG\\card"+card+".png"));
					card=String.valueOf(gamer.show(1));
					G2_card.setIcon(new ImageIcon("src\\CARD_IMG\\card"+card+".png"));
					card=String.valueOf(gamer.show(2));
					G3_card.setIcon(new ImageIcon("src\\CARD_IMG\\card"+card+".png"));
					
					JOptionPane.showMessageDialog(null, "ù��° ����ī�� ����");
					G1_card.setIcon(new ImageIcon("src\\CARD_IMG\\Card_Front1.png"));
					G2_card.setIcon(new ImageIcon("src\\CARD_IMG\\Card_Front1.png"));
					G3_card.setIcon(new ImageIcon("src\\CARD_IMG\\Card_Front1.png"));
					card=String.valueOf(dealer.open(d_index)); //����ī�� ����
					D1_card.setIcon(new ImageIcon("src\\CARD_IMG\\card"+card+".png"));
					
					JOptionPane.showMessageDialog(null, "ù��° ī�� ����");
					card=String.valueOf(gamer.show(0));
					G1_card.setIcon(new ImageIcon("src\\CARD_IMG\\card"+card+".png"));
					card=String.valueOf(computer1.show(0));
					C1_card.setIcon(new ImageIcon("src\\CARD_IMG\\card"+card+".png"));
					/*over=bet(gamer, computer1);
					if(over==0) {
						JOptionPane.showMessageDialog(null, "someone win!");
						messageLabel.setText("���� ��� : "+g_gold);
						break;
					}*/
					
					++d_index;
					JOptionPane.showMessageDialog(null, "�ι�° ����ī�� ����");
					card=String.valueOf(dealer.open(d_index)); //����ī�� ����
					D2_card.setIcon(new ImageIcon("src\\CARD_IMG\\card"+card+".png"));
					/*over=bet(gamer, computer1);
					if(over==0) {
						JOptionPane.showMessageDialog(null, "someone win!");
						messageLabel.setText("���� ��� : "+g_gold);
						break;
					}*/
					
					++d_index;
					JOptionPane.showMessageDialog(null, "����° ����ī�� ����");
					card=String.valueOf(dealer.open(d_index)); //����ī�� ����
					D3_card.setIcon(new ImageIcon("src\\CARD_IMG\\card"+card+".png"));
					/*over=bet(gamer, computer1);
					if(over==0) {
						JOptionPane.showMessageDialog(null, "someone win!");
						messageLabel.setText("���� ��� : "+g_gold);
						break;
					}*/
					
					++d_index;
					JOptionPane.showMessageDialog(null, "������ ����ī�� ����");
					card=String.valueOf(dealer.open(d_index)); //����ī�� ����
					D4_card.setIcon(new ImageIcon("src\\CARD_IMG\\card"+card+".png"));
					/*over=bet(gamer, computer1);
					if(over==0) {
						JOptionPane.showMessageDialog(null, "someone win!");
						messageLabel.setText("���� ��� : "+g_gold);
						break;
					}*/
					
					if(d_index==3) break;

					/*System.out.println("ù��° ī�� ����");
					System.out.println("gamer : "+gamer.firstopen()+" someone : "+computer1.firstopen()); //someone�� computer
					over=bet(gamer, computer1);
					if(over==0) {
						System.out.println("someone win!");
						System.out.println("���� ��� : "+g_gold);
						break;
					}
					System.out.println();
					
					++d_index;
					dealer.open(d_index); //�ι�° ����ī�� ����
					over=bet(gamer, computer1);
					if(over==0) {
						System.out.println("someone win!");
						System.out.println("���� ��� : "+g_gold);
						break;
					}
					System.out.println();
					
					++d_index;
					dealer.open(d_index); //����° ����ī�� ����
					over=bet(gamer, computer1);
					if(over==0) {
						System.out.println("someone win!");
						System.out.println("���� ��� : "+g_gold);
						break;
					}
					System.out.println();
					
					++d_index;
					dealer.open(d_index); //����������ī�� ����
					over=bet(gamer, computer1);
					if(over==0) {
						System.out.println("someone win!");
						System.out.println("���� ��� : "+g_gold);
						break;
					}
					System.out.println();
					
					//ī�� �հ�κ�
					int cnt=0; //���κ��� ī��Ʈ
					
					List<Integer> c_result= computer1.Deduplication();
					List<Integer> d_result= dealer.Deduplication();
					List<Integer> g_result= gamer.Deduplication();
					int c_sum=0;
					int g_sum=0;
					boolean c_win=false; // ��ǻ�� ���κ��� ����
					boolean g_win=false; // �÷��̾� ���κ��� ����
					
					dealer.testshow();
					computer1.testshow();
					System.out.println(d_result);
					System.out.println(c_result);
					
					System.out.println("�ߺ����� �� �հ豸�ϱ� computer----------------");
					for(int i=0; i<d_result.size(); i++) {
						for(int j=0; j<c_result.size(); j++) {
							if(d_result.get(i)==c_result.get(j)) {
								++cnt;
								d_result.set(i, 0);
								c_result.set(j, 0);
							}
						}
					}
					System.out.println("computer �ߺ�����");
					System.out.println("����ī�� : "+d_result);
					System.out.println(c_result);
					if(c_result.size()==3&&d_result.size()==4&&cnt==0) {
						System.out.println("computer ���κ���!!!! ������ �¸�");
						c_win=true;
					}else {
						for(int s:c_result) {
							c_sum+=s;
						}
						for(int s:d_result) {
							c_sum+=s;
						}
						System.out.println("�� �հ�");
						System.out.println(c_sum);
					}
					
					cnt=0;
					d_result= dealer.Deduplication();
					
					dealer.testshow();
					gamer.testshow();
					System.out.println(d_result);
					System.out.println(g_result);
					
					System.out.println("�ߺ����� �� �հ豸�ϱ� gamer----------------");
					for(int i=0; i<d_result.size(); i++) {
						for(int j=0; j<g_result.size(); j++) {
							if(d_result.get(i)==g_result.get(j)) {
								++cnt;
								d_result.set(i, 0);
								g_result.set(j, 0);
							}
						}
					}
					System.out.println("gamer �ߺ�����");
					System.out.println("����ī�� : "+d_result);
					System.out.println(g_result);
					if(g_result.size()==3&&d_result.size()==4&&cnt==0) {
						System.out.println("gamer ���κ���!!!! ������ �¸�");
						g_win=true;
					}else {
						for(int s:g_result) {
							g_sum+=s;
						}
						for(int s:d_result) {
							g_sum+=s;
						}
						System.out.println("�� �հ�");
						System.out.println(g_sum);
					}
					
					if(g_win==true&&c_win==true) System.out.println("�Ѵ� �̰�µ� ����� ���������ڽ��ϱ� ? ");
					else if(g_win==true) {
						System.out.println("gamer ���κ���!!!! ������ �¸�");
						System.out.println("��� : "+gold_total);
					}
					else if(c_win==true) {
						System.out.println("computer ���κ���!!!! ������ �¸�");
						System.out.println("��� : "+gold_total);
					}
					else if(g_sum==c_sum) {
						System.out.println("���� ����. ����� ���������ڽ��ϱ�?");
					}
					else if(g_sum<c_sum) {
						System.out.println("gamer �¸�");
						System.out.println("��� : "+gold_total);
					}
					else if(g_sum>c_sum) {
						System.out.println("computer �¸�");
						System.out.println("��� : "+gold_total);
					}
					
					if(d_index==4) {
						break;
					}*/
				}
			}
		});
		Startbtn.setBounds(1349, 51, 190, 59);
		rainbowPanel.add(Startbtn);
		Startbtn.setBorder(null);
		IntroMusic.close();
		
	}
}

