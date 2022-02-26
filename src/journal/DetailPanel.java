package journal;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.JSeparator;
import javax.swing.JButton;

public class DetailPanel extends JPanel {
	private JLabel lblTask;
	private JLabel lblDescription;
	private JLabel lblDate;
	private JLabel lblSubject;
	private JLabel lblCritical;
	private JLabel lblMagnifyingGlass;
	private ImageIcon magnifyingGlass;
	private JSeparator separator;
	private JButton btnDelete;

	/**
	 * Create the panel.
	 */
	public DetailPanel() {
		setBorder(null);
		
		this.magnifyingGlass = new ImageIcon(getClass().getResource("/rsz2_glass.png"));
		
		setLayout(null);
		
		this.lblTask = new JLabel("\r\n");
		this.lblTask.setVerticalAlignment(SwingConstants.CENTER);
		this.lblTask.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Selected Task", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		this.lblTask.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		this.lblTask.setBounds(10, 11, 190, 44);
		add(this.lblTask);
		
		this.lblDescription = new JLabel("Description\r\n");
		this.lblDescription.setVerticalAlignment(SwingConstants.TOP);
		this.lblDescription.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		this.lblDescription.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Task Description", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		this.lblDescription.setBounds(10, 123, 260, 70);
		add(this.lblDescription);
		
		this.lblDate = new JLabel("New label");
		this.lblDate.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		this.lblDate.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Date Added", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		this.lblDate.setBounds(200, 76, 170, 44);
		add(this.lblDate);
		
		this.lblSubject = new JLabel("\r\n");
		this.lblSubject.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		this.lblSubject.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Subject", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.lblSubject.setBounds(10, 76, 190, 44);
		add(this.lblSubject);
		
		this.lblCritical = new JLabel("");
		this.lblCritical.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		this.lblCritical.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Critical?", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		this.lblCritical.setBounds(272, 123, 98, 70);
		add(this.lblCritical);
		
		this.lblMagnifyingGlass = new JLabel(magnifyingGlass);
		this.lblMagnifyingGlass.setBounds(316, 0, 64, 60);
		add(this.lblMagnifyingGlass);
		
		this.separator = new JSeparator();
		this.separator.setBounds(10, 63, 360, 2);
		add(this.separator);
		
		this.btnDelete = new JButton("Delete Task\r\n");
		this.btnDelete.setBounds(120, 204, 140, 23);
		add(this.btnDelete);
		
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JournalController.removeSelectedRow();
				JournalController.switchToIdlePanel();
			}
			
		});

	}
	
	
	public void setComponentLblTask(String str) {
		lblTask.setText(str);
	}
	public void setComponentLblDescription(String str) {
		lblDescription.setText(str);
	}
	public void setComponentLblSubject(String str) {
		lblSubject.setText(str);
	}
	public void setComponentLblDate(String str) {
		lblDate.setText(str);
	}
	public void setComponentLblCritical(String str) {
		lblCritical.setText(str);
	}
}
