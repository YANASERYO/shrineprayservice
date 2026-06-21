package com.shrine.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shrine.entity.StaffAccountEntity;

public interface StaffAccountRepository extends JpaRepository<StaffAccountEntity, Long> {
//	検索メソッド
	Optional<StaffAccountEntity> findByUsername(String username);
	
}