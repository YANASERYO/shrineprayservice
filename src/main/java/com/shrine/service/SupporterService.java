package com.shrine.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.shrine.entity.SupporterEntity;
import com.shrine.repository.SupporterRepository;

@Service
public class SupporterService {

    private final SupporterRepository supporterRepository;

    public SupporterService(SupporterRepository supporterRepository) {
        this.supporterRepository = supporterRepository;
    }

    public List<SupporterEntity> findAllActiveSupporters() {
        return supporterRepository.findByActiveTrueOrderBySupporterNumberAsc();
    }

    public List<SupporterEntity> findBySupporterType(String supporterType) {
        return supporterRepository
                .findBySupporterTypeAndActiveTrueOrderBySupporterNumberAsc(supporterType);
    }

    public SupporterEntity findById(Long id) {
        return supporterRepository.findById(id).orElse(null);
    }

    public SupporterEntity create(SupporterEntity supporter) {
        LocalDateTime now = LocalDateTime.now();

        supporter.setActive(true);
        supporter.setCreatedAt(now);
        supporter.setUpdatedAt(now);

        if (supporter.getRegisteredDate() == null) {
            supporter.setRegisteredDate(LocalDate.now());
        }

        return supporterRepository.save(supporter);
    }

    public SupporterEntity update(Long id, SupporterEntity updatedSupporter) {
        SupporterEntity existingSupporter =
                supporterRepository.findById(id).orElse(null);

        if (existingSupporter == null) {
            return null;
        }

        existingSupporter.setSupporterNumber(updatedSupporter.getSupporterNumber());
        existingSupporter.setSupporterType(updatedSupporter.getSupporterType());
        existingSupporter.setName(updatedSupporter.getName());
        existingSupporter.setKana(updatedSupporter.getKana());
        existingSupporter.setCorporateType(updatedSupporter.getCorporateType());
        existingSupporter.setRepresentativeName(updatedSupporter.getRepresentativeName());
        existingSupporter.setContactPerson(updatedSupporter.getContactPerson());
        existingSupporter.setBirthday(updatedSupporter.getBirthday());
        existingSupporter.setPostalCode(updatedSupporter.getPostalCode());
        existingSupporter.setAddress(updatedSupporter.getAddress());
        existingSupporter.setAddressKana(updatedSupporter.getAddressKana());
        existingSupporter.setPhone(updatedSupporter.getPhone());
        existingSupporter.setEmail(updatedSupporter.getEmail());
        existingSupporter.setRegisteredDate(updatedSupporter.getRegisteredDate());
        existingSupporter.setNote(updatedSupporter.getNote());
        existingSupporter.setUpdatedAt(LocalDateTime.now());

        return supporterRepository.save(existingSupporter);
    }

    public void deactivate(Long id) {
        SupporterEntity supporter = supporterRepository.findById(id).orElse(null);

        if (supporter == null) {
            return;
        }

        supporter.setActive(false);
        supporter.setUpdatedAt(LocalDateTime.now());

        supporterRepository.save(supporter);
    }
}