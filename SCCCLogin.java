package model;

import java.util.Random;

public class SCCCLogin implements IUsername, IPassword {
	private static final int MAX_LENGTH = 4;

	@Override
	public String assignUsername(String fName, String lName, String id) {
		return new StringBuilder(lName.substring(lName.length() - getLastNameLengthMaxFour(lName)))
				.append(fName.charAt(0)).append(id.substring(id.length() - 2)).toString();
	}

	private int getLastNameLengthMaxFour(String lName) {
		return lName.length() > MAX_LENGTH ? MAX_LENGTH : lName.length();
	}

	@Override
	public String assignPassword(String password) {
		return encrypt(password);
	}

	@Override
	public boolean isValidPassword(String password) {
		final int MIN_PW_LENGTH = 8;
		if (password.length() < MIN_PW_LENGTH || password.contains("[^A-Za-z0-9_]")) {
			return false;
		} else if (!password.contains("[A-Z]") && !password.contains("[a-z]") && !password.contains("[0-9]")) {
			return false;
		}
		return true;
	}

	public boolean checkPassword(String enteredPassword, String currentPassword) {
		return enteredPassword.equals(decrypt(currentPassword));
	}

	private boolean checkPassword(String entry1, String entry2, boolean settingNew) {
		return entry1.equals(entry2);
	}

	public String setNewPassword(String enteredPassword, String currentPassword, String newPassword,
			String newPasswordEntryTwo) {
		if (checkPassword(enteredPassword, currentPassword) && checkPassword(newPassword, newPasswordEntryTwo, true)) {
			return encrypt(newPassword);
		}
		return null;
	}

	/*
	 * @Override public String encrypt(String information) { int offset = 1;
	 * String encrypt1 = encrypt1(information); StringBuilder sb = new
	 * StringBuilder(); for (int i = 0; i < encrypt1.length() - 1; i++) {
	 * sb.append((char)(encrypt1.charAt(i) + offset)); } return sb.toString(); }
	 * 
	 * public String decrypt(String information) { int offset = -1;
	 * StringBuilder sb = new StringBuilder(information.length()); for (int i =
	 * 0; i < information.length() - 1; i+=2) {
	 * sb.append((char)(information.charAt(i) + offset)); } return
	 * sb.toString(); }
	 */

	/*
	 * 
	 * The following was done purely for fun, and *almost* worked, but not
	 * quite... also, had a tendency to throw OutOfMemoryErrors for obvious
	 * reasons, so there's that too... 
	 * -UPDATE- now it should work properly,though memory may still be an
	 * issue when there are many Person objects(ergo too many passwords),
	 * or multiple threads working with password iterator (I imagine).
	 */ @Override
	public String encrypt(String information) {
		String encrypt1 = encrypt1(information);
		String encrypt2 = encrypt2(encrypt1);
		String encrypt3 = encrypt3(encrypt2);
		String encrypted = encrypt4(encrypt3);
		// String encrypted =
		// encrypt4(encrypt3(encrypt2(encrypt1(information))));
		return encrypted;
	}

	private String encrypt3(String partTwo) {
		return partTwo.replaceAll("0000", "4");
	}

	private String encrypt4(String partThree) {
		Random r = new Random();
		int arbitraryValue = r.nextInt(70);
		StringBuilder sb = new StringBuilder();
		if (arbitraryValue < 35) {
			return sb.append('^').append(partThree).toString();
		}
		String flipped = partThree.replaceAll("0", "3").replaceAll("1", "0").replaceAll("3", "1");
		return sb.append('v').append(flipped).toString();
	}

	private String encrypt2(String partOne) {
		EncryptionIterator ei = new EncryptionIterator();
		return ei.encrypt(partOne);
	}

	private String decrypt1(String partOne) {
		StringBuilder sb = new StringBuilder();
		if (partOne.charAt(0) == '^') {
			return sb.append(partOne.substring(1)).toString();
		} else {
			String flipped = partOne.substring(1).replaceAll("0", "3").replaceAll("1", "0").replaceAll("3", "1");
			return sb.append(flipped).toString();
		}
	}

	/*
	 * private String decrypt2(String partTwo) { return partTwo.replaceAll("4",
	 * "0000"); }
	 */

	private String decrypt3(String partThree) {
		DecryptionIterator di = new DecryptionIterator();
		return di.decrypt(partThree);
	}

	private String decrypt4(String partFour) {
		StringBuilder decryptor = new StringBuilder();
		for (int i = 0; i < partFour.length() - 1; i += 2) {
			decryptor.append(partFour.charAt(i));
		}
		return decryptor.toString();
	}

	public String decrypt(String engage) {
		String decrypt1 = decrypt1(engage);
		String decrypt3 = decrypt3(decrypt1);

		return decrypt4(decrypt3);
	}

	/**
	 * pre-encryption process. Adds random characters to password
	 * 
	 * @param info
	 * @return
	 */
	private String encrypt1(String info) {
		StringBuilder encryptor = new StringBuilder();
		for (int i = 0; i < info.length(); i++) {
			encryptor.append(info.charAt(i)).append(junkChar());
		}
		encryptor.append('~');
		return encryptor.toString();
	}

	private char junkChar() {
		Random r = new Random();
		final int MIN_VALUE = 33;
		final int MAX_VALUE = 126;
		final int NUM_MIN = '0';
		final int NUM_MAX = '9';
		final int NUM_RANGE = NUM_MAX - NUM_MIN;
		final int UPPERCASE_MIN = 'A';
		final int UPPERCASE_MAX = 'Z';
		final int UPPERCASE_RANGE = UPPERCASE_MAX - UPPERCASE_MIN;
		final int LOWERCASE_MIN = 'a';
		final int LOWERCASE_MAX = 'z';
		final int LOWERCASE_RANGE = LOWERCASE_MAX - LOWERCASE_MIN;

		int ranNum = MIN_VALUE + r.nextInt(MAX_VALUE - MIN_VALUE);
		return (char) (ranNum < NUM_MIN ? NUM_MIN + (NUM_MIN - ranNum) % NUM_RANGE
				: ranNum <= NUM_MAX ? ranNum
						: ranNum < UPPERCASE_MIN ? UPPERCASE_MIN + (UPPERCASE_MIN - ranNum) % UPPERCASE_RANGE
								: ranNum <= UPPERCASE_MAX ? ranNum
										: ranNum < LOWERCASE_MIN
												? LOWERCASE_MIN + (LOWERCASE_MIN - ranNum) % LOWERCASE_RANGE
												: LOWERCASE_MIN + (ranNum - LOWERCASE_MIN) % LOWERCASE_RANGE);
	}

}
