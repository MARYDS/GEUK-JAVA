package com.fordeideas.geuk.datamodel;

public class Election {

	private String year;
	private int electorate;
	private int invalidVotes;
	private int validVotes;
	private int turnoutPercent;

	public Election() {}
	
	public Election(String year, int electorate, int invalidVotes, int validVotes, int turnoutPercent) {
		this.year = year;
		this.electorate = electorate;
		this.invalidVotes = invalidVotes;
		this.validVotes = validVotes;
		this.turnoutPercent = turnoutPercent;
	}
	
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public int getElectorate() {
		return electorate;
	}
	public void setElectorate(int electorate) {
		this.electorate = electorate;
	}
	public int getInvalidVotes() {
		return invalidVotes;
	}
	public void setInvalidVotes(int invalidVotes) {
		this.invalidVotes = invalidVotes;
	}
	public int getValidVotes() {
		return validVotes;
	}
	public void setValidVotes(int validVotes) {
		this.validVotes = validVotes;
	}
	public int getTurnoutPercent() {
		return turnoutPercent;
	}
	public void setTurnoutPercent(int turnoutPercent) {
		this.turnoutPercent = turnoutPercent;
	}	

}
