package interfacetest;

class Cat implements Soundable {
	@Override
	public String sound() {
		return "야옹";
	}
}

public class SoundableEx {
	public static void main(String[] args) {
		printSound(new Cat()); // Cat
		
		printSound(new Soundable() {
			@Override
			public String sound() {
				return "멍멍";
			}
		}); // Dog
	}
	
	private static void printSound(Soundable soundable) {
		System.out.println(soundable.sound());
	}
}
