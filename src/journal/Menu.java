package journal;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;


public class Menu {
	private static final int PORT = 7000;
	final static String CREATETASKPANEL = "Create Task Panel";
	final static String IDLEPANEL = "Idle Panel";
	
	//ALL SUB PANELS FOR MENU ARE REQUIRED TO BE 320X500 IN RESOLUTION
	
	private JLabel timeMsg, timeLabel, labelStatus;
	private Timer timer;
	private JFrame frameMain;
	private JPanel panelSecondary;
	//private IdlePanel idleCard;
	private CreateTaskPanel createTaskCard;
	private JButton buttonDelete;
	private JMenuBar menuBar;
	private JMenu menuFile, menuUtilities, menuHelp;
	private JMenuItem mItemAbout, mItemCreateTask, mItemClrAllTask, mItemLoad, mItemSave, mItemExit;
	private ImageIcon icon;
	private CardLayout cardLayout;
	
	private CreateTaskUI createtaskui;
	private MenuTable menutable;
	
	public Menu()  {
		
		//assign frames
		this.frameMain = new JFrame("Journal");
		//assign menu table, call controller for model assignment.
		this.menutable = new MenuTable(JournalController.getCustomTableModelCall());
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
		this.labelStatus = new JLabel("Journal test build -- https://github.com/amul339");
		
		this.buttonDelete = new JButton("Delete");
		
		///////////////////////////////
		//SECONDARY PANEL
		this.cardLayout = new CardLayout();
		this.panelSecondary = new JPanel();
		
		
		//RIGHT HAND SIDE UI CARDS INITIALIZED HERE!!!!
		this.idleCard = new IdlePanel();
		this.createTaskCard = new CreateTaskPanel();
		
		///////////////////////////////
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
		labelStatus.setBounds(12, 370, 350, 300);
		timeMsg.setBounds(12,5,100,20);
		buttonDelete.setBounds(12,425,80,25);
		menuUtilities.setEnabled(false);
		mItemLoad.setEnabled(true);
		buttonDelete.setEnabled(false);
		panelSecondary.setBounds(438, 20, 320, 500);
		
		//panelSecondary.setBorder(BorderFactory.createLineBorder(Color.black));
		
		//configure main frame and add panel
		
		frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameMain.setLocationRelativeTo(null);
		frameMain.setSize(800,600);
		frameMain.setResizable(false);
		frameMain.setJMenuBar(menuBar);
		frameMain.setIconImage(icon.getImage());
		
		//set layout
		frameMain.setLayout(null);
		panelSecondary.setLayout(cardLayout);
		
		//add cards to panelSecondary CardLayout
		panelSecondary.add(idleCard, IDLEPANEL);
		panelSecondary.add(createTaskCard, CREATETASKPANEL);
		
		
		//add components
		frameMain.add(timeLabel);
		frameMain.add(labelStatus);
		frameMain.add(timeMsg);
		frameMain.add(buttonDelete);
		frameMain.add(menutable.getScrollTasks());
		frameMain.add(panelSecondary);
		
		
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
					cardLayout.show(panelSecondary, CREATETASKPANEL);
				}
			}
		});
		
		
		mItemClrAllTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JournalController.ClearAllTasksCall();
			}
		});
		
		mItemExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		
		buttonDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JournalController.removeSelectedRow();
			}
		});
		
		mItemLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JournalController.loadSavedDataCall();
			}
		});
		
		mItemSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JournalController.saveDataCall();
			}
		});
		
		
		
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

		frameMain.setLocationRelativeTo(null);
		frameMain.setVisible(true);
		
		
	}
	
	public JPanel getIdleCard() {
		return idleCard;
	}
	
	public CreateTaskPanel getCreateTaskCard() {
		return (CreateTaskPanel) createTaskCard;
	}
	
	public MenuTable getMenuTable() {
		return this.menutable;
	}
	
	public void setStatusLabel(String str) {
		this.labelStatus.setText(str);
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
	
	//returns integer for option selected
	public int promptClearAllTasks() {
		return JOptionPane.showConfirmDialog(frameMain, "This will clear all tasks from the table.\nAre you sure you want to continue?", "Clear All Tasks?", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION);
	}
	
	public static int getPort() {
		return PORT;
	}


	
	
	
	
	
	
	

	
	
}
