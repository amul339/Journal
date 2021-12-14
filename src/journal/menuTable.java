package journal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class menuTable {
	
	private static JTable tableTasks = new JTable();
	private static JScrollPane scrollTasks = new JScrollPane(tableTasks);
	private static CustomTableModel customTableModel = new CustomTableModel();
	private static TableRowSorter<CustomTableModel> sorter = new TableRowSorter<CustomTableModel>(customTableModel);
	
	private static int selectedRow = -1;
	
	public menuTable() {
		
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
		
		
		scrollTasks.setBounds(12, 50, 360, 360);
		
		tableTasks.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mousePressed(MouseEvent e) {	
		      JTable src = (JTable) e.getSource();
		      int row = src.rowAtPoint(e.getPoint());
		      int col = src.columnAtPoint(e.getPoint());
		      
		      
		      //exception keeps happening even with a surrounding if statement?? FIXME
		      //try-catch to stay for now...
		      try {
		    	  selectedRow = tableTasks.getRowSorter().convertRowIndexToModel(row);
		      }
		      catch (ArrayIndexOutOfBoundsException exception) {
		    	  selectedRow = -1;
		      }
		      
		      /*
		      if (selectedRow != -1) {
		    	  //enable delete button
		      }
		      */
		      
		    }
		  	});
	}
	
	public static CustomTableModel getTableModel() {
		return customTableModel;
	}
	
	public static JScrollPane getScrollTasks() {
		return scrollTasks;
	}
	
	public static int getSelectedRow() {
		return selectedRow;
	}
	
}

class CustomTableModel extends AbstractTableModel {
			/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
			private ArrayList<Task> tasks;

		    public CustomTableModel() {
		    	tasks = new ArrayList<Task>();
		    }
		    public CustomTableModel(ArrayList<Task> tasks) {
		    	this.tasks = tasks;
		    }
		    
		    @Override
		    public int getColumnCount() {
		    	return 3;
		    }
		    
		    @Override
		    public int getRowCount() {
		    	return tasks.size();
		    }

		    @Override
		    public String getColumnName(int column) {
		    	switch (column) {
		    	case 0:
		    		return "Task";
		    	case 1:
		    		return "Due";
		    	case 2:
		    		return "Date Created";
		    	}
		    	return null;
		    }
		    
		    @Override 
		    public Object getValueAt(int rowIndex, int columnIndex) {
		    	Task task = tasks.get(rowIndex);
		    	switch (columnIndex) {
		    	case 0:
		    		return task.toString();
		    	case 1:
		    		return Menu.localDateTimeFormatter(task.getDueLocalDateTime());
		    	case 2:
		    		return Menu.localDateTimeFormatter(task.getAddedLocalDateTime());
		    	}
		    	return null;
		    }
		    public void add(Task task) {
		    	tasks.add(task);
		    	int row = tasks.indexOf(task);
		    	fireTableRowsInserted(row, row);
		    }
		    
		    public void removeTask(Task task) {
		    	
		    	if (tasks.contains(task)) {
		    		int row = tasks.indexOf(task);
		    		tasks.remove(row);
		    		fireTableRowsDeleted(row, row);
		    	}
		    }
		    
		    public void removeRow(int row) {
		    	tasks.remove(row);
		    	fireTableRowsDeleted(row,row);
		    }
		    
		    public void removeAll() {
		    	
		    	tasks.clear();
		    	fireTableDataChanged();
		    }
		    
		    @Override
		    public boolean isCellEditable(int row, int col) {
		       return false;
		    }

}
