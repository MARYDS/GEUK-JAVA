package com.fordeideas.geuk.datamodel;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "wardconlocauth")
public class WardConLocAuth implements Serializable {
    private static final long serialVersionUID = 1L;
    
	@Id
	@Column(name="wardId", nullable=false)
	private String wardId;
	@Column(name="wardName")
	private String wardName;
	@Id
	@Column(name="onsid", nullable=false)
	private String onsid;
	@Id
	@Column(name="areaId", nullable=false)
	private String areaId;
	@Column(name="areaName")
	private String areaName;
	@ManyToOne
	@JoinColumn(name="onsid", nullable=false, updatable=false)
	private Constituency constituency;

	public WardConLocAuth() {}
	
	public WardConLocAuth(String wardId, String wardName, String onsid, String areaId, String areaName) {
		this.wardId = wardId;
		this.wardName = wardName;
		this.onsid = onsid;
		this.areaId = areaId;
		this.areaName = areaName;
	}
	
	public String getWardId() {
		return wardId;
	}
	public void setWardId(String wardId) {
		this.wardId = wardId;
	}
	public String getWardName() {
		return wardName;
	}
	public void setWardName(String wardName) {
		this.wardName = wardName;
	}
	public String getOnsid() {
		return onsid;
	}
	public void setOnsid(String onsid) {
		this.onsid = onsid;
	}
	public String getAreaId() {
		return areaId;
	}
	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public Constituency getConstituency() {
		return constituency;
	}
	public void setConstituency(Constituency constituency) {
		this.constituency = constituency;
	}
}
