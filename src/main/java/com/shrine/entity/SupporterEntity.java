package com.shrine.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "supporter")
public class SupporterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "supporter_number", nullable = false, unique = true)
    private String supporterNumber;

    @Column(name = "supporter_type", nullable = false)
    private String supporterType;

    @Column(nullable = false)
    private String name;

    private String kana;

    @Column(name = "corporate_type")
    private String corporateType;

    @Column(name = "representative_name")
    private String representativeName;

    @Column(name = "contact_person")
    private String contactPerson;

    private LocalDate birthday;

    @Column(name = "postal_code")
    private String postalCode;

    private String address;

    @Column(name = "address_kana")
    private String addressKana;

    private String phone;

    private String email;

    @Column(name = "registered_date")
    private LocalDate registeredDate;

    @Column(columnDefinition = "TEXT")
    private String note;

    private boolean active;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public SupporterEntity() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getSupporterNumber() { return supporterNumber; }
    public void setSupporterNumber(String supporterNumber) { this.supporterNumber = supporterNumber; }

    public String getSupporterType() { return supporterType; }
    public void setSupporterType(String supporterType) { this.supporterType = supporterType; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getKana() { return kana; }
    public void setKana(String kana) { this.kana = kana; }

    public String getCorporateType() { return corporateType; }
    public void setCorporateType(String corporateType) { this.corporateType = corporateType; }

    public String getRepresentativeName() { return representativeName; }
    public void setRepresentativeName(String representativeName) { this.representativeName = representativeName; }

    public String getContactPerson() { return contactPerson; }
    public void setContactPerson(String contactPerson) { this.contactPerson = contactPerson; }

    public LocalDate getBirthday() { return birthday; }
    public void setBirthday(LocalDate birthday) { this.birthday = birthday; }

    public String getPostalCode() { return postalCode; }
    public void setPostalCode(String postalCode) { this.postalCode = postalCode; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getAddressKana() { return addressKana; }
    public void setAddressKana(String addressKana) { this.addressKana = addressKana; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public LocalDate getRegisteredDate() { return registeredDate; }
    public void setRegisteredDate(LocalDate registeredDate) { this.registeredDate = registeredDate; }

    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}

