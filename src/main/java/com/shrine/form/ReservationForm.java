package com.shrine.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ReservationForm {
	@NotBlank(message = "名前は必須です")
	private String name;
	
	@NotBlank(message = "かなは必須です")
	private String kana;
	
	@NotBlank(message = "生年月日は必須です")
	private String birthday;
	
	@NotBlank(message = "電話番号は必須です")
	private String phone;
	
	@NotBlank(message = "住所は必須です")
	private String address;
	
	@NotBlank(message = "メールアドレスは必須です")
	@Email(message = "メールアドレスの形式が正しくありません")
	private String email;
	
	@NotBlank(message = "希望日は必須です")
	private String preferredDate;
	
	@NotBlank(message = "祈祷内容は必須です")
	private String prayerType;
	
	@Size(max = 500, message = "備考は500文字以内で入力してください")
	private String note;
	
	public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getKana() { return kana; }
    public void setKana(String kana) { this.kana = kana; }

    public String getBirthday() { return birthday; }
    public void setBirthday(String birthday) { this.birthday = birthday; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

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
	
	

