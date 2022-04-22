package member.action;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ActionForward {
	private String path;
	private boolean redirect = true;

	public ActionForward(String path) {
		this.path = path;
	}
	
	public ActionForward(String path, boolean redirect) {
		this.path = path;
		this.redirect = redirect;
	}
	
}
