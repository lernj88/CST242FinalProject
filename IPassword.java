package model;

public interface IPassword extends IEncryption {
	public String assignPassword(String password);

	public boolean isValidPassword(String password);

	public String setNewPassword(String enteredPassword, String currentPassword, String newPassword,
			String newPasswordEntryTwo);
}
