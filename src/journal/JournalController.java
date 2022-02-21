package journal;

import journalModel.*;

import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;

public class JournalController extends JournalModels {
	final static String CREATETASKPANEL = "Create Task Panel";
	final static String IDLEPANEL = "Idle Panel";

	//ALL PRIVATE FUNCTIONS 
	public static void loadSavedDataCall() {
		
		
		
		//check if directory exists
		JournalModels.initDirectory();
		
		//should probably clear tasks here prior to loading...
		JournalModels.deleteAllTasks();
		
		int dataLoadCount = JournalModels.loadSavedData();
		
		if (dataLoadCount == -1) {
			JournalController.setStatusLabel("Failed to load data");
		}
		else {
			JournalController.setStatusLabel("Successfully loaded " + dataLoadCount + " tasks");
		}
		
	}
	
	public static void saveDataCall() {
		
		//check if directory exists
		JournalModels.initDirectory();
		
		int dataSaveCount = JournalModels.saveData();
		
		if (dataSaveCount == -1) {
			JournalController.setStatusLabel("Failed to save data");
		}
		else {
			JournalController.setStatusLabel("Successfully saved " + dataSaveCount + " tasks");
		}
		
	}
	
	public static void createTaskFromUI() {
		//Variables need for this
		
		String txtTaskString = JournalController.getComponentTxtTaskString();
		String txtDueString = JournalController.getComponentTxtDueString();
		String comboTaskTypeSelectedString = JournalController.getComponentComboTaskTypeSelectedString();
		String comboSubjectSelectedString = Main.getMenu().getCreateTaskCard().getComboSubjectSelectedString();
		boolean isCritical = JournalController.isComponentChkBoxCriticalChecked();
		
		if (JournalModels.createTaskIfOk(txtTaskString, txtDueString,  comboTaskTypeSelectedString, isCritical)) {
			JournalController.switchToIdlePanel();
			JournalController.setStatusLabel("Task created successfully");
		}
		else {
			JournalController.setComponentTxtDueToBlank();
			JournalController.showMessageSomethingWentWrong();
		}
	}
	
	public static void removeSelectedRow() {
		
		int selectedRow = Main.getMenu().getMenuTable().getSelectedRow();
		
		if (JournalModels.removeSelectedRowFromModel(selectedRow)) {
			JournalController.setDeleteButton(false);
		}
		
		//Update UI Label to say that row has been removed?
	}
	
	
	/// this method could probably be moved to a dedicated journal 'sensor' package to separate out other method calls.
	public static void deleteButtonTableSensor(MouseEvent e) {
		
		JTable src = (JTable) e.getSource();
	      int row = src.rowAtPoint(e.getPoint());
	      //int col = src.columnAtPoint(e.getPoint());
	      
	    //exception keeps happening even with a surrounding if statement?? FIXME
	      //try-catch to stay for now...
	      try {
	    	  Main.getMenu().getMenuTable().setSelectedRow(Main.getMenu().getMenuTable().getTableTasks().getRowSorter().convertRowIndexToModel(row));
	    	  JournalController.setDeleteButton(true);
	      }
	      catch (ArrayIndexOutOfBoundsException exception) {
	    	  Main.getMenu().getMenuTable().setSelectedRow(-1);
	    	  
	    	  JournalController.setDeleteButton(false);
	      }
		
	}
	
	public static void ClearAllTasksCall() {
		// TODO Auto-generated method stub
		if (Main.getMenu().promptClearAllTasks() == 0) {
			JournalModels.deleteAllTasks();
			JournalController.setStatusLabel("Cleared All Tasks");
		}
		
	}
	
	public static void switchToIdlePanel() {
		JPanel panelSecondary = Main.getMenu().getSecondaryPanel();
		Main.getMenu().getCardLayout().show(panelSecondary, IDLEPANEL);
	}
	
	public static void switchToCreatePanel() {
		JPanel panelSecondary = Main.getMenu().getSecondaryPanel();
		Main.getMenu().getCardLayout().show(panelSecondary, CREATETASKPANEL);
	}
	
	//UI needs to access this therefore is set to public
	public static CustomTableModel getCustomTableModelCall() {
		return JournalModels.getCustomTableModel();
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////
	
	private static void setDeleteButton(boolean bool) {
		Main.getMenu().enableDelete(bool);
	}
	
	public static void setStatusLabel(String str) {
		Main.getMenu().setStatusLabel(str);
	}
	
	private static String getComponentComboTaskTypeSelectedString() {
		return Main.getMenu().getCreateTaskCard().getComponentComboTaskTypeSelectedString();
	}
	
	private static String getComponentTxtDueString() {
		return Main.getMenu().getCreateTaskCard().getComponentTxtDueString();
	}
	
	private static String getComponentTxtTaskString() {
		return Main.getMenu().getCreateTaskCard().getComponentTxtTaskString();
	}
	
	private static boolean isComponentChkBoxCriticalChecked() {
		return Main.getMenu().getCreateTaskCard().isComponentChkBoxCriticalChecked();
	}
	
	private static void setComponentTxtDueToBlank() {
		Main.getMenu().getCreateTaskCard().setComponentTxtDueToBlank();
	}
	
	public static void showMessageSomethingWentWrong() {
		JFrame frame = Main.getMenu().getMenuFrame();
		JOptionPane.showMessageDialog(frame, "Your task cannot be blank or contain any special characters. \nIf you have entered a custom date, please ensure you have entered a FUTURE date in the correct date format of 'dd-MM-yyyy HH:mm:ss'");
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
