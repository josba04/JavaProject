package Priority;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.Writer;

public class MemberJoin {
static Scanner Q = new Scanner(System.in);
	public static void main(String[] args) {
		File file = new File("E:\\ÇÐ±³\\JAVA\\Project\\MemberDB.txt");
		try {
			FileWriter filewriter = new FileWriter(file, true);
			if(file.isFile() && file.canWrite()) {
				System.out.print("ID : ");
				filewriter.append(Q.nextLine());
				filewriter.append("\t");
				System.out.print("Password : ");
				filewriter.append(Q.nextLine());
				filewriter.append("\t");
//				System.out.print("Gold : ");
//				filewriter.append("500");
//				filewriter.append("\r");
				
				String gold = "500";
				filewriter.write(gold);
				
				System.out.println("Join Finish");
			}
			filewriter.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		
		
	}

}
