package gui;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import org.freixas.jcalendar.DateEvent;
import org.freixas.jcalendar.DateListener;
import org.freixas.jcalendar.JCalendar;

public class Roster_GUI extends JFrame {

	private JPanel contentPane;
	private JCalendar calendar;
	private JScrollPane appointmentScroller; 
	private JTable appointmentTable;
	private String date;

	
    //headers for the table
    String[] columns = new String[] {
      "Staff" , "Monday", "Tuesday", "Wednesday", "Thursday","Friday"
    };
     
    //actual data for the table in a 2d array
    Object[][] data = new Object[][] {
        {"Gary O'Brien", "9.00am - 5.30pm", "9.00am - 5.30pm", "9.00am - 5.30pm", "9.00am - 5.30pm", "9.00am - 5.30pm" },
    };
    private JPanel calanderPanel;
    private JPanel buttonPanel;
    private JButton addButton;
    private JButton editButton;
    private JButton deleteButton;
    private JButton exitButton;



	public Roster_GUI() {
		setTitle("Roster Section");
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
		
		
        appointmentTable = new JTable(data, columns);
		appointmentScroller = new JScrollPane(appointmentTable);
		appointmentScroller.setBounds(0, 0, 675, 126);
		spreadsheetpanel.add(appointmentScroller);
		
		calanderPanel = new JPanel();
		calanderPanel.setBounds(10, 11, 345, 157);
		contentPane.add(calanderPanel);
		MyDateListener listener = new MyDateListener();	
		calanderPanel.setLayout(null);
		calendar = new JCalendar(JCalendar.DISPLAY_DATE, false);
		calendar.setBounds(10, 11, 325, 135);
		calanderPanel.add(calendar);
		calendar.addDateListener(listener);
		
		
		buttonPanel = new JPanel();
		buttonPanel.setBounds(10, 327, 675, 49);
		contentPane.add(buttonPanel);
		buttonPanel.setLayout(null);
		
		addButton = new JButton("Add Roster");
		addButton.setBounds(26, 11, 133, 23);
		buttonPanel.add(addButton);
		
		editButton = new JButton("Edit Roster");
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		editButton.setBounds(174, 11, 133, 23);
		buttonPanel.add(editButton);
		
		deleteButton = new JButton("Delete Roster");
		deleteButton.setBounds(326, 11, 133, 23);
		buttonPanel.add(deleteButton);
		
		exitButton = new JButton("Return to Main");
		exitButton.setBounds(469, 11, 133, 23);
		buttonPanel.add(exitButton);
		

		

		
	}
	
	
	private class MyDateListener implements DateListener{
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		       
		public void dateChanged(DateEvent e){
			
			Calendar c = e.getSelectedDate();
			appointmentTable.setVisible(true);
			
			if (c != null) {
				
				 date = dateFormat.format(c.getTime()); 
		


			}
			
			else {
				
				System.out.println("No time selected.");
			}
		}

	}
	
	public void exitListener(ActionListener listenForButton){
	    
		exitButton.addActionListener(listenForButton);

		
		}

}
