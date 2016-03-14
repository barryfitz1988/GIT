package gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionListener;

import org.hibernate.sql.Delete;

public class Customer_GUI extends JFrame {

	private JPanel contentPane;
	private JTextField IDtextField;
	private JTextField FirstNametextField;
	private JTextField surnametextField;
	private JTextField phonetextField;
	private JTextField infoTextfield;
	private JTextField historyTextfield;
	private JScrollPane customerScroller; 
	private JTable customertable;
	private JButton exitJbutton;
	private JButton deleteJButton;
	private JButton addJButton;
	private JButton editJButton;
	private JOptionPane updateDetails;
	//private JOptionPane deleteDetails;
    private JTextField detailidtextfield;
    private JTextField detailfirstnametextfield;
    private JTextField detailsurnameTextField;
    private JTextField detailphonetextfield;
    private JTextField detailinfotextfield;
    private JTextField detailhistorytextfield;
//    private CustomerTable customertable;
	
	
	
	public Customer_GUI() {
		setTitle("Customer Section");


		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 711, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel listCustomerspanel = new JPanel();
		listCustomerspanel.setBounds(10, 11, 313, 207);
		listCustomerspanel.setBorder(new TitledBorder(null, "Search Customer", TitledBorder.LEFT, TitledBorder.TOP, null, Color.BLACK));
		contentPane.add(listCustomerspanel);
		
		
		JPanel enterCustoemrJpanel = new JPanel();
		enterCustoemrJpanel.setBounds(333, 11, 338, 207);
		enterCustoemrJpanel.setBorder(new TitledBorder(null, "Add New Customer", TitledBorder.LEFT, TitledBorder.TOP, null, Color.BLACK));
		contentPane.add(enterCustoemrJpanel);
		enterCustoemrJpanel.setLayout(null);
        listCustomerspanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		
		
        customertable = new JTable();
		customerScroller = new JScrollPane(customertable);
		listCustomerspanel.add(customerScroller);
		
		JLabel firstNameJLabel = new JLabel("First Name");
		firstNameJLabel.setBounds(10, 64, 98, 14);
		enterCustoemrJpanel.add(firstNameJLabel);
		
		JLabel lblIdNumber = new JLabel("ID Number");
		lblIdNumber.setBounds(10, 24, 67, 14);
		enterCustoemrJpanel.add(lblIdNumber);
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setBounds(10, 107, 67, 14);
		enterCustoemrJpanel.add(lblSurname);
		
		JLabel lblPhoneNumber = new JLabel("Telephone");
		lblPhoneNumber.setBounds(10, 155, 84, 14);
		enterCustoemrJpanel.add(lblPhoneNumber);
		
		IDtextField = new JTextField();
		IDtextField.setBounds(80, 21, 75, 20);
		enterCustoemrJpanel.add(IDtextField);
		IDtextField.setColumns(10);
		
		FirstNametextField = new JTextField();
		FirstNametextField.setColumns(10);
		FirstNametextField.setBounds(80, 61, 75, 20);
		enterCustoemrJpanel.add(FirstNametextField);
		
		surnametextField = new JTextField();
		surnametextField.setColumns(10);
		surnametextField.setBounds(80, 104, 75, 20);
		enterCustoemrJpanel.add(surnametextField);
		
		phonetextField = new JTextField();
		phonetextField.setColumns(10);
		phonetextField.setBounds(80, 152, 75, 20);
		enterCustoemrJpanel.add(phonetextField);
		
		JLabel lblAdditionalInfo = new JLabel("Information");
		lblAdditionalInfo.setBounds(159, 21, 73, 20);
		enterCustoemrJpanel.add(lblAdditionalInfo);
		
		infoTextfield = new JTextField();
		infoTextfield.setBounds(235, 21, 93, 60);
		enterCustoemrJpanel.add(infoTextfield);
		infoTextfield.setColumns(10);
		
		JLabel lblHistory = new JLabel("History");
		lblHistory.setBounds(165, 107, 67, 14);
		enterCustoemrJpanel.add(lblHistory);
		
		historyTextfield = new JTextField();
		historyTextfield.setColumns(10);
		historyTextfield.setBounds(235, 104, 93, 60);
		enterCustoemrJpanel.add(historyTextfield);
		
		addJButton = new JButton("Add");
		addJButton.setBounds(235, 173, 89, 23);
		enterCustoemrJpanel.add(addJButton);
		
		JPanel customerDetailsJPanel = new JPanel();
		customerDetailsJPanel.setBounds(10, 229, 675, 163);
		customerDetailsJPanel.setBorder(new TitledBorder(null, "Customer Details", TitledBorder.LEFT, TitledBorder.TOP, null, Color.BLACK));
		contentPane.add(customerDetailsJPanel);
		customerDetailsJPanel.setLayout(null);
		
		JLabel detailidNumberJLabel = new JLabel("ID Number");
		detailidNumberJLabel.setBounds(26, 25, 67, 14);
		customerDetailsJPanel.add(detailidNumberJLabel);
		
		JLabel detailfirstnameJLabel = new JLabel("First Name");
		detailfirstnameJLabel.setBounds(24, 58, 98, 14);
		customerDetailsJPanel.add(detailfirstnameJLabel);
		
		JLabel detailsurnameJLabel = new JLabel("Surname");
		detailsurnameJLabel.setBounds(26, 96, 67, 14);
		customerDetailsJPanel.add(detailsurnameJLabel);
		
		JLabel detailphoneJLabel = new JLabel("Telephone");
		detailphoneJLabel.setBounds(26, 138, 84, 14);
		customerDetailsJPanel.add(detailphoneJLabel);
		
		JLabel detailinfoJLabel = new JLabel("Information");
		detailinfoJLabel.setBounds(218, 22, 73, 20);
		customerDetailsJPanel.add(detailinfoJLabel);
		
		JLabel detailhistoryJLabel = new JLabel("History");
		detailhistoryJLabel.setBounds(218, 96, 67, 14);
		customerDetailsJPanel.add(detailhistoryJLabel);
		
		detailidtextfield = new JTextField();
		detailidtextfield.setColumns(10);
		detailidtextfield.setBounds(87, 22, 108, 20);
		detailidtextfield.setEditable(false);
		customerDetailsJPanel.add(detailidtextfield);
		
		detailfirstnametextfield = new JTextField();
		detailfirstnametextfield.setColumns(10);
		detailfirstnametextfield.setBounds(87, 55, 108, 20);
		customerDetailsJPanel.add(detailfirstnametextfield);
		
		detailsurnameTextField = new JTextField();
		detailsurnameTextField.setColumns(10);
		detailsurnameTextField.setBounds(87, 93, 108, 20);
		customerDetailsJPanel.add(detailsurnameTextField);
		
		detailphonetextfield = new JTextField();
		detailphonetextfield.setColumns(10);
		detailphonetextfield.setBounds(87, 135, 108, 20);
		customerDetailsJPanel.add(detailphonetextfield);
		
		detailinfotextfield = new JTextField();
		detailinfotextfield.setColumns(10);
		detailinfotextfield.setBounds(287, 25, 195, 60);
		customerDetailsJPanel.add(detailinfotextfield);
		
		detailhistorytextfield = new JTextField();
		detailhistorytextfield.setColumns(10);
		detailhistorytextfield.setBounds(287, 96, 195, 60);
		customerDetailsJPanel.add(detailhistorytextfield);
		
		editJButton = new JButton("Edit");
		editJButton.setBounds(494, 92, 67, 23);
		customerDetailsJPanel.add(editJButton);
		
		deleteJButton = new JButton("Delete");
		deleteJButton.setBounds(574, 92, 78, 23);
		customerDetailsJPanel.add(deleteJButton);
		
		exitJbutton = new JButton("Exit");
		exitJbutton.setBounds(574, 134, 67, 23);
		customerDetailsJPanel.add(exitJbutton);
	
		
		
		updateDetails = new JOptionPane();
		updateDetails.setBounds(574, 134, 200,200);	
		customerDetailsJPanel.add(updateDetails);
	

	}
	


