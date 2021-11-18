package journal;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;

import javax.swing.*;

public class Menu {
	
	private JLabel timeMsg, timeLabel;
	private JLabel labelAbout, labelAuthor, labelClrWarning, labeltxtTask, labelTaskType;
	private JFrame frameMain, frameAbout, frameSettings, frameCreateTask, frameClrAllTask;
	private Timer timer;
	private JPanel panelMain, panelAbout, panelSettings, panelCreateTask, panelClrAllTask;
	private JButton buttonPLH, buttonPLH2, buttonClrCont;
	private JMenuBar menuBar;
	private JMenu menuFile, menuHelp;
	private JMenuItem mItemAbout, mItemCreateTask, mItemClrAllTask, mItemLoad;
	private ImageIcon iconAbout, iconSettings, iconMain;
	private JCheckBox chkboxCritical;
	private JComboBox<String> comboTaskType;
	private JTextField txtTask;
	
	public Menu() {
		
		//assign frames
		this.frameMain = new JFrame("Journal");
		this.frameAbout = new JFrame("About");
		this.frameSettings = new JFrame("Settings");
		this.frameCreateTask = new JFrame("Create Task");
		this.frameClrAllTask = new JFrame("Clear All Tasks");
		
		//assignment toolbar and menu items
		this.menuBar = new JMenuBar();
		this.menuFile = new JMenu("File");
		this.menuHelp = new JMenu("Help");
		this.mItemAbout = new JMenuItem("About");
		this.mItemLoad = new JMenuItem("Load");
		this.mItemCreateTask = new JMenuItem("Create Task");
		this.mItemClrAllTask = new JMenuItem("Clear All Tasks");
		
		//assign sub-menu labels and components
		this.labelAbout = new JLabel("Journal in-dev");
		this.labelAuthor = new JLabel("Created by Anthony Mulder");
		this.labelClrWarning = new JLabel("<html>This will clear all active to-do tasks. <br/> Are you sure you want to continue?<html>");
		
		
		//assign panels and other garbage
		this.timeLabel = new JLabel(getDateTime(), JLabel.CENTER);
		this.timeMsg  = new JLabel("System time:");
		this.panelMain = new JPanel();
		this.panelAbout = new JPanel();
		this.panelSettings = new JPanel();
		this.panelCreateTask = new JPanel();
		this.panelClrAllTask = new JPanel();
		this.buttonPLH = new JButton("PLH");
		this.buttonPLH2 = new JButton("PLH2");
		this.buttonClrCont = new JButton("Continue");
		this.chkboxCritical = new JCheckBox("Critical");
		this.comboTaskType = new JComboBox<String>();
		this.txtTask = new JTextField();
		this.labeltxtTask = new JLabel("Describe your task in the box below:");
		this.labelTaskType = new JLabel("Task Type:");
		
		

		menuHelp.add(mItemAbout);
		menuFile.add(mItemLoad);
		menuFile.add(mItemCreateTask);
		menuFile.add(mItemClrAllTask);
		
		menuBar.add(menuFile);
		menuBar.add(menuHelp);
		
		//configure bounds for main panel components
		timeLabel.setBounds(-30, -15, 200, 100);
		timeMsg.setBounds(12,5,100,20);
		buttonPLH.setBounds(390,10,80,25);
		buttonPLH2.setBounds(390,50,80,25);
		
		//configure bounds for about panel components
		labelAbout.setBounds(10,30,100,25);
		labelAuthor.setBounds(10,50,200,25);
		
		//configure bounds for settings panel components
		
		
		//configure bounds for create_task panel components
		labeltxtTask.setBounds(10, 10, 250, 20);
		txtTask.setBounds(10, 35, 300, 20);
		
		comboTaskType.addItem("End of Day");
		comboTaskType.addItem("End of Week");
		comboTaskType.addItem("No Expiration");
		
		labelTaskType.setBounds(10, 60, 150, 20);
		comboTaskType.setBounds(10, 85, 100, 20);
		chkboxCritical.setBounds(150, 85 , 100, 20);
		
		//configure bounds for 'clear all tasks' panel components
		labelClrWarning.setVerticalAlignment(SwingConstants.TOP);
		labelClrWarning.setHorizontalAlignment(SwingConstants.CENTER);
		buttonClrCont.setSize(150,25);
		
		
		//configure main frame and add panel
		frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameMain.setLocationRelativeTo(null);
		frameMain.setSize(500,500);
		frameMain.setResizable(false);
		frameMain.setJMenuBar(menuBar);
		frameMain.add(panelMain);
		
		//configure 'about' frame and add pane
		frameAbout.setSize(300,150);
		frameAbout.setResizable(false);
		frameAbout.add(panelAbout);
		
		//configure 'settings' frame and add panel
		frameSettings.setSize(300,300);
		frameSettings.setResizable(false);
		frameSettings.add(panelSettings);
		
		//configure 'create task' frame and add panel
		frameCreateTask.setSize(500,200);
		frameCreateTask.setResizable(false);
		frameCreateTask.add(panelCreateTask);
		
		//configure 'clear all tasks' frame and add panel
		frameClrAllTask.setSize(300,140);
		frameClrAllTask.setResizable(false);
		frameClrAllTask.add(panelClrAllTask);
		
		
		
		//set layout of all panels
		panelMain.setLayout(null);
		panelAbout.setLayout(null);
		panelCreateTask.setLayout(null);
		
		//add components to 'main' panel
		panelMain.add(timeLabel);
		panelMain.add(timeMsg);
		panelMain.add(buttonPLH);
		panelMain.add(buttonPLH2);
		
		//add components to 'about' panel
		panelAbout.add(labelAbout);
		panelAbout.add(labelAuthor);
		
		//add components to 'create task' panel
		panelCreateTask.add(comboTaskType);
		panelCreateTask.add(chkboxCritical);
		panelCreateTask.add(txtTask);
		panelCreateTask.add(labeltxtTask);
		panelCreateTask.add(labelTaskType);
		
		//add components to 'clear all tasks' panel
		panelClrAllTask.add(labelClrWarning);
		panelClrAllTask.add(buttonClrCont);
		
		mItemAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameAbout.setVisible(true);
			}
		});
		
		mItemCreateTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameCreateTask.setVisible(true);
			}
		});
		
		mItemClrAllTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameClrAllTask.setVisible(true);
			}
		});
		
		
		frameMain.setVisible(true);
		
		
		
		/////TIMER FOR CLOCK
		ActionListener clkPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
		    	updateTimeLabel();
		    	System.out.println("debug");
		    }
		};
		this.timer = new Timer(1000, clkPerformer);
		timer.setRepeats(true);
		timer.start();
		/////
		
		
		
	}
	
	
	//returns current LocalDateTime in string format.
	public static String getDateTime() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String dateTime = java.time.LocalDateTime.now().format(formatter);
			
		return dateTime;
			
	}
		
		//update timeLabel with current time.
	public void updateTimeLabel() {
		this.timeLabel.setText(getDateTime());
	}
		
	public JLabel getTimeLabel() {
		return this.timeLabel;
	}
	
	public JFrame getMenuFrame() {
		return this.frameMain;
	}
	
}
