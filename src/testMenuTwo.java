import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

public class testMenuTwo extends JFrame {

	private JPanel contentPane, panelInfo, panelPrimary, panelSecondary;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testMenuTwo frame = new testMenuTwo();
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
	public testMenuTwo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		this.contentPane = new JPanel();
		this.contentPane.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		GridBagConstraints gbc_primary = new GridBagConstraints();
		GridBagConstraints gbc_secondary = new GridBagConstraints();
		setContentPane(this.contentPane);
		
		this.panelPrimary = new JPanel();
		this.panelSecondary = new JPanel();
		this.panelInfo = new JPanel();
		
		panelPrimary.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), new EtchedBorder(EtchedBorder.LOWERED, null, null)));
		panelSecondary.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), new EtchedBorder(EtchedBorder.LOWERED, null, null)));
		panelInfo.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), new EtchedBorder(EtchedBorder.LOWERED, null, null)));
		
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.anchor = GridBagConstraints.PAGE_START;
		gbc.weightx = 5;
		gbc.weighty = 5;
		contentPane.add(panelInfo, gbc);
		
		gbc_primary.gridx = 0;
		gbc_primary.gridy = 1;
		gbc_primary.weightx = 1;
		gbc_primary.weighty = 1;
		gbc_primary.ipadx = 400;
		gbc_primary.ipady = 150;
		
		contentPane.add(panelPrimary, gbc_primary);
		gbc_secondary.gridy = 1;
		gbc_secondary.gridx = 1;
		gbc_secondary.weightx = 1;
		gbc_secondary.weighty = 1;
		gbc_secondary.ipadx = 400;
		gbc_secondary.ipady = 150;
		contentPane.add(panelSecondary, gbc_secondary);
		
		
		
		
		
		
	}

}
