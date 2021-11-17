package journal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;

import javax.swing.*;

public class Menu {
	
	private JLabel timeMsg;
	private JLabel timeLabel;
	private JFrame frame;
	private Timer timer;
	private JPanel panel;
	private JButton button;
	
	public Menu() {
		
		this.frame = new JFrame("Journal");
		this.timeLabel = new JLabel(getDateTime(), JLabel.CENTER);
		this.timeMsg  = new JLabel("System time:");
		this.panel = new JPanel();
		this.button = new JButton("About");
		
		//configure bounds
		timeLabel.setBounds(-30, -15, 200, 100);
		timeMsg.setBounds(12,5,100,20);
		button.setBounds(390,10,80,25);
		
		
		
		
		//configure frame and add panel
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setSize(500,500);
		frame.add(panel);
		
		panel.setLayout(null);
		
		//add components to panel
		panel.add(timeLabel);
		panel.add(timeMsg);
		panel.add(button);
		
		frame.setVisible(true);
		
		ActionListener taskPerformer = new ActionListener() {
		    public void actionPerformed(ActionEvent evt) {
		    	updateTimeLabel();
		    	System.out.println("debug");
		    }
		};
		this.timer = new Timer(1000, taskPerformer);
		timer.setRepeats(true);
		timer.start();
		
		
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
		return this.frame;
	}
	
}
