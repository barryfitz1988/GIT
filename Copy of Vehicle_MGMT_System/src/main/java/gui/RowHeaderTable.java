package gui;


import java.awt.Component;
import java.awt.Font;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import model.Employee_Model;


public class RowHeaderTable extends JTable
implements ChangeListener, PropertyChangeListener, TableModelListener
{
	private JTable main;
	private ArrayList<Employee_Model> employees;
	
	public RowHeaderTable(ArrayList<Employee_Model> employees, JTable table)
	{
		this.employees = employees;
		main = table;
		main.addPropertyChangeListener(this);
		main.getModel().addTableModelListener(this);
		setFocusable(false);
		setAutoCreateColumnsFromModel(false);
		setSelectionModel(main.getSelectionModel());
		
		TableColumn column = new TableColumn();
		column.setHeaderValue("");
		addColumn(column);
		column.setCellRenderer(new RowNameRenderer());
		
		getColumnModel().getColumn(0).setPreferredWidth(130);
		setPreferredScrollableViewportSize(getPreferredSize());
	}
	
	public void addNotify()
	{
		super.addNotify();
		
		Component c = getParent();
		
		if(c instanceof JViewport)
		{
			JViewport viewport = (JViewport)c;
			viewport.addChangeListener(this);
		}
	}
	
	public int getRowCount()
	{
		return employees.size();
	}
	
	public int getRowHeight(int row)
	{
		int rowHeight = main.getRowHeight(row);
		
		if(rowHeight !=  super.getRowHeight(row))
		{
			super.setRowHeight(row, rowHeight);
		}
		
		return rowHeight;
	}
	
	public Object getValueAt(int row, int column)
	{
	      return employees.get(row).getEmp_firstname() + " " + 
	     employees.get(row).getEmp_surname();
	}
	
	public void setValueAt(Object value, int row, int column) {}
	
	public boolean isCellEditable(int row, int column)
	{
		return false;
	}
	
	public void stateChanged(ChangeEvent e)
	{
		JViewport viewport = (JViewport)e.getSource();
		JScrollPane scrollpane = (JScrollPane)viewport.getParent();
		scrollpane.getVerticalScrollBar().setValue(viewport.getViewPosition().y);
	}
	
	public void propertyChange(PropertyChangeEvent e)
	{
		if("selectionModel".equals(e.getPropertyName()))
		{
			setSelectionModel(main.getSelectionModel());
		}
		
		if("rowHeight".equals(e.getPropertyName()))
		{
			repaint();
		}
		
		if("model".equals(e.getPropertyName()))
		{
			main.getModel().addTableModelListener(this);
			revalidate();
		}
	}
	
	public void tableChanged(TableModelEvent e)
	{
		revalidate();
	}
	
	private static class RowNameRenderer extends DefaultTableCellRenderer
	{
		public RowNameRenderer()
		{
			setHorizontalAlignment(JLabel.CENTER);
		}
		
		public Component getTableCellRendererComponent(JTable table, Object value, 
				boolean isSelected, boolean hasFocus, int row, int column)
		{
			if(table != null)
			{
				JTableHeader header = table.getTableHeader();
				
				if(header != null)
				{
					setForeground(header.getForeground());
					setBackground(header.getBackground());
					setFont(header.getFont());
				}
			}
			
			if(isSelected)
			{
				setFont(getFont().deriveFont(Font.BOLD));
			}
			
			setText((value == null) ? "" : value.toString());
			setBorder(UIManager.getBorder("TableHeader.cellBorder"));
			
			return this;
		}
	}
}
