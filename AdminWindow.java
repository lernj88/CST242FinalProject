package view;

import java.util.ArrayList;
import java.util.HashSet;

import eventlisteners.AddEventListener;
import eventobjects.StudentAddEventObject;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.Person;

public class AdminWindow {
	private AdminMenuBar menu;
	private ArrayList<GridPane> paneList;
	private Label fnameLbl;
	private Label lnameLbl;
	private Label passwordLbl;
	private Label gpaLbl;
	private Label creditsLbl;
	private Label buildingLbl;
	private Label cityLbl;
	private Label streetLbl;
	private Label stateLbl;
	private Label zipLbl;
	private Label coursesTakingLbl;
	private Label coursesTakenLbl;
	private TextField fnameField;
	private TextField lnameField;
	private TextField passwordField;
	private TextField gpaField;
	private TextField creditsField;
	private TextField buildingField;
	private TextField cityField;
	private TextField streetField;
	private TextField stateField;
	private TextField zipField;
	private TextField searchField;
	private TextArea coursesTaking;
	private TextArea coursesTaken;
	private Button addButton;
	private Button updateButton;
	private Button searchButton;
	//private Person current;
	private ArrayList<AddEventListener> add;
	private int currentListener = 0;
	private Stage secondaryStage = new Stage();
	
	public AdminWindow() {
		fnameLbl = new Label("First Name: ");
		lnameLbl = new Label("Last Name: ");
		passwordLbl = new Label("Password: ");
		gpaLbl = new Label("GPA: ");
		creditsLbl = new Label("Credits Taking: ");
		buildingLbl = new Label("House No.: ");
		streetLbl = new Label("Street: ");
		cityLbl = new Label("City: ");
		stateLbl = new Label("State: ");
		zipLbl = new Label("Zip: ");
		coursesTakingLbl = new Label("Courses Taking: ");
		coursesTakenLbl = new Label("Courses Taken: ");
		fnameField = new TextField();
		lnameField = new TextField();
		passwordField = new TextField();
		gpaField = new TextField();
		creditsField = new TextField();
		buildingField = new TextField();
		streetField = new TextField();
		cityField = new TextField();
		stateField = new TextField();
		zipField = new TextField();
		coursesTaking = new TextArea();
		coursesTaken = new TextArea();
		addButton = new Button();
		updateButton = new Button();
		GridPane studentPane = new GridPane();
		
		studentPane.addRow(0, fnameLbl, fnameField, lnameLbl, lnameField, passwordLbl, passwordField);
		studentPane.addRow(1, buildingLbl, buildingField, streetLbl, streetField, cityLbl, cityField, stateLbl, stateField, zipLbl, zipField);
		studentPane.addRow(2, gpaLbl, gpaField, creditsLbl, creditsField);
		studentPane.addRow(3, coursesTakingLbl, coursesTaking, coursesTakenLbl, coursesTaken);
		//studentPane.addRow(4, addButton, updateButton);
		HBox constantButtons = new HBox();
		constantButtons.getChildren().addAll(addButton, searchField, searchButton, updateButton);
		BorderPane hugePane = new BorderPane();
		hugePane.setTop(menu.getStartMenu());
		hugePane.setCenter(studentPane);
		hugePane.setBottom(constantButtons);
		
		Scene hugeScene = new Scene(hugePane);
		secondaryStage.setScene(hugeScene);
		
		addButton.setOnAction(e -> {
			String fname = fnameField.getText();
			String lname = lnameField.getText();
			String password = passwordField.getText();
			String gpa = gpaField.getText();
			String credits = creditsField.getText();
			String building = buildingField.getText();
			String street = streetField.getText();
			String city = cityField.getText();
			String zip = zipField.getText();
			String state = stateField.getText();
			HashSet<String> coursesTaken = new HashSet<>();
			HashSet<String> coursesTaking = new HashSet<>();
			String[] taking = this.coursesTaking.getText().split("\n");
			String[] taken = this.coursesTaken.getText().split("\n");
			for (String s : taken) {
				coursesTaken.add(s);
			}
			for (String s : taking) {
				coursesTaking.add(s);
			}
			
			StudentAddEventObject event = new StudentAddEventObject(this, fname, lname, password, gpa, credits, building, street, city, zip, state, coursesTaken, coursesTaking);
			if (add.get(currentListener) != null) {
				add.get(currentListener).addButtonClicked(event);
			}
		});
	}
	
	public void open() {
		secondaryStage.show();
	}
	
	public void addAddListeners(AddEventListener...eventListeners) {
		for(AddEventListener e : eventListeners) {
			add.add(e);
		}
	}
}
