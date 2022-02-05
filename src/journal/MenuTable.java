package journal;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableRowSorter;

public class MenuTable {
	
	private JTable tableTasks;
	private JScrollPane scrollTasks;
	private TableRowSorter<AbstractTableModel> sorter;
	private int selectedRow;
	
	public MenuTable(AbstractTableModel customTableModel) {
		
		this.sorter = new TableRowSorter<AbstractTableModel>(customTableModel);
		this.tableTasks = new JTable();
		this.scrollTasks = new JScrollPane(tableTasks);
		this.selectedRow = -1;
		
		tableTasks.setModel(customTableModel);
		tableTasks.setFillsViewportHeight(true);
		tableTasks.getTableHeader().setReorderingAllowed(false);
		tableTasks.setRowSelectionAllowed(false);
		tableTasks.setColumnSelectionAllowed(false);
		tableTasks.setCellSelectionEnabled(false);
		tableTasks.setAutoCreateRowSorter(true);
		tableTasks.setRowSorter(sorter);
		
		List<RowSorter.SortKey> sortKeys = new ArrayList<>();
		
		sortKeys.add(new RowSorter.SortKey(1, SortOrder.ASCENDING));
		sorter.setSortKeys(sortKeys);
		
		
		scrollTasks.setBounds(12, 50, 400, 360);
		
		tableTasks.getColumn("Task").setPreferredWidth(100);
		
		tableTasks.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mousePressed(MouseEvent e) {	
		    	JournalController.deleteButtonTableSensor(e);
		    }
		  	});
	}
	
	public JTable getTableTasks() {
		return this.tableTasks;
	}
	
	public JScrollPane getScrollTasks() {
		return this.scrollTasks;
	}
	
	public void setSelectedRow(int row) {
		this.selectedRow = row;
	}
	
	public int getSelectedRow() {
		return this.selectedRow;
	}
	
}


