package classtest;

public class PhysicalInfo {
	
	// Property : 이름, 나이, 키, 몸무게
	String name;
	int age;
	double height;
	double weight;

	// Constructor : 멤버변수 4개를 모두 전달인자로 받는 형태
	public PhysicalInfo(String name, int age, double height, double weight) {
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}
	
	// Function : update(age), update(age, height), update(age, height, weight)
	void update(int age) {
		this.age = age;
	}

	void update(int age, double height) {
		this.age = age;
		this.weight = height;
	}
	
	void update(int age, double height, double weight) {
		this.age = age;
		this.height = height;
		this.weight = weight;
	}
	
	
}
