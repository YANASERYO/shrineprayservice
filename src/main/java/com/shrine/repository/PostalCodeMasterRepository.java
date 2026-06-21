package com.shrine.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shrine.entity.PostalCodeMaster;

public interface PostalCodeMasterRepository extends JpaRepository<PostalCodeMaster, Long> {

	List<PostalCodeMaster>findByPostalCode(String postalCode);
}
