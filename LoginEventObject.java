package eventobjects;

import java.util.EventObject;

public class LoginEventObject extends EventObject {
	private String username;
	private String password;

	public LoginEventObject(Object source) {
		super(source);
	}
	
	public LoginEventObject(Object source, String username, String password) {
		this(source);
		this.username = username;
		this.password = password;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	
	

}
