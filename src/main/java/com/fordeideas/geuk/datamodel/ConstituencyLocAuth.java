package com.fordeideas.geuk.datamodel;

public class ConstituencyLocAuth {
	
	private String onsid;
	private String areaCode;
	private int wardsCon;
	private int wardsLA;
	
	public ConstituencyLocAuth() {}
	
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

}
