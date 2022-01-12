package journal;

import java.time.LocalDateTime;

import javax.swing.UIManager;

public class Main {
	
	private static Menu menu = null;
	
	
	public static void main(String[] args) {
		
		//create menuUI instance
		
		if (InstanceHandler.checkPort(Menu.getPort())) {
			menu = new Menu();
			System.out.print("LAUNCHING!!!");
			
		}		
		
	}
	
	public static Menu getMenu() {
		return menu;
	}
	public static LocalDateTime getLocalDateTime() {
		return java.time.LocalDateTime.now();
	}
}
