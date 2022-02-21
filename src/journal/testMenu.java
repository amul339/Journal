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

public class testMenu extends JFrame {

	private JPanel contentPane;
	private JLayeredPane panelSecondary;
	private JPanel panelPrimary;
	private CardLayout cardLayout;
	private JPanel panelInfo;
	private MenuTablePanel menuTablePanel;
	private IdlePanel idlePanel;

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
		setResizable(false);
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
		this.panelInfo.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Journal Alpha", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		FlowLayout fl_panelInfo = (FlowLayout) this.panelInfo.getLayout();
		fl_panelInfo.setHgap(0);
		fl_panelInfo.setVgap(50);
		GridBagConstraints gbc_panelInfo = new GridBagConstraints();
		gbc_panelInfo.fill = GridBagConstraints.BOTH;
		gbc_panelInfo.gridheight = 3;
		gbc_panelInfo.gridwidth = 2;
		gbc_panelInfo.insets = new Insets(0, 0, 5, 0);
		gbc_panelInfo.gridx = 0;
		gbc_panelInfo.gridy = 0;
		this.contentPane.add(this.panelInfo, gbc_panelInfo);
		
		this.panelPrimary = new JPanel();
		GridBagConstraints gbc_panelPrimary = new GridBagConstraints();
		gbc_panelPrimary.fill = GridBagConstraints.BOTH;
		gbc_panelPrimary.insets = new Insets(0, 0, 0, 5);
		gbc_panelPrimary.gridx = 0;
		gbc_panelPrimary.gridy = 3;
		this.contentPane.add(this.panelPrimary, gbc_panelPrimary);
		this.panelPrimary.setLayout(null);
		
		this.cardLayout = new CardLayout();
		this.menuTablePanel = new MenuTablePanel();
		this.menuTablePanel.setBounds(10, 5, 355, 420);
		this.panelPrimary.add(this.menuTablePanel);
		this.panelSecondary = new JLayeredPane();
		this.panelSecondary.setBorder(new TitledBorder(null, "Control Panel", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panelSecondary = new GridBagConstraints();
		gbc_panelSecondary.fill = GridBagConstraints.BOTH;
		gbc_panelSecondary.gridx = 1;
		gbc_panelSecondary.gridy = 3;
		this.contentPane.add(this.panelSecondary, gbc_panelSecondary);
		this.panelSecondary.setLayout(cardLayout);
		
		this.idlePanel = new IdlePanel();
		this.idlePanel.setBounds(0, 0, 1, 1);
		this.panelSecondary.add(this.idlePanel);
		
		
		
	}
	
	public CardLayout getCardLayout() {
		return this.cardLayout;
	}
}
