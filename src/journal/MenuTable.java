package journal;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableRowSorter;

public class MenuTable extends JTable {
	
	private TableRowSorter<AbstractTableModel> sorter;
	private int selectedRow;
	
	public MenuTable(AbstractTableModel customTableModel) {
		
		this.sorter = new TableRowSorter<AbstractTableModel>(customTableModel);
		this.selectedRow = -1;
		
		setModel(customTableModel);
		setFillsViewportHeight(true);
		getTableHeader().setReorderingAllowed(false);
		setRowSelectionAllowed(false);
		setColumnSelectionAllowed(false);
		setCellSelectionEnabled(false);
		setAutoCreateRowSorter(true);
		setRowSorter(sorter);
		
		List<RowSorter.SortKey> sortKeys = new ArrayList<>();
		
		sortKeys.add(new RowSorter.SortKey(1, SortOrder.ASCENDING));
		sorter.setSortKeys(sortKeys);
		
		
		
		//getColumn("Task").setPreferredWidth(100);
		
		addMouseListener(new MouseAdapter() {
		    @Override
		    public void mousePressed(MouseEvent e) {	
		    	JournalController.switchToDetailPanel(e);
		    	JournalController.deleteButtonTableSensor(e);
		    }
		  	});
	}
	
	public JTable getTableTasks() {
		return this;
	}
	
	public void setSelectedRow(int row) {
		this.selectedRow = row;
	}
	
	public int getSelectedRow() {
		return this.selectedRow;
	}
	
}


