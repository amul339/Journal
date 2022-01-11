package journal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
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
	private ImageIcon icon;
	
	private static final int PORT = 7002;
	
	public DeleteTasksUI() {
		
		this.frameClrAllTask = new JFrame("Clear All Tasks");
		this.buttonClrCont = new JButton("Continue");
		this.labelClrWarning = new JLabel("<html>This will clear all active to-do tasks. <br/> Are you sure you want to continue?<html>");
		this.panelClrAllTask = new JPanel();
		this.icon = new ImageIcon(getClass().getResource("/journal.png"));
		
		//configure bounds for 'clear all tasks' panel components
		labelClrWarning.setVerticalAlignment(SwingConstants.TOP);
		labelClrWarning.setHorizontalAlignment(SwingConstants.CENTER);
		buttonClrCont.setSize(150,25);
		
		//configure 'clear all tasks' frame and add panel
		frameClrAllTask.setSize(300,140);
		frameClrAllTask.setResizable(false);
		frameClrAllTask.setIconImage(icon.getImage());
		frameClrAllTask.add(panelClrAllTask);
		frameClrAllTask.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
		//add components to 'clear all tasks' panel
		panelClrAllTask.add(labelClrWarning);
		panelClrAllTask.add(buttonClrCont);
		
		frameClrAllTask.setLocationRelativeTo(null);
		frameClrAllTask.setVisible(true);
		
		buttonClrCont.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//clear all tasks
				Menu.deleteAllTasks();
				frameClrAllTask.dispose();
			}
		});
		
		frameClrAllTask.addWindowListener(new WindowAdapter() {
			@Override
		    public void windowClosing(WindowEvent e) {
		        // do your work here
		        InstanceHandler.closePort(DeleteTasksUI.getPort());
		    }         
		});
		
	}
	
	public static int getPort() {
		return PORT;
	}

}
