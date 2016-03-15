package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
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
import javax.swing.event.MouseInputListener;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.border.LineBorder;

public class Sales_GUI extends JFrame {



	private JPanel contentPane;
	private JTextField IDtextField;
	private JTextField MaketextField;
	private JTextField ModeltextField;
	private JTextField regTextfield;
	private JTextField DescriptionTextfield;
	private JScrollPane customerScroller; 
	private JTable Salestable;
	private JButton exitJbutton;
	private JButton deleteJButton;
	private JButton addJButton;
	private JButton editJButton;
	private JOptionPane updateDetails;
	//private JOptionPane deleteDetails;
    private JTextField detailidtextfield;
    private JTextField detailregtextfield;
    private JTextField detailmakeTextField;
    private JTextField detailmodeltextfield;
    private JTextField detaildescriptiontextfield;
    private JTextField priceTextfield;
    private JTextField priceInfotextField;
    private JLabel priceInfoLbl;
    private JTextField ImageTextField;
    private JLabel imageLbl;
    
 
    private ImageIcon carIcon;
    private JLabel lblDBImageLbl;
    


	/**
	 * Create the frame.
	 */
	public Sales_GUI() {
		setTitle("Sales Section");


		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 711, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel ListSalesspanel = new JPanel();
		ListSalesspanel.setBounds(10, 11, 241, 183);
		ListSalesspanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Search Vehicle", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(ListSalesspanel);
		
		
		JPanel enterDetailspanel = new JPanel();
		enterDetailspanel.setBounds(261, 11, 410, 183);
		enterDetailspanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Add New Sales Car", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(enterDetailspanel);
		enterDetailspanel.setLayout(null);
        ListSalesspanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		
		
        Salestable = new JTable();
		customerScroller = new JScrollPane(Salestable);
		ListSalesspanel.add(customerScroller);
		
		JLabel makeJLabel = new JLabel("Make");
		makeJLabel.setBounds(10, 64, 98, 14);
		enterDetailspanel.add(makeJLabel);
		
		JLabel lblIdNumber = new JLabel("ID Number");
		lblIdNumber.setBounds(10, 24, 67, 14);
		enterDetailspanel.add(lblIdNumber);
		
		JLabel lblModel = new JLabel("Model");
		lblModel.setBounds(10, 107, 67, 14);
		enterDetailspanel.add(lblModel);
		
		IDtextField = new JTextField();
		IDtextField.setBounds(80, 21, 75, 20);
		enterDetailspanel.add(IDtextField);
		IDtextField.setColumns(10);
		
		MaketextField = new JTextField();
		MaketextField.setColumns(10);
		MaketextField.setBounds(80, 61, 75, 20);
		enterDetailspanel.add(MaketextField);
		
		ModeltextField = new JTextField();
		ModeltextField.setColumns(10);
		ModeltextField.setBounds(80, 104, 75, 20);
		enterDetailspanel.add(ModeltextField);
		
		JLabel lblAdditionalInfo = new JLabel("Registration");
		lblAdditionalInfo.setBounds(159, 21, 73, 20);
		enterDetailspanel.add(lblAdditionalInfo);
		
		regTextfield = new JTextField();
		regTextfield.setBounds(235, 21, 93, 20);
		enterDetailspanel.add(regTextfield);
		regTextfield.setColumns(10);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(159, 137, 67, 14);
		enterDetailspanel.add(lblDescription);
		
		DescriptionTextfield = new JTextField();
		DescriptionTextfield.setColumns(10);
		DescriptionTextfield.setBounds(235, 114, 93, 60);
		enterDetailspanel.add(DescriptionTextfield);
		
		addJButton = new JButton("Add");
		addJButton.setBounds(339, 151, 61, 23);
		enterDetailspanel.add(addJButton);
		
		priceTextfield = new JTextField();
		priceTextfield.setColumns(10);
		priceTextfield.setBounds(80, 152, 75, 20);
		enterDetailspanel.add(priceTextfield);
		
		JLabel priceLbl = new JLabel("Price");
		priceLbl.setBounds(10, 155, 67, 14);
		enterDetailspanel.add(priceLbl);
		
		ImageTextField = new JTextField();
		ImageTextField.setFont(new Font("Tahoma", Font.ITALIC, 11));
		ImageTextField.setText("Click To Add Image");
		ImageTextField.setColumns(10);
		ImageTextField.setBounds(235, 61, 118, 20);
		enterDetailspanel.add(ImageTextField);
		
		imageLbl = new JLabel("Image");
		imageLbl.setBounds(159, 64, 73, 20);
		enterDetailspanel.add(imageLbl);
		
		JPanel customerDetailsJPanel = new JPanel();
		customerDetailsJPanel.setBounds(20, 194, 675, 198);
		customerDetailsJPanel.setBorder(new TitledBorder(null, "Sales Details", TitledBorder.LEFT, TitledBorder.TOP, null, Color.BLACK));
		contentPane.add(customerDetailsJPanel);
		customerDetailsJPanel.setLayout(null);
		
		JLabel detailidNumberJLabel = new JLabel("ID Number");
		detailidNumberJLabel.setBounds(26, 25, 67, 14);
		customerDetailsJPanel.add(detailidNumberJLabel);
		
		JLabel RegInfoJLabel = new JLabel("Reg");
		RegInfoJLabel.setBounds(24, 58, 98, 14);
		customerDetailsJPanel.add(RegInfoJLabel);
		
		JLabel MakeJLabel = new JLabel("Make");
		MakeJLabel.setBounds(26, 96, 67, 14);
		customerDetailsJPanel.add(MakeJLabel);
		
		JLabel ModelJLabel = new JLabel("Model");
		ModelJLabel.setBounds(26, 138, 84, 14);
		customerDetailsJPanel.add(ModelJLabel);
		
		JLabel detailDescriptionJLabel = new JLabel("Description");
		detailDescriptionJLabel.setBounds(218, 25, 67, 14);
		customerDetailsJPanel.add(detailDescriptionJLabel);
		
		detailidtextfield = new JTextField();
		detailidtextfield.setColumns(10);
		detailidtextfield.setBounds(87, 22, 108, 20);
		detailidtextfield.setEditable(false);
		customerDetailsJPanel.add(detailidtextfield);
		
		detailregtextfield = new JTextField();
		detailregtextfield.setEditable(false);
		detailregtextfield.setColumns(10);
		detailregtextfield.setBounds(87, 55, 108, 20);
		customerDetailsJPanel.add(detailregtextfield);
		
		detailmakeTextField = new JTextField();
		detailmakeTextField.setColumns(10);
		detailmakeTextField.setBounds(87, 93, 108, 20);
		customerDetailsJPanel.add(detailmakeTextField);
		
		detailmodeltextfield = new JTextField();
		detailmodeltextfield.setColumns(10);
		detailmodeltextfield.setBounds(87, 135, 108, 20);
		customerDetailsJPanel.add(detailmodeltextfield);
		
		detaildescriptiontextfield = new JTextField();
		detaildescriptiontextfield.setColumns(10);
		detaildescriptiontextfield.setBounds(218, 50, 120, 60);
		customerDetailsJPanel.add(detaildescriptiontextfield);
		
		editJButton = new JButton("Edit");
		editJButton.setBounds(242, 164, 67, 23);
		customerDetailsJPanel.add(editJButton);
		
		deleteJButton = new JButton("Delete");
		deleteJButton.setBounds(319, 164, 78, 23);
		customerDetailsJPanel.add(deleteJButton);
		
		exitJbutton = new JButton("Exit");
		exitJbutton.setBounds(407, 164, 67, 23);
		customerDetailsJPanel.add(exitJbutton);
		
		priceInfotextField = new JTextField();
		priceInfotextField.setColumns(10);
		priceInfotextField.setBounds(87, 167, 108, 20);
		customerDetailsJPanel.add(priceInfotextField);
		
		priceInfoLbl = new JLabel("Price");
		priceInfoLbl.setBounds(24, 168, 84, 14);
		customerDetailsJPanel.add(priceInfoLbl);
		
		
		carIcon = new ImageIcon();
		
		JPanel ImagePanel = new JPanel();
		ImagePanel.setBorder(new LineBorder(Color.WHITE, 0));
		ImagePanel.setBounds(365, 25, 261, 127);
		customerDetailsJPanel.add(ImagePanel);
		ImagePanel.setLayout(null);
		
		lblDBImageLbl = new JLabel(carIcon);
		lblDBImageLbl.setBounds(0, 0, 261, 127);
		ImagePanel.add(lblDBImageLbl);
		
			
			
	updateDetails = new JOptionPane();
	updateDetails.setBounds(244, 336, 200, 200);
	contentPane.add(updateDetails);
	}
	
	
	
	
	
