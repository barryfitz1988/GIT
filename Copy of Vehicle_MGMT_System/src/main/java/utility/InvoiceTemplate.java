package utility;



import java.math.BigDecimal;

import model.Invoice_Model;
import gui.Templates;
import net.sf.dynamicreports.report.base.expression.AbstractValueFormatter;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.column.Columns;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.component.ComponentBuilder;
import net.sf.dynamicreports.report.builder.component.HorizontalListBuilder;
import net.sf.dynamicreports.report.builder.component.TextFieldBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.builder.subtotal.AggregationSubtotalBuilder;
import net.sf.dynamicreports.report.definition.ReportParameters;
import net.sf.dynamicreports.report.exception.DRException;
import static net.sf.dynamicreports.report.builder.DynamicReports.*;

public class InvoiceTemplate {
	
	private Invoice_Model invoice;
	
	StyleBuilder boldStyle = stl.style().bold();  
	StyleBuilder boldCenteredStyle = stl.style(boldStyle);
	StyleBuilder titleStyle = stl.style(boldCenteredStyle).setFontSize(15);

	public InvoiceTemplate(Invoice_Model invoice) throws DRException {
		
		this.invoice = invoice;
		build();
	}

	private void build() throws DRException {
		
		TextFieldBuilder<String> title = DynamicReports.cmp.text("INVOICE NO. " + 
					invoice.getId() + "      DATE : " + invoice.getDate());
		title.setStyle(titleStyle);

		StyleBuilder columnStyle = stl.style(Templates.columnStyle).setBorder(stl.pen1Point());
		StyleBuilder subtotalStyle = stl.style(columnStyle).bold();
		StyleBuilder shippingStyle = stl.style(Templates.boldStyle);
		 	 
		//init columns
		TextColumnBuilder<Integer> rowNoColumn = Columns.reportRowNumberColumn("No.").setFixedColumns(2);
		TextColumnBuilder<String> descriptionColumn = Columns.column("Description", "item_name", DynamicReports.type.stringType())
		 	         .setFixedWidth(250);
		TextColumnBuilder<Integer> quantityColumn = Columns.column("Quantity", "item_quantity",  DynamicReports.type.integerType());
		TextColumnBuilder<Double> unitPriceColumn = Columns.column("Unit Price", "item_price", DynamicReports.type.doubleType());
		TextColumnBuilder<BigDecimal> priceColumn = unitPriceColumn.multiply(quantityColumn)
				.setTitle("Total Price")
				.setDataType(DynamicReports.type.bigDecimalType());
		AggregationSubtotalBuilder<BigDecimal> unitPriceSum = sbt.sum(priceColumn).setLabel("TOTAL =");

		report()
		 .setTemplate(Templates.reportTemplate)
		 .setColumnStyle(columnStyle)
		 .setSubtotalStyle(subtotalStyle)
		 .columns(rowNoColumn, descriptionColumn, quantityColumn, 
		 	        		 unitPriceColumn.setValueFormatter(new ValueFormatter()), 
		 	        		 priceColumn.setValueFormatter(new ValueFormatter()))
		 .columnGrid( rowNoColumn, descriptionColumn, quantityColumn, unitPriceColumn,
		 	            grid.horizontalColumnGridList().add(priceColumn).newRow())		 	      
		 .subtotalsAtSummary(unitPriceSum.setValueFormatter(new ValueFormatter()))	
		 .title(title, cmp.horizontalList().setStyle(stl.style(10)).setGap(50).add(
		 	           cmp.hListCell(createCustomerComponent1("Bill To", invoice)),
		 	           cmp.hListCell(createCustomerComponent2("Bill From"))),
		 	           cmp.verticalGap(10))
		 .pageFooter(Templates.footerComponent)
		 .setDataSource(invoice.getItems())
		 .show(false);	 	    
	}
	
	private static class ValueFormatter extends AbstractValueFormatter<String, Number> {
	      private static final long serialVersionUID = 1L;
	 
	      @Override
	      public String format(Number value, ReportParameters reportParameters) {
	         return type.bigDecimalType().valueToString(value, reportParameters.getLocale()) + " EUR";
	      }
	}
	
	private ComponentBuilder<?, ?> createCustomerComponent1(String label, Invoice_Model i) {
		HorizontalListBuilder list = cmp.horizontalList().setBaseStyle(stl.style().setTopBorder(stl.pen1Point()).setLeftPadding(10));
		addCustomerAttribute(list, "Name", i.getCustomername());
		addCustomerAttribute(list, "Vehicle Registration", i.getVehiclereg());
		return cmp.verticalList(cmp.text(label).setStyle(Templates.boldStyle), list);
	}
	
	private ComponentBuilder<?, ?> createCustomerComponent2(String label) {
		HorizontalListBuilder list = cmp.horizontalList().setBaseStyle(stl.style().setTopBorder(stl.pen1Point()).setLeftPadding(10));
		addCustomerAttribute(list, "Name", "Fitzgrald's Garage");
		addCustomerAttribute(list, "Address", "Drimoleague Co. Cork");
		return cmp.verticalList(cmp.text(label).setStyle(Templates.boldStyle), list);
	}
	 private void addCustomerAttribute(HorizontalListBuilder list, String label, String value) {
		 
		 if (value != null) {
		 list.add(cmp.text(label + ":").setFixedColumns(8).setStyle(Templates.boldStyle), cmp.text(value)).newRow();
		 }
	}
}