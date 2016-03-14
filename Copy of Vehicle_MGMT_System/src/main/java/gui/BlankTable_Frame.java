package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionListener;

public class BlankTable_Frame extends JFrame {

	private JPanel contentPane;
	private JTable blankTable;
	private JScrollPane blankScroller;


	/**
	 * Create the frame.
	 */
	public BlankTable_Frame() {
		setTitle("Please Select ");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 544, 437);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		JPanel detailsJPanel = new JPanel();
		detailsJPanel.setBorder(new TitledBorder(null, "Details", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		detailsJPanel.setBounds(22, 11, 322, 381);
		detailsJPanel.setLayout(null);
		blankTable = new JTable(/*data, columns*/);
		blankScroller = new JScrollPane(blankTable);
		blankScroller.setBounds(10, 23, 498, 354);
		detailsJPanel.add(blankScroller);
		contentPane.add(detailsJPanel);
		
		
		
	}


	public JTable getBlankTable() {
		return blankTable;
	}


	public void setBlankTable(JTable blankTable) {
		this.blankTable = blankTable;
	}


	public JScrollPane getBlankScroller() {
		return blankScroller;
	}


	public void setBlankScroller(JScrollPane blankScroller) {
		this.blankScroller = blankScroller;
	}

	public void tableSelecterListener(ListSelectionListener rowSelected){
	    
		
		blankTable.getSelectionModel().addListSelectionListener(rowSelected);
		
		}
	
	
}