	public ImageIcon getCarIcon() {
		return carIcon;
	}





	public void setCarIcon(ImageIcon carIcon) {
		this.carIcon = carIcon;
	}





	public JTextField getIDtextField() {
		return IDtextField;
	}





	public void setIDtextField(JTextField iDtextField) {
		IDtextField = iDtextField;
	}





	public JTextField getMaketextField() {
		return MaketextField;
	}





	public void setMaketextField(JTextField maketextField) {
		MaketextField = maketextField;
	}





	public JTextField getModeltextField() {
		return ModeltextField;
	}





	public void setModeltextField(JTextField modeltextField) {
		ModeltextField = modeltextField;
	}





	public JTextField getRegTextfield() {
		return regTextfield;
	}





	public void setRegTextfield(JTextField regTextfield) {
		this.regTextfield = regTextfield;
	}





	public JTextField getDescriptionTextfield() {
		return DescriptionTextfield;
	}





	public void setDescriptionTextfield(JTextField descriptionTextfield) {
		DescriptionTextfield = descriptionTextfield;
	}





	public JTable getSalestable() {
		return Salestable;
	}





	public void setSalestable(JTable salestable) {
		Salestable = salestable;
	}





	public JOptionPane getUpdateDetails() {
		return updateDetails;
	}





	public void setUpdateDetails(JOptionPane updateDetails) {
		this.updateDetails = updateDetails;
	}





