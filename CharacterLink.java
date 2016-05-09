package model;

public class CharacterLink {
	private CharacterLink next;
	private CharacterLink prev;
	private char data;
	
	public CharacterLink(char c) {
		data = c;
	}

	/**
	 * @return the data
	 */
	public char getData() {
		return data;
	}

	/**
	 * @return the prev
	 */
	public CharacterLink getPrev() {
		return prev;
	}

	/**
	 * @param prev the prev to set
	 */
	public CharacterLink setPrev(CharacterLink prev) {
		this.prev = prev;
		return this;
	}

	/**
	 * @return the next
	 */
	public CharacterLink getNext() {
		return next;
	}
	
	public CharacterLink setNext(CharacterLink next) {
		this.next = next;
		return this;
	}
	
	public char write(char c) {
		return data == c? '1' : '0';
	}
	
	
}
