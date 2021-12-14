package journal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CreateTaskUI {
	
	private JFrame frameCreateTask;
	private JPanel panelCreateTask;
	private JCheckBox chkboxCritical;
	private JComboBox<String> comboTaskType;
	private JTextField txtTask, txtDue;
	private JLabel labeltxtTask, labelTaskType, labeltxtCustom;
	private JButton buttonTaskOk, buttonTaskCancel;
	private ImageIcon icon;
	
	public CreateTaskUI() {
		this.frameCreateTask = new JFrame("Create Task");
		this.panelCreateTask = new JPanel();
		this.chkboxCritical = new JCheckBox("Critical");
		this.comboTaskType = new JComboBox<String>();
		this.txtTask = new JTextField();
		this.txtDue = new JTextField();
		this.labeltxtCustom = new JLabel("Custom Due Date (dd-MM-yyyy HH:mm:ss)");
		this.labeltxtTask = new JLabel("Describe your task in the box below:");
		this.labelTaskType = new JLabel("Task Type:");
		this.buttonTaskOk = new JButton("Create");
		this.buttonTaskCancel = new JButton("Cancel");
		this.icon = new ImageIcon(getClass().getResource("/journal.png"));
		
		
		//configure bounds for create_task panel components
		labeltxtTask.setBounds(10, 10, 250, 20);
		txtTask.setBounds(10, 35, 300, 20);
		txtDue.setBounds(10, 140, 150, 20);
		labeltxtCustom.setBounds(10, 115, 250, 20);
		comboTaskType.addItem("Midnight");
		comboTaskType.addItem("7 Days");
		comboTaskType.addItem("No Expiration");
		comboTaskType.addItem("<Custom>");
		
		labelTaskType.setBounds(10, 60, 150, 20);
		comboTaskType.setBounds(10, 85, 100, 20);
		chkboxCritical.setBounds(160, 85 , 100, 20);
		buttonTaskOk.setBounds(365, 35, 80, 40);
		buttonTaskCancel.setBounds(365, 90, 80, 25);
		txtDue.setEnabled(false);
		labeltxtCustom.setEnabled(false);
		//configure 'create task' frame and add panel
		frameCreateTask.setSize(500,220);
		frameCreateTask.setResizable(false);
		frameCreateTask.setIconImage(icon.getImage());
		frameCreateTask.add(panelCreateTask);
		frameCreateTask.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
		panelCreateTask.setLayout(null);
				
				//add components to 'create task' panel
		panelCreateTask.add(comboTaskType);
		panelCreateTask.add(chkboxCritical);
		panelCreateTask.add(txtTask);
		panelCreateTask.add(txtDue);
		panelCreateTask.add(labeltxtCustom);
		panelCreateTask.add(labeltxtTask);
		panelCreateTask.add(labelTaskType);
		panelCreateTask.add(buttonTaskOk);
		panelCreateTask.add(buttonTaskCancel);
		
		
		frameCreateTask.setLocationRelativeTo(null);
		frameCreateTask.setVisible(true);
				
		buttonTaskOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//create task instance if textbox has content, get input from textbox and additional settings.
				
				final String currentTaskDescription = txtTask.getText();
				LocalDateTime timeDue;
				boolean isCritical = false;
				
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
					
				
				if (!currentTaskDescription.isBlank()) {
					
					
					if (chkboxCritical.isSelected()) {
						isCritical = true;
					}
					
					switch(comboTaskType.getSelectedItem().toString()) {
					
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
							timeDue = LocalDateTime.parse(txtDue.getText(), formatter);
							}
							catch(DateTimeParseException exception) {
								txtDue.setText("");
								JOptionPane.showMessageDialog(frameCreateTask, "Incorrect custom date format, please try again.\nExact format of 'dd-MM-yyyy HH:mm:ss' is required.");
								return;
							}
							
							if (timeDue.isBefore(java.time.LocalDateTime.now())) {
								JOptionPane.showMessageDialog(frameCreateTask, "Please enter a valid future date");
							}
							
							
							break;
						default:
							timeDue = LocalDateTime.of(java.time.LocalDate.now(), LocalTime.of(23, 59, 59));
							break;
					}
					
					menuTable.getTableModel().add(new Task(timeDue, isCritical, currentTaskDescription));
					//put task in list to be displayed on main menu
					
					//refresh table
					frameCreateTask.dispose();
					
				}
			}
			
		});
		
		
		comboTaskType.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {
				JComboBox<String> comboTaskType = (JComboBox<String>) e.getSource();
				
				Object selected = comboTaskType.getSelectedItem();
				if (selected.toString().equals("<Custom>")) {
					labeltxtCustom.setEnabled(true);
					txtDue.setEnabled(true);
				}
				else {
					labeltxtCustom.setEnabled(false);
					txtDue.setEnabled(false);
					txtDue.setText("");
				}
			}
			
		});
		
		buttonTaskCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameCreateTask.dispose();
			}
			
		});
		
	}
}
