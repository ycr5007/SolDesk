package exam;

public class Odd extends OddDetector {

	Odd(int n) {
		super(n);
	}
	
	@Override
	boolean isOdd() {
		if(n % 2 != 0) {
			return true;
		}
		return false;
	}
}
