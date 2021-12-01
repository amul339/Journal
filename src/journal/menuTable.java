package journal;

import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class menuTable {
	
	private static ArrayList<Task> taskDirectoryArray = new ArrayList<Task>();
	private static JTable tableTasks = new JTable();
	private static JScrollPane scrollTasks = new JScrollPane(tableTasks);
	private static DefaultTableModel tableModelTasks = new DefaultTableModel() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};
	
	public menuTable() {
		
		tableTasks.setModel(tableModelTasks);
		tableTasks.setFillsViewportHeight(true);
		tableTasks.getTableHeader().setReorderingAllowed(false);
		tableTasks.setRowSelectionAllowed(false);
		tableTasks.setColumnSelectionAllowed(false);
		tableTasks.setCellSelectionEnabled(false);
		
		tableModelTasks.addColumn("Task");
		tableModelTasks.addColumn("Date");
		
		scrollTasks.setBounds(12, 50, 225, 360);
	}
	
	public static DefaultTableModel getTableModelTasks() {
		return tableModelTasks;
	}
	
	public static JScrollPane getScrollTasks() {
		return scrollTasks;
	}
	
	public static ArrayList<Task> getTaskDirectoryArray() {
		return taskDirectoryArray;
	}
}
