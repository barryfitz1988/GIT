package controller;


import gui.Main_Menu_GUI;
import gui.Roster_GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Roster_Model;

public class Roster_Controller {
	
	
	private Main_Menu_GUI maingui = new Main_Menu_GUI();
	private Roster_GUI rostergui = new Roster_GUI ();
	private Roster_Model rostermodel = new Roster_Model();
	
	
    public Roster_Controller(Main_Menu_GUI maingui, Roster_GUI rostergui, Roster_Model rostermodel) {
    	        this.maingui = maingui;
    	        this.rostergui= rostergui;
    	        this.rostermodel = rostermodel;
    	         

    	       this.rostergui.exitListener(new exitListener());     
    		   this.maingui.addRosterListener(new Listener());
    		    
    
    
    }
    
    
	class exitListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {

				rostergui.dispose();
				maingui.setVisible(true);

			} catch (NumberFormatException nfe) {

				System.out.println("Not A Number: " + nfe.getMessage());

			}

		}

	}
    
    class Listener implements ActionListener{
    	
    	
    	public void actionPerformed(ActionEvent e) {
    
    		
    		
    		 try {


    			 maingui.dispose();
    			 
    			 
    			 rostergui.setVisible(true);
    			 
    		 
    		 } catch (NumberFormatException nfe) {
  			   
                 System.out.println("Not A Number: " + nfe.getMessage());
       
              }
    	
    	
    }
    	
}
	
	

}
