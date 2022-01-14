package journalModel;

import java.io.BufferedReader;
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

import journal.CreateTaskUI;
import journal.InstanceHandler;
import journal.JournalController;


public class JournalModels {
	
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	
	private static menuTable menuTable = new menuTable();
	
	
	//createTaskIfOk returns true if all UI fields are OK for a task to be created, then creates the task.
	protected static boolean createTaskIfOk(String txtTaskString, String txtDueString, String comboTaskTypeSelectedString, boolean isCritical) {
		//create task instance if text-box has content, get input from text-box and additional settings.
		LocalDateTime timeDue = null;
		
		formatter = JournalModels.getDateTimeFormatter();
		
		if (!txtTaskString.isBlank()) {
			
			switch(comboTaskTypeSelectedString) {
			
				case"Midnight":
					timeDue = LocalDateTime.of(java.time.LocalDate.now(), LocalTime.of(23, 59, 59));
					break;
				case"7 Days":
					timeDue = LocalDateTime.of(java.time.LocalDate.now().plusDays(7), java.time.LocalTime.now());
					break;
				case"No Expiration":
					timeDue = null;
					break;
				case"<Custom>":
					try {
					timeDue = LocalDateTime.parse(txtDueString, formatter);
					}
					catch(DateTimeParseException exception) {
						return false;
					}
					
					if (timeDue.isBefore(java.time.LocalDateTime.now())) {
						return false;
					}
					
					break;
				default:
					timeDue = null;
					break;
			}
			
			JournalModels.createTaskOnTable(timeDue, isCritical, txtTaskString);
			
			return true;
		}
		return false;
	}
	
	protected static void removeSelectedRowFromModel() {
		
		int selectedRow = getMenuTable().getSelectedRow();
		
		if (selectedRow != -1) {
			getMenuTable().getTableModel().removeRow(selectedRow);
			JournalController.setDeleteButton(false);
		}
	}
	
	protected static void saveData() {
		// save each task and its data in text file format
		try {
			
			ArrayList<String> strTableTasks = new ArrayList<String>();
			ArrayList<Task> tableTasks = getMenuTable().getTableModel().getData();
		
			Path file = Paths.get("resources/savedJData.txt");
			
			
			
			// for each task, convert task to one big string with '^' separating task attributes.
			//look at method 'taskAttribToString';
			//store all task to string conversions in array
			//finally write to file
			for (Task task : tableTasks) {
				strTableTasks.add(taskAttribToString(task));
			}
			
			//add indicator for EOF
			strTableTasks.add("END");
		
			Files.write(file, strTableTasks, StandardCharsets.UTF_8);
			
			System.out.println("Successfully saved data");
			
		}
		catch (Exception ex) {
			System.out.println("Write error");
			System.out.println(ex);
		}
		
	}
	
	protected static void loadSavedData() {
		int dataLoadCount = 0; // counts how many tasks have been loaded
		System.out.println("Loading data...");
		
		try {
			@SuppressWarnings("resource")
			BufferedReader reader = new BufferedReader(new FileReader("resources/savedJData.txt"));
			String rline = reader.readLine();
				
			while(!rline.equals("END")) {
			
			
				String[] data = rline.split("\\^");
				//timeDue, timeAdded, isCritical, task description
				loadSingleTaskFromFile(LocalDateTime.parse(data[0], formatter),LocalDateTime.parse(data[1], formatter),Boolean.parseBoolean(data[2]),data[3]);
				rline = reader.readLine();
				dataLoadCount++;
			
			}
			
			System.out.println("Successfully loaded data");
		}
		catch(Exception ex) {
			System.out.println("Failed to load data on file line " + dataLoadCount + ", possibly corrupt?");
		}
		
	}
	
	private static void createTaskOnTable(LocalDateTime timeDue, boolean isCritical, String task) {
		getMenuTable().getTableModel().add(new Task(timeDue, isCritical, task));
	}
	
	protected static void deleteAllTasks() {
		getMenuTable().getTableModel().removeAll();
	}
	
	//helper function
	private static void loadSingleTaskFromFile(LocalDateTime timeDue, LocalDateTime timeAdded, boolean isCritical, String task) {
		getMenuTable().getTableModel().add(new Task(timeDue, timeAdded, isCritical, task));
	}
	//Converts task data to strings. Used for saving task data to text.
	protected static String taskAttribToString(Task task) {
		String taskDesc = task.toString();
		String addedTime = localDateTimeFormatter(task.getAddedLocalDateTime());
		String dueTime = localDateTimeFormatter(task.getDueLocalDateTime());
		String isCritical = Boolean.toString(task.checkIfCritical());
		
		
		return dueTime + "^" + addedTime + "^" + isCritical + "^" + taskDesc;
	}
	
	protected static menuTable getMenuTable() {
		return menuTable;
	}
	
	protected static DateTimeFormatter getDateTimeFormatter() {
		return formatter;
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
