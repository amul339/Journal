package journal;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;

public class MenuTablePanel extends JScrollPane {

	/**
	 * Create the panel.
	 */
	public MenuTablePanel() {
		super(new MenuTable(JournalController.getCustomTableModelCall()));
		
		
	}
	
	public MenuTable getMenuTable() {
		JViewport viewport = this.getViewport(); 
		return (MenuTable) viewport.getView();
	}
	

}
