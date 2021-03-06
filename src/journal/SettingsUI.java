package journal;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SettingsUI {
	
	private JFrame frameSettings;
	private JPanel panelSettings;
	
	private static final int PORT = 7003;
	
	public SettingsUI() {
		this.frameSettings = new JFrame("Settings");
		this.panelSettings = new JPanel();
		
		//configure bounds for settings panel components
		//configure 'settings' frame and add panel
		frameSettings.setSize(300,300);
		frameSettings.setResizable(false);
		frameSettings.add(panelSettings);
		frameSettings.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
		frameSettings.setLocationRelativeTo(null);
		frameSettings.setVisible(true);

	}
}
