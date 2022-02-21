package journal;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.table.AbstractTableModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.JLayeredPane;
import java.awt.Component;

public class testMenu extends JFrame {

	private JPanel contentPane;
	private JLayeredPane panelSecondary;
	private JPanel panelPrimary;
	private MenuTablePanel menuTablePanel;
	private CardLayout cardLayout;
	private IdlePanel idlePanel;
	private CreateTaskPanel createTaskPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testMenu frame = new testMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public testMenu() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), new EtchedBorder(EtchedBorder.LOWERED, null, null)));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		this.panelPrimary = new JPanel();
		this.panelPrimary.setBorder(null);
		this.contentPane.add(this.panelPrimary);
		this.panelPrimary.setLayout(null);
		
		this.menuTablePanel = new MenuTablePanel();
		menuTablePanel.setBounds(5, 40, 380, 380);
		menuTablePanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		this.panelPrimary.add(this.menuTablePanel);
		
		this.cardLayout = new CardLayout();
		this.panelSecondary = new JLayeredPane();
		this.panelSecondary.setBorder(null);
		this.contentPane.add(this.panelSecondary);
		this.panelSecondary.setLayout(cardLayout);
		
		this.idlePanel = new IdlePanel();
		this.panelSecondary.add(this.idlePanel, "name_8412550718600");
		
		this.createTaskPanel = new CreateTaskPanel();
		this.panelSecondary.add(this.createTaskPanel, "name_8434180523800");
		
		
		
	}
	
	public CardLayout getCardLayout() {
		return this.cardLayout;
	}
}
