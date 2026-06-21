package com.shrine.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "postal_code_master")
public class PostalCodeMaster {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String postalCode;
	private String prefecture;
	private String city;
	private String town;
	private String prefectureKana;
	private String cityKana;
	private String townKana;
	
	public Long getId() {return id;}
	public String getPostalCode() {return postalCode;}
    public String getPrefecture() {return prefecture;}
    public String getCity() {return city;}
    public String getTown() {return town;}
    public String getPrefectureKana() {return prefectureKana;}
    public String getCityKana() {return cityKana;}
    public String getTownKana() {return townKana;}
}