	public void exitListener(ActionListener listenForButton){
	    
		exitJbutton.addActionListener(listenForButton);

		
		}
	
	
	public void deleteListener(ActionListener listenForButton){
	    
		deleteJButton.addActionListener(listenForButton);

		
		}
	
	
	public void editButtonListener(ActionListener listenForButton){
	    
		editJButton.addActionListener(listenForButton);

		
		}
	
	
	public void addNewCustomerListener(ActionListener listenForButton){
	    
		addJButton.addActionListener(listenForButton);

		
		}
	
	
	public void tableSelecterListener(ListSelectionListener rowSelected){
	    
		
		customertable.getSelectionModel().addListSelectionListener(rowSelected);
		
		}
	
	
	public JTextField getIDtextField() {
		return IDtextField;
	}
	public void setIDtextField(JTextField iDtextField) {
		IDtextField = iDtextField;
	}
	public JTextField getFirstNametextField() {
		return FirstNametextField;
	}
	public void setFirstNametextField(JTextField firstNametextField) {
		FirstNametextField = firstNametextField;
	}
	public JTextField getSurnametextField() {
		return surnametextField;
	}
	public void setSurnametextField(JTextField surnametextField) {
		this.surnametextField = surnametextField;
	}
	public JTextField getPhonetextField() {
		return phonetextField;
	}
	public void setPhonetextField(JTextField phonetextField) {
		this.phonetextField = phonetextField;
	}
	public JTextField getInfoTextfield() {
		return infoTextfield;
	}
	public void setInfoTextfield(JTextField infoTextfield) {
		this.infoTextfield = infoTextfield;
	}
	public JTextField getHistoryTextfield() {
		return historyTextfield;
	}
	public void setHistoryTextfield(JTextField historyTextfield) {
		this.historyTextfield = historyTextfield;
	}
	
