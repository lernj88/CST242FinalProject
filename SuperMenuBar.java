package view;

import javafx.application.Platform;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class SuperMenuBar {
	private MenuBar startMenu;
	private Menu fileMenu;
	private MenuItem logoff;
	private MenuItem exit;
	
	public SuperMenuBar(Stage secondaryStage) {
		startMenu = new MenuBar();
		startMenu.prefWidthProperty().bind(secondaryStage.widthProperty());
		fileMenu = new Menu("File");
		logoff= new MenuItem("Log Out");
		exit = new MenuItem("Quit");
		fileMenu.getItems().addAll(logoff, exit);
		
		startMenu.getMenus().add(fileMenu);
		
		logoff.setOnAction(e -> {
			secondaryStage.close();
		});
		exit.setOnAction(e -> {
			Platform.exit();
		});
	}

	/**
	 * @return the startMenu
	 */
	public MenuBar getStartMenu() {
		return startMenu;
	}

	/**
	 * @return the fileMenu
	 */
	public Menu getFileMenu() {
		return fileMenu;
	}

	/**
	 * @return the logoff
	 */
	public MenuItem getLogoff() {
		return logoff;
	}

	/**
	 * @return the exit
	 */
	public MenuItem getExit() {
		return exit;
	}
}
