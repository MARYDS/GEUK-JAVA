package com.fordeideas.geuk.datamodel;

public class PartySummary {

	private String year;
	private String partyCode;
	private String regionName;
	private int candidates;
	private int seats;
	private int votes;
	private double votesPercent;
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
	
}
