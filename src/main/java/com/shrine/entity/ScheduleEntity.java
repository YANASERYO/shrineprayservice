package com.shrine.entity;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.LocalDate;

@Entity
public class ScheduleEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private LocalDate date;
	private LocalTime startTime;
	private LocalTime endTime;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private boolean deleted;
	private String note;
	private String staffName;
	private String staffAccount;
	private String genre;
	
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	public LocalDate getDate() { return date; }
	public void setDate(LocalDate date) { this.date = date; }
	
	public LocalTime getStartTime() { return startTime; }
	public void setStartTime(LocalTime startTime) { this.startTime = startTime; }
	
	public LocalTime getEndTime() { return endTime; }
	public void setEndTime(LocalTime endTime) { this.endTime = endTime; }
	
	public LocalDateTime getCreatedAt() { return createdAt; }
	public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt;}
	
	public LocalDateTime getUpdatedAt() { return updatedAt; }
	public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt;}
	
	public boolean isDeleted() { return deleted; }
	public void setDeleted(boolean deleted) { this.deleted = deleted; }
	
	public String getNote() { return note; }
	public void setNote(String note) { this.note = note; }
	
	public String getStaffName() { return staffName; }
	public void setStaffName(String staffName) { this.staffName = staffName; }
	
	public String getStaffAccount() { return staffAccount; }
	public void setStaffAccount(String staffAccount) { this.staffAccount = staffAccount; }
	
	public String getGenre() { return genre; }
	public void setGenre(String genre) { this.genre = genre;
	
	}
	}
	}

}
