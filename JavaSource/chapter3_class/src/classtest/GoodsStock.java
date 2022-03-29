package classtest;

public class GoodsStock {
	// Property : Code(P1010), Stock(25)
	// Function : Stock++, Stock--
		// Method > 제작자가 만든 어떠한 기능을 갖고 있다.
	String productCode;
	int stock;

	public GoodsStock() {	}
	
	public GoodsStock(String productCode, int stock) {
		this.productCode = productCode;
		this.stock = stock;
		System.out.println("제품번호 : " + productCode + "\t현재 수량 : " + stock);
	}

	/*
		접근제한자 return MethodName(args...) {
			함수 내용;
		}
		
		접근제한자 : public, private ...
		return : 메소드가 동작을 마지고, 메소드를 호출한 곳으로 값 반환
				> 일반 자료형 (byte, short, int, double, char ...)
				> 배열 (byte[], int[], double[] ...)
				> Class, Interface (String, 제작자가 만든 Class / Interface ...)
				> void ( 반환값 없음 )
	*/
	
	// 수량을 입력받아, 현재의 재고에 추가 > 현재 재고수량이 얼마인지 값 반환
	int increaseStock(int count) {
		stock += count;
		return stock;
		/*
			return 후 값 사용
				① 출력문에서 사용, 넘어오는 값을 출력한 후 값의 효용성이 사라짐
				② 변수에 담아 사용, 값 출력 또는 반환값을 이용하여 다른 계산에 활용
		*/
	}

	// 수량을 입력받아, 현재의 재고에 감소 > 현재 재고수량이 얼마인지 값 반환
	int decreaseStock(int count) {
		stock -= count;
		return stock;
	}
	
	public static void main(String[] args) {
		
		GoodsStock keyRing = new GoodsStock("A110", 100);
		// keyRing 제품 200개 추가
		System.out.println(keyRing.productCode + "의 입고 후 수량 > " + keyRing.increaseStock(200));
		GoodsStock pencil = new GoodsStock("S110", 350);
		System.out.println(pencil.productCode + "의 판매 후 수량 > " + pencil.decreaseStock(150));
		
		// 모든 제품 50개씩 추가 후 전체 합계 구하기
		int productStock = keyRing.increaseStock(50) + pencil.increaseStock(50);
		System.out.println("50개씩 추가입고 후 모든 제품의 수량 > " + productStock);
	}
}
