package journal;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InfoUI {
	
	private static final int PORT = 7004;
	
	private JLabel labelAbout, labelAuthor;
	private JPanel panelAbout;
	private JFrame frameAbout;
	private ImageIcon icon;
	
	
	public InfoUI() {
		//assign sub-menu labels and components
		this.frameAbout = new JFrame("About");
		this.labelAbout = new JLabel("Journal in-dev");
		this.labelAuthor = new JLabel("<html> Created by Anthony Mulder 2021, 2022.<br> https://github.com/amul339 <html>");
		this.panelAbout = new JPanel();
		this.icon = new ImageIcon(getClass().getResource("/question.png"));
		
		//configure bounds for about panel components
		labelAbout.setBounds(10,30,100,25);
		labelAuthor.setBounds(10,50,250,50);
				
		//configure 'about' frame and add pane
		frameAbout.setSize(300,150);
		frameAbout.setIconImage(icon.getImage());
		frameAbout.setResizable(false);
		frameAbout.add(panelAbout);
		frameAbout.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
		panelAbout.setLayout(null);
				
		//add components to 'about' panel
		panelAbout.add(labelAbout);
		panelAbout.add(labelAuthor);
		
		frameAbout.setLocationRelativeTo(null);
		frameAbout.setVisible(true);
		
		frameAbout.addWindowListener(new WindowAdapter() {
			@Override
		    public void windowClosing(WindowEvent e) {
		        // do your work here
		        InstanceHandler.closePort(InfoUI.getPort());
		    }         
		});
	}
	
	
	
	public static int getPort() {
		return PORT;
	}
}
