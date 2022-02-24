package journal;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {
	private static Menu menu = null;
	private static Setup setup = null;
	
	
	public static void main(String[] args) {
		
		//create menuUI instance
	
		if (InstanceHandler.checkPort(Setup.getPort())) {
			//check if data exists (assume it doesn't for now)
			setup = new Setup();
			System.out.print("LAUNCHING!!!");
		}
	}
	
	public static void launchMenu() {
		menu = new Menu();
	}
	
	
	public static Menu getMenu() {
		return menu;
	}
	
	public static Setup getSetup() {
		return setup;
	}
		
}
