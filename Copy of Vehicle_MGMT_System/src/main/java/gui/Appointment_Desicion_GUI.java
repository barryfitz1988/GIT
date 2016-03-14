package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Appointment_Desicion_GUI extends JFrame {

	private JPanel contentPane;
	private JButton btnUpdate;
	private JButton btnDelete;


	/**
	 * Create the frame.
	 */
	public Appointment_Desicion_GUI() {
		setTitle("Update Or Delete");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\r\n\r\n\t\t\t\t             Update or Delete Appointment??");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setBounds(10, 25, 394, 46);
		contentPane.add(lblNewLabel);
		
		btnUpdate = new JButton("Update");
		btnUpdate.setBounds(44, 183, 89, 23);
		contentPane.add(btnUpdate);
		
		btnDelete = new JButton("Delete");
		btnDelete.setBounds(275, 183, 89, 23);
		contentPane.add(btnDelete);
	}
	
	
	public void DeleteAppointment(ActionListener listenForClick){
	    
		btnDelete.addActionListener(listenForClick);


		
		}
	
	
	
	public void UpdateAppointment(ActionListener listenForClick){
	    
		btnUpdate.addActionListener(listenForClick);


		
		}
	
}
