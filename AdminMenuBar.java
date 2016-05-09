package view;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class AdminMenuBar extends SuperMenuBar {
	
	private Menu studentMenu;
	private MenuItem addStudent;
	private MenuItem updateStudent;
	private MenuItem whatIf;
	private MenuItem sain;
	private Menu professorMenu;
	private MenuItem addProfessor;
	private MenuItem updateProfessor;

	public AdminMenuBar(Stage secondaryStage) {
		super(secondaryStage);
		super.getLogoff().setOnAction(e -> {
			
			secondaryStage.close();
		});
	}

	/**
	 * @return the studentMenu
	 */
	public Menu getStudentMenu() {
		return studentMenu;
	}

	/**
	 * @return the addStudent
	 */
	public MenuItem getAddStudent() {
		return addStudent;
	}

	/**
	 * @return the updateStudent
	 */
	public MenuItem getUpdateStudent() {
		return updateStudent;
	}

	/**
	 * @return the whatIf
	 */
	public MenuItem getWhatIf() {
		return whatIf;
	}

	/**
	 * @return the sain
	 */
	public MenuItem getSain() {
		return sain;
	}

	/**
	 * @return the professorMenu
	 */
	public Menu getProfessorMenu() {
		return professorMenu;
	}

	/**
	 * @return the addProfessor
	 */
	public MenuItem getAddProfessor() {
		return addProfessor;
	}

	/**
	 * @return the updateProfessor
	 */
	public MenuItem getUpdateProfessor() {
		return updateProfessor;
	}
	
	
}
