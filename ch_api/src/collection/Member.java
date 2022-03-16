package collection;

public class Member {
	private String id;
	private String name;
	private String password;

	public Member(String id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "\n[Member > id : " + id + " / name : " + name + " / password : " + password + "]\n";
	}
	
	// Set 에서 중복 저장이 안되도록 처리
	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Member) {
			Member mem = (Member)obj;
			return this.id.equals(mem.id);
		}
		return false;
	}
	
}
