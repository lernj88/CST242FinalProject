package model;

/**
 * 
 * 
 * @author James Lerner
 *
 * @version Java 1.8.0_66
 * 
 * @see Person
 */
public class Admin extends Person {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7526489405989459796L;
	
	private String title;

	public Admin(String fName, String lName, String password) {
		super(fName, lName, password, 3);
	}
	
	/*public Person(String fName, String lName, String phone, Address address,
			int status) */
	public Admin(String fName, String lName, String password, String phone, Address address, String title) {
		super(fName, lName, password, phone, address, 3);
		this.title = title;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

}
