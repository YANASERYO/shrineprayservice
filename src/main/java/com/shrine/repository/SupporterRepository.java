package com.shrine.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shrine.entity.SupporterEntity;

public interface SupporterRepository extends JpaRepository<SupporterEntity, Long> {

    List<SupporterEntity> findByActiveTrueOrderBySupporterNumberAsc();

    List<SupporterEntity> findBySupporterTypeAndActiveTrueOrderBySupporterNumberAsc(String supporterType);

    Optional<SupporterEntity> findBySupporterNumber(String supporterNumber);

    boolean existsBySupporterNumber(String supporterNumber);
}