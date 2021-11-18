package journal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;

import javax.swing.*;

public class Menu {
	
	private JLabel timeMsg, timeLabel;
	private JLabel labelAbout, labelAuthor;
	private JFrame frameMain, frameAbout, frameSettings;
	private Timer timer;
	private JPanel panelMain, panelAbout, panelSettings;
	private JButton buttonPLH, buttonPLH2;
	private JMenuBar menuBar;
	private JMenu menuFile, menuHelp;
	private JMenuItem mItemAbout;
	
	public Menu() {
		
		this.frameMain = new JFrame("Journal");
		this.frameAbout = new JFrame("About");
		this.frameSettings = new JFrame("Settings");
		
		this.menuBar = new JMenuBar();
		this.menuFile = new JMenu("File");
		this.menuHelp = new JMenu("Help");
		this.mItemAbout = new JMenuItem("About");
		
		this.labelAbout = new JLabel("Journal VER X");
		this.labelAuthor = new JLabel("Created by Anthony Mulder");
		
		
		this.timeLabel = new JLabel(getDateTime(), JLabel.CENTER);
		this.timeMsg  = new JLabel("System time:");
		this.panelMain = new JPanel();
		this.panelAbout = new JPanel();
		this.buttonPLH = new JButton("PLH");
		this.buttonPLH2 = new JButton("PLH2");
		

		menuHelp.add(mItemAbout);
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
		
		
		
		//configure main frame and add panel
		frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameMain.setLocationRelativeTo(null);
		frameMain.setSize(500,500);
		frameMain.setResizable(false);
		frameMain.setJMenuBar(menuBar);
		frameMain.add(panelMain);
		
		//configure about frame and add panel
		frameAbout.setSize(300,150);
		frameAbout.setResizable(false);
		frameAbout.add(panelAbout);
		
		//configure settings frame and add panel
		frameSettings.setSize(300,300);
		frameSettings.setResizable(false);
		
		//set layout of all panels
		panelMain.setLayout(null);
		panelAbout.setLayout(null);
		
		//add components to main panel
		panelMain.add(timeLabel);
		panelMain.add(timeMsg);
		panelMain.add(buttonPLH);
		panelMain.add(buttonPLH2);
		
		//add components to about panel
		panelAbout.add(labelAbout);
		panelAbout.add(labelAuthor);
		
		mItemAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameAbout.setVisible(true);
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
