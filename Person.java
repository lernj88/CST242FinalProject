package model;

import java.io.Serializable;

import tags.SainTag;

/**
 * 
 * @author me
 *
 */
public class Person implements Serializable, SainTag {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3287598641180452850L;
	private String fName;
	private String lName;
	private String password;
	private String phone;
	/**
	 * Persons' home address
	 * 
	 * @see Address
	 */
	private Address address;
	private IUsername usernameAssignator;
	private IPassword passwordStuff;
	/**
	 * 1: Student<br>
	 * 2: Professor<br>
	 * 3: Admin
	 */
	private final int STATUS;
	private final String ID;
	private final String USERNAME;

	private static int counter;

	/*
	 * public Person(int status) { ID = Integer.toString(++counter); this.STATUS
	 * = status; }
	 */

	public Person(String fName, String lName, String password, int status) {
		this.STATUS = status;
		this.fName = fName;
		this.lName = lName;
		synchronized (this) {
			ID = String.format("%08d", ++counter);
		}
		usernameAssignator = new SCCCLogin();
		passwordStuff = (IPassword) usernameAssignator;
		USERNAME = assignUsername();
	}

	public Person(String fName, String lName, String password, String phone, Address address, int status) {
		this(fName, lName, password, status);
		this.phone = phone;
		this.address = address;
	}

	public Person(Person person) {
		this.fName = person.fName;
		this.lName = person.lName;
		this.phone = person.phone;
		// this.address = new Address(person.address);
		this.ID = person.ID;
		this.STATUS = person.STATUS;
		this.USERNAME = person.USERNAME;
	}

	/**
	 * @return the fName
	 */
	public String getfName() {
		return fName;
	}

	/**
	 * @param fName
	 *            the fName to set
	 */
	public void setfName(String fName) {
		this.fName = fName;
	}

	/**
	 * @return the lName
	 */
	public String getlName() {
		return lName;
	}

	/**
	 * @param lName
	 *            the lName to set
	 */
	public void setlName(String lName) {
		this.lName = lName;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone
	 *            the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	public void setAddress(int buildingNumber, String streetName, String city, String zip, String state) {
		this.address.setBuildingNumber(buildingNumber);
		this.address.setStreetName(streetName);
		this.address.setCity(city);
		this.address.setZip(zip);
		this.address.setState(state);
	}

	/*
	 * private int getLastNameLengthMaxFour() { return lName.length() > 4 ? 4 :
	 * lName.length(); }
	 * 
	 *//**
		 * Replace with interface for more versatility?
		 * 
		 * @return
		 *//*
		 * private String assignUsername() { return new
		 * StringBuilder(lName.substring(lName.length() -
		 * getLastNameLengthMaxFour()))
		 * .append(fName.charAt(0)).append(ID.substring(ID.length() -
		 * 2)).toString(); }
		 */

	/**
	 * Assigns username automatically as specified by the given
	 * usernameAssignator.
	 * 
	 * @return
	 * 
	 */
	private String assignUsername() {
		return usernameAssignator.assignUsername(fName, lName, ID);
	}

	/**
	 * This method should be used if automatic assignment of username fails or
	 * is unwanted.
	 * 
	 * @param username
	 */
	/*
	 * public void setUsername(String username) { this.username = username }
	 */

	/**
	 * 
	 * @return username - used to login
	 */
	public String getUsername() {
		return USERNAME;
	}

	/**
	 * @return the iD
	 */
	public String getID() {
		return ID;
	}

	/**
	 * @return the counter
	 */
	public static int getCounter() {
		return counter;
	}

	public static void setCounter(int counter) {
		if (Person.counter == 0) {
			Person.counter = counter;
		}
	}

	/**
	 * @return the status
	 */
	public int getStatus() {
		return STATUS;
	}

	public boolean isStudent() {
		return STATUS == 1;
	}

	public boolean isFaculty() {
		return STATUS == 2;
	}

	public boolean isAdmin() {
		return STATUS == 3;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ID == null) ? 0 : ID.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (ID == null) {
			if (other.ID != null)
				return false;
		} else if (!ID.equals(other.ID))
			return false;
		/*
		 * if (STATUS != other.STATUS) return false; if (USERNAME == null) { if
		 * (other.USERNAME != null) return false; } else if
		 * (!USERNAME.equals(other.USERNAME)) return false; if (address == null)
		 * { if (other.address != null) return false; } else if
		 * (!address.equals(other.address)) return false; if (fName == null) {
		 * if (other.fName != null) return false; } else if
		 * (!fName.equals(other.fName)) return false; if (lName == null) { if
		 * (other.lName != null) return false; } else if
		 * (!lName.equals(other.lName)) return false; if (password == null) { if
		 * (other.password != null) return false; } else if
		 * (!password.equals(other.password)) return false; if (phone == null) {
		 * if (other.phone != null) return false; } else if
		 * (!phone.equals(other.phone)) return false;
		 */
		return true;
	}
	
	/**
	 * This method will set a new password if a basic password-check is satisfied.
	 * If currentPassword does not match {@link Person#password} exactly, then the password will not be changed.
	 * @param currentPassword - case-sensitive, old password.
	 * @param newPassword - the password with which to replace password.
	 * @return returns false if password does not match, true if successful in setting new password.
	 */
	public boolean setPassword(String currentPassword, String newPassword, String newPasswordEntryTwo) {
		String temp = passwordStuff.setNewPassword(currentPassword, this.password, newPassword, newPasswordEntryTwo);
		if (temp != null) {
			password = temp;
			return true;
		}
		return false;
	}
	
	public boolean checkPassword(String password) {
		return ((SCCCLogin)passwordStuff).checkPassword(password, this.password);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Person [fName=" + fName + ", lName=" + lName + ", phone=" + phone + ", address=" + address + "ID = "
				+ ID + "]";
	}
}
