package com.shrine.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Reservation {
	
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
	private String addressKana;

//	引数なしのコンストラクタ
	public Reservation() {
	}
	
//	引数ありのコンストラクタ
	public Reservation(String name, String kana,LocalDate birthday,String gender, String phone,String postalCode,String address, String email, LocalDate preferredDate, LocalTime preferredTime,String prayerType, String note,String addressKana) {
        this.name = name;
        this.kana = kana;
        this.birthday = birthday;
        this.gender = gender;
        this.phone = phone;
        this.postalCode = postalCode;
        this.address = address;
        this.email = email;
        this.preferredDate = preferredDate;
        this.preferredTime = preferredTime;
        this.prayerType = prayerType;
        this.note = note;
        this.addressKana =addressKana;
    }
	
//	氏名
	public String getName() {return name;}
    public void setName(String name) {this.name = name;}

//    かな
	public String getKana() {return kana;}
	public void setKana(String kana) {this.kana = kana;}
	
//	生年月日
	public LocalDate getBirthday() {return birthday;}
	public void setBirthday(LocalDate birthday) {this.birthday = birthday;}
	
//	性別
	public String getGender() {return gender;}
	public void setGender(String gender) {this.gender = gender;}

//	電話番号
	public String getPhone() {return phone;}
	public void setPhone(String phone) {this.phone = phone;}
	
//	郵便番号
	public String getPostalCode() {return postalCode;}
	public void setPostalCode(String postalCode) {this.postalCode = postalCode;}

//	住所
	public String getAddress() {return address;}
	public void setAddress(String address) {this.address = address;}
	
//	メールアドレス
	public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email;}

//	希望日
	public LocalDate getPreferredDate() {return preferredDate;}
	public void setPreferredDate(LocalDate preferredDate) {this.preferredDate = preferredDate;}

//	希望時間
	public LocalTime getPreferredTime() {return preferredTime;}
	public void setPreferredTime(LocalTime preferredTime) {this.preferredTime = preferredTime;}
	
//	祈願内容
	public String getPrayerType() {return prayerType;}
	public void setPrayerType(String prayerType) {this.prayerType = prayerType;}

//	備考
	public String getNote() {return note;}
	public void setNote(String note) {this.note = note;}
	
//　住所カナ
	public String getAddressKana() {return addressKana;}
	public void setAddressKana(String addressKana) {this.addressKana =addressKana;}
}
