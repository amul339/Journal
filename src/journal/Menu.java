package journal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.*;

import journalModel.menuTable;

public class Menu {
	private static final int PORT = 7000;
	
	private JLabel timeMsg, timeLabel, labelStatus;
	private JFrame frameMain;
	private Timer timer;
	private JPanel panelMain;
	private JButton buttonDelete, buttonPLH2;
	private JMenuBar menuBar;
	private JMenu menuFile, menuUtilities, menuHelp;
	private JMenuItem mItemAbout, mItemCreateTask, mItemClrAllTask, mItemLoad, mItemSave, mItemExit;
	private ImageIcon icon;
	
	public Menu() {
		
		//assign frames
		this.frameMain = new JFrame("Journal");
		this.icon = new ImageIcon(getClass().getResource("/journal.png"));
	
		//assignment tool-bar and menu items
		this.menuBar = new JMenuBar();
		this.menuFile = new JMenu("File");
		this.menuHelp = new JMenu("Help");
		this.menuUtilities = new JMenu("Utilities");
		this.mItemAbout = new JMenuItem("About");
		this.mItemLoad = new JMenuItem("Load");
		this.mItemSave = new JMenuItem("Save");
		this.mItemExit = new JMenuItem("Exit");
		this.mItemCreateTask = new JMenuItem("Create Task");
		this.mItemClrAllTask = new JMenuItem("Clear All Tasks");
		
		//assign panels and other garbage
		this.timeLabel = new JLabel(JournalController.localDateTimeFormatter(JournalController.getLocalDateTime()), JLabel.CENTER);
		this.timeMsg  = new JLabel("System time:");
		this.labelStatus = new JLabel("Testing");
		this.panelMain = new JPanel();
		this.buttonDelete = new JButton("Delete");
		this.buttonPLH2 = new JButton("PLH2");

		menuHelp.add(mItemAbout);
		menuFile.add(mItemLoad);
		menuFile.add(mItemSave);
		menuFile.add(mItemCreateTask);
		menuFile.add(mItemClrAllTask);
		menuFile.add(mItemExit);
		menuBar.add(menuFile);
		menuBar.add(menuUtilities);
		menuBar.add(menuHelp);
		
		//configure bounds for main panel components
		timeLabel.setBounds(-30, -15, 200, 100);
		labelStatus.setBounds(12, 370, 200, 100);
		timeMsg.setBounds(12,5,100,20);
		buttonDelete.setBounds(390,10,80,25);
		buttonPLH2.setBounds(390,50,80,25);
		menuUtilities.setEnabled(false);
		mItemLoad.setEnabled(true);
		buttonDelete.setEnabled(false);
		buttonPLH2.setEnabled(false);
		
		//configure main frame and add panel
		frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameMain.setLocationRelativeTo(null);
		frameMain.setSize(500,500);
		frameMain.setResizable(false);
		frameMain.setJMenuBar(menuBar);
		frameMain.setIconImage(icon.getImage());
		frameMain.add(panelMain);
		
		//set layout
		panelMain.setLayout(null);
		
		//add components to 'main' panel
		panelMain.add(timeLabel);
		panelMain.add(labelStatus);
		panelMain.add(timeMsg);
		panelMain.add(buttonDelete);
		panelMain.add(buttonPLH2);
		panelMain.add(JournalController.getMenuTable().getScrollTasks());
		
		
		mItemAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (InstanceHandler.checkPort(InfoUI.getPort())) {
					new InfoUI();
				}
			}
		});
		
		mItemCreateTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (InstanceHandler.checkPort(CreateTaskUI.getPort())) {
					new CreateTaskUI();
				}
			}
		});
		
		/*
		mItemClrAllTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (InstanceHandler.checkPort(DeleteTasksUI.getPort())) {
					new DeleteTasksUI();
				}
			}
		});
		*/
		mItemExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		
		buttonDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JournalController.removeSelectedRowFromModel();
			}
		});
		
		mItemLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JournalController.loadSavedData();
			}
		});
		
		mItemSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JournalController.saveData();
			}
		});
		
		frameMain.setLocationRelativeTo(null);
		frameMain.setVisible(true);
		
		/////TIMER FOR CLOCK
		ActionListener clkPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
		    	updateTimeLabel();
		    }
		};
		this.timer = new Timer(1000, clkPerformer);
		timer.setRepeats(true);
		timer.start();
		/////
		
		
		
	}
	
		//update timeLabel with current time.
	private void updateTimeLabel() {
		this.timeLabel.setText(JournalController.localDateTimeFormatter(JournalController.getLocalDateTime()));
	}
	
	private JButton getDeleteButton() {
		return this.buttonDelete;
	}
	
	public JFrame getMenuFrame() {
		return this.frameMain;
	}
	
	public void enableDelete(boolean bool) {
		// TODO Auto-generated method stub
		getDeleteButton().setEnabled(bool);
	}
	
	public static int getPort() {
		return PORT;
	}
	
	
	
	
	
	
	
	

	
	
}
