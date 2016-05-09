package exceptions;
/**
 * Should be thrown when GPA not between 0 and 4.
 * @author me
 *
 */
public class InvalidGPAException extends IllegalArgumentException {

	public InvalidGPAException() {
		super();
	}

	public InvalidGPAException(String s) {
		super(s);
	}
	
}
