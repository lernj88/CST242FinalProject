package controller;

import javafx.stage.Stage;
import view.AdminWindow;
import view.FacultyWindow;
import view.LoginScene;
import view.StudentWindow;

/**
 * Note to self: not quite as much a facade as originally planned. Think of new name.
 * @author me
 *
 */
public class ViewFacade {
	private LoginScene loginWindow;
	private AdminWindow adminWindow;
	private FacultyWindow facultyWindow;
	private StudentWindow studentWindow;

	public ViewFacade(Stage primaryStage) {
		loginWindow = new LoginScene();
		adminWindow = new AdminWindow();
		facultyWindow = new FacultyWindow();
		
	}

	/**
	 * @return the loginWindow
	 */
	public LoginScene getLoginWindow() {
		return loginWindow;
	}
	
	public AdminWindow getAdminWindow() {
		return adminWindow;
	}
	
	public void openAdminWindow() {
		adminWindow.open();
	}
	
	public void openFacultyWindow() {
		facultyWindow.open();
	}
	
	public void openStudentWindow() {
		studentWindow.open();
	}
	
}
