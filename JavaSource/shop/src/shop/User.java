package shop;

public class User {
	private String name; // 고객명
	private PayType payType; // 결제방식 ( 유효성 검사 : 원하는 데이터 입력값 외 다른값은 처리하지 않음 )
	
	public User(String name, PayType payType) {
		this.name = name;
		this.payType = payType;
	}

	public String getName() {
		return name;
	}

	public PayType getPayType() {
		return payType;
	}
	
}
