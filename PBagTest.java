package tests;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import exceptions.InvalidUsernameException;
import model.Admin;
import model.PeopleBag;
import model.Professor;
import model.Student;

public class PBagTest {
	//public Person(String fName, String lName, String password, int status) {
	static Professor p1;
	static Professor p2;
	static Professor p3;
	static Student s1;
	static Admin a1;
	static PeopleBag pBag;
	static InvalidUsernameException e = null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		p1 = new Professor("John", "Doe", "apoiuet");
		p2 = new Professor("Jane", "Doe", "apoiuet");
		p3 = new Professor(p2);
		s1 = new Student("Joan", "Doe", "qoiutq");
		a1 = new Admin("Jack", "Flash", "password");
		
		pBag = new PeopleBag();
		pBag.add(p1);
		pBag.add(p2);
		
		try {
			pBag.add(p3);
		} catch (InvalidUsernameException e1) {
			e = e1;
		}
	}

	@Test
	public void testContains() {
		assertThat(pBag.contains(s1.getID()), is(false));
		assertThat(pBag.contains(p2.getID()), is(true));
	}

	@Test
	public void testAdd() throws InvalidUsernameException {
		assertThat(pBag.add(a1), is(true));
		assertThat(e, is(notNullValue())); //making sure that exception thrown when should be.
	}
	
	@Test
	public void testFindByID() {
		assertThat(pBag.findById("00000001"), is(p1));
		assertThat(pBag.findById("719837531312"), is(nullValue()));
	}

}
