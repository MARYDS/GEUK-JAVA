package com.fordeideas.geuk.datamodel;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "election")
public class Election {

	@Id
	@Column(name="year", nullable=false)
	private String year;
	@Column(name="electorate")
	private int electorate;
	@Column(name="invalidVotes")
	private int invalidVotes;
	@Column(name="validVotes")
	private int validVotes;
	@Column(name="turnoutPercent")
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

    @Override
    public String toString() {
        return "Election Year: "   + this.year         + ", " +
        	   "Electorate: "      + this.electorate   + ", " +
               "Invalid Votes: "   + this.invalidVotes + ", " +
        	   "Valid Votes: "     + this.validVotes   + ", " +
               "Turnout Percent: " + this.turnoutPercent;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof Election)) {
            return false;
        }
        Election election = (Election) obj;
        return this.year.equals(election.year) &&
               this.electorate == election.electorate &&
               this.invalidVotes == election.invalidVotes &&
               this.validVotes == election.validVotes &&
               this.turnoutPercent == election.turnoutPercent;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, electorate, invalidVotes, validVotes, turnoutPercent);
    }
	

}
