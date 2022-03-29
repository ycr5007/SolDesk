package api;

public class Member {
	private String id;

	public Member(String id) {
		this.id = id;
	}

	/*
		Object 메소드 오버라이딩
			Source - Override/Implement methods...
	*/
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Member) {
			Member member = (Member)obj;
			if(id.equals(member.id)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		return getClass() + "의 id : " + id;
	}
	
}
