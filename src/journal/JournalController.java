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
	
	public static void createTaskCheck() {
		JournalModels.createTaskCheck();
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
	
	public static String getComponentComboTaskTypeSelectedString() {
		return Main.getMenu().getCreateTaskUI().getComponentComboTaskTypeSelectedString();
	}
	
	public static String getComponentTxtDueString() {
		return Main.getMenu().getCreateTaskUI().getComponentTxtDueString();
	}
	
	public static String getComponentTxtTaskString() {
		return Main.getMenu().getCreateTaskUI().getComponentTxtTaskString();
	}
	
	public static boolean isComponentChkBoxCriticalChecked() {
		return Main.getMenu().getCreateTaskUI().isComponentChkBoxCriticalChecked();
	}
	
	public static void setComponentTxtDueToBlank() {
		Main.getMenu().getCreateTaskUI().setComponentTxtDueToBlank();
	}
	
	public static void showMessageIncorrectDateFormat() {
		Main.getMenu().getCreateTaskUI().showMessageIncorrectDateFormat();
	}
	
	public static void showMessageEnterFutureDate() {
		Main.getMenu().getCreateTaskUI().showMessageEnterFutureDate();
	}
	
	public static void disposeCreateTaskUI() {
		Main.getMenu().getCreateTaskUI().disposeCreateTaskUI();
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
