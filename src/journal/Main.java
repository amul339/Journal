package journal;



public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Menu menu = new Menu();
		
		while (menu.getMenuFrame().isVisible()) {
			menu.updateTimeLabel();
		}
		
	}
	
	
}
