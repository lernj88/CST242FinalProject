package exceptions;
/**
 * Should be thrown in cases where password is not up to specifications or uses illegal characters.
 * @author me
 *
 */
public class InvalidPasswordException extends IllegalArgumentException {

	public InvalidPasswordException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InvalidPasswordException(String s) {
		super(s);
		// TODO Auto-generated constructor stub
	}
	

}
