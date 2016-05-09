package eventobjects;

import java.util.ArrayList;
import java.util.HashSet;

import exceptions.InvalidGPAException;
import tags.AddEventTag;

public class StudentAddEventObject extends PersonAddEventObject implements AddEventTag {

	private String gpa;
	private String creditsTaking;
	
	private HashSet<String> coursesTaking;
	private HashSet<String> coursesTaken;

	public StudentAddEventObject(Object source) {
		super(source);
	}

	public StudentAddEventObject(Object source, String fName, String lName, String password, String gpa,
			String creditsTaking, String buildingNumber, String streetName, String city, String zip, String state,
			HashSet<String> coursesTaking, HashSet<String> coursesTaken) {
		super(source, fName, lName, password, buildingNumber, streetName, city, zip, state);
		this.gpa = gpa;
		this.creditsTaking = creditsTaking;
		this.coursesTaking = coursesTaking;
		this.coursesTaken = coursesTaken;
		check();
	}
	
	private void check() {
		if (gpa != null) {
			try {
				checkGpa();
			} catch (Exception e) {
				super.add(e);
			}
		}
		if (creditsTaking != null) {
			try {
				checkCredits();
			} catch (Exception e) {
				super.add(e);
			}
		}
	}

	private void checkCredits() {
		int credits = Integer.parseInt(creditsTaking);
		if (credits < 0) {
			throw new IllegalArgumentException("Students can't take a negative number of credits");
		}
	}

	private void checkGpa() {
		double gpaTemp = Double.valueOf(gpa);
		if (gpaTemp < 0 || gpaTemp > 4) { //assumes min gpa of 0 and max gpa of 4
			throw new InvalidGPAException("GPA must be a value between 0 and 4");
		}
	}
	
	public String getGpa() {
		return gpa;
	}
	
	public String getCredits() {
		return creditsTaking;
	}

}
