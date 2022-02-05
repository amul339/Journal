package journal;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

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
		
}
