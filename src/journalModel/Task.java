package journalModel;

import java.time.LocalDateTime;

import journal.JournalController;

public class Task {
	
	private boolean isCritical;
	private String task;
	private Subject subject;
	private LocalDateTime timeAdded, timeDue;
	
	
	public Task(LocalDateTime timeDue, LocalDateTime timeAdded, boolean isCritical, String task, Subject subject) {
		this.timeDue = timeDue;
		this.task = task;
		this.isCritical = isCritical;
		this.subject = subject;
		
		if (timeAdded == null) {
			this.timeAdded = JournalController.getLocalDateTime();
		}
		else {
			this.timeAdded = timeAdded;
		}
		
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
	
	public Subject getSubject() {
		return this.subject;
	}

	
	
	@Override 
	public String toString() {
		return task;
	}
}
