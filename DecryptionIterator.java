package model;

public class DecryptionIterator {
	
	private static final LoopedList LIST = LoopedList.getLooper();
	/**
	 * by default the iterator starts at this character.
	 */
	private int currentChar = 0;
	private IMover[] mover = { new ForwardMarch(), new ReverseMarch() };

	public String decrypt(String s) {
		StringBuilder sb = new StringBuilder();
		CharacterLink current = LIST.getStart();
		int currentMover = 0;
		if (s.charAt(0) == '2') {
			currentMover = 1;
			currentChar++;
		}
		while (currentChar < s.length()) { //checks for end of string
			if (s.charAt(currentChar) == '4') {
				for (int i = 0; i < 4; i++) {
					current = mover[currentMover].move(current);
				}
			} else if (s.charAt(currentChar) == '2') {
				currentMover = swapMover(currentMover);
				current = mover[currentMover].move(current);
				
			} else if(s.charAt(currentChar) == '1') {
				sb.append(current.getData());
				current = mover[currentMover].move(current);
			} else {
				current = mover[currentMover].move(current);
			}
			currentChar++;
		}
		return sb.toString();
	}
	
	public int swapMover(int mover) {
		if (mover == 0) {
			return 1;
		}
		return 0;
	}
}
