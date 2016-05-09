package controller;

import eventobjects.AdminAddEventObject;
import eventobjects.ProfAddEventObject;
import eventobjects.StudentAddEventObject;
import javafx.stage.Stage;
import model.Address;
import model.Admin;
import model.CourseBag;
import model.MajorBag;
import model.PeopleBag;
import model.Person;
import model.Student;

public class Controller {
	private PeopleBag pBag;
	public Controller(Stage primaryStage) {
		CourseBag cBag = new CourseBag();
		pBag = new PeopleBag();
		MajorBag mBag = new MajorBag();
		ViewFacade view = new ViewFacade(primaryStage);
		
		view.getAdminWindow().addAddListeners(e -> {
			StudentAddEventObject s = (StudentAddEventObject) e;
			if (s.getMessageList().isEmpty()) {
				String fname = s.getfName();
				String lname = s.getlName();
				String password = s.getPassword();
				Student student = new Student(fname, lname, password);
				Address address = new Address();
				if (s.getBuildingNumber() != null) {
					address.setBuildingNumber(Integer.parseInt(s.getBuildingNumber()));
				}
				address.setStreetName(s.getStreetName());
				address.setCity(s.getCity());
				address.setZip(s.getZip());
				address.setState(s.getState());
				
				student.setAddress(address);
				
				if (s.getGpa() != null) {
					student.setGpa(Double.parseDouble(s.getGpa()));
				}
				if (s.getCredits() != null) {
					student.setCreditsTaking(Integer.parseInt(s.getCredits()));
				}
				
				//student.setCoursesTaking(s.getCoursesTaking());
				//student.setCoursesTaken(s.getCoursesTaken());
			} else {
				//pass error messages to view here.
			}
		}, e -> {
			ProfAddEventObject prof = (ProfAddEventObject) e;
		}, e -> {
			AdminAddEventObject a = (AdminAddEventObject) e;
			
			if (a.getMessageList().isEmpty()) {
				String fname = a.getfName();
				String lname = a.getlName();
				String password = a.getPassword();
				Admin admin = new Admin(fname, lname, password);
				Address address = new Address();
				if (a.getBuildingNumber() != null) {
					address.setBuildingNumber(Integer.parseInt(a.getBuildingNumber()));
				}
				address.setStreetName(a.getStreetName());
				address.setCity(a.getCity());
				address.setZip(a.getZip());
				address.setState(a.getState());

				admin.setAddress(address);

				admin.setTitle(a.getTitle());
			}
		});
		
		view.getLoginWindow().setLoginListener(e -> {
			Person p = login(e.getUsername(), e.getPassword());
			if (p == null) {
				//pass error message to view
			} else if (p.getStatus() == 1) {
				primaryStage.hide();
				view.openStudentWindow();
			} else if (p.getStatus() == 2) {
				primaryStage.hide();
				view.openFacultyWindow();
			} else if (p.getStatus() == 3) {
				primaryStage.hide();
				view.openAdminWindow();
			}
		});
		
	}
	
	public Person login(String username, String password) {
		return pBag.login(username, password);
	}

}
