package tests;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.BeforeClass;
import org.junit.Test;

import model.SCCCLogin;

public class PasswordTests {
	static String tester;
	static String tester2;
	static String tester3;
	static String encrypted;
	static String encrypted2;
	static String encrypted3;
	static String decrypted;
	static String decrypted2;
	static String decrypted3;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		tester = "Wuite_Exciting_How_This_Almost_Works1"; 
		SCCCLogin login= new SCCCLogin();
		encrypted = login.encrypt(tester);
		decrypted = login.decrypt(encrypted);
		tester2 = "Very_Disappointing_How_It_Doesnt_Work"; //problem seems to be decryption with String where first character previous to 'W'.
		encrypted2 = login.encrypt(tester2);
		decrypted2 = login.decrypt(encrypted2);
		tester3 = "It_works_it_works12314"; //Yay!
		encrypted3 = login.encrypt(tester3);
		decrypted3 = login.decrypt(encrypted3);
	}
	
	/*@Test
	public void testEncrypt() {
		assertThat(encrypted.charAt(0), is('Z'));
		assertThat(encrypted.charAt(2), is('f'));
		assertThat(encrypted.charAt(4), is('t'));
		assertThat(encrypted.length(), is(6));
	}*/
	@Test
	public void testDecrypt() {
		assertThat(decrypted, is(tester));
		assertThat(decrypted2, is(tester2));
		assertThat(decrypted3, is(tester3));
	}

}
