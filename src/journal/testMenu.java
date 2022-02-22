package journal;

import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.border.EtchedBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.JLayeredPane;
import javax.swing.border.TitledBorder;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Component;
import java.awt.Window.Type;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Font;

public class testMenu extends JFrame {

	private JPanel contentPane;
	private JLayeredPane panelSecondary;
	private JPanel panelPrimary;
	private CardLayout cardLayout;
	private JPanel panelInfo;
	private MenuTablePanel menuTablePanel;
	private CreateTaskPanel createTaskPanel;
	private JButton buttonInfo_CreateTask;
	private JLabel labelWelcome;
	private JLabel labelIcon;
	private ImageIcon logo;

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
		setTitle("Journal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), new EtchedBorder(EtchedBorder.LOWERED, null, null)));
		setContentPane(this.contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{393, 393, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 563, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		this.contentPane.setLayout(gbl_contentPane);
		
		this.panelInfo = new JPanel();
		this.panelInfo.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Journal Alpha", TitledBorder.LEADING, TitledBorder.TOP, new Font("Segoe UI", Font.PLAIN, 16) , new Color(0, 0, 0)));
		this.panelInfo.setLayout(null);
		GridBagConstraints gbc_panelInfo = new GridBagConstraints();
		gbc_panelInfo.ipady = 99;
		gbc_panelInfo.fill = GridBagConstraints.BOTH;
		gbc_panelInfo.gridwidth = 2;
		gbc_panelInfo.gridheight = 3;
		gbc_panelInfo.gridx = 0;
		gbc_panelInfo.gridy = 0;
		this.contentPane.add(this.panelInfo, gbc_panelInfo);
		
		this.buttonInfo_CreateTask = new JButton("<html> Create a<br> new task! <html>");
		this.buttonInfo_CreateTask.setFocusable(false);
		this.buttonInfo_CreateTask.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		this.buttonInfo_CreateTask.setBounds(620, 25, 90, 58);
		this.panelInfo.add(this.buttonInfo_CreateTask);
		this.buttonInfo_CreateTask.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		this.labelWelcome = new JLabel("Back again, NAME?");
		this.labelWelcome.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 20));
		this.labelWelcome.setBounds(10, 28, 274, 30);
		this.panelInfo.add(this.labelWelcome);
		
		this.logo = new ImageIcon(getClass().getResource("/rsz_journal2.png"));
		this.labelIcon = new JLabel(logo);
		this.labelIcon.setBounds(725, 30, 33, 50);
		this.panelInfo.add(this.labelIcon);
		
		this.panelPrimary = new JPanel();
		this.panelPrimary.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Planner", TitledBorder.LEADING, TitledBorder.TOP, new Font("Segoe UI", Font.PLAIN, 12), null));
		GridBagConstraints gbc_panelPrimary = new GridBagConstraints();
		gbc_panelPrimary.fill = GridBagConstraints.BOTH;
		gbc_panelPrimary.gridx = 0;
		gbc_panelPrimary.gridy = 3;
		this.contentPane.add(this.panelPrimary, gbc_panelPrimary);
		
		this.cardLayout = new CardLayout();
		this.panelPrimary.setLayout(new BoxLayout(this.panelPrimary, BoxLayout.X_AXIS));
		this.menuTablePanel = new MenuTablePanel();
		this.panelPrimary.add(this.menuTablePanel);
		this.panelSecondary = new JLayeredPane();
		this.panelSecondary.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Control Panel", TitledBorder.LEADING, TitledBorder.TOP, new Font("Segoe UI", Font.PLAIN, 12), new Color(0, 0, 0)));
		GridBagConstraints gbc_panelSecondary = new GridBagConstraints();
		gbc_panelSecondary.fill = GridBagConstraints.BOTH;
		gbc_panelSecondary.gridx = 1;
		gbc_panelSecondary.gridy = 3;
		this.contentPane.add(this.panelSecondary, gbc_panelSecondary);
		this.panelSecondary.setLayout(cardLayout);
		
		this.createTaskPanel = new CreateTaskPanel();
		this.panelSecondary.add(this.createTaskPanel, "name_15684098500800");
		
		
		
		
	}
	
	public CardLayout getCardLayout() {
		return this.cardLayout;
	}
}
