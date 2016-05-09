package model;

public class ForwardMarch implements IMover {

	@Override
	public CharacterLink move(CharacterLink c) {
		return c.getNext();
	}

	

}