	public JTextField getDetailidtextfield() {
		return detailidtextfield;
	}





	public void setDetailidtextfield(JTextField detailidtextfield) {
		this.detailidtextfield = detailidtextfield;
	}





	public JTextField getDetailregtextfield() {
		return detailregtextfield;
	}





	public void setDetailregtextfield(JTextField detailregtextfield) {
		this.detailregtextfield = detailregtextfield;
	}





	public JTextField getDetailmakeTextField() {
		return detailmakeTextField;
	}





	public void setDetailmakeTextField(JTextField detailmakeTextField) {
		this.detailmakeTextField = detailmakeTextField;
	}





	public JTextField getDetailmodeltextfield() {
		return detailmodeltextfield;
	}





	public void setDetailmodeltextfield(JTextField detailmodeltextfield) {
		this.detailmodeltextfield = detailmodeltextfield;
	}





	public JTextField getDetaildescriptiontextfield() {
		return detaildescriptiontextfield;
	}





	public void setDetaildescriptiontextfield(JTextField detaildescriptiontextfield) {
		this.detaildescriptiontextfield = detaildescriptiontextfield;
	}





	public JTextField getPriceTextfield() {
		return priceTextfield;
	}





	public void setPriceTextfield(JTextField priceTextfield) {
		this.priceTextfield = priceTextfield;
	}





	public JTextField getPriceInfotextField() {
		return priceInfotextField;
	}





	public void setPriceInfotextField(JTextField priceInfotextField) {
		this.priceInfotextField = priceInfotextField;
	}





	public JLabel getLblDBImageLbl() {
		return lblDBImageLbl;
	}





	public void setLblDBImageLbl(JLabel lblDBImageLbl) {
		this.lblDBImageLbl = lblDBImageLbl;
	}





	public JTextField getImageTextField() {
		return ImageTextField;
	}





	public void setImageTextField(JTextField imageTextField) {
		ImageTextField = imageTextField;
	}





	public JLabel getImageLbl() {
		return imageLbl;
	}





	public void setImageLbl(JLabel imageLbl) {
		this.imageLbl = imageLbl;
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
	
	
	public void addNewSalesListener(ActionListener listenForButton){
	    
		addJButton.addActionListener(listenForButton);

		
		}
	
	
	public void tableSelecterListener(ListSelectionListener rowSelected){
	    
		
		Salestable.getSelectionModel().addListSelectionListener(rowSelected);
		
		}
	
	
	public void SearchforImage( MouseListener listenForTextfield){
	    
		ImageTextField.addMouseListener(listenForTextfield);
		
		
		}
}
