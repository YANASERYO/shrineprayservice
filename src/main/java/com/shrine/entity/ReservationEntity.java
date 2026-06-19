//getsetgetsetで記述したけど決まりはあるのか?

package com.shrine.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ReservationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String kana;
    private String birthday;
    private String phone;
    private String postalCode;
    private String address;
    private String email;
    private String preferredDate;
    private String prayerType;
    private String note;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getKana() { return kana; }
    public void setKana(String kana) { this.kana = kana; }

    public String getBirthday() { return birthday; }
    public void setBirthday(String birthday) { this.birthday = birthday; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    
    public String getPostalCode() { return postalCode; }
    public void setPostalCode(String postalCode) { this.postalCode = postalCode;}

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPreferredDate() { return preferredDate; }
    public void setPreferredDate(String preferredDate) { this.preferredDate = preferredDate; }

    public String getPrayerType() { return prayerType; }
    public void setPrayerType(String prayerType) { this.prayerType = prayerType; }

    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }
}