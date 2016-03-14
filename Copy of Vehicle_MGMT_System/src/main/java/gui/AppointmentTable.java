package gui;

import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;

import model.Employee_Model;



public class AppointmentTable extends AbstractTableModel {
	
	
	private ArrayList<Employee_Model> employees;

    public AppointmentTable(ArrayList<Employee_Model> employees) {
       
    	super();
		this.employees = employees;
		
	 }
    
    public boolean isCellEditable(int row, int col) {
        return false;
    }
 
    public Object getValueAt(int row, int col) {
        return null;
    }
 
    public int getColumnCount() {
        return employees.size();
    }
 
    public int getRowCount() {
        return 11;
    }
    
   
 

}
 
	class MultiLineCellRenderer extends JTextArea implements TableCellRenderer {
 
    public MultiLineCellRenderer() {
        setLineWrap(true);
        setWrapStyleWord(true);
        setOpaque(true);
        setEditable(false); //this line doesn't seem to be doing anything
    }
 
    public Component getTableCellRendererComponent(JTable table, Object value,
        boolean isSelected, boolean hasFocus, int row, int column) {
        if (isSelected) {
            setForeground(table.getSelectionForeground());
            setBackground(table.getSelectionBackground());
        }
        else {
            setForeground(table.getForeground());
            setBackground(table.getBackground());
        }
        setFont(table.getFont());
        if (hasFocus) {
            setBorder(UIManager.getBorder("Table.focusCellHighlightBorder"));
            if (table.isCellEditable(row, column)) {
                setForeground(UIManager.getColor("Table.focusCellForeground"));
                setBackground(UIManager.getColor("Table.focusCellBackground"));
            }
        }
        else {
            setBorder(new EmptyBorder(1, 2, 1, 2));
        }
        setText((value == null) ? "" : value.toString());
        setEditable(false); //this line doesn't seem to be doing anything
        return this;
    }
    
    
}
