package model;

import java.util.HashSet;

import tags.SainTag;

public class Course implements SainTag {
	private Professor prof;
	private Textbook tb;
	private HashSet<Student> students;
	
	private int crn;
	private String courseNumber;
	private String courseTitle;
	
	public Course(int crn, String courseNumber, String courseTitle) {
		this.crn = crn;
		this.courseNumber = courseNumber;
		this.courseTitle = courseTitle;
	}

	public Course(Course v) {
		this.prof = new Professor(prof);
		this.tb = new Textbook(tb);
		this.students = getStudents();
		this.crn = v.crn;
	}

	public synchronized boolean addStudent(Student s) {
		return students.add(s);
	}

	public boolean isInCourse(Student s) {
		return students.contains(s);
	}

	public void setCrn(int crn) {
		this.crn = crn;
	}

	public int getCrn() {
		return crn;
	}

	public void setProfessor(Professor prof) {
		this.prof = new Professor(prof);
	}

	public Professor getProfessor() {
		return prof;
	}

	/**
	 * @return the tb
	 */
	public Textbook getTb() {
		return tb;
	}

	/**
	 * @param tb
	 *            the tb to set
	 */
	public void setTb(Textbook tb) {
		this.tb = tb;
	}

	/**
	 * @return the students
	 */
	public HashSet<Student> getStudents() {
		HashSet<Student> studentsCopy = new HashSet<>();
		students.forEach(k -> {
			studentsCopy.add(new Student(k));
		});
		return new HashSet<Student>(students);
	}

}
