package journal;

import java.awt.event.ActionEvent;
import journal.Task.Type;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CreateTaskUI {
	
	private JFrame frameCreateTask;
	private JPanel panelCreateTask;
	private JCheckBox chkboxCritical;
	private JComboBox<String> comboTaskType;
	private JTextField txtTask;
	private JLabel labeltxtTask, labelTaskType;
	private JButton buttonTaskOk;
	
	public CreateTaskUI() {
		this.frameCreateTask = new JFrame("Create Task");
		this.panelCreateTask = new JPanel();
		this.chkboxCritical = new JCheckBox("Critical");
		this.comboTaskType = new JComboBox<String>();
		this.txtTask = new JTextField();
		this.labeltxtTask = new JLabel("Describe your task in the box below:");
		this.labelTaskType = new JLabel("Task Type:");
		this.buttonTaskOk = new JButton("Create");
		
		
		//configure bounds for create_task panel components
		labeltxtTask.setBounds(10, 10, 250, 20);
		txtTask.setBounds(10, 35, 300, 20);
		comboTaskType.addItem("End of Day");
		comboTaskType.addItem("End of Week");
		comboTaskType.addItem("No Expiration");
		
		labelTaskType.setBounds(10, 60, 150, 20);
		comboTaskType.setBounds(10, 85, 100, 20);
		chkboxCritical.setBounds(150, 85 , 100, 20);
		buttonTaskOk.setBounds(365, 40, 80, 25);
		
		//configure 'create task' frame and add panel
		frameCreateTask.setSize(500,200);
		frameCreateTask.setResizable(false);
		frameCreateTask.add(panelCreateTask);
		frameCreateTask.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
		panelCreateTask.setLayout(null);
				
				//add components to 'create task' panel
		panelCreateTask.add(comboTaskType);
		panelCreateTask.add(chkboxCritical);
		panelCreateTask.add(txtTask);
		panelCreateTask.add(labeltxtTask);
		panelCreateTask.add(labelTaskType);
		panelCreateTask.add(buttonTaskOk);
		
		frameCreateTask.setVisible(true);
				
		buttonTaskOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//create task instance if textbox has content, get input from textbox and additional settings.
				
				final String currentTaskDescription = txtTask.getText();
				Type currenttaskType;
				
				if (!currentTaskDescription.isBlank()) {
				
					switch(comboTaskType.getSelectedItem().toString()) {
						case"End of Day":
							currenttaskType = Task.Type.EOD;
						case"End of Week":
							currenttaskType = Task.Type.EOW;
							break;
						case"No Expiration":
							currenttaskType = Task.Type.INDEFINITE;
							break;
						default:
							currenttaskType = Task.Type.EOD;
					}
					
					
					if(chkboxCritical.isSelected()) {
						Task newTask = new Task(currenttaskType, true, currentTaskDescription);
						menuTable.getTaskDirectoryArray().add(newTask);
						menuTable.getTableModelTasks().addRow(new String[] {newTask.toString(), newTask.getTimeAdded()});
					}
					else {
						Task newTask = new Task(currenttaskType, false, currentTaskDescription);
						menuTable.getTaskDirectoryArray().add(newTask);
						menuTable.getTableModelTasks().addRow(new String[] {newTask.toString(), newTask.getTimeAdded()});
					}
					//put task in list to be displayed on main menu
					
					//refresh main menu list 
					
					
					frameCreateTask.dispose();
					
				}
			}
			
		});
		
	}
}
