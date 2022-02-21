package journal;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
		
		labelLogo.setBounds(110, 200, 100, 100);
		
		add(labelLogo);
	}

}
