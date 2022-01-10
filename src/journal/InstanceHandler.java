package journal;

import java.io.*;
import java.net.*;
import java.util.HashMap;

public class InstanceHandler {
	
	
	static HashMap<Integer, ServerSocket> portDirectory = new HashMap<Integer, ServerSocket>();
	
	public static boolean checkPort(int PORT) {
		
		try {
			
			portDirectory.put(PORT, new ServerSocket(PORT,0,InetAddress.getByAddress(new byte[] {127,0,0,1})));
			
			System.out.println("Successfully opened " + PORT);
			
		}
		//Under failure, create and start new instance of server with specified PORT
		catch (BindException e) {
			System.err.println("Already running...");
			
			return false;
		}
		catch (IOException e) {
			System.err.println("Unexpected error whilst checking/opening port");
			e.printStackTrace();
			System.exit(2);
		}
		
		return true;
	}
	
	public static void closePort(int PORT) {
		//create a hashmap of sockets so that we can close them when frame is closed?
		
		try {
			portDirectory.get(PORT).close();
			System.out.println("Closing " + PORT);
			portDirectory.remove(PORT);
		}
		catch(NullPointerException e) {
			System.out.println("Port" + PORT + "is not open");
		}
		catch (IOException e) {
			System.err.println("Unexpected error whilst closing port");
			e.printStackTrace();
			System.exit(2);
		}
	}

}
