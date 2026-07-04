package com.shrine.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shrine.entity.StaffNoticeEntity;

public interface StaffNoticeRepository extends JpaRepository<StaffNoticeEntity, Long> {
	List<StaffNoticeEntity> findByDeletedFalseOrderByCreatedAtDesc();

}