	public JTable getCustomertable() {
		return customertable;
	}
	public void setCustomertable(JTable customertable) {
		this.customertable = customertable;
	}

	public JTextField getDetailidtextfield() {
		return detailidtextfield;
	}

	public void setDetailidtextfield(JTextField detailidtextfield) {
		this.detailidtextfield = detailidtextfield;
	}

	public JTextField getDetailfirstnametextfield() {
		return detailfirstnametextfield;
	}

	public void setDetailfirstnametextfield(JTextField detailfirstnametextfield) {
		this.detailfirstnametextfield = detailfirstnametextfield;
	}

	public JTextField getDetailsurnameTextField() {
		return detailsurnameTextField;
	}

	public void setDetailsurnameTextField(JTextField detailsurnameTextField) {
		this.detailsurnameTextField = detailsurnameTextField;
	}

	public JTextField getDetailphonetextfield() {
		return detailphonetextfield;
	}

	public void setDetailphonetextfield(JTextField detailphonetextfield) {
		this.detailphonetextfield = detailphonetextfield;
	}

	public JTextField getDetailinfotextfield() {
		return detailinfotextfield;
	}

	public void setDetailinfotextfield(JTextField detailinfotextfield) {
		this.detailinfotextfield = detailinfotextfield;
	}

	public JTextField getDetailhistorytextfield() {
		return detailhistorytextfield;
	}

	public void setDetailhistorytextfield(JTextField detailhistorytextfield) {
		this.detailhistorytextfield = detailhistorytextfield;
	}

	public JOptionPane getUpdateDetails() {
		return updateDetails;
	}

	public void setUpdateDetails(JOptionPane saveDetails) {
		this.updateDetails = saveDetails;
	}
	
	
	
	
	
	
	
	
}
