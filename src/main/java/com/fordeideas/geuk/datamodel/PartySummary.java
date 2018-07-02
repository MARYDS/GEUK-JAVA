package com.fordeideas.geuk.datamodel;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "partySummary")
public class PartySummary {

	@Id
	@Column(name="year", nullable=false)
	private String year;
	@Id
	@Column(name="partyCode", nullable=false)
	private String partyCode;
	@Column(name="regionName")
	private String regionName;
	@Column(name="candidates")
	private int candidates;
	@Column(name="seats")
	private int seats;
	@Column(name="votes")
	private int votes;
	@Column(name="votesPercent")
	private double votesPercent;
	@Column(name="changePercent")
	private double changePercent;
	
	public PartySummary() {}
	
	public PartySummary(String year, String partyCode, String regionName, int candidates, int seats, int votes, double votesPercent, double changePercent) {
		this.year = year;
		this.partyCode = partyCode;
		this.regionName = regionName;
		this.candidates = candidates;
		this.seats = seats;
		this.votes = votes;
		this.votesPercent = votesPercent;
		this.changePercent = changePercent;
	}
	
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getPartyCode() {
		return partyCode;
	}
	public void setPartyCode(String partyCode) {
		this.partyCode = partyCode;
	}
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	public int getCandidates() {
		return candidates;
	}
	public void setCandidates(int candidates) {
		this.candidates = candidates;
	}
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	public int getVotes() {
		return votes;
	}
	public void setVotes(int votes) {
		this.votes = votes;
	}
	public double getVotesPercent() {
		return votesPercent;
	}
	public void setVotesPercent(double votesPercent) {
		this.votesPercent = votesPercent;
	}
	public double getChangePercent() {
		return changePercent;
	}
	public void setChangePercent(double changePercent) {
		this.changePercent = changePercent;
	}

    @Override
    public String toString() {
        return "Year: "           + this.year         + ", " +
        	   "Party Code: "     + this.partyCode    + ", " +
               "Region Name: "    + this.regionName   + ", " +
        	   "Candidates: "     + this.candidates   + ", " +
               "Seats: "          + this.seats        + ", " +
        	   "Votes: "          + this.votes        + ", " +
               "Votes Percent: "  + this.votesPercent + ", " +
        	   "Change Percent: " + this.changePercent;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof PartySummary)) {
            return false;
        }
        PartySummary partySummary = (PartySummary) obj;
        return this.year.equals(partySummary.year) &&
        	   this.partyCode.equals(partySummary.partyCode)  &&
        	   this.regionName.equals(partySummary.regionName)  &&
               this.candidates == partySummary.candidates &&
               this.seats == partySummary.seats &&
               this.votes == partySummary.votes &&
               this.votesPercent == partySummary.votesPercent &&
               this.changePercent == partySummary.changePercent;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, partyCode, regionName, candidates, seats, votes, votesPercent, changePercent);
    }
	
}
