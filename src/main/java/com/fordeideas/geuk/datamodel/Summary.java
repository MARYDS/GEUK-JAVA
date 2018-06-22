package com.fordeideas.geuk.datamodel;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name = "summary")
public class Summary implements Serializable {
    private static final long serialVersionUID = 1L;

	@Id
	@Column(name="year", nullable=false)	
	private String year;
	
	@Id
	@Column(name="onsid", nullable=false)	
	private String onsid;
	
	@Column(name="electorate", nullable=false)	
	private int electorate;
	
	@Column(name="invalidVotes", nullable=false)	
	private int invalidVotes;
	
	@Column(name="validVotes", nullable=false)	
	private int validVotes;
	
	@Column(name="majority", nullable=false)	
	private int majority;
	
	@Column(name="majorityPercent", nullable=false)
	private double majorityPercent;

	//@Column(name="partyCode", nullable=false)
	//private String partyCode;

	@Column(name="firstName", nullable=false)
	private String firstName;
	
	@Column(name="surname", nullable=false)
	private String surname;
	
	@Column(name="fullName", nullable=false)
    private String fullName;
	
	@Column(name="partyChanged", nullable=false)	
    private String partyChanged;
	
	//@Column(name="previousParty", nullable=false)
    //private String previousParty;
	
	//@Column(name="runnerUp", nullable=false)	
    //private String runnerUp;

	@Column(name="narrative", nullable=false)
	private String narrative;
	
	@Column(name="turnoutPercent", nullable=false)
	private double turnoutPercent;

	@ManyToOne
	@JoinColumn(name="onsid", nullable=false, updatable=false)
	private Constituency constituency;
	
	@ManyToOne
	@JoinColumn(name="partyCode", nullable=false, updatable=false)
	private Party party;

	@ManyToOne
	@JoinColumn(name="previousParty", nullable=false, updatable=false)
	private Party prevParty;
	
	@ManyToOne
	@JoinColumn(name="runnerUp", nullable=false, updatable=false)
	private Party runnerUpParty;	
	
	public Summary() {}
	
	public Summary(String year, String onsid, int electorate, int invalidVotes, int validVotes, int majority, double majorityPercent, String partyCode, String firstName, String surname, String fullName, String partyChanged, String previousParty, String runnerUp, String narrative) {
		this.year = year;
		this.onsid = onsid;
		this.electorate = electorate;
		this.invalidVotes = invalidVotes;
		this.validVotes = validVotes;
		this.majority = majority;
		this.majorityPercent = majorityPercent;
		//this.partyCode = partyCode;
		this.firstName = firstName;
		this.surname = surname;
		this.fullName = fullName;
		this.partyChanged = partyChanged;
		//this.previousParty = previousParty;
		//this.runnerUp = runnerUp;
		this.narrative = narrative;
	}
	
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	
	public String getOnsid() {
		return onsid;
	}
	public void setOnsid(String onsid) {
		this.onsid = onsid;
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
		
	public int getMajority() {
		return majority;
	}
	public void setMajority(int majority) {
		this.majority = majority;
	}
	
	public double getMajorityPercent() {
		return Math.round(majorityPercent * 10.0) / 10.0;
	}
	public void setMajorityPercent(double majorityPercent) {
		this.majorityPercent = majorityPercent;
	}
	
	//public String getPartyCode() {
	//	return partyCode;
	//}
	//public void setPartyCode(String partyCode) {
	//	this.partyCode = partyCode;
	//}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
		
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public String getPartyChanged() {
		return partyChanged;
	}
	public void setPartyChanged(String partyChanged) {
		this.partyChanged = partyChanged;
	}
		
	//public String getPreviousParty() {
	//	return previousParty;
	//}
	//public void setPreviousParty(String previousParty) {
	//	this.previousParty = previousParty;
	//}
	
	//public String getRunnerUp() {
	//	return runnerUp;
	//}
	//public void setRunnerUp(String runnerUp) {
	//	this.runnerUp = runnerUp;
	//}	
	
	public String getNarrative() {
		return narrative;
	}
	public void setNarrative(String narrative) {
		this.narrative = narrative;
	}

	public double getTurnoutPercent() {
		return turnoutPercent;
	}

	public void setTurnoutPercent(double turnoutPercent) {
		this.turnoutPercent = turnoutPercent;
	}


	public Constituency getConstituency() {
		return constituency;
	}

	public void setConstituency(Constituency constituency) {
		this.constituency = constituency;
	}

	public Party getParty() {
		return party;
	}

	public void setParty(Party party) {
		this.party = party;
	}

	public Party getPrevParty() {
		return prevParty;
	}

	public void setPrevParty(Party prevParty) {
		this.prevParty = prevParty;
	}

	public Party getRunnerUpParty() {
		return runnerUpParty;
	}

	public void setRunnerUpParty(Party runnerUpParty) {
		this.runnerUpParty = runnerUpParty;
	}

}