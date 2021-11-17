package journal;

import java.time.format.DateTimeFormatter;

import javax.swing.*;

public class Menu {
	
	
	JLabel timeLabel;
	JFrame frame;
	
	public Menu() {
		
		this.frame = new JFrame("Journal");
		this.timeLabel = new JLabel();
		
		//exit_on_close kills program once window has been shut
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		frame.setLocationRelativeTo(null);
		frame.setBounds(0, 0, 300, 300);
		
		timeLabel.setBounds(0, 0, 10, 50);
		timeLabel.setVisible(true);
		frame.add(timeLabel);
		
	}
	
	
	//returns current LocalDateTime in string format.
	public static String getDateTime() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String dateTime = java.time.LocalDateTime.now().format(formatter);
			
		return dateTime;
			
	}
		
		//update timeLabel with current time.
	public void updateTimeLabel() {
		timeLabel.setText(getDateTime());
	}
		
	public JLabel getTimeLabel() {
		return this.timeLabel;
	}
	
	public JFrame getMenuFrame() {
		return this.frame;
	}
	
}
