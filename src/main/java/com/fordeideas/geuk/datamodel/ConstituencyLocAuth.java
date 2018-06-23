package com.fordeideas.geuk.datamodel;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "constituency")
public class ConstituencyLocAuth {

	@Id
	@Column(name="onsid", nullable=false)
	private String onsid;
	@Id
	@Column(name="areaCode", nullable=false)
	private String areaCode;
	@Column(name="wardsCon")
	private int wardsCon;
	@Column(name="wardsLA")
	private int wardsLA;
	@ManyToOne
	@JoinColumn(name="areaCode", nullable=false, updatable=false)
	private EUReferendum euRefResult;	
	
	public ConstituencyLocAuth(String onsid, String areaCode, int wardsCon, int wardsLA) {
		this.onsid = onsid;
		this.areaCode = areaCode;
		this.wardsCon = wardsCon;
		this.wardsLA = wardsLA;
	}
	
	public String getOnsid() {
		return onsid;
	}
	public void setOnsid(String onsid) {
		this.onsid = onsid;
	}
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public int getWardsCon() {
		return wardsCon;
	}
	public void setWardsCon(int wardsCon) {
		this.wardsCon = wardsCon;
	}
	public int getWardsLA() {
		return wardsLA;
	}
	public void setWardsLA(int wardsLA) {
		this.wardsLA = wardsLA;
	}
	
	public EUReferendum getEuRefResult() {
		return euRefResult;
	}

	public void setEuRefResult(EUReferendum euRefResult) {
		this.euRefResult = euRefResult;
	}

	public ConstituencyLocAuth() {
		super();
	}

    @Override
    public String toString() {
        return "Constituency Id:"       + this.onsid    + ", " +
               "Area Code:"             + this.areaCode + ", " +
               "Wards in Constituency:" + this.wardsCon + ", " +
               "Wards in Local Auth:"   + this.wardsLA;  
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof ConstituencyLocAuth)) {
            return false;
        }
        ConstituencyLocAuth conLocAuth = (ConstituencyLocAuth) obj;
        return this.onsid.equals(conLocAuth.onsid)  &&
        	   this.areaCode.equals(conLocAuth.areaCode)  &&
               this.wardsCon == conLocAuth.wardsCon &&
               this.wardsLA == conLocAuth.wardsLA;
    }

    @Override
    public int hashCode() {
        return Objects.hash(onsid, areaCode, wardsCon, wardsLA);
    }
	
}
