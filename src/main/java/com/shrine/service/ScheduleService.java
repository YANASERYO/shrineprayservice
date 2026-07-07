package com.shrine.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.shrine.entity.ScheduleEntity;
import com.shrine.repository.ScheduleRepository;



@Service
public class ScheduleService {
	private final ScheduleRepository scheduleRepository;
	
	public ScheduleService(ScheduleRepository scheduleRepository) {
		this.scheduleRepository = scheduleRepository;
	}
	
	public List<ScheduleEntity> findAllNotDeleted() {
		return scheduleRepository.findByDeletedFalseOrderByDateAscStartTimeAsc();
	}
	
	public void create(ScheduleEntity schedule) {
		schedule.setCreatedAt(LocalDateTime.now());
		schedule.setUpdatedAt(LocalDateTime.now());
		schedule.setDeleted(false);
		scheduleRepository.save(schedule);
	}
	
	public void delete(Long id) {
	    ScheduleEntity schedule = scheduleRepository.findById(id).orElseThrow();
	    schedule.setDeleted(true);
	    schedule.setUpdatedAt(LocalDateTime.now());
	    scheduleRepository.save(schedule);
	}

}
