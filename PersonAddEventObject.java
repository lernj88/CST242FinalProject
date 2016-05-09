package eventobjects;

import java.util.ArrayList;
import java.util.EventObject;

import exceptions.InvalidPasswordException;
import exceptions.InvalidAddressException;
import tags.AddEventTag;

public class PersonAddEventObject extends EventObject implements AddEventTag {
	private ArrayList<String> messageList;
	private String fName;
	private String lName;
	private String password;
	private String buildingNumber;
	private String streetName;
	private String city;
	/**
	 * 5-digit number denoting zip code.
	 */
	private String zip;
	private String state;
	
	public PersonAddEventObject(Object source) {
		super(source);
	}

	public PersonAddEventObject(Object source, String fName, String lName, String password, String buildingNumber,
			String streetName, String city, String zip, String state) {
		super(source);
		messageList = new ArrayList<>();
		this.fName = fName;
		this.lName = lName;
		this.password = password;
		this.buildingNumber = buildingNumber;
		this.streetName = streetName;
		this.city = city;
		this.zip = zip;
		this.state = state;
		check();
	}
	private void check() {
		if(buildingNumber != null) {
			try {
				checkBuildingNumber();
			} catch (Exception e) {
				add(e);
			}
		}
		if(zip != null) {
			try {
				checkZip();
			} catch (Exception e) {
				add(e);
			}
		}
		try {
			checkPassword();
		} catch (InvalidPasswordException e) {
			add(e);
		}
	}

	private void checkPassword() {
		final int MIN_PW_LENGTH = 8;
		if (password.length() < MIN_PW_LENGTH) {
			throw new InvalidPasswordException("Please enter a password that is at least 8 characters long");
		}
		if (password.contains("[^A-Za-z0-9_]")) {
			throw new InvalidPasswordException("Please enter a password containing only numbers, letters, and underscores");
		}
		if (!password.contains("[A-Z]") && !password.contains("[a-z]") && !password.contains("[0-9]")) {
			throw new InvalidPasswordException("Please enter a password containging at least:\none upper-case character \none lower-case character \none number character");
		}
	}

	private void checkZip() {
		if(zip.length() != 5) {
			throw new InvalidAddressException("The zip code is a 5-digit code, not " + zip.length());
		}
		Integer.valueOf(zip);
	}

	private void checkBuildingNumber() {
		if (Integer.valueOf(buildingNumber) < 1) {
			throw new InvalidAddressException("Please enter a building number > 0");
		}
	}
	
	public void add(Exception e) {
		messageList.add(e.getMessage());
	}

	/**
	 * @return the messageList
	 */
	public ArrayList<String> getMessageList() {
		return messageList;
	}

	/**
	 * @return the fName
	 */
	public String getfName() {
		return fName;
	}

	/**
	 * @return the lName
	 */
	public String getlName() {
		return lName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @return the buildingNumber
	 */
	public String getBuildingNumber() {
		return buildingNumber;
	}

	/**
	 * @return the streetName
	 */
	public String getStreetName() {
		return streetName;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @return the zip
	 */
	public String getZip() {
		return zip;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	
}
