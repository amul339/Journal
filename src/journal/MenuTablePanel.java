package journal;

import javax.swing.JScrollPane;

public class MenuTablePanel extends JScrollPane {

	/**
	 * Create the panel.
	 */
	public MenuTablePanel() {
		
		super(new MenuTable(JournalController.getCustomTableModelCall()));
	}

}
