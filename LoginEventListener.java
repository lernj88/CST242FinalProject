package eventlisteners;

import java.util.EventListener;

import eventobjects.LoginEventObject;

public interface LoginEventListener extends EventListener {
	public void loginClicked(LoginEventObject ev);
}
