package journal;

import journalModel.*;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;

public class JournalController extends JournalModels {

	//ALL PRIVATE FUNCTIONS
	
	public static void journalSetup() {
		String nameString = Main.getSetup().getNameString();
		String subject1String = Main.getSetup().getSubject1String();
		String subject2String = Main.getSetup().getSubject2String();
		String subject3String = Main.getSetup().getSubject3String();
		String subject4String = Main.getSetup().getSubject4String();
		//THIS SHOULD BE DONE IN A BETTER WAY FOR A LATER VERSION OF JOURNAL
		//    TODO make a more robust way of creating a subject.
		//make sure that whatever the user enters is a valid string
		
		//sets username in program memory
		JournalController.setUsername(nameString);
		
		//adds subjects to program memory
		JournalController.addSubject(subject1String, null);
		JournalController.addSubject(subject2String, null);
		JournalController.addSubject(subject3String, null);
		JournalController.addSubject(subject4String, null);

		
		//TEMPORARY
		//start journal once setup is complete
		Main.launchMenu();
		refreshSubjectList();
	}
	
	//This method is triggered when there is a detected change in the JComboBox 'comboDue'
	//Custom date JTextField 'textFieldCustomDate' is either enabled or disabled depending on if '<Custom>' option has been selected.
	public static void comboDueCustomSensor(ActionEvent e) {
		
		JComboBox<String> comboTaskType = (JComboBox<String>) e.getSource();
		
		Object selected = comboTaskType.getSelectedItem();
		if (selected.toString().equals("<Custom>")) {
			Main.getMenu().getCreateTaskPanel().enableCustomDateField(true);
		}
		else {
			Main.getMenu().getCreateTaskPanel().enableCustomDateField(false);
			Main.getMenu().getCreateTaskPanel().clearCustomDateField();
		}
		
	}
	
	public static void refreshSubjectList() {
		//first remove everything from subject combo box on create task ui
		Main.getMenu().getCreateTaskPanel().removeAllSubjectsFromComboSubjectSelection();
		
		
		for (String string : JournalModels.getSubjectDirectory().keySet()) {
			Main.getMenu().getCreateTaskPanel().addSubjectToComboSubjectSelection(string);
		}
	}
	
	
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
		
		String txtTaskString = Main.getMenu().getCreateTaskPanel().getComponentTxtTaskString();
		String txtDueString = Main.getMenu().getCreateTaskPanel().getComponentTxtDueString();
		String comboTaskTypeSelectedString = Main.getMenu().getCreateTaskPanel().getComponentComboTaskTypeSelectedString();
		String comboSubjectSelectedString = Main.getMenu().getCreateTaskPanel().getComponentComboSubjectSelectedString();
		String txtAreaDescString = Main.getMenu().getCreateTaskPanel().getComponentTxtAreaDescString();
		
		boolean isCritical = JournalController.isComponentChkBoxCriticalChecked();
		
		
		
