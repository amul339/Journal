package journalModel;

public class Subject {
	
	private String subjectName;
	private String subjectDescription;
	
	public Subject(String subjectName, String subjectDescription) {
	
		this.subjectName = subjectName;
		this.subjectDescription = subjectDescription;
	}
	
	@Override
	public String toString() {
		return subjectName;
		
	}
	
	public String getDescription() {
		return subjectDescription;
	}
	
}
