package eventlisteners;

import java.util.EventListener;

import tags.AddEventTag;

public interface AddEventListener extends EventListener {
	public void addButtonClicked(AddEventTag ev);
}
