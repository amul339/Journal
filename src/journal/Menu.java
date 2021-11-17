package journal;

import java.time.format.DateTimeFormatter;

import javax.swing.*;

public class Menu {
	
	
	static JLabel timeLabel = new JLabel();
	
	public Menu() {
		
		JFrame frame = new JFrame("Journal");
		
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
		
	public static JLabel getTimeLabel() {
		return timeLabel;
	}
	
}
