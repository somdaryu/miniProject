package main;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import collection.Book;

public class Shopping {

	public static void main(String[] args) throws Exception{
		int choice = 2;
		//int choice = showMenu();//메뉴를 보여준다

		if(choice == 1) {
			writeData();
		}else if(choice == 2) {
			readData();
		}else if(choice == 3) {
			
		}else if(choice == 4) {
			
		}else {
			//종료 출력
		}

	}//main
	
	static int showMenu() { //메뉴를 선택하는 메소드
		System.out.println("1. 상품 주문하기");
		System.out.println("2. 전체 주문 이력 보기");
		System.out.println("3. 고객별 주문 이력 보기");
		System.out.println("4.  특정 날짜에 들어온 주문이력 보기");
		System.out.println("5.  끝내기");
		System.out.print("옵션을 선택하세요: ");
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		return choice;
	}
	
	static void writeData() throws Exception{ //주문 내용을 입력해서 txt파일로 만드는 메소드
		System.out.println("주문내용을 입력하세요");
		Scanner scanner = new Scanner(System.in);
		FileWriter fileWriter = new FileWriter("data.txt", true);
		String str ="";
		int id = 5;
		str += id+ ",";
		System.out.print("고객명: ");
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
	
	static ArrayList<DataClass> readData() throws Exception{
		ArrayList<DataClass> list = new ArrayList<>();
		FileReader fr = new FileReader("data.txt");
		BufferedReader br = new BufferedReader(fr);
		
		while(true) {
			String line = br.readLine();
			if(line == null) break;
			
			String[] data = line.split(",");
			int id = Integer.parseInt(data[0]);
			String name = data[1];
			String prd = data[2];
			int cnt = Integer.parseInt(data[3]);
			int price = Integer.parseInt(data[4]);
			String date = data[5];
			String time = data[6];
			
			DataClass dataclass = new DataClass(id, name, prd, cnt, price, date, time);
			list.add(dataclass);
		}
		
		return list;
	}
	
	static void searchDate(List<DataClass> list) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("고객명: ");
		String customer = scanner.nextLine();
		
		
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

	@Override
	public String toString() {
		return "DataClass [id=" + id + ", name=" + name + ", prd=" + prd + ", cnt=" + cnt + ", price=" + price
				+ ", date=" + date + ", time=" + time + "]";
	}
	
	
	
}

	
