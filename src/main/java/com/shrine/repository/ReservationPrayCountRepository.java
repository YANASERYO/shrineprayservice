package com.shrine.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shrine.entity.ReservationEntity;

public interface ReservationPrayCountRepository extends JpaRepository<ReservationEntity, Long> {

    long countByPrayedFalseAndPreferredDate(LocalDate preferredDate);

    long countByPrayedTrue();

    long countByPrayedFalseAndPreferredDateAfter(LocalDate preferredDate);
}