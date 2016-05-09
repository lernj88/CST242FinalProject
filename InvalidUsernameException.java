package exceptions;
/**
 * This exception is thrown when a username is deemed invalid, such as when invalid characters are used, or when someone with the username already exists.
 * @author me
 *
 */
public class InvalidUsernameException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7130166780867336173L;

	public InvalidUsernameException() {
		// TODO Auto-generated constructor stub
	}

	public InvalidUsernameException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public InvalidUsernameException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidUsernameException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidUsernameException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
