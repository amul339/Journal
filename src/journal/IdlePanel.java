package journal;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;

public class IdlePanel extends JPanel {
	
	private ImageIcon logo;
	private JLabel labelLogo;
	
	/**
	 * Create the panel.
	 */
	public IdlePanel() {
		
		this.logo = new ImageIcon(getClass().getResource("/rsz_journal.png"));
		setLayout(null);
		this.labelLogo = new JLabel(logo);
		
		labelLogo.setBounds(145, 172, 100, 100);
		
		add(labelLogo);
	}
}
