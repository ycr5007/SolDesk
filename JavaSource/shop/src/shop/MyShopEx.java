package shop;

public class MyShopEx {
	public static void main(String[] args) {
//		IShop shop = new MyShop(); // 다형성
		MyShop shop = new MyShop();
		
		// 상호지정
		shop.setTitle("전자상가");
		
		// 고객(User)생성
		shop.genUser();
		
		// 제품생성
		shop.genProduct();
		
		// shop 시작
		shop.start();
	}
}
