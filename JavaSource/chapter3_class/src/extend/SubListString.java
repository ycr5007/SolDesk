package extend;

public class SubListString extends ListString {
	String name = "성춘향";
	
	// @ : 어노테이션, Compiler 에게 전달하는 내용
	@Override
	public void list() {
		super.list();
		System.out.println(name + " 하위 클래스");
	}
	
	public void writer() {
		System.out.println("상위 클래스 name : " + super.name);
		System.out.println("하위 클래스 name : " + this.name);
		System.out.println();
		System.out.println("this.list() 실행부분");
		this.list();
		System.out.println();
		System.out.println("super.list() 실행부분");
		super.list();
	}
}
