package journal;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Task {
	
	private Type taskType;
	private boolean isCritical;
	private String task;
	private LocalDateTime timeAdded, timeDue;
	
	enum Type {
		EOD, //end of day
		EOW, //end of week
		INDEFINITE //no expiration
	}
	
	
	public Task(Type taskType, boolean isCritical, String task) {
		this.taskType = taskType;
		this.task = task;
		this.isCritical = isCritical;
		this.timeAdded = Menu.getLocalDateTime();
		
		switch(taskType) {
		case EOD:
			this.timeDue = LocalDateTime.of(timeAdded.toLocalDate(), LocalTime.of(23,59,59));
			break;
		case EOW:
			this.timeDue = LocalDateTime.of(timeAdded.plusDays(7).toLocalDate(), LocalTime.of(23, 59, 59));
			break;
		case INDEFINITE:
			this.timeDue = null;
			break;
		default:
			this.timeDue = LocalDateTime.of(timeAdded.toLocalDate(), LocalTime.of(23,59,59));
	}
		
	}
	
	public Type getTaskType() {
		return this.taskType;
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
