package main;

import gui.AddAppointment_GUI;
import gui.Appointment_GUI;
import gui.Customer_GUI;
import gui.Employee_GUI;
import gui.Invoice_GUI;
import gui.Main_Menu_GUI;
import gui.Parts_GUI;
import gui.Roster_GUI;
import gui.Sales_GUI;
import gui.Service_GUI;
import gui.Vehicle_GUI;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.Appointment_Model;
import model.Customer_Model;
import model.Employee_Model;
import model.Invoice_Model;
import model.Parts_Model;
import model.Roster_Model;
import model.Sales_Model;
import model.Service_Model;
import model.Vehicle_Model;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



import org.springframework.boot.builder.SpringApplicationBuilder;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import controller.Appointment_Controller;
import controller.Customer_Controller;
import controller.Employee_Controller;
import controller.Invoice_Controller;
import controller.Parts_Controller;
import controller.Roster_Controller;
import controller.Sales_Controller;
import controller.Service_Controller;
import controller.Vehicle_Controller;




@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		new SpringApplicationBuilder(Main.class).headless(false).run(args);;
		// TODO Auto-generated method stub
        
	       Main_Menu_GUI theView = new Main_Menu_GUI(); 
	       Invoice_Model invoiceModel = new Invoice_Model();
	       Invoice_GUI invoiceView = new Invoice_GUI();
	       Invoice_Controller invoiceController = new Invoice_Controller(theView, invoiceView, invoiceModel);       
	       Customer_Model theModel = new Customer_Model();
	       Customer_GUI theResult = new Customer_GUI();
	       Customer_Controller theController = new Customer_Controller(theView, theResult, theModel);
	       Appointment_Model appointmentModel = new Appointment_Model();
	       Appointment_GUI appointmentView = new Appointment_GUI();
	       AddAppointment_GUI addappointmentgui = new AddAppointment_GUI();
	       Appointment_Controller appointmentController = new Appointment_Controller(theView, addappointmentgui, appointmentView, appointmentModel, invoiceView);
	       Service_Model serviceModel = new Service_Model();
	       Service_GUI serviceView = new Service_GUI();
	       Service_Controller serviceController = new Service_Controller(theView, serviceView, serviceModel);
	       Parts_Model partsModel = new Parts_Model();
	       Parts_GUI partsView = new Parts_GUI();
	       Parts_Controller partscontroller = new Parts_Controller(theView, partsView, partsModel);
	       Vehicle_Model vehicleModel = new Vehicle_Model();
	       Vehicle_GUI vehicleView = new Vehicle_GUI();
	       Vehicle_Controller vehiclecontroller = new Vehicle_Controller(theView, vehicleView, vehicleModel);
	       Employee_Model employeeModel = new Employee_Model();
	       Employee_GUI employeeView = new Employee_GUI();
	       Employee_Controller employeecontroller = new Employee_Controller(theView, employeeView, employeeModel);
	       Roster_Model rosterModel = new Roster_Model();
	       Roster_GUI rosterView = new Roster_GUI();
	       Roster_Controller rosterController = new Roster_Controller(theView, rosterView, rosterModel);
	       Sales_Model salesModel = new Sales_Model();
	       Sales_GUI salesView = new Sales_GUI();
	       Sales_Controller salesController = new Sales_Controller(theView, salesView, salesModel);
	       

		
		

			 theView.setVisible(true);

	}

}
