package journalModel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;

import journal.JournalController;


public class JournalModels {
	
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	
	private static String username;
	private static CustomTableModel customtablemodel = new CustomTableModel();
	private static HashMap<String,Subject> subjectDirectory = new HashMap<String,Subject>();
	
	private static String targetDirectory = System.getProperty("user.home").concat("\\Documents\\Journal");
	private static String targetSavedLocation = System.getProperty("user.home").concat("\\Documents\\Journal\\savedJData.txt");
	
	private static LocalDateTime recentDueLocalDateTime = null;
	private static Subject recentSubject = null;
	
	protected static void setUsername(String name) {
		username = name;
	}
	
	protected static void addSubject(String subjectName, String subjectDescription) {
		subjectDirectory.put(subjectName, new Subject(subjectName, subjectDescription));
	}
	
	
	//returns boolean (yes if directory exists, otherwise no)
	protected static void initDirectory() {
		
		//first checks if directory already exists.
		
		File dir = new File(targetDirectory);
		if (!dir.exists()){
		    dir.mkdirs();
		}
		
	}
	
	
	//method checks if UI parameters are valid. 
	//If a custom due date has been chosen, the method will check if this is a valid date. If this chosen date is valid, it will update the recentDueLocalDateTime accordingly.
	//this is done to avoid parsing the due date again if the checkUIParameters happens to return true (clumsy, I know).
	protected static boolean checkUIParameters(String txtTaskString, String txtDueString, String comboTaskTypeSelectedString, String comboSubjectSelectedString) {
		
		formatter = JournalModels.getDateTimeFormatter();
		
		
		//band aid fix to not crash load/save system
		if (txtTaskString.contains("^")) {
			return false;
		}
		
		//check subject selection
		try {
			recentSubject = subjectDirectory.get(comboSubjectSelectedString);
		}
		catch (Exception e) {
			//probably a good idea to create a real error message here but if this is triggered something is horribly wrong.
			//likely means that method that updates the JComboBox for subject is broken.
			e.printStackTrace();
			return false;
		}
		
		if (!txtTaskString.equals("")) {
			
			switch(comboTaskTypeSelectedString) {
			
				case"Midnight":
					recentDueLocalDateTime = LocalDateTime.of(java.time.LocalDate.now(), LocalTime.of(23, 59, 59));
					break;
				case"7 Days":
					recentDueLocalDateTime = LocalDateTime.of(java.time.LocalDate.now().plusDays(7), java.time.LocalTime.now());
					break;
				case"No Expiration":
					recentDueLocalDateTime = null;
					break;
				case"<Custom>":
					try {
					recentDueLocalDateTime = LocalDateTime.parse(txtDueString, formatter);
					}
					catch(DateTimeParseException exception) {
						//This means that the user specified custom date format is incorrect.
						return false;
					}
					
					if (recentDueLocalDateTime.isBefore(java.time.LocalDateTime.now())) {
						return false;
					}
					
					break;
				default:
					recentDueLocalDateTime = null;
					break;
			}
			
			return true;
		}
		//may need to reset recentDueLocalDateTime variable...?? dunno
		return false;
	}
	
	protected static void removeSelectedRowFromModel(int selectedRow) {
		
		if (selectedRow != -1) {
			getCustomTableModel().removeRow(selectedRow);
		}
	}
	
	//returns the number of tasks successfully saved to file.
	//if error found, returns -1.
	protected static void saveData() {
		// save each task and its data in text file format
		
	}
	
	//returns number of tasks that have been successfully loaded
	//if error found, returns -1.
	protected static void loadSavedData() {
	
	}
	
	//Task instance gets generated and then is recorded onto table model.
	protected static void createTaskOnTable(LocalDateTime timeDue, LocalDateTime timeAdded, boolean isCritical, String task, Subject subject, String description) {
		getCustomTableModel().add(new Task(timeDue, timeAdded, isCritical, task, subject, description));
	}
	
	protected static void deleteAllTasks() {
		getCustomTableModel().removeAll();
	}
	
	protected static HashMap<String, Subject> getSubjectDirectory() {
		return subjectDirectory;
	}
	
	protected static CustomTableModel getCustomTableModel() {
		return customtablemodel;
	}
	
	protected static DateTimeFormatter getDateTimeFormatter() {
		return formatter;
	}
	
	protected static Subject getRecentSubject() {
		return recentSubject;
	}
	
	protected static LocalDateTime getRecentDueLocalDateTime() {
		return recentDueLocalDateTime;
	}

	//returns current LocalDateTime in string format.
	protected static String localDateTimeFormatter(LocalDateTime localDateTime) {
		
		if (localDateTime != null) {
			return localDateTime.format(JournalController.getDateTimeFormatter());
		}
		else {
			return "-";
		}
	}


	

}
