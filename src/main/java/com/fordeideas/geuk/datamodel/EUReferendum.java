package com.fordeideas.geuk.datamodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "eureferendum")
public class EUReferendum {
	
	@Id
	@Column(name="areaCode", nullable=false)
	private String areaCode;
	@Column(name="areaName")
	private String areaName;
	@Column(name="region")
	private String region;
	@Column(name="electorate")
	private int electorate;
	@Column(name="leavePercent")
	private double leavePercent;
	@Column(name="leaveVotes")
	private int leaveVotes;
	@Column(name="remainPercent")
	private double remainPercent;
	@Column(name="remainVotes")
	private int remainVotes;
	@Column(name="turnoutPercent")
	private double turnoutPercent;

	public EUReferendum() {}
	
	public EUReferendum(String areaCode, String areaName, String region, int electorate, double leavePercent, int leaveVotes, double remainPercent, int remainVotes, double turnoutPercent){
		this.areaCode = areaCode;
		this.areaName = areaName;
		this.region = region;
		this.electorate = electorate;
		this.leavePercent = leavePercent;
		this.leaveVotes = leaveVotes;
		this.remainPercent = remainPercent;
		this.remainVotes = remainVotes;
		this.turnoutPercent = turnoutPercent;		
	}
	
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public int getElectorate() {
		return electorate;
	}
	public void setElectorate(int electorate) {
		this.electorate = electorate;
	}
	public double getLeavePercent() {
		return leavePercent;
	}
	public void setLeavePercent(double leavePercent) {
		this.leavePercent = leavePercent;
	}
	public int getLeaveVotes() {
		return leaveVotes;
	}
	public void setLeaveVotes(int leaveVotes) {
		this.leaveVotes = leaveVotes;
	}
	public double getRemainPercent() {
		return remainPercent;
	}
	public void setRemainPercent(double remainPercent) {
		this.remainPercent = remainPercent;
	}
	public int getRemainVotes() {
		return remainVotes;
	}
	public void setRemainVotes(int remainVotes) {
		this.remainVotes = remainVotes;
	}
	public double getTurnoutPercent() {
		return turnoutPercent;
	}
	public void setTurnoutPercent(double turnoutPercent) {
		this.turnoutPercent = turnoutPercent;
	}
	
}
