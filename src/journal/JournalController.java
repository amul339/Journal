package journal;

import journalModel.JournalModels;
import journalModel.menuTable;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class JournalController extends JournalModels {
	
	public static void createTask(LocalDateTime timeDue, boolean isCritical, String currentTaskDescription) {
		// TODO Auto-generated method stub
		JournalModels.createTask(timeDue, isCritical, currentTaskDescription);
		
	}
	
	public static void loadSavedData() {
		JournalModels.loadSavedData();
	}
	
	public static void saveData() {
		JournalModels.saveData();
	}
	
	public static void removeSelectedRowFromModel() {
		JournalModels.removeSelectedRowFromModel();
	}
	
	public static void setDeleteButton(boolean bool) {
		Main.getMenu().enableDelete(bool);
	}
	
	public static menuTable getMenuTable() {
		return JournalModels.getMenuTable();
	}
	
	public static LocalDateTime getLocalDateTime() {
		return java.time.LocalDateTime.now();
	}
	
	public static DateTimeFormatter getDateTimeFormatter() {
		return JournalModels.getDateTimeFormatter();
	}
	
	public static String localDateTimeFormatter(LocalDateTime localdatetime) {
		return JournalModels.localDateTimeFormatter(localdatetime);
	}
	
	
}
