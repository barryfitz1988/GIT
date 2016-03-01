
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class pg2 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pg2 window = new pg2();

					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public pg2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Merry Xmas My Jen Jen");
		frame.setBounds(100, 100, 717, 432);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(220, 20, 60));
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmSeeAPuppy = new JMenuItem("See a puppy ");
		mnFile.add(mntmSeeAPuppy);
		
		JMenuItem mntmReliveAMemory = new JMenuItem("Relive a memory");
		mnFile.add(mntmReliveAMemory);
		
		JMenuItem mntmANicePic = new JMenuItem("A nice pic of you ");
		mnFile.add(mntmANicePic);
		
		JMenuItem mntmYourCuddeler = new JMenuItem("Your cuddler");
		mnFile.add(mntmYourCuddeler);
		
		JMenuItem mntmExit = new JMenuItem("Exit ");
		mnFile.add(mntmExit);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmClickHereFor = new JMenuItem("Click Here for the answers");
		mnHelp.add(mntmClickHereFor);
		
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar.add(menuBar_1);
		frame.getContentPane().setLayout(null);
		
		
		
		JLabel doglabel = new JLabel("");
		Image dog =  new ImageIcon(this.getClass().getResource("dogxmas.png")).getImage();
		doglabel.setBounds(62, 73, 470, 288);
		doglabel.setIcon(new ImageIcon(dog));
		frame.getContentPane().add(doglabel);
		
		JTextPane textPane = new JTextPane();
		textPane.setText("Hello Jennifer Merry Christmas \n"
				+ "I am Jimmy your guide for this quiz for your Christmas \n\n"
				+ "So I'm going to ask you the first question have you been a good girl this year? \n\n"
				+ "Yes \n\n"
				+ "or \n\n"
				+ "No \n\n");
		textPane.setBounds(10, 11, 681, 146);
		frame.getContentPane().add(textPane);
		
		JButton btnYes = new JButton("Yes");
		btnYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnYes.setBounds(486, 240, 89, 23);
		frame.getContentPane().add(btnYes);
		
		JButton btnNo = new JButton("No");
		btnNo.setBounds(585, 240, 89, 23);
		frame.getContentPane().add(btnNo);
		
	
		

		
		
	}
}
