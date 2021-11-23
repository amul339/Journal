package journal;

import java.awt.Dimension;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;

import javax.swing.*;

public class Menu {
	
	private static DefaultListModel<Task> listModelTasks = new DefaultListModel<Task>();
	private static JList<Task> listTasks = new JList<Task>();
	private static JScrollPane scrollTasks = new JScrollPane(listTasks);
	
	private JLabel timeMsg, timeLabel;
	private JFrame frameMain;
	private Timer timer;
	private JPanel panelMain;
	private JButton buttonPLH, buttonPLH2;
	private JMenuBar menuBar;
	private JMenu menuFile, menuHelp;
	private JMenuItem mItemAbout, mItemCreateTask, mItemClrAllTask, mItemLoad;
	
	
	
	
	
	public Menu() {
		
		
		
		//assign frames
		this.frameMain = new JFrame("Journal");
		
		
		//assignment toolbar and menu items
		this.menuBar = new JMenuBar();
		this.menuFile = new JMenu("File");
		this.menuHelp = new JMenu("Help");
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
		mItemLoad.setEnabled(false);
		buttonPLH.setEnabled(false);
		buttonPLH2.setEnabled(false);
		listTasks.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listTasks.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		listTasks.setModel(listModelTasks);
		
		//scrollTasks.setPreferredSize(new Dimension(200,80));
		
		scrollTasks.setBounds(12, 50, 225, 360);
		scrollTasks.setVisible(true);
		
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
		panelMain.add(scrollTasks);
		
		
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
	private static String getDateTime() {
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
	
	public static DefaultListModel<Task> getListModelTasks() {
		return listModelTasks;
	}
	
}
