package gui;



import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;








import model.Employee_Model;

import org.freixas.jcalendar.DateEvent;
import org.freixas.jcalendar.DateListener;
import org.freixas.jcalendar.JCalendar;



public class Appointment_GUI extends JFrame {

	private JPanel contentPane;
	private JCalendar calendar;
	private JScrollPane appointmentScroller; 
	private JTable appointmentTable;
	private JTable rowtable;
	private String date;
	private JPanel calanderPanel;
    private JPanel buttonPanel;
    private JButton exitButton;
    private TableColumnModel columnModel;
    private DefaultTableModel tablemodel;
    private JOptionPane errorPane;


	public Appointment_GUI() {
		setTitle("Appointment Section");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 711, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel spreadsheetpanel = new JPanel();
		spreadsheetpanel.setBounds(10, 179, 675, 137);
		contentPane.add(spreadsheetpanel);
        spreadsheetpanel.setLayout(null);
		
		
        appointmentTable = new JTable();
        appointmentScroller = new JScrollPane(appointmentTable);
		appointmentScroller.setBounds(0, 0, 675, 126);
		 rowtable = new RowNumberTable(appointmentTable);
		 appointmentScroller.setRowHeaderView(rowtable);
		 appointmentScroller.setCorner(JScrollPane.UPPER_LEFT_CORNER,rowtable.getTableHeader());
		tablemodel = (DefaultTableModel)appointmentTable.getModel();
		//tablemodel.setColumnCount(arg0);
		columnModel = appointmentTable.getColumnModel();
		appointmentTable.setRowHeight(25);
		//appointmentTable.setValueAt("HELLO", 0, 0);
		appointmentTable.setVisible(false);
        

		spreadsheetpanel.add(appointmentScroller);
		
		calanderPanel = new JPanel();
		calanderPanel.setBounds(10, 11, 345, 157);
		contentPane.add(calanderPanel);
		calanderPanel.setLayout(null);
		calendar = new JCalendar(JCalendar.DISPLAY_DATE, false);
		calendar.setBounds(10, 11, 325, 135);
		calanderPanel.add(calendar);

		
		
		buttonPanel = new JPanel();
		buttonPanel.setBounds(10, 327, 675, 49);
		contentPane.add(buttonPanel);
		buttonPanel.setLayout(null);
		
		exitButton = new JButton("Return to Main");
		exitButton.setBounds(469, 11, 133, 23);
		buttonPanel.add(exitButton);
		
		errorPane = new JOptionPane();
		exitButton.setBounds(469, 11, 133, 23);
		buttonPanel.add(exitButton);

		

		
	}
	
	



	public void MyDateListener(DateListener changedDate){
		
		
		calendar.addDateListener(changedDate);
	}
	

	
	
	public void exitListener(ActionListener listenForButton){
	    
		exitButton.addActionListener(listenForButton);

		
		}
	
	
	public void selectCellonTable(MouseListener listenForClick){
	    
		appointmentTable.addMouseListener(listenForClick);


		
		}
	
	
	


	public JCalendar getCalendar() {
		return calendar;
	}


	public void setCalendar(JCalendar calendar) {
		this.calendar = calendar;
	}


	public JTable getAppointmentTable() {
		return appointmentTable;
	}


	public void setAppointmentTable(JTable appointmentTable) {
		this.appointmentTable = appointmentTable;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}



	public JButton getExitButton() {
		return exitButton;
	}


	public void setExitButton(JButton exitButton) {
		this.exitButton = exitButton;
	}


	public TableColumnModel getColumnModel() {
		return columnModel;
	}


	public void setColumnModel(TableColumnModel columnModel) {
		this.columnModel = columnModel;
	}
	
    public JTable getRowtable() {
		return rowtable;
	}


	public void setRowtable(JTable rowtable) {
		this.rowtable = rowtable;
	}
	
	public DefaultTableModel getTablemodel() {
		return tablemodel;
	}


	public void setTablemodel(DefaultTableModel tablemodel) {
		this.tablemodel = tablemodel;
	}





	public JOptionPane getErrorPane() {
		return errorPane;
	}





	public void setErrorPane(JOptionPane errorPane) {
		this.errorPane = errorPane;
	}
	
	
	
}
