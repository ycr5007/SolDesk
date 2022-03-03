package condition;

/*
	for 문의 중첩
		행 / 열을 갖는 for 문
		
		=======================================
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 3; j++) {
					System.out.print(" * ");	
				}
				System.out.println();
			}
		=======================================
		
			열	내부	→
		행	i0,j0		i0,j1		i0,j2
		
		외	i1,j0		i1,j1		i1,j2
		부
			i2,j0		i2,j1		i2,j2
		↓
		
*/

public class ForEx7 {
	public static void main(String[] args) {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				System.out.print(" * ");	
			}
			System.out.println();
		}
	}
}
