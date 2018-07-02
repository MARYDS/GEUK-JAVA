package com.fordeideas.geuk.datamodel;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "constituency")
public class Constituency {
	
	@Id
	@Column(name="onsid", nullable=false)
	private String onsid;
	@Column(name="constituencyName")
	private String constituencyName;
	@Column(name="regionName")
	private String regionName;
	@Column(name="country")
	private String country;
	@Column(name="countyName")
	private String countyName;
	
	public Constituency() {
		super();
	}
	
	public Constituency(String onsid, String constituencyName, String regionName, String country, String countyName) {
		this.onsid = onsid;
		this.constituencyName = constituencyName;
		this.regionName = regionName;
		this.country = country;
		this.countyName = countyName;
	}
	
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

    @Override
    public String toString() {
        return "Constituency Id: "   + this.onsid            + ", " +
               "Constituency Name: " + this.constituencyName + ", " +
               "Region Name: "       + this.regionName       + ", " +
               "Country: "           + this.country          + ", " +
               "County Name: "       + this.countyName;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof Constituency)) {
            return false;
        }
        Constituency constituency = (Constituency) obj;
        return this.onsid.equals(constituency.onsid)  &&
        	   this.constituencyName.equals(constituency.constituencyName)  &&
               this.regionName.equals(constituency.regionName) &&
               this.country.equals(constituency.country) && 
               this.countyName.equals(constituency.countyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(onsid, constituencyName, regionName, country, countyName);
    }
}
