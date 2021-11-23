package journal;

import java.util.ArrayList;

public class Main {
	
	private static ArrayList<Task> taskList;
	private static Menu menu;
	
	public static void main(String[] args) {
		
		//task list
		taskList = new ArrayList<Task>();
		
		//create menuUI instance
		menu = new Menu();
		
		
	}
	
	public static ArrayList<Task> getTaskList() {
		return taskList;
	}
	
	
}
