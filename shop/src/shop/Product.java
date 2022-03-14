package shop;

public abstract class Product {
	private String pName; // 상품명
	private int price; // 가격

	public Product(String pName, int price) {
		this.pName = pName;
		this.price = price;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public void printDetail() {
		System.out.println("상품명 : " + pName);
		System.out.println("상품가 : " + price);
		printExtra();
	}
	
	public abstract void printExtra();
	
}
