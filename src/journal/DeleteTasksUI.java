package journal;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JLabel;

public class DeleteTasksUI {
	
	private JFrame frameClrAllTask;
	private JPanel panelClrAllTask;
	private JButton buttonClrCont;
	private JLabel labelClrWarning;
	
	public DeleteTasksUI() {
		
		this.frameClrAllTask = new JFrame("Clear All Tasks");
		this.buttonClrCont = new JButton("Continue");
		this.labelClrWarning = new JLabel("<html>This will clear all active to-do tasks. <br/> Are you sure you want to continue?<html>");
		this.panelClrAllTask = new JPanel();
		
		//configure bounds for 'clear all tasks' panel components
		labelClrWarning.setVerticalAlignment(SwingConstants.TOP);
		labelClrWarning.setHorizontalAlignment(SwingConstants.CENTER);
		buttonClrCont.setSize(150,25);
		
		//configure 'clear all tasks' frame and add panel
		frameClrAllTask.setSize(300,140);
		frameClrAllTask.setResizable(false);
		frameClrAllTask.add(panelClrAllTask);
		frameClrAllTask.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
		//add components to 'clear all tasks' panel
		panelClrAllTask.add(labelClrWarning);
		panelClrAllTask.add(buttonClrCont);
		
		frameClrAllTask.setVisible(true);
	}
	
	public static void ClearAllTasks() {
		Main.getTaskList().clear();
	}
}
