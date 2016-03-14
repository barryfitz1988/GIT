package model;

import java.util.Date;

public class Roster_Model {
	
	
	private Date date;
	private int employee_id;
	private String start_time;
	private String end_time;
	
	
	
	public Roster_Model(Date date, int employee_id, String start_time,
			String end_time) {
		this.date = date;
		this.employee_id = employee_id;
		this.start_time = start_time;
		this.end_time = end_time;
	}
	
	public Roster_Model(){}

	
	
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	@Override
	public String toString() {
		return "Roster_Model [date=" + date + ", employee_id=" + employee_id
				+ ", start_time=" + start_time + ", end_time=" + end_time + "]";
	}
	
	
	
	
	
	
	

}
