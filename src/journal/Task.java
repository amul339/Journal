package journal;

import java.time.LocalDateTime;

public class Task {
	
	private boolean isCritical;
	private String task;
	private LocalDateTime timeAdded, timeDue;
	
	
	public Task(LocalDateTime timeDue, boolean isCritical, String task) {
		this.timeDue= timeDue;
		this.task = task;
		this.isCritical = isCritical;
		this.timeAdded = Menu.getLocalDateTime();
		
		menuTable.getTaskDirectoryArray().add(this);
		
	}
	
	public boolean checkIfCritical() {
		return this.isCritical;
	}
	
	public LocalDateTime getDueLocalDateTime() {
		return this.timeDue;
	}
	
	public LocalDateTime getAddedLocalDateTime() {
		return this.timeAdded;
	}

	
	
	@Override 
	public String toString() {
		return task;
	}
}
