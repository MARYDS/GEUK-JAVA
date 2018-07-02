package com.fordeideas.geuk.datamodel;

import java.util.Objects;

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

    @Override
    public String toString() {
        return "Area Code: "       + this.areaCode       + ", " +
        	   "Area Name: "       + this.areaName       + ", " +
               "Region: "          + this.region         + ", " +
        	   "Electorate: "      + this.electorate     + ", " +
               "Leave Percent: "   + this.leavePercent   + ", " +
        	   "Leave Votes: "     + this.leaveVotes     + ", " +
               "Remain Percent: "  + this.remainPercent  + ", " +
        	   "Remain Votes: "    + this.remainVotes    + ", " +
        	   "Turnout Percent: " + this.turnoutPercent;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof EUReferendum)) {
            return false;
        }
        EUReferendum euReferendum = (EUReferendum) obj;
        return this.areaCode.equals(euReferendum.areaCode) &&
        	   this.areaName.equals(euReferendum.areaName)  &&
        	   this.region.equals(euReferendum.region)  &&
               this.electorate == euReferendum.electorate &&
               this.leavePercent == euReferendum.leavePercent &&
               this.leaveVotes == euReferendum.leaveVotes &&
               this.remainPercent == euReferendum.remainPercent &&
               this.remainVotes == euReferendum.remainVotes &&
               this.turnoutPercent == euReferendum.turnoutPercent;
    }

    @Override
    public int hashCode() {
        return Objects.hash(areaCode, areaName, region, electorate, leavePercent, leaveVotes, remainPercent, remainVotes, turnoutPercent);
    }

}
