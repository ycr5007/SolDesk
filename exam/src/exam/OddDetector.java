package exam;

public abstract class OddDetector {
	int n;
	OddDetector(int n){
		this.n = n;
	}
	
	protected int getN() {
		return n;
	}
	
	abstract boolean isOdd();
}
