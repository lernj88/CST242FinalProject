package eventobjects;

import java.util.HashSet;

public class ProfAddEventObject extends PersonAddEventObject{
	private String title;
	private String department;
	private HashSet<Integer> coursesTeaching; 

	public ProfAddEventObject(Object source, String fName, String lName, String password, String buildingNumber,
			String streetName, String city, String zip, String state, String title, String department) {
		super(source, fName, lName, password, buildingNumber, streetName, city, zip, state);
		this.title = title;
		this.department = department;
	}

	public ProfAddEventObject(Object source) {
		super(source);
		// TODO Auto-generated constructor stub
	}
	
}
