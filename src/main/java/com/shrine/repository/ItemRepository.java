package com.shrine.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shrine.entity.ItemEntity;

public interface ItemRepository extends JpaRepository<ItemEntity, Long> {

	
	List<ItemEntity> findByActiveTrueOrderBySortOrderAsc();
	
    List<ItemEntity> findByActiveTrueOrderBySortOrderAscIdAsc();

    List<ItemEntity> findByCategoryAndActiveTrueOrderBySortOrderAscIdAsc(String category);

    List<ItemEntity> findByUsageTypeAndActiveTrueOrderBySortOrderAscIdAsc(String usageType);
}