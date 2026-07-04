package com.shrine.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.shrine.entity.StaffNoticeEntity;
import com.shrine.repository.StaffNoticeRepository;

@Service
public class StaffNoticeService {
	private final StaffNoticeRepository staffNoticeRepository;
	
	public StaffNoticeService(StaffNoticeRepository staffNoticeRepository) {
		this.staffNoticeRepository = staffNoticeRepository;
	}
	
//	一覧
	public List<StaffNoticeEntity>findAllNotices() {
		return staffNoticeRepository.findByDeletedFalseOrderByCreatedAtDesc();
	}

//	新規
	public StaffNoticeEntity createNotice(StaffNoticeEntity notice) {
		notice.setCreatedAt(LocalDateTime.now());
		notice.setUpdatedAt(LocalDateTime.now());
		notice.setDeleted(false);
		return staffNoticeRepository.save(notice);
	}
}
