package shop;

public class CellPhone extends Product{
	private String carrier; // 통신사 정보

	public CellPhone(String pName, int price, String carrier) {
		super(pName, price);
		this.carrier = carrier;
	}
	
	@Override
	public void printExtra() {
		System.out.println("통신사 : " + carrier);
	}
}
