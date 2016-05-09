package exceptions;
/**
 * should be thrown when 
 * @author me
 *
 */
public class InvalidAddressException extends IllegalArgumentException {
	
	
	public InvalidAddressException() {
		super();
	}

	public InvalidAddressException(String s) {
		super(s);
	}
	
}
