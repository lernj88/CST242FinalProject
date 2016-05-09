package model;

import java.util.ArrayList;
import java.util.HashSet;

import tags.SainTag;

public class Major implements SainTag {
	private String title;
	private String id;
	
	/**
	 * This HashSet accepts the Course's unique crn, acting as a check against duplicates.
	 */
	private HashSet<Integer> courses;
	private ArrayList<Course> majorCourses;
	private ArrayList<Course> engCourses;
	private ArrayList<Course> sciCourses;
	private ArrayList<Course> matCourses;
	private ArrayList<Course> sscCourses;
	private ArrayList<Course> humCourses;

	/*
	 * pk- must be unique, primary key nn- means no null uq- means unique ai-
	 * auto-incremented
	 * 
	 */

	public Major(String title, String id) {
		this.title = title;
		this.id = id;
		courses = new HashSet<>();
		majorCourses = new ArrayList<>();
		engCourses = new ArrayList<>();
		sciCourses = new ArrayList<>();
		matCourses = new ArrayList<>();
		sscCourses = new ArrayList<>();
		humCourses = new ArrayList<>();
	}

	/*
	 * 0 = major course 1 = eng course 2 = sci course 3 = mat course 4 = ssc
	 * course 5 = hum course
	 */
	/**
	 * 
	 * @param c
	 *            course to add
	 * @param courseType
	 *            0 = maj, 1 = eng, 2 = sci, 3 = mat, 4 = ssc, 5 = hum
	 * @return <b>true</b> if course added successfully, <b>false</b> if course
	 *         already on the list, or the courseType is invalid.
	 */
	public boolean addCourse(Course c, int courseType) {
		switch (courseType) {
		case 0:
			return courses.add(c.getCrn()) && majorCourses.add(c);
		case 1:
			return courses.add(c.getCrn()) && engCourses.add(c);
		case 2:
			return courses.add(c.getCrn()) && sciCourses.add(c);
		case 3:
			return courses.add(c.getCrn()) && matCourses.add(c);
		case 4:
			return courses.add(c.getCrn()) && sscCourses.add(c);
		case 5:
			return courses.add(c.getCrn()) && humCourses.add(c);
		default:
			return false;
		}
	}

	public boolean removeCourse(Course c) {
		return (majorCourses.remove(c) || engCourses.remove(c) || sciCourses.remove(c) || matCourses.remove(c)
				|| sscCourses.remove(c) || humCourses.remove(c)) && courses.remove(c.getCrn());
	}

	/**
	 * This method will return all courses for the major as an ArrayList of
	 * ArrayList{@literal <Course>}, using the following indices: <br>
	 * <br>
	 * 
	 * <b>majorIndex</b> = 0<br>
	 * <b>engIndex</b> = 1<br>
	 * <b>sciIndex</b> = 2<br>
	 * <b>matIndex</b> = 3<br>
	 * <b>sscIndex</b> = 4<br>
	 * <b>humIndex</b> = 5
	 * 
	 */
	public ArrayList<ArrayList<Course>> getAllCourses() {
		ArrayList<ArrayList<Course>> lookAtAllTheseCourses = new ArrayList<>();
		lookAtAllTheseCourses.add(majorCourses);
		lookAtAllTheseCourses.add(engCourses);
		lookAtAllTheseCourses.add(sciCourses);
		lookAtAllTheseCourses.add(matCourses);
		lookAtAllTheseCourses.add(sscCourses);
		lookAtAllTheseCourses.add(humCourses);
		return lookAtAllTheseCourses;
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

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
}
