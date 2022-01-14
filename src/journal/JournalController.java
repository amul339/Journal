package journal;

import journalModel.JournalModels;
import journalModel.menuTable;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class JournalController extends JournalModels {

	//ALL PRIVATE FUNCTIONS 
	public static void loadSavedData() {
		//should probably clear tasks here prior to loading...
		deleteAllTasks();
		JournalModels.loadSavedData();
	}
	
	public static void saveData() {
		JournalModels.saveData();
	}
	
	public static void createTaskFromUI() {
		//Variables need for this
		
		String txtTaskString = JournalController.getComponentTxtTaskString();
		String txtDueString = JournalController.getComponentTxtDueString();
		String comboTaskTypeSelectedString = JournalController.getComponentComboTaskTypeSelectedString();
		boolean isCritical = JournalController.isComponentChkBoxCriticalChecked();
		
		if (JournalModels.createTaskIfOk(txtTaskString, txtDueString, comboTaskTypeSelectedString, isCritical)) {
			JournalController.disposeCreateTaskUI();
			InstanceHandler.closePort(CreateTaskUI.getPort());
		}
		else {
			JournalController.showMessageSomethingWentWrong();
		}
	}
	
	public static void removeSelectedRow() {
		
		if (JournalModels.removeSelectedRowFromModel()) {
			JournalController.setDeleteButton(false);
		}
		
		//Update UI Label to say that row has been removed?
	}
	
	private static void setDeleteButton(boolean bool) {
		Main.getMenu().enableDelete(bool);
	}
	
	//UI needs to access this therefore is set to public
	public static menuTable getMenuTable() {
		return JournalModels.getMenuTable();
	}
	
	private static String getComponentComboTaskTypeSelectedString() {
		return Main.getMenu().getCreateTaskUI().getComponentComboTaskTypeSelectedString();
	}
	
	private static String getComponentTxtDueString() {
		return Main.getMenu().getCreateTaskUI().getComponentTxtDueString();
	}
	
	private static String getComponentTxtTaskString() {
		return Main.getMenu().getCreateTaskUI().getComponentTxtTaskString();
	}
	
	private static boolean isComponentChkBoxCriticalChecked() {
		return Main.getMenu().getCreateTaskUI().isComponentChkBoxCriticalChecked();
	}
	
	private static void setComponentTxtDueToBlank() {
		Main.getMenu().getCreateTaskUI().setComponentTxtDueToBlank();
	}
	
	private static void showMessageIncorrectDateFormat() {
		Main.getMenu().getCreateTaskUI().showMessageIncorrectDateFormat();
	}
	
	private static void showMessageEnterFutureDate() {
		Main.getMenu().getCreateTaskUI().showMessageEnterFutureDate();
	}
	
	private static void showMessageSomethingWentWrong() {
		Main.getMenu().getCreateTaskUI().showMessageSomethingWentWrong();
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
