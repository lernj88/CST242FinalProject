package model;

public class EncryptionIterator {
	private static final LoopedList LIST = LoopedList.getLooper();
	/**
	 * by default the iterator starts at this character.
	 */
	private int currentChar = 0;
	private IMover[] mover = { new ForwardMarch(), new ReverseMarch() };

	public String encrypt(String s) {
		StringBuilder sb = new StringBuilder();
		sb.ensureCapacity(80);
		CharacterLink current = LIST.getStart();
		int currentMover = LIST.determineDirection(current.getData(), s.charAt(currentChar));
		if(currentMover == 1) {
			sb.append('2');
		}
		while (s.charAt(currentChar) != '~') { //checks for end of string
			int tempMover = 0;
			boolean oneWritten = false; //set to true when 1 is appended, i.e. s.charAt(currentChar) is equal to character stored in current
			while (!oneWritten) {
				sb.append(current.write(s.charAt(currentChar)));
				if(sb.charAt(sb.length() - 1) == '1') {
					oneWritten = true;
					currentChar++;
				}
				current = mover[currentMover].move(current);
				int start;
				while(sb.length() > 80 && (start = sb.indexOf("0000")) != -1) {
					sb.replace(start, start + 4, "4");
				}
			}
			if ((currentMover) != (tempMover = LIST.determineDirection(s.charAt(currentChar - 1), s.charAt(currentChar)))) {
				currentMover = tempMover;
				sb.append('2');
				current = mover[currentMover].move(current);
			}
		}
		return sb.toString();
	}
}
