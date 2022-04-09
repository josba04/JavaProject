package Priority;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Login {
	static Scanner Q = new Scanner(System.in);
	public static void main(String[] args) {
		int pass = 0;

		System.out.print("Input ID : ");
		String id = Q.nextLine();
		System.out.print("Input PassWord : ");
		String pw = Q.nextLine();
		
		File file = new File("E:\\ÇÐ±³\\JAVA\\Project\\MemberDB.txt");
		try {
			FileReader filereader = new FileReader(file);
			BufferedReader bufReader = new BufferedReader(filereader);
			String gold;
			try {
				gold = bufReader.readLine();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String line = "";
			try {
				while((line = bufReader.readLine()) != null) {
					System.out.println(line.indexOf(id) + "\t" + line.indexOf(pw) /* + "\t" + line.indexOf(gold) */);
					int passId = line.indexOf(id);
					int passPw = line.indexOf(pw);
//					int Gold = line.indexOf(gold);
					
					if(passId != -1 && passPw != -1) {
//						System.out.println(Gold);
						System.out.println("LogIn Finish");
						
						pass = 1;
					}
				}
				if(pass == 0) {
					System.out.println("Not LogIn");
				}
				bufReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
