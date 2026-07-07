package com.shrine.form;

import java.time.LocalDate;
import java.time.LocalTime;


public class ScheduleForm {
	
	private String name;
	private LocalDate date;
	private LocalTime startTime;
	private LocalTime endTime;
	private String note;
	private String staffName;
	private String staffAccount;
	private String genre;
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	public LocalDate getDate() { return date; }
	public void setDate(LocalDate date) { this.date = date; }
	
	public LocalTime getStartTime() { return startTime; }
	public void setStartTime(LocalTime startTime) { this.startTime = startTime; }
	
	public LocalTime getEndTime() { return endTime; }
	public void setEndTime(LocalTime endTime) { this.endTime = endTime; }
	
	public String getNote() { return note; }
	public void setNote(String note) { this.note = note; }
	
	public String getStaffName() { return staffName; }
	public void setStaffName(String staffName) { this.staffName = staffName; }
	
	public String getStaffAccount() { return staffAccount; }
	public void setStaffAccount(String staffAccount) { this.staffAccount = staffAccount; }
	
	public String getGenre() { return genre; }
	public void setGenre(String genre) { this.genre = genre; }
	
	
	

}
