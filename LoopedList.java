package model;

public class LoopedList {
	private CharacterLink start;
	private static boolean isCreated = false;
	private static final char MIN_NUM = '0';
	private static final char MAX_NUM = '9';
	private static final char MIN_UPPER = 'A';
	private static final char MAX_UPPER = 'Z';
	private static final char MIN_LOWER = 'a';
	private static final char MAX_LOWER = 'z';
	
	private static final int NUM_RANGE = MAX_NUM - MIN_NUM + 1;//1 added for upper-bound;
	private static final int UPPER_RANGE = MAX_UPPER - MIN_UPPER + 1;
	private static final int LOWER_RANGE = MAX_LOWER - MIN_LOWER + 1;
	private static final int TOTAL_RANGE = NUM_RANGE + UPPER_RANGE + LOWER_RANGE; 
	private static LoopedList looper;

	private LoopedList() {
		for (char i = MIN_NUM; i <= MAX_NUM; i++) {
			add(new CharacterLink(i));
		}
		for (char i = MIN_UPPER; i <= MAX_UPPER; i++) {
			add(new CharacterLink(i));
		}
		for (char i = MIN_LOWER; i <= MAX_LOWER; i++) {
			add(new CharacterLink(i));
		}
		add(new CharacterLink('_'));
	}

	private void add(CharacterLink c) {
		if (!isEmpty()) {
			c.setPrev(start.getPrev()).setNext(start);
			start.getPrev().setNext(c);
			start.setPrev(c);
		} else {
			(start = c).setNext(start).setPrev(start);
		}
	}

	public boolean isEmpty() {
		return start == null;
	}
	
	/**
	 * @return the first
	 */
	public CharacterLink getStart() {
		return start;
	}
	
	public static synchronized LoopedList getLooper() {
		if (!isCreated) {
			looper = new LoopedList();
		} 
		return looper;
	}

	/**
	 * 
	 * @param prev character just written
	 * @param current character to write
	 * @return <b>0</b>: forward<br> <b>1</b>: reverse
	 */
	public int determineDirection(char prev, char current) {
		int difference = Math.abs(processChar(current) - processChar(prev));
		if (difference > TOTAL_RANGE / 2 && current > prev) {
			return 0;
		}
		return 1;
	}
	
	public int processChar(char c) {
		if (c >= MIN_NUM && c <= MAX_NUM) {
			return c - MIN_NUM;
		} else if (c <= MAX_UPPER) {
			return NUM_RANGE + c - MIN_UPPER;   
		} else if (c <= MAX_LOWER) {
			return NUM_RANGE + UPPER_RANGE + c - MIN_LOWER;
		} else {
			return NUM_RANGE + UPPER_RANGE + LOWER_RANGE; //if underscore
		}
	}
	
	
}
