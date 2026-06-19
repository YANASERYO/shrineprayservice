//getsetgetsetで記述したけど決まりはあるのか?

package com.shrine.entity;

import java.time.LocalDate;
import java.time.chrono.JapaneseDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

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
    //祈願済かどうか真==祈願済、偽==祈願前
    private boolean prayed;
    //祈願日
    private String prayedAt;

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
    
    public boolean isPrayed() { return prayed; }
    public void setPrayed(boolean prayed) { this.prayed = prayed; }
    
    public String getPrayedAt() { return prayedAt; }
    public void setPrayedAt(String prayedAt) { this.prayedAt = prayedAt;}
    
    //一覧表示でのみ西暦を和暦に変換する
    public String getBirthdayWareki() {
        if (birthday == null || birthday.isBlank()) {
            return "";
        }

        try {
            LocalDate date = LocalDate.parse(birthday);
            JapaneseDate japaneseDate = JapaneseDate.from(date);

            DateTimeFormatter formatter =
                    DateTimeFormatter.ofPattern("Gy年M月d日", Locale.JAPAN);

            return formatter.format(japaneseDate);
        } catch (Exception e) {
            return birthday;
        }
    }
    		
}
