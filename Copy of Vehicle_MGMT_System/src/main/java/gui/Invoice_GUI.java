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
import javax.swing.event.ListSelectionListener;

public class Invoice_GUI extends JFrame {

	private JPanel contentPane;
	private JScrollPane serviceScroller; 
	private JTable invoiceTable;
    private JButton btnPrint;
    private JButton btnExit;


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
		detailsJPanel.setBounds(22, 11, 568, 381);
		detailsJPanel.setLayout(null);
		invoiceTable = new JTable();
		serviceScroller = new JScrollPane(invoiceTable);
		serviceScroller.setBounds(10, 23, 548, 278);
		detailsJPanel.add(serviceScroller);
		contentPane.add(detailsJPanel);
		
		btnPrint = new JButton("Print...");
		btnPrint.setBounds(371, 347, 66, 23);
		detailsJPanel.add(btnPrint);
		
		btnExit = new JButton("Exit");
		btnExit.setBounds(463, 347, 66, 23);
		detailsJPanel.add(btnExit);
	}

	
	
	
	public JTable getInvoiceTable() {
		return invoiceTable;
	}




	public void setInvoiceTable(JTable invoiceTable) {
		this.invoiceTable = invoiceTable;
	}




	public void exitListener(ActionListener listenForButton){
	    
		btnExit.addActionListener(listenForButton);

		
		}
	
	
	
	public void printListener(ActionListener listenForButton){
	    
		btnPrint.addActionListener(listenForButton);

		
		}
	
	public void tableSelecterListener(ListSelectionListener rowSelected){
	    
		
		invoiceTable.getSelectionModel().addListSelectionListener(rowSelected);
		
		}

}
