package model;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * 
 * @author me
 *
 */
public class Student extends Person {
	private static final long serialVersionUID = 1835180187131099914L;
	private double gpa;
	// private GradeBag gBag = new GradeBag();
	private String major;
	private HashSet<Integer> coursesTaken = new HashSet<>();
	private HashSet<Integer> coursesTaking = new HashSet<>();
	private HashSet<Integer> coursesToTake = new HashSet<>();
	private int creditsTaking;
	// TODO LEAVING THIS IN FOR NOW IN CASE DECIDE TO USE (doubt it)
	// private final String studentID = "s" + this.getCounter();

	/*
	 * public Student() { super(1); }
	 */

	public Student(String fName, String lName, String password) {
		super(fName, lName, password, 1);
	}

	public Student(String fName, String lName, String password, String phone, Address address, String major, double gpa,
			int creditsTaking) {
		super(fName, lName, password, phone, address, 1);
		this.gpa = gpa;
		this.major = major;
		this.creditsTaking = creditsTaking;
	}

	public Student(double gpa, String fName, String lName, String password, String phone, Address address, String major,
			ArrayList<Integer> coursesTaken, ArrayList<Integer> coursesTaking, ArrayList<Integer> coursesToTake,
			int creditsTaking) {
		super(fName, lName, password, phone, address, 1);
		this.gpa = gpa;
		this.major = major;
		this.coursesTaken.addAll(coursesTaken);
		this.coursesTaking.addAll(coursesTaking);
		this.coursesToTake.addAll(coursesToTake);
		this.creditsTaking = creditsTaking;
	}
	/*
	 * public Student(double gpa, String fName, String lName, String phone,
	 * String address, String major, Course[] coursesTaken, Course[]
	 * coursesTaking, Course[] coursesToTake, int creditsTaking) { super (fName,
	 * lName, phone, address, 1); this.gpa = gpa; this.major = major;
	 * this.creditsTaking = creditsTaking;
	 * 
	 * }
	 */

	public Student(Student student) {
		super(student);
		this.gpa = student.gpa;
		this.major = student.major;
		this.coursesTaken = student.coursesTaken;
		this.coursesTaking = student.coursesTaking;
		this.coursesToTake = student.coursesToTake;
		this.creditsTaking = student.creditsTaking;
	}

	public boolean hasToTake(int crn) {
		for (Integer i : coursesToTake) {
			if (crn == i) {
				return true;
			}
		}
		return false;
	}

	public boolean hasNotTaken(int course) {
		/*
		 * if (coursesTaken.isEmpty()){ return true; }
		 */
		return !coursesTaken.contains(course);
	}

	public boolean isNotTaking(int course) {
		return !coursesTaking.contains(course);
	}

	// TODO: update this method to take into account a repeated class.
	/**
	 * This method is mainly designed for adding courses during import
	 * 
	 * @param coursesTaken
	 *            the coursesTaken to set
	 */
	public void addCoursesTaken(ArrayList<Integer> course) {
		for (Integer i : course) {
			if (hasNotTaken(i)) {
				coursesTaken.add(i);
			}

			if (!isNotTaking(i)) {
				coursesTaking.remove(i);
			}
		}
	}

	public void addCourseTaken(Integer crn) {
		if (hasNotTaken(crn)) {
			coursesTaken.add(crn);
		}
	}

	/**
	 * @return the coursesTaken
	 */
	public HashSet<Integer> getCoursesTaken() {
		return coursesTaken;
	}

	/**
	 * @return the coursesTaking
	 */
	public HashSet<Integer> getCoursesTaking() {
		return coursesTaking;
	}

	/**
	 * @param coursesTaking
	 *            the coursesTaking to set
	 */
	public void addCoursesTaking(HashSet<Integer> course) {
		for (Integer i : course) {
			if (isNotTaking(i)) {
				coursesTaking.add(i);
			}
			if (hasToTake(i)) {
				deleteCourseToTake(i);
			}
		}
	}

	public synchronized boolean deleteCoursesTaking(int course) {
		return coursesTaking.remove(course);
	}

	/**
	 * @return the coursesToTake
	 */
	public HashSet<Integer> getCoursesToTake() {
		return coursesToTake;
	}

	/**
	 * This method is a bit dangerous and then some. Nonetheless, it was the
	 * fastest way to implement in the UpdateStudentScene class. (no adds or
	 * deletes necessary). This method will overwrite the entire list, and is
	 * not the kind of thing that should be used half-cocked (is probably what
	 * someone wiser would say). It should be noted that
	 * {@link PeopleBag#updateCoursesToTake(MajorBag)} effectively handles any
	 * interdependencies between the three student course lists but may prove
	 * inefficient when it comes to changes committed to a single entity.
	 * Modification to also handle a single entity recommended in future
	 * updates.
	 * 
	 * @param coursesTaking
	 */
	public void setCoursesTaking(ArrayList<Integer> coursesTaking) {
		this.coursesTaking.clear();
		this.coursesTaking.addAll(coursesTaking);
	}

	/**
	 * @see Student#setCoursesTaking(ArrayList)
	 * @param coursesTaken
	 */
	public void setCoursesTaken(ArrayList<Integer> coursesTaken) {
		this.coursesTaken.clear();
		this.coursesTaken.addAll(coursesTaken);
	}

	/**
	 * @param coursesToTake
	 *            the coursesToTake to set
	 */
	public void defineCoursesToTakeForMajor(ArrayList<Integer> coursesToTake) {

		// doesn't address possibility of major being changed. Maybe add boolean
		// to address this and improve efficiency?

		/*
		 * if(this.coursesToTake.isEmpty()) {
		 * this.coursesToTake.addAll(coursesToTake); }
		 */

		this.coursesToTake.clear();
		this.coursesToTake.addAll(coursesToTake);
		for (Integer i : coursesToTake) {
			for (Integer j : coursesTaken) {
				if (i.equals(j)) {
					this.coursesToTake.remove(i);
				}
			}
			for (Integer k : coursesTaking) {
				if (i.equals(k)) {
					this.coursesToTake.remove(i);
				}
			}
		}
	}

	/**
	 * @return the gpa
	 */
	public double getGpa() {
		return gpa;
	}

	/**
	 * @param gpa
	 *            the gpa to set
	 */
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	/**
	 * @return the major
	 */
	public String getMajor() {
		return major;
	}

	/**
	 * @param major
	 *            the major to set
	 */
	public void setMajor(String major) {
		this.major = major;
	}

	public void deleteCourseToTake(Integer course) {
		coursesToTake.remove(course);
	}

	/**
	 * @return the creditsTaking
	 */
	public int getCreditsTaking() {
		return creditsTaking;
	}

	/**
	 * @param creditsTaking
	 *            the creditsTaking to set
	 */
	public void setCreditsTaking(int creditsTaking) {
		this.creditsTaking = creditsTaking;
	}
	
	

	/*
	 * public String getID() { return studentID; }
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Student [Name = " + getfName() + " " + getlName() + ", gpa = " + gpa + ", major = " + major
				+ ", coursesTaken = " + coursesTaken + ", coursesTaking = " + coursesTaking + ", coursesToTake = "
				+ coursesToTake + ", creditsTaking = " + creditsTaking + ", Phone = " + getPhone() + ", Address = "
				+ getAddress() + ", ID = " + getID() + "]";
	}
}
