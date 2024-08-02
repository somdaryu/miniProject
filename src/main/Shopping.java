package main;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Shopping {

	public static void main(String[] args) throws Exception{
		int choice;
		//int choice = showMenu();//메뉴를 보여준다
		readData();
		/*
		if(choice == 1) {
			writeData();//메모장파일에 주문내용 기록하는 함수
		}else if(choice == 2) {
			
		}else if(choice == 3) {
			
		}else if(choice == 4) {
			
		}else {
			//종료 출력
		}
		*/		
		
	}//main
	
	static int showMenu() {
		System.out.println("메뉴를 선택하세요");
		System.out.print("메뉴: ");
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		return choice;
	}
	
	static void writeData() throws Exception{
		System.out.println("주문내용을 입력하세요");
		Scanner scanner = new Scanner(System.in);
		FileWriter fileWriter = new FileWriter("data.txt", true);
		String str ="";
		int id = 5;
		str += id+ ",";
		System.out.println(str);
		str += scanner.nextLine()+ ",";
		System.out.print("제품명: ");
		str += scanner.nextLine()+ ",";
		System.out.print("제품의 수량: ");
		str += scanner.nextLine()+ ",";
		System.out.print("제품의 가격: ");
		str += scanner.nextLine()+ ",";
		str += "2022-22-22";
		str += ",";
		str += "08:08:08";
		str += "\n";
		
		fileWriter.write(str);
		fileWriter.flush();
		System.out.println("주문이 완료되었습니다");
	}
	
	static ArrayList readData() throws Exception{
		ArrayList<String> list = new ArrayList<>();
		FileReader fr = new FileReader("data.txt");
		BufferedReader br = new BufferedReader(fr);
		
		while(true) {
			String line = br.readLine();
			if(line == null) break;
			list.add(line);		
		}
		System.out.println(list);
		return list;
	}
}//end

class DataClass{
	int id;
	String name;
	String prd;
	int cnt;
	int price;
	String date;
	String time;
	public DataClass(int id, String name, String prd, int cnt, int price, String date, String time) {

		this.id = id;
		this.name = name;
		this.prd = prd;
		this.cnt = cnt;
		this.price = price;
		this.date = date;
		this.time = time;
	}
	
}

	
