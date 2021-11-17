package journal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;

import javax.swing.*;

public class Menu {
	
	JLabel timeMsg;
	JLabel timeLabel;
	JFrame frame;
	Timer timer;
	
	public Menu() {
		
		this.frame = new JFrame("Journal");
		this.timeLabel = new JLabel(getDateTime(), JLabel.CENTER);
		
		//exit_on_close kills program once window has been shut
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		frame.setLocationRelativeTo(null);
		frame.setBounds(0, 0, 500, 500);
		
		timeLabel.setVisible(true);
		frame.add(timeLabel);
		
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
