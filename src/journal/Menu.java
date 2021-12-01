package journal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;

import javax.swing.*;

public class Menu {
	
	private JLabel timeMsg, timeLabel;
	private JFrame frameMain;
	private Timer timer;
	private JPanel panelMain;
	private JButton buttonPLH, buttonPLH2;
	private JMenuBar menuBar;
	private JMenu menuFile, menuUtilities, menuHelp;
	private JMenuItem mItemAbout, mItemCreateTask, mItemClrAllTask, mItemLoad;
	private menuTable menuTable;
	
	
	
	
	
	public Menu() {
		
		//assign frames
		this.frameMain = new JFrame("Journal");
		
		
		//assignment tool-bar and menu items
		this.menuBar = new JMenuBar();
		this.menuFile = new JMenu("File");
		this.menuHelp = new JMenu("Help");
		this.menuUtilities = new JMenu("Utilities");
		this.mItemAbout = new JMenuItem("About");
		this.mItemLoad = new JMenuItem("Load");
		this.mItemCreateTask = new JMenuItem("Create Task");
		this.mItemClrAllTask = new JMenuItem("Clear All Tasks");
		
		//assign panels and other garbage
		this.timeLabel = new JLabel(getDateTime(), JLabel.CENTER);
		this.timeMsg  = new JLabel("System time:");
		this.panelMain = new JPanel();
		this.buttonPLH = new JButton("PLH");
		this.buttonPLH2 = new JButton("PLH2");
		
		this.menuTable = new menuTable();

		menuHelp.add(mItemAbout);
		menuFile.add(mItemLoad);
		menuFile.add(mItemCreateTask);
		menuFile.add(mItemClrAllTask);
		menuBar.add(menuFile);
		menuBar.add(menuUtilities);
		menuBar.add(menuHelp);
		
		//configure bounds for main panel components
		timeLabel.setBounds(-30, -15, 200, 100);
		timeMsg.setBounds(12,5,100,20);
		buttonPLH.setBounds(390,10,80,25);
		buttonPLH2.setBounds(390,50,80,25);
		menuUtilities.setEnabled(false);
		mItemLoad.setEnabled(false);
		buttonPLH.setEnabled(false);
		buttonPLH2.setEnabled(false);
		
		//configure main frame and add panel
		frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameMain.setLocationRelativeTo(null);
		frameMain.setSize(500,500);
		frameMain.setResizable(false);
		frameMain.setJMenuBar(menuBar);
		frameMain.add(panelMain);
		
		//set layout
		panelMain.setLayout(null);
		
		//add components to 'main' panel
		panelMain.add(timeLabel);
		panelMain.add(timeMsg);
		panelMain.add(buttonPLH);
		panelMain.add(buttonPLH2);
		panelMain.add(journal.menuTable.getScrollTasks());
		
		
		mItemAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new InfoUI();
			}
		});
		
		mItemCreateTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CreateTaskUI();
			}
		});
		
		mItemClrAllTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DeleteTasksUI();
			}
		});
		
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
	
	
	//returns current LocalDateTime in string format.
	public static String getDateTime() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String dateTime = java.time.LocalDateTime.now().format(formatter);
			
		return dateTime;
			
	}
		
		//update timeLabel with current time.
	private void updateTimeLabel() {
		this.timeLabel.setText(getDateTime());
	}
		
	public JLabel getTimeLabel() {
		return this.timeLabel;
	}
	
	public JFrame getMenuFrame() {
		return this.frameMain;
	}
}
