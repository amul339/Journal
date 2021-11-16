

import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
	static JLabel timeLabel = new JLabel(formatDate());
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
		
		System.out.print(formatDate());
		
		while(true) {
			updateTimeLabel(timeLabel);
		}
		
	}
	
	public Main() {
		JFrame frame = new JFrame("Journal");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setBounds(0, 0, 300, 300);
		
		timeLabel.setBounds(0, 0, 10, 50);
		timeLabel.setVisible(true);
		frame.add(timeLabel);
		
	}
	
	
	//returns LocalDateTime in string format.
	private static String formatDate() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formatDateTime = java.time.LocalDateTime.now().format(formatter);
		
		return formatDateTime;
		
	}
	
	//update timeLabel with current time.
	private static JLabel updateTimeLabel(JLabel timeLabel) {
		timeLabel.setText(formatDate());
		return timeLabel;
	}
	
}
