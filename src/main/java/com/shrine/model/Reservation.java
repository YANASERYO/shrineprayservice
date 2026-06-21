package com.shrine.model;

public class Reservation {
	
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
	private String addressKana;

//	引数なしのコンストラクタ
	public Reservation() {
	}
	
//	引数ありのコンストラクタ
	public Reservation(String name, String kana,String birthday, String phone,String postalCode,String address, String email, String preferredDate, String prayerType, String note,String addressKana) {
        this.name = name;
        this.kana = kana;
        this.birthday = birthday;
        this.phone = phone;
        this.postalCode = postalCode;
        this.address = address;
        this.email = email;
        this.preferredDate = preferredDate;
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
	public String getBirthday() {return birthday;}
	public void setBirthday(String birthday) {this.birthday = birthday;}

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

//	希望日時
	public String getPreferredDate() {return preferredDate;}
	public void setPreferredDate(String preferredDate) {this.preferredDate = preferredDate;}

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
