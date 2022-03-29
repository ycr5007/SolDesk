package thread;

public class SmallLetters extends Thread {
	@Override
	public void run() {
		for(char ch = 'a'; ch <= 'z'; ch++) {
			System.out.print(ch + " ");
		}
	}
	
}
