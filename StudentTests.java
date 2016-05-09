package tests;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.BeforeClass;
import org.junit.Test;

import model.Address;
import model.Student;

public class StudentTests {
	
	static Student student1;
	static Student student2;
	static Student student3;
	static Student s1Duplicate;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		/*
		 * public Address(int buildingNumber, String streetName, String city, String state, String zip)
		 * public Student(String fName, String lName, String password, String phone, Address address, String major, double gpa,
			int creditsTaking)
		 */
		student1 = new Student("John", "Doe", "Passw0rd", "631-278-9285", 
				new Address(26, "Whackamole Lane", "Hasbro", "NY", "11734"),
				"Amateur Basket Weaving", 2.5, 7);
		student2 = new Student("Jane", "Doe", "Passw0rd");
		student3 = new Student("Jean", "Doe", "Passw0rd");
		s1Duplicate = new Student(student1);
		
		student2.setAddress(student1.getAddress());
		student2.setfName("Joan");
		student2.setlName("d'Arc");
		student2.setMajor("French");
		student2.setGpa(4.0);
		student2.setPhone("631-918-2765");
	}

	@Test
	public void test() {
		assertThat(student2, is(student2));
		assertThat(student1, is(s1Duplicate));
		assertThat(s1Duplicate, is(student1));
		assertThat(student1, is(not(student2)));
		assertThat(student2, is(not(student1)));
		
		assertThat(student1.isAdmin(), is(false));
		assertThat(student1.isFaculty(), is(false));
		assertThat(student1.isStudent(), is(true));
		
		assertThat(student1.getAddress(), is(student2.getAddress()));
		assertThat(student2.getAddress(), is(student2.getAddress()));
		assertThat(student1.getAddress(), is(not(student3.getAddress())));
		
		assertThat(student1.getfName(), is("John"));
		assertThat(student1.getlName(), is("Doe"));
		assertThat(student1.getMajor(), is("Amateur Basket Weaving"));
		assertThat(student1.getMajor(), is(not(student2.getMajor())));
		
		assertThat(student1.getID(), is("00000001"));
	}

}
