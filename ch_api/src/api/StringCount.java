package api;

public class StringCount {
	public static void main(String[] args) {
		String str1 = "aabbccAABBCCaa";
		
		int cnt = count(str1, "aa", 0);
		System.out.println("원본 문자열에 aa 패턴이 " + cnt + "개 나왔습니다.");
	}
	
	public static int count(String src, String key, int pos) {
		// key에 해당하는 패턴이 몇번 나왔는가?
		int cnt = 0;
		for(int i = pos; i < src.length(); i++) {
			if(src.substring(i).startsWith(key)) {
				cnt++;
			}
		}
		return cnt;
	}
	
	public static int countHY(String src, String key, int pos) {
		int count = 0;
		boolean status = true;
		while(status) {
			if(src.indexOf(key, pos) >= pos) {
				count++;
				pos = src.indexOf(key,pos + 1);
			}else {
				status = false;
			}
		}
		return count;
	}
	
	public static int countAnswer(String src, String key, int pos) {
		int count = 0;
		int index = 0;
		
		if(key == null || key.length() == 0) {
			return -1;
		}
		
		while((index = src.indexOf(key, pos)) != -1) {
			count++;
			pos = index + key.length();
		}
		return count;
	}
}
