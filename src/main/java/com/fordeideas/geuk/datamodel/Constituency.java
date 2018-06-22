package com.fordeideas.geuk.datamodel;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "constituency")
public class Constituency {
	
	private String onsid;
	private String constituencyName;
	private String regionName;
	private String country;
	private String countyName;
	
	public Constituency() {}
	
	public Constituency(String onsid, String constituencyName, String regionName, String country, String countyName) {
		this.onsid = onsid;
		this.constituencyName = constituencyName;
		this.regionName = regionName;
		this.country = country;
		this.countyName = countyName;
	}
	
	@Id
	public String getOnsid() {
		return onsid;
	}
	public void setOnsid(String onsid) {
		this.onsid = onsid;
	}
	public String getConstituencyName() {
		return constituencyName;
	}
	public void setConstituencyName(String constituencyName) {
		this.constituencyName = constituencyName;
	}
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCountyName() {
		return countyName;
	}
	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}	

}
