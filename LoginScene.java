package view;

import eventlisteners.LoginEventListener;
import eventobjects.LoginEventObject;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class LoginScene {
	private LoginEventListener login;
	private Label userLabel;
	private TextField userField;
	private Label passwordLabel;
	private PasswordField passwordField;
	private Button loginButton;
	private GridPane loginPane;
	private Scene loginScene;
	
	public LoginScene() {
		userLabel = new Label("Username: ");
		userField = new TextField("Enter username");
		passwordLabel = new Label("Password: ");
		passwordField = new PasswordField();
		loginButton = new Button("Login");
		
		loginPane = new GridPane();
		loginPane.addRow(0, userLabel, userField);
		loginPane.addRow(1, passwordLabel, passwordField);
		loginPane.add(loginButton, 1, 2);
		
		loginButton.setOnAction(e -> {
			String username = userField.getText();
			String password = passwordField.getText();
			LoginEventObject ev = new LoginEventObject(this, username, password);
			if(login != null) {
				clear();
				login.loginClicked(ev);
			}
		});
		
		loginScene = new Scene(loginPane);
	}
	
	public Scene getLoginScene() {
		return loginScene;
	}
	
	private void clear() {
		userField.clear();
		passwordField.clear();
	}
	
	public void setLoginListener(LoginEventListener e) {
		login = e;
	}

}
