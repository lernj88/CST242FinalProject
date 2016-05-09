package tests;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import org.junit.BeforeClass;
import org.junit.Test;

import model.Person;

public class PersonTest {
	
	
	static Person p1;
	static Person p2;
	static Person p3;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Person.setCounter(70);
		p1 = new Person("John", "Doe", "Passw0rd", 1);
		p2 = new Person("Jane", "Doe", "Passw0rd", 2);
		p3 = new Person(p1);
	}

	@Test
	public void test() {
		assertThat(p1, is(not(p2)));
		//assertThat(p1, is(p3));
	}
	
	public void testUsername() {
		assertThat(p1.getUsername(), is("DoeJ71"));
		assertThat(p1.getUsername(), is("DoeJ72"));
	}

}
