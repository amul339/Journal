package journal;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import java.awt.Dimension;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class CreateTaskPanel extends JPanel {
	private JPanel panel;
	private JLabel labelDetails;
	private JSeparator separator;
	private JLabel labelTitle;
	private JTextField txtTitle;
	private JTextArea txtAreaDesc;
	private JLabel labelDescription;
	private JSeparator separator_1;
	private JLabel labelSubjectSelection;
	private JComboBox comboSubjectSelection;
	private JLabel labelProperties;
	private JSeparator separator_3;
	private JLabel labelDue;
	private JComboBox comboDue;
	private JCheckBox checkBoxCritical;
	private JLabel labelCustomDate;
	private JFormattedTextField textFieldCustomDate;
	private JSeparator separator_2;
	private JButton buttonCreate;
	private JButton buttonClear;
	private JButton buttonClose;

	/**
	 * Create the panel.
	 */
	public CreateTaskPanel() {
		setBorder(null);
		setLayout(new GridLayout(1, 1, 0, 0));
		
		panel = new JPanel();
		add(panel);
		panel.setLayout(null);
		
		labelDetails = new JLabel("Task details");
		labelDetails.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		labelDetails.setBounds(12, 12, 114, 16);
		panel.add(labelDetails);
		
		separator = new JSeparator();
		separator.setBounds(12, 31, 296, 10);
		panel.add(separator);
		
		labelTitle = new JLabel("Task title");
		labelTitle.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		labelTitle.setBounds(12, 40, 55, 16);
		panel.add(labelTitle);
		
		txtTitle = new JTextField();
		txtTitle.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		txtTitle.setBounds(12, 60, 150, 20);
		panel.add(txtTitle);
		txtTitle.setColumns(10);
		
		txtAreaDesc = new JTextArea();
		txtAreaDesc.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		txtAreaDesc.setBounds(12, 110, 250, 69);
		panel.add(txtAreaDesc);
		
		labelDescription = new JLabel("Task description");
		labelDescription.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		labelDescription.setBounds(12, 85, 125, 16);
		panel.add(labelDescription);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(12, 215, 260, 10);
		panel.add(separator_1);
		
		labelSubjectSelection = new JLabel("Subject Selection");
		labelSubjectSelection.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		labelSubjectSelection.setBounds(12, 191, 150, 20);
		panel.add(labelSubjectSelection);
		
		comboSubjectSelection = new JComboBox();
		comboSubjectSelection.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		comboSubjectSelection.setBounds(12, 229, 150, 25);
		panel.add(comboSubjectSelection);
		
		labelProperties = new JLabel("Mission Parameters");
		labelProperties.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		labelProperties.setBounds(12, 275, 150, 16);
		panel.add(labelProperties);
		
		separator_3 = new JSeparator();
		separator_3.setBounds(12, 295, 260, 16);
		panel.add(separator_3);
		
		labelDue = new JLabel("Task Due\r\n");
		labelDue.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		labelDue.setBounds(12, 315, 55, 16);
		panel.add(labelDue);
		
		comboDue = new JComboBox();
		comboDue.setModel(new DefaultComboBoxModel(new String[] {"Midnight", "7 Days", "No Expiration", "<Custom>"}));
		comboDue.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		comboDue.setBounds(12, 335, 125, 25);
		panel.add(comboDue);
		
		checkBoxCritical = new JCheckBox("Critical");
		checkBoxCritical.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		checkBoxCritical.setBounds(150, 335, 112, 24);
		panel.add(checkBoxCritical);
		
		labelCustomDate = new JLabel("Custom Due Date");
		labelCustomDate.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		labelCustomDate.setBounds(12, 380, 125, 16);
		panel.add(labelCustomDate);
		
		textFieldCustomDate = new JFormattedTextField();
		textFieldCustomDate.setEnabled(false);
		textFieldCustomDate.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		textFieldCustomDate.setBounds(12, 400, 150, 20);
		panel.add(textFieldCustomDate);
		
		separator_2 = new JSeparator();
		separator_2.setBounds(12, 430, 296, 10);
		panel.add(separator_2);
		
		buttonCreate = new JButton("Create");
		buttonCreate.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 12));
		
		buttonCreate.setBounds(40, 452, 72, 25);
		panel.add(buttonCreate);
		
		buttonClear = new JButton("Clear");
		buttonClear.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 12));
		
		buttonClear.setBounds(125, 452, 72, 25);
		panel.add(buttonClear);
		
		buttonClose = new JButton("Close");
		buttonClose.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 12));
		buttonClose.setBounds(209, 452, 72, 25);
		panel.add(buttonClose);
		
		buttonCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JournalController.createTaskFromUI();
			}
			
		});
		
		buttonClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
			
		});
		
		
		

	}
	public String getComponentComboTaskTypeSelectedString() {
		return comboDue.getSelectedItem().toString();
	}
	
	public String getComponentTxtDueString() {
		return textFieldCustomDate.getText();
	}
	
	public String getComponentTxtTaskString() {
		return txtTitle.getText();
	}
	public boolean isComponentChkBoxCriticalChecked() {
		
		if (checkBoxCritical.isSelected()) {
			return true;
		}
		
		return false;
	}
	
	public void setComponentTxtDueToBlank() {
		textFieldCustomDate.setText("");
	}
	
}