		if (JournalModels.checkUIParameters(txtTaskString, txtDueString,  comboTaskTypeSelectedString, comboSubjectSelectedString)) {
			
			//most recent parsed due date
			LocalDateTime recentDueLocalDateTime = JournalController.getRecentDueLocalDateTime();
			
			//most recent subject selected (string to object translation already done)
			Subject recentSubject = JournalController.getRecentSubject();
			
			JournalModels.createTaskOnTable(recentDueLocalDateTime, null, isCritical, txtTaskString, recentSubject, txtAreaDescString);
			
			//switch to idle panel after task creation is done
			switchToIdlePanel();
			
			//clear fields
			Main.getMenu().getCreateTaskPanel().clearAllFields();
		}
		else {
			Main.getMenu().getCreateTaskPanel().clearCustomDateField();
			JournalController.showMessageSomethingWentWrong();
		}
	}
	
	public static void removeSelectedRow() {
		
		int selectedRow = Main.getMenu().getMenuTablePanel().getMenuTable().getSelectedRow();
		
		
		if (JournalModels.removeSelectedRowFromModel(selectedRow)) {
			JournalController.setDeleteButton(false);
		}
		
		//Update UI Label to say that row has been removed?
	}
	
	//Update detail panel UI corresponding with input Task 'task'. i.e. description.
	public static void updateDetailPanel(Task task) {
		String taskTitleString = task.toString();
		String taskSubjectString = task.getSubject().toString();
		String taskDescriptionString = task.getDescription();
		String taskTimeAddedString = JournalController.localDateTimeFormatter(task.getAddedLocalDateTime());
		boolean taskIsCritical = task.checkIfCritical();
		
		//update detail panel ui
		Main.getMenu().getDetailPanel().setComponentLblTask(taskTitleString);
		Main.getMenu().getDetailPanel().setComponentLblDescription(taskDescriptionString);
		Main.getMenu().getDetailPanel().setComponentLblSubject(taskSubjectString);
		Main.getMenu().getDetailPanel().setComponentLblDate(taskTimeAddedString);
		
		if (taskIsCritical) {
			Main.getMenu().getDetailPanel().setComponentLblCritical("Yes");
		}
		else {
			Main.getMenu().getDetailPanel().setComponentLblCritical("No");
		}
		
	}
	
	//
	public static void switchToDetailPanel(MouseEvent e) {
		
		JTable src = (JTable) e.getSource();
	      int row = src.rowAtPoint(e.getPoint());
	      
	      
	      
		
	}
	
	/// this method could probably be moved to a dedicated journal 'sensor' package to separate out other method calls.
	public static void tableSensor(MouseEvent e) {
		
		JTable src = (JTable) e.getSource();
	      int row = src.rowAtPoint(e.getPoint());
	      int col = src.columnAtPoint(e.getPoint());
	      
	    //exception keeps happening even with a surrounding if statement?? FIXME
	      //try-catch to stay for now...
	      
	      
	      try {
	    	  
	    	  //sets the selected row on the table using information from mouse event e
	    	  //convertRowIndexToModel() method is called because even though we know the row, this row number does not correspond necessarily to that on the model,
	    	  //as the table may be graphically sorted.
	    	  //25/02/2022 this try-catch statement is very scuffed as the 2nd method executed can only be executed if the first method does not fail.
	    	  Main.getMenu().getMenuTablePanel().getMenuTable().setSelectedRow(Main.getMenu().getMenuTablePanel().getMenuTable().getRowSorter().convertRowIndexToModel(row));
	    	  
	    	  //get data from row
	    	  Task task = (Task) Main.getMenu().getMenuTablePanel().getMenuTable().getValueAt(row, 1);
	    	  //update detail panel with current selected task
	    	  
	    	  updateDetailPanel(task);
	    	  switchToDetailPanel();
	    	  
	    	  JournalController.setDeleteButton(true);
	      }
	      catch (ArrayIndexOutOfBoundsException exception) {
	    	  Main.getMenu().getMenuTablePanel().getMenuTable().setSelectedRow(-1);
	    	  
	    	  JournalController.setDeleteButton(false);
	      }
		
	}
	
	public static void updateControlPanelStatus(String msg) {
		//update control panel titled border here... TODO
	}
	
	public static void switchToDetailPanel() {
		JLayeredPane panelSecondary = Main.getMenu().getSecondaryPanel();
		
		Main.getMenu().getCardLayout().show(panelSecondary, "Detail Panel");
		
		Main.getMenu().enableCreateTaskButton(true);
	}
	
	public static void switchToIdlePanel() {
		JLayeredPane panelSecondary = Main.getMenu().getSecondaryPanel();
		
		Main.getMenu().getCardLayout().show(panelSecondary, "Idle Panel");
		
		Main.getMenu().enableCreateTaskButton(true);

	}
	
	public static void switchToCreatePanel() {
		//EVERY TIME WE SWITCH, WE NEED TO REFRESH SUBJECT LIST
		refreshSubjectList();
		
		//creating new variable? TODO
		JLayeredPane panelSecondary = Main.getMenu().getSecondaryPanel();
		Main.getMenu().getCardLayout().show(panelSecondary, "Create Task Panel");
		
		Main.getMenu().enableCreateTaskButton(false);
	}
	
	//UI needs to access this therefore is set to public
	public static CustomTableModel getCustomTableModelCall() {
		return JournalModels.getCustomTableModel();
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////
	
	private static void setDeleteButton(boolean bool) {
		//Main.getMenu().enableDelete(bool); FIXME
	}
	
	public static void setStatusLabel(String str) {
		//Main.getMenu().setStatusLabel(str); FIXME
	}
	
	
	private static boolean isComponentChkBoxCriticalChecked() {
		return Main.getMenu().getCreateTaskPanel().isComponentChkBoxCriticalChecked();
	}
	
	
	public static void showMessageSomethingWentWrong() {
		JFrame frame = Main.getMenu();
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
