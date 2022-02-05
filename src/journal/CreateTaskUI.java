package journal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CreateTaskUI {
	
	private JFrame frameCreateTask;
	private JPanel panelCreateTask;
	private JCheckBox chkboxCritical;
	private JComboBox<String> comboTaskType;
	private JTextField txtTask, txtDue;
	private JTextArea txtDesc;
	private JLabel labeltxtTask, labeltxtTaskDesc, labelTaskType, labeltxtCustom;
	private JButton buttonTaskOk, buttonTaskCancel;
	private ImageIcon icon;
	private JScrollPane scrolltxtDesc;
	
	private static final int PORT = 7001;
		
	public CreateTaskUI() {
		
		
		//Local result variable generated from CreateTaskUI to be picked up by JournalModels after sending message to Main to create task instance.	
		this.frameCreateTask = new JFrame("Create Task");
		this.panelCreateTask = new JPanel();
		this.chkboxCritical = new JCheckBox("Critical");
		this.comboTaskType = new JComboBox<String>();
		this.txtTask = new JTextField();
		this.txtDue = new JTextField();
		this.txtDesc = new JTextArea();
		this.scrolltxtDesc = new JScrollPane();
		this.labeltxtCustom = new JLabel("Custom Due Date (dd-MM-yyyy HH:mm:ss)");
		this.labeltxtTask = new JLabel("Task title:");
		this.labeltxtTaskDesc = new JLabel("Describe your task in the box below:");
		this.labelTaskType = new JLabel("Task Type:");
		this.buttonTaskOk = new JButton("Create");
		this.buttonTaskCancel = new JButton("Cancel");
		this.icon = new ImageIcon(getClass().getResource("/journal.png"));
		
		
		//configure bounds for create_task panel components
		labeltxtTask.setBounds(10, 10, 250, 20);
		txtTask.setBounds(10, 35, 300, 20);
		txtDue.setBounds(10, 220, 150, 20);
		labeltxtCustom.setBounds(10, 195, 250, 20);
		comboTaskType.addItem("Midnight");
		comboTaskType.addItem("7 Days");
		comboTaskType.addItem("No Expiration");
		comboTaskType.addItem("<Custom>");
		scrolltxtDesc.add(txtDesc);
		txtDesc.setLineWrap(true);
		txtDesc.setEditable(true);
		scrolltxtDesc.setEnabled(true);
		txtDesc.setEnabled(true);
		
		labelTaskType.setBounds(10, 140, 150, 20);
		comboTaskType.setBounds(10, 165, 100, 20);
		chkboxCritical.setBounds(160, 165 , 100, 20);
		buttonTaskOk.setBounds(365, 35, 80, 40);
		buttonTaskCancel.setBounds(365, 90, 80, 25);
		labeltxtTaskDesc.setBounds(10, 60, 250, 20);
		scrolltxtDesc.setBounds(10, 85, 300, 50);
		txtDue.setEnabled(false);
		labeltxtCustom.setEnabled(false);
		//configure 'create task' frame and add panel
		frameCreateTask.setSize(500,300);
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
		panelCreateTask.add(scrolltxtDesc);
		panelCreateTask.add(labeltxtCustom);
		panelCreateTask.add(labeltxtTask);
		panelCreateTask.add(labelTaskType);
		panelCreateTask.add(buttonTaskOk);
		panelCreateTask.add(buttonTaskCancel);
		panelCreateTask.add(labeltxtTaskDesc);
		
		frameCreateTask.setLocationRelativeTo(null);
		frameCreateTask.setVisible(true);
				
		buttonTaskOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JournalController.createTaskFromUI();
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
				InstanceHandler.closePort(CreateTaskUI.getPort());
			}
			
		});
		
		frameCreateTask.addWindowListener(new WindowAdapter() {
			@Override
		    public void windowClosing(WindowEvent e) {
		        // do your work here
		        InstanceHandler.closePort(CreateTaskUI.getPort());
		    }         
		});
		
	}
	
	
	public static int getPort() {
		return PORT;
	}
	
	public String getComponentComboTaskTypeSelectedString() {
		return comboTaskType.getSelectedItem().toString();
	}
	
	public String getComponentTxtDueString() {
		return txtDue.getText();
	}
	
	public String getComponentTxtTaskString() {
		return txtTask.getText();
	}
	public boolean isComponentChkBoxCriticalChecked() {
		
		if (chkboxCritical.isSelected()) {
			return true;
		}
		
		return false;
	}
	
	public void setComponentTxtDueToBlank () {
		txtDue.setText("");
	}


	public void showMessageIncorrectDateFormat() {
		JOptionPane.showMessageDialog(frameCreateTask, "Incorrect custom date format, please try again.\nExact format of 'dd-MM-yyyy HH:mm:ss' is required.");
	}


	public void showMessageEnterFutureDate() {
		JOptionPane.showMessageDialog(frameCreateTask, "Please enter a valid future date");
		
	}
	
	public void showMessageSomethingWentWrong() {
		JOptionPane.showMessageDialog(frameCreateTask, "Your task cannot be blank or contain any special characters. \nIf you have entered a custom date, please ensure you have entered a FUTURE date in the correct date format of 'dd-MM-yyyy HH:mm:ss'");
	}


	public void disposeCreateTaskUI() {
		frameCreateTask.dispose();
	}
	
	
}
