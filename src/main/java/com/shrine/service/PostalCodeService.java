package com.shrine.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shrine.entity.PostalCodeMaster;
import com.shrine.repository.PostalCodeMasterRepository;

@Service
public class PostalCodeService {

    private final PostalCodeMasterRepository postalCodeMasterRepository;

    public PostalCodeService(PostalCodeMasterRepository postalCodeMasterRepository) {
        this.postalCodeMasterRepository = postalCodeMasterRepository;
    }

    public List<PostalCodeMaster> findByPostalCode(String postalCode) {

        if (postalCode == null) {
            return List.of();
        }

        String normalizedPostalCode = postalCode.replace("-", "").trim();

        if (normalizedPostalCode.length() != 7) {
            return List.of();
        }

        return postalCodeMasterRepository.findByPostalCode(normalizedPostalCode);
    }
}
