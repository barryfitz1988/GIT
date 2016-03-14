package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class Invoice_GUI extends JFrame {

	private JPanel contentPane;
	private JScrollPane serviceScroller; 
	private JTable serviceTable;
    //headers for the table
    String[] columns = new String[] {
      "ID" , "Registration", "Make", "Model", "Chassis Number", "Customer ID"
    };
     
    //actual data for the table in a 2d array
    Object[][] data = new Object[][] {
        { 001, "08-c-1999", "VW", "Golf","WVWZZZ1JZ",23 },

    };
    private JButton btnPrint;
    private JButton btnExit;
    private JTextArea billTextArea;


	public Invoice_GUI() {
		setTitle("Invoice Section");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 711, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel detailsJPanel = new JPanel();
		detailsJPanel.setBorder(new TitledBorder(null, "Invoice Information", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		detailsJPanel.setBounds(22, 11, 322, 381);
		detailsJPanel.setLayout(null);
		serviceTable = new JTable(data, columns);
		serviceScroller = new JScrollPane(serviceTable);
		serviceScroller.setBounds(10, 23, 302, 347);
		detailsJPanel.add(serviceScroller);
		contentPane.add(detailsJPanel);
		
		
		
		
		JPanel informationJPanel = new JPanel();
		informationJPanel.setBorder(new TitledBorder(null, "Invoice Details", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		informationJPanel.setBounds(363, 11, 322, 381);
		contentPane.add(informationJPanel);
		informationJPanel.setLayout(null);
		
		btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnPrint.setBounds(74, 347, 66, 23);
		informationJPanel.add(btnPrint);
		
		btnExit = new JButton("Exit");
		btnExit.setBounds(225, 347, 66, 23);
		informationJPanel.add(btnExit);
		
		billTextArea = new JTextArea();
		billTextArea.setEditable(false);
		billTextArea.setWrapStyleWord(true);
		billTextArea.setText("This is where the Bill info goes");
		billTextArea.setBounds(10, 25, 302, 323);
		informationJPanel.add(billTextArea);
	}

	
	public void exitListener(ActionListener listenForButton){
	    
		btnExit.addActionListener(listenForButton);

		
		}
	
	public void printListener(ActionListener listenForButton){
	    
		btnPrint.addActionListener(listenForButton);

		
		}

}
