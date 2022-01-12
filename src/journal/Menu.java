package journal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.*;

public class Menu {
	
	private static final int PORT = 7000;
	private static menuTable menuTable = new menuTable();
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	
	private JLabel timeMsg, timeLabel, labelStatus;
	private JFrame frameMain;
	private Timer timer;
	private JPanel panelMain;
	private JButton buttonDelete, buttonPLH2;
	private JMenuBar menuBar;
	private JMenu menuFile, menuUtilities, menuHelp;
	private JMenuItem mItemAbout, mItemCreateTask, mItemClrAllTask, mItemLoad, mItemSave, mItemExit;
	private ImageIcon icon;
	
	public Menu() {
		
		//assign frames
		this.frameMain = new JFrame("Journal");
		this.icon = new ImageIcon(getClass().getResource("/journal.png"));
		
		//assignment tool-bar and menu items
		this.menuBar = new JMenuBar();
		this.menuFile = new JMenu("File");
		this.menuHelp = new JMenu("Help");
		this.menuUtilities = new JMenu("Utilities");
		this.mItemAbout = new JMenuItem("About");
		this.mItemLoad = new JMenuItem("Load");
		this.mItemSave = new JMenuItem("Save");
		this.mItemExit = new JMenuItem("Exit");
		this.mItemCreateTask = new JMenuItem("Create Task");
		this.mItemClrAllTask = new JMenuItem("Clear All Tasks");
		
		//assign panels and other garbage
		this.timeLabel = new JLabel(localDateTimeFormatter(Main.getLocalDateTime()), JLabel.CENTER);
		this.timeMsg  = new JLabel("System time:");
		this.labelStatus = new JLabel("Testing");
		this.panelMain = new JPanel();
		this.buttonDelete = new JButton("Delete");
		this.buttonPLH2 = new JButton("PLH2");

		menuHelp.add(mItemAbout);
		menuFile.add(mItemLoad);
		menuFile.add(mItemSave);
		menuFile.add(mItemCreateTask);
		menuFile.add(mItemClrAllTask);
		menuFile.add(mItemExit);
		menuBar.add(menuFile);
		menuBar.add(menuUtilities);
		menuBar.add(menuHelp);
		
		//configure bounds for main panel components
		timeLabel.setBounds(-30, -15, 200, 100);
		labelStatus.setBounds(12, 370, 200, 100);
		timeMsg.setBounds(12,5,100,20);
		buttonDelete.setBounds(390,10,80,25);
		buttonPLH2.setBounds(390,50,80,25);
		menuUtilities.setEnabled(false);
		mItemLoad.setEnabled(true);
		buttonDelete.setEnabled(false);
		buttonPLH2.setEnabled(false);
		
		//configure main frame and add panel
		frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameMain.setLocationRelativeTo(null);
		frameMain.setSize(500,500);
		frameMain.setResizable(false);
		frameMain.setJMenuBar(menuBar);
		frameMain.setIconImage(icon.getImage());
		frameMain.add(panelMain);
		
		//set layout
		panelMain.setLayout(null);
		
		//add components to 'main' panel
		panelMain.add(timeLabel);
		panelMain.add(labelStatus);
		panelMain.add(timeMsg);
		panelMain.add(buttonDelete);
		panelMain.add(buttonPLH2);
		panelMain.add(menuTable.getScrollTasks());
		
		
		mItemAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (InstanceHandler.checkPort(InfoUI.getPort())) {
					new InfoUI();
				}
			}
		});
		
		mItemCreateTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (InstanceHandler.checkPort(CreateTaskUI.getPort())) {
					new CreateTaskUI();
				}
			}
		});
		
		mItemClrAllTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (InstanceHandler.checkPort(DeleteTasksUI.getPort())) {
					new DeleteTasksUI();
				}
			}
		});
		
		mItemExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		
		buttonDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = menuTable.getSelectedRow();
				
				if (selectedRow != -1) {
					menuTable.getTableModel().removeRow(selectedRow);
					getDeleteButton().setEnabled(false);
				}
			}
		});
		
		mItemLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu.loadSavedData();
			}
		});
		
		mItemSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu.saveData();
			}
		});
		
		frameMain.setLocationRelativeTo(null);
		frameMain.setVisible(true);
		
		/////TIMER FOR CLOCK
		ActionListener clkPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
		    	updateTimeLabel();
		    }
		};
		this.timer = new Timer(1000, clkPerformer);
		timer.setRepeats(true);
		timer.start();
		/////
		
		
		
	}
	
	
	//returns current LocalDateTime in string format.
	public static String localDateTimeFormatter(LocalDateTime localDateTime) {
		
		if (localDateTime != null) {
			return localDateTime.format(formatter);
		}
		else {
			return "-";
		}
	}
		//update timeLabel with current time.
	private void updateTimeLabel() {
		this.timeLabel.setText(localDateTimeFormatter(Main.getLocalDateTime()));
	}
	
	private JButton getDeleteButton() {
		return this.buttonDelete;
	}
	
	public JFrame getMenuFrame() {
		return this.frameMain;
	}
	
	public void enableDelete(boolean bool) {
		// TODO Auto-generated method stub
		getDeleteButton().setEnabled(bool);
	}
	
	public static menuTable getMenuTable() {
		return menuTable;
	}
	
	public static int getPort() {
		return PORT;
	}
	
	public static void deleteAllTasks() {
		getMenuTable().getTableModel().removeAll();
	}
	
	//Converts task data to strings. Used for saving task data to text.
	public static String taskAttribToString(Task task) {
		String taskDesc = task.toString();
		String addedTime = Menu.localDateTimeFormatter(task.getAddedLocalDateTime());
		String dueTime = Menu.localDateTimeFormatter(task.getDueLocalDateTime());
		String isCritical = Boolean.toString(task.checkIfCritical());
		
		
		return dueTime + "^" + addedTime + "^" + isCritical + "^" + taskDesc;
	}
	
	public static void createTask(LocalDateTime timeDue, boolean isCritical, String task) {
		getMenuTable().getTableModel().add(new Task(timeDue, isCritical, task));
	}
	public static void loadSingleTaskFromFile(LocalDateTime timeDue, LocalDateTime timeAdded, boolean isCritical, String task) {
		getMenuTable().getTableModel().add(new Task(timeDue, timeAdded, isCritical, task));
	}
	public static void loadSavedData() {
		int dataLoadCount = 0; // counts how many tasks have been loaded
		System.out.println("Loading data...");
		
		//should probably clear tasks here prior to loading...
		Menu.deleteAllTasks();
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader("resources/savedJData.txt"));
			String rline = reader.readLine();
				
			while(!rline.equals("END")) {
			
			
				String[] data = rline.split("\\^");
				//timeDue, timeAdded, isCritical, task description
				Menu.loadSingleTaskFromFile(LocalDateTime.parse(data[0], formatter),LocalDateTime.parse(data[1], formatter),Boolean.parseBoolean(data[2]),data[3]);
				rline = reader.readLine();
				dataLoadCount++;
			
			}
			
			System.out.println("Successfully loaded data");
		}
		catch(Exception ex) {
			System.out.println("Failed to load data on file line " + dataLoadCount + ", possibly corrupt?");
		}
		
	}
	
	public static void saveData() {
		// save each task and its data in text file format
		try {
			
			ArrayList<String> strTableTasks = new ArrayList<String>();
			ArrayList<Task> tableTasks = Menu.getMenuTable().getTableModel().getData();
		
			Path file = Paths.get("resources/savedJData.txt");
			
			
			
			// for each task, convert task to one big string with '^' separating task attributes.
			//look at method 'taskAttribToString';
			//store all task to string conversions in array
			//finally write to file
			for (Task task : tableTasks) {
				
				
				strTableTasks.add(Menu.taskAttribToString(task));
				
				
			}
			
			
			//add indicator for EOF
			strTableTasks.add("END");
		
			Files.write(file, strTableTasks, StandardCharsets.UTF_8);
			
			System.out.println("Successfully saved data");
			
		}
		catch (Exception ex) {
			System.out.println("Write error");
			System.out.println(ex);
		}
	}

	
	
}
