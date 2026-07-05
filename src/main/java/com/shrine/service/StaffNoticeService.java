package com.shrine.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.shrine.entity.StaffAccountEntity;
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
	public StaffNoticeEntity createNotice(StaffNoticeEntity notice,StaffAccountEntity staffAccount) {
		LocalDateTime now = LocalDateTime.now();
		
		notice.setStaffAccount(staffAccount);
		notice.setCreatedAt(now);
		notice.setUpdatedAt(now);
		notice.setDeleted(false);
		
		return staffNoticeRepository.save(notice);
	}
	
//	削除
	public void deleteNotice(Long id) {
		StaffNoticeEntity notice = staffNoticeRepository.findById(id)
				.orElseThrow();
		notice.setDeleted(true);
		notice.setUpdatedAt(LocalDateTime.now());
		staffNoticeRepository.save(notice);
	}
}
