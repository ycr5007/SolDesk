package interfacetest;

public class AppInfoEx {
	public static void main(String[] args) {
		SeparateVolume book = new SeparateVolume("101D", "개미", "베르나르 베르베르");
		Lendable book1 = new SeparateVolume("110D", "신", "베르나르 베르베르");
		AppCD cd = new AppCD("999A", "Oracle");
		Lendable cd1 = new AppCD("999A", "MySQL");
		
		book.checkOut("홍길동", "2022-02-28");
		cd.checkOut("성춘향", "2022-03-01");
		
		book1.checkOut("홍길동", "2022-02-28");
		cd1.checkOut("성춘향", "2022-03-01");
		
	}
}
