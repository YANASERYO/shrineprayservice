package com.shrine.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shrine.entity.ScheduleEntity;


public interface ScheduleRepository extends JpaRepository<ScheduleEntity, Long> {

	List<ScheduleEntity> findByDeletedFalseOrderByDateAscStartTimeAsc();
	
	List<ScheduleEntity> findByDeletedFalseAndDateGreaterThanEqualOrderByDateAscStartTimeAsc(LocalDate date);

	List<ScheduleEntity> findByDeletedFalseAndDateOrderByStartTimeAsc(LocalDate date);
}
