package journal;

public class Task {
	
	private Type taskType;
	private boolean isCritical;
	private String task;
	
	
	enum Type {
		EOD, //end of day
		EOW, //end of week
		INDEFINITE //no expiration
	}
	
	
	public Task(Type taskType, boolean isCritical, String task) {
		this.taskType = taskType;
		this.task = task;
		this.isCritical = isCritical;
	}
	
	public Type getTaskType() {
		return this.taskType;
	}
	
	public boolean checkIfCritical() {
		return this.isCritical;
	}
	
	
	@Override 
	public String toString() {
		return task;
	}
}