package journalModel;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class CustomTableModel extends AbstractTableModel {
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
    		return "Subject";
    	case 1:
    		return "Task";
    	case 2:
    		return "Due";
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
    		return JournalModels.localDateTimeFormatter(task.getDueLocalDateTime());
    	case 2:
    		return JournalModels.localDateTimeFormatter(task.getAddedLocalDateTime());
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
    
    public ArrayList<Task> getData() {
    	return this.tasks;
    }

}
