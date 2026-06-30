//getsetgetsetで記述したけど決まりはあるのか?

package com.shrine.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import com.shrine.util.WarekiUtil;

@Entity
public class ReservationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String kana;
    private LocalDate birthday;
    private String gender;
    private String phone;
    private String postalCode;
    private String address;
    private String email;
    private LocalDate preferredDate;
    private LocalTime preferredTime;
    private String prayerType;
    private String note;
    
    //祈願済かどうか真==祈願済、偽==祈願前
    private boolean prayed;
    //祈願日
    private LocalDateTime prayedAt;
    private String addressKana;
    //入力日
    private LocalDateTime createdAt;
    //prayedの更新日
    private LocalDateTime updatedAt;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getKana() { return kana; }
    public void setKana(String kana) { this.kana = kana; }

    public LocalDate getBirthday() { return birthday; }
    public void setBirthday(LocalDate birthday) { this.birthday = birthday; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    
    public String getPostalCode() { return postalCode; }
    public void setPostalCode(String postalCode) { this.postalCode = postalCode;}

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public LocalDate getPreferredDate() { return preferredDate; }
    public void setPreferredDate(LocalDate preferredDate) { this.preferredDate = preferredDate; }

    public LocalTime getPreferredTime() { return preferredTime; }
    public void setPreferredTime(LocalTime preferredTime) { this.preferredTime = preferredTime; }
    
    public String getPrayerType() { return prayerType; }
    public void setPrayerType(String prayerType) { this.prayerType = prayerType; }

    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }
    
    public boolean isPrayed() { return prayed; }
    public void setPrayed(boolean prayed) { this.prayed = prayed; }
    
    public LocalDateTime getPrayedAt() { return prayedAt; }
    public void setPrayedAt(LocalDateTime prayedAt) { this.prayedAt = prayedAt;}
    
    public String getAddressKana() {return addressKana;}
    public void setAddressKana(String addressKana) {this.addressKana = addressKana;}
    
    //WarekiUtilclassを作成
    public String getBirthdayWareki() {
        return WarekiUtil.toWareki(this.birthday);
        
    }
    
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
    
//    ReservationServiceより移動させた
    public void markAsPrayed() {
        LocalDateTime now = LocalDateTime.now();
        this.prayed = true;
        this.prayedAt = now;
        this.updatedAt = now;
    }
    		
}
