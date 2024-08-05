package main;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Shopping {

	public static void main(String[] args) throws Exception{

		while(true) {		
			Order.getCount();
			FileWriter fw = new FileWriter("data.txt", true);
			Scanner scanner = new Scanner(System.in);
	
			System.out.println("1. 상품 주문하기");
			System.out.println("2. 전체 주문 이력 보기");
			System.out.println("3. 고객별 주문 이력 보기");
			System.out.println("4. 특정 날짜에 들어온 주문이력 보기");
			System.out.println("5. 끝내기");
			System.out.print("옵션을 선택하세요:");
			int choice = scanner.nextInt();

			if(choice == 1) {
				Order order = new Order();
				fw.write("주문 번호: "+Order.count + ", ");
				scanner.nextLine();
				System.out.print("고객명: ");
				String name = scanner.nextLine();
				fw.write("고객명: "+name + ", ");
				
				System.out.print("제품명: ");
				String product = scanner.nextLine();
				fw.write("제품명: "+product + ", ");
				
				System.out.print("제품 수량: ");
				String cnt = scanner.nextLine();
				fw.write("제품 수량: "+cnt + ", ");
				
				System.out.print("제품 금액: ");
				String price = scanner.nextLine();
				fw.write("제품 금액: "+price + ", ");
				
				LocalDateTime curDateTime = LocalDateTime.now();
				// 날짜를 특정포맷으로 출력하기
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
				String formatDate = curDateTime.format(formatter);
				fw.write("주문 일시: "+ formatDate + "\n");
				
				System.out.println("주문이 완료되었습니다!");
				
				fw.flush();
				fw.close();
				
			}else if(choice == 2) {
				String FILE_NAME = "data.txt"; 
				//FileReader: 입력 기반 스트림
				
				FileReader fr = new FileReader(FILE_NAME);
				//BufferedReader: 보조스트림 (줄단위로 텍스트를 가져오는 기능)
				BufferedReader br = new BufferedReader(fr);
				//한줄씩 가져오기~
		
				while(true) {
					String line = br.readLine();
					if(line == null) {
						break;
					}
					System.out.println(line);
				}		
				
			}else if(choice == 3) {
				scanner.nextLine();

				System.out.print("고객명: ");
				String name = scanner.nextLine();
				Search.searchName(name.trim());
			
			}else if(choice == 4) {
				scanner.nextLine();
				System.out.print("날짜: ");
				String date = scanner.nextLine();
				Search.searchName(date);
			}else if(choice == 5) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}else {
				System.out.println("1번부터 5번사이의 번호를 입력하세요.");
			}
		}
	}
}

class Order{
	
	static int count = 0;
	public Order() {
		count++;
	}

	public static void getCount() throws IOException {
		String FILE_NAME = "data.txt"; 
		FileReader fr = new FileReader(FILE_NAME);

		BufferedReader br = new BufferedReader(fr);
		
		
		int lastCount = 0;
		
		while(true) {
			String line = br.readLine();
			if(line == null) {
				break;
			}
			String[] arr = line.split(", ");
			
			for(int i=0; i<arr.length; i++) {
				String info = arr[i];
				
				if(info.startsWith("주문 번호: ")) {
					String[] numCut = info.split(": ");
					lastCount = Integer.parseInt(numCut[1]);
				}
			}
		}
		count = lastCount;
	}
}

class Search {
	public static void searchDate(String date) throws IOException {
		String FILE_NAME = "data.txt"; 
		FileReader fr = new FileReader(FILE_NAME);

		BufferedReader br = new BufferedReader(fr);
	
		while(true) {
			String line = br.readLine();
			if(line == null) {
				break;
			}
			
			if(line.contains(date)) {
				System.out.println(line);
			}
		}
	}
	
	public static void searchName(String name) throws IOException {
		String FILE_NAME = "data.txt"; 
		FileReader fr = new FileReader(FILE_NAME);

		BufferedReader br = new BufferedReader(fr);
		
		int orderCount = 0;
		int sumPrice = 0;
		int orderNum = 0;
		
		while(true) {
			String line = br.readLine();
			if(line == null) {
				break;
			}
			
			if(line.contains(name)) {
				String[] arr = line.split(", ");
				
				for(int i=0; i<arr.length; i++) {
					String info = arr[i];
					
					if(info.startsWith("고객명: ")) {
						String[] nameCut = info.split(": ");
						
						orderCount++;
	
					}
					
					if(info.startsWith("제품 수량: ")){
						String[] nameCut = info.split(": ");
						orderNum = Integer.parseInt(nameCut[1]);
					}
					
					if(info.startsWith("제품 금액: ")) {
						String[] nameCut = info.split(": ");
						
						int price = Integer.parseInt(nameCut[1]);
						sumPrice = sumPrice + (orderNum * price);
					}
				}
			}
		}
		
		System.out.println("전체 주문 건수: "+ orderCount);
		System.out.println("전체 주문 금액: "+ sumPrice);
	}
}
	
