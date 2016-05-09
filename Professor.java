package model;

import java.util.ArrayList;
import java.util.HashSet;

public class Professor extends Person {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8600837093740795251L;

	private String officeAddress;
	private String title;
	private String department;
	/**
	 * 
	 */
	private int payScale;
	private HashSet<Integer> coursesTeaching = new HashSet<>();

	public Professor(String fName, String lName, String password) {
		super(fName, lName, password, 2);
	}

	public Professor(String fName, String lName, String password, int payScale, String phone, Address homeAddress,
			String officeAddress, String title, String department) {
		super(fName, lName, password, phone, homeAddress, 2);
		this.officeAddress = officeAddress;
		this.title = title;
		this.department = department;
		this.payScale = payScale;
	}

	public Professor(Professor professor) {
		super(professor);
		this.officeAddress = professor.officeAddress;
		this.title = professor.title;
		this.department = professor.department;
		this.payScale = professor.payScale;
	}

	/**
	 * @return the officeAddress
	 */
	public String getOfficeAddress() {
		return officeAddress;
	}

	/**
	 * @param officeAddress
	 *            the officeAddress to set
	 */
	public void setOfficeAddress(String officeAddress) {
		this.officeAddress = officeAddress;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * @param department
	 *            the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/*
	 * public String getID() { return ID; }
	 */

	/**
	 * @return the payScale
	 */
	public int getPayScale() {
		return payScale;
	}

	/**
	 * @param payScale
	 *            the payScale to set
	 */
	public void setPayScale(int payScale) {
		this.payScale = payScale;
	}

	public boolean teachingCourse(int crn) {
		return coursesTeaching.contains(crn);
	}

	public void addCourses(HashSet<Integer> courses) {
		for (Integer i : courses) {
			if (!teachingCourse(i)) {
				coursesTeaching.add(i);
			}
		}
	}

	public HashSet<Integer> getCoursesTeaching() {
		return coursesTeaching;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Faculty [Name = " + getfName() + " " + getlName() + ", officeAddress = " + officeAddress + ", title = "
				+ title + ", department = " + department + ", payScale = " + payScale + ", Phone = " + getPhone()
				+ ", Address = " + getAddress() + ", ID = " + getID() + "]";
	}
}
