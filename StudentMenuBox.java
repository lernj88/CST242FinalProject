package view;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class StudentMenuBox extends SuperMenuBar {
	private Menu studentMenu;
	private MenuItem sain;
	private MenuItem whatIf;
	
	public StudentMenuBox(Stage secondaryStage) {
		super(secondaryStage);
		
		studentMenu = new Menu("Student");
		sain = new MenuItem("Sain Report");
		whatIf = new MenuItem("What-If Analysis");
		studentMenu.getItems().addAll(sain, whatIf);
		
		whatIf.setOnAction(e -> {
			
		});
		
		sain.setOnAction(e -> {
			
		});
	}
}
