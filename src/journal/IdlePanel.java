package journal;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.BoxLayout;

public class IdlePanel extends JPanel {
	
	private ImageIcon logo;
	private JLabel labelLogo_1;
	
	/**
	 * Create the panel.
	 */
	public IdlePanel() {
		
		this.logo = new ImageIcon(getClass().getResource("/rsz_journal.png"));
		setLayout(new BorderLayout(0, 0));
		
		this.labelLogo_1 = new JLabel(logo);
		add(this.labelLogo_1);
	}
}
