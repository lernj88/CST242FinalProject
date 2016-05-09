package eventobjects;

public class AdminAddEventObject extends PersonAddEventObject {
	private String title;

	public AdminAddEventObject(Object source, String fName, String lName, String password, String buildingNumber,
			String streetName, String city, String zip, String state, String title) {
		super(source, fName, lName, password, buildingNumber, streetName, city, zip, state);
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}

}
