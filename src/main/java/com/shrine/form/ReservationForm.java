package com.shrine.form;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class ReservationForm {
	@NotBlank(message = "名前は必須です")
	private String name;
	
	@NotBlank(message = "かなは必須です")
	private String kana;
	
	@NotNull(message = "生年月日は必須です")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate birthday;
	
	@NotBlank(message = "性別は必須です")
	private String gender;
	
	@NotBlank(message = "電話番号は必須です")
	private String phone;
	
	@NotBlank(message = "郵便番号は必須です")
	private String postalCode;
	
	@NotBlank(message = "住所は必須です")
	private String address;
	
	@NotBlank(message = "メールアドレスは必須です")
	@Email(message = "メールアドレスの形式が正しくありません")
	private String email;
	
//	空の場合は当日受付として処理に変更
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate preferredDate;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	private LocalTime preferredTime;
	
	@NotBlank(message = "祈祷内容は必須です")
	private String prayerType;
	
	@Size(max = 200, message = "備考は200文字以内で入力してください")
	private String note;
	
//	祝詞用住所のフリガナ
	private String addressKana;
	
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
    public void setPostalCode(String postalCode) { this.postalCode = postalCode; }

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
    
    public String getAddressKana() {return addressKana;}
    public void setAddressKana(String addressKana) {this.addressKana = addressKana;}
}
	
	

