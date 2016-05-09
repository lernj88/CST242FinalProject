package model;

public class ReverseMarch implements IMover {

	@Override
	public CharacterLink move(CharacterLink c) {
		return c.getPrev();
	}
}
