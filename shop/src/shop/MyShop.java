package shop;

import java.util.Scanner;

public class MyShop implements IShop{
	private String title;
	private User users[] = new User[2];
	private Product products[] = new Product[5];
	private Product carts[];
	private static Scanner sc = new Scanner(System.in);
	private int selUser = 0;
	
	@Override
	public void genProduct() {
		// 핸드폰 3개, 스마트TV 2개
		products[0] = new CellPhone("A", 500000, "SKT");
		products[1] = new CellPhone("B", 350000, "LG");
		products[2] = new CellPhone("C", 119900, "KT");
		products[3] = new SmartTV("A", 2500000, "8K UHD(7,680 x 4,320)");
		products[4] = new SmartTV("B", 1300000, "4K(4,096 x 2,160)");
	}
	@Override
	public void genUser() {
		// User 객체를 이용해 2명 생성 ( 배열 이용 ) 
		users[0] = new User("학생A", PayType.CARD);
		users[1] = new User("성인B", PayType.CASH);
	}
	@Override
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public void start() {
		carts = new Product[100];
		System.out.println(title + " : 메인 화면 - 계정 선택");
		System.out.println("========================");
//		for(int i = 0; i < users.length; i++) {
//			System.out.println("[" + i + "]" + users[i].getName() + "(" + users[i].getPayType() + ")");
//		}
		
		int index = 0;
		for(User user: users) {
			System.out.println("[" + index++ + "]" + user.getName() + "(" + user.getPayType() + ")");
		}
		
		System.out.println("[x]종 료");
		System.out.print("선택 : ");
		String choice = sc.nextLine();
		
		
		// choice ( 0, 1, x )
		switch(choice) {
			case "0" : case "1" :
				System.out.println("## " + choice + " 선택 ##");
				selUser = Integer.parseInt(choice);
				productList();
				break;
			case "x" :
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			default :
				System.out.println("잘못된 값이 입력되었습니다.");
				start();
				break;
		}
	}
	
	public void productList() {
		System.out.println(title + " : 상품 목록 - 상품 선택");
		System.out.println("========================");
		int index = 0;
		for(Product product: products) {
			System.out.print("[" + index++ + "]");
			product.printDetail();
		}
		
		System.out.println("[h]메인 화면");
		System.out.println("[c]체크 아웃");
		System.out.print("선택 : ");
		String choice = sc.nextLine();
		System.out.println("## " + choice + " 선택 ##");
		
		/*
			0 ~ 4 상품 : 장바구니에 상품을 담고, 다시한번 상품 목록 보여주기
			h : 계정선택
			c : checkOut 호출
				> 
		*/
		
		switch(choice) {
			case "0": case "1": case "2": case "3": case "4": // 0 ~ 4 장바구니 담고, 다시 한번 목록화면 보여주기
				for(int i = 0; i < carts.length; i++) {
					if(carts[i] == null) {
						carts[i] = products[Integer.parseInt(choice)];
						break;
					}
				}
				productList();
				break;
			case "h":
				System.out.println("계정선택화면으로 돌아갑니다...");
				start();
				break;
			case "c":
				checkOut();
				break;
			default:
				System.out.println("잘못된 값이 입력되었습니다.");
				productList();
				break;
		}
	}
	
	public void checkOut() {
		System.out.println(title + " : 체크아웃");
		System.out.println("========================");
		int index = 0;
		int totalPrice = 0;
		for(Product cart: carts) {
				if(cart != null) {
				System.out.print("[" + index++ + "]");
				System.out.println(cart.getpName() + "(" + cart.getPrice() + ")");
				totalPrice = totalPrice + cart.getPrice();
			}
		}
		System.out.println("========================");
		System.out.println("결제 방법 : " + users[selUser].getPayType());
		System.out.println("합계 : " + totalPrice);
		System.out.println("[p]이전 , [q] 결제 완료");
		System.out.print("선택 : ");
		String choice = sc.nextLine();
		
		switch(choice) {
			case "p":
				System.out.println("이전화면으로 돌아갑니다...");
				productList();
				break;
			case "q":
				System.out.println(totalPrice + "원 결제 완료 되었습니다.");
				break;
			default:
				System.out.println("잘못된 값이 입력되었습니다.");
				checkOut();
				break;
		}
	}
}
