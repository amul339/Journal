package journal;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.CompoundBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Setup extends JFrame {
	
	final private static int PORT = 6999;

	private JPanel contentPane;
	private JLabel lblLogo;
	private ImageIcon logo;
	private JLabel lblWelcomeMsg;
	private JLabel lblAuthor;
	private JSeparator separator;
	private JLabel lblDetectMsg;
	private JPanel panelName;
	private JTextField textFieldName;
	private JPanel panelSubject1;
	private JTextField textFieldSubject1;
	private JPanel panelSubject2;
	private JTextField textFieldSubject2;
	private JPanel panelSubject3;
	private JTextField textFieldSubject3;
	private JPanel panelSubject4;
	private JTextField textFieldSubject4;
	private JSeparator separator_1;
	private JButton buttonOk;

	
	public Setup() {
		setTitle("Journal Setup");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(null);
		
		this.logo = new ImageIcon(getClass().getResource("/rsz_journal2.png"));
		this.lblLogo = new JLabel(logo);
		this.lblLogo.setBounds(378, 11, 46, 61);
		this.contentPane.add(this.lblLogo);
		
		this.lblWelcomeMsg = new JLabel("Welcome to Journal!");
		this.lblWelcomeMsg.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		this.lblWelcomeMsg.setBounds(10, 2, 225, 27);
		this.contentPane.add(this.lblWelcomeMsg);
		
		this.lblAuthor = new JLabel("Written by Anthony Mulder - github.com/amul339/");
		this.lblAuthor.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		this.lblAuthor.setBounds(10, 30, 271, 14);
		this.contentPane.add(this.lblAuthor);
		
		this.separator = new JSeparator();
		this.separator.setBounds(10, 52, 206, 2);
		this.contentPane.add(this.separator);
		
		this.lblDetectMsg = new JLabel("<html> We have detected Journal has not been run before! <br> Please complete the following fields down below to get started. <html>");
		this.lblDetectMsg.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		this.lblDetectMsg.setBounds(10, 55, 340, 33);
		this.contentPane.add(this.lblDetectMsg);
		
		this.panelName = new JPanel();
		this.panelName.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Name", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		this.panelName.setBounds(10, 93, 150, 47);
		this.contentPane.add(this.panelName);
		this.panelName.setLayout(null);
		
		this.textFieldName = new JTextField();
		this.textFieldName.setBounds(10, 16, 130, 20);
		this.panelName.add(this.textFieldName);
		this.textFieldName.setColumns(10);
		
		this.panelSubject1 = new JPanel();
		this.panelSubject1.setLayout(null);
		this.panelSubject1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Subject 1", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		this.panelSubject1.setBounds(10, 151, 150, 47);
		this.contentPane.add(this.panelSubject1);
		
		this.textFieldSubject1 = new JTextField();
		this.textFieldSubject1.setColumns(10);
		this.textFieldSubject1.setBounds(10, 16, 130, 20);
		this.panelSubject1.add(this.textFieldSubject1);
		
		this.panelSubject2 = new JPanel();
		this.panelSubject2.setLayout(null);
		this.panelSubject2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Subject 2", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		this.panelSubject2.setBounds(170, 151, 150, 47);
		this.contentPane.add(this.panelSubject2);
		
		this.textFieldSubject2 = new JTextField();
		this.textFieldSubject2.setColumns(10);
		this.textFieldSubject2.setBounds(10, 16, 130, 20);
		this.panelSubject2.add(this.textFieldSubject2);
		
		this.panelSubject3 = new JPanel();
		this.panelSubject3.setLayout(null);
		this.panelSubject3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Subject 3", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		this.panelSubject3.setBounds(10, 203, 150, 47);
		this.contentPane.add(this.panelSubject3);
		
		this.textFieldSubject3 = new JTextField();
		this.textFieldSubject3.setColumns(10);
		this.textFieldSubject3.setBounds(10, 16, 130, 20);
		this.panelSubject3.add(this.textFieldSubject3);
		
		this.panelSubject4 = new JPanel();
		this.panelSubject4.setLayout(null);
		this.panelSubject4.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Subject 4", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		this.panelSubject4.setBounds(170, 203, 150, 47);
		this.contentPane.add(this.panelSubject4);
		
		this.textFieldSubject4 = new JTextField();
		this.textFieldSubject4.setColumns(10);
		this.textFieldSubject4.setBounds(10, 16, 130, 20);
		this.panelSubject4.add(this.textFieldSubject4);
		
		this.separator_1 = new JSeparator();
		this.separator_1.setBounds(10, 145, 206, 2);
		this.contentPane.add(this.separator_1);
		
		this.buttonOk = new JButton("OK");
		this.buttonOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JournalController.journalSetup();
				dispose();
			}
		});
		this.buttonOk.setBounds(335, 200, 89, 23);
		this.contentPane.add(this.buttonOk);
		setResizable(false);
		
		setVisible(true);
	}
	
	public String getNameString() {
		return textFieldName.getText();
	}
	public String getSubject1String() {
		return textFieldSubject1.getText();
	}
	public String getSubject2String() {
		return textFieldSubject2.getText();
	}
	public String getSubject3String() {
		return textFieldSubject3.getText();
	}
	public String getSubject4String() {
		return textFieldSubject4.getText();
	}
	
	public static int getPort() {
		return PORT;
	}
	
}
