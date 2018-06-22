package com.fordeideas.geuk.datamodel;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detail")
public class Detail implements Serializable {
    private static final long serialVersionUID = 1L;

	@Id
	@Column(name="year", nullable=false)
	private String year;
	@Id
	@Column(name="onsid", nullable=false)
	private String onsid;
	@Column(name="firstName")
	private String firstName;
	@Column(name="surname")
	private String surname;
	@Id
	@Column(name="fullName", nullable=false)
	private String fullName;
	@Column(name="gender")
	private String gender;
	@Id
	@Column(name="partyCode", nullable=false)
	private String partyCode;
	@Column(name="votes")	
	private int votes;
	@Column(name="share")
	private double share;
	@Column(name="change")
	private double change;	
	@Column(name="wiki")
	private String wiki;		
	@Column(name="photo")
	private String photo;	
	@ManyToOne
	@JoinColumn(name="onsid", nullable=false, updatable=false)
	private Constituency constituency;

	@ManyToOne
	@JoinColumn(name="partyCode", nullable=false, updatable=false)
	private Party party;

	public Detail() {}
	
	public Detail(String year, String onsid, String firstName, String surname, String fullName, String gender, String partyCode, int votes, double share, double change) {
		this.year = year;
		this.onsid = onsid;
		this.firstName = firstName;
		this.surname = surname;
		this.fullName = fullName;
		this.gender = gender;
		this.partyCode = partyCode;
		this.votes = votes;
		this.share = share;
		this.change = change;
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
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPartyCode() {
		return partyCode;
	}
	public void setPartyCode(String partyCode) {
		this.partyCode = partyCode;
	}
	public int getVotes() {
		return votes;
	}
	public void setVotes(int votes) {
		this.votes = votes;
	}
	public double getShare() {
		return Math.round(share * 10.0) / 10.0;
	}
	public void setShare(double share) {
		this.share = share;
	}
	public double getChange() {
		return Math.round(change * 10.0) / 10.0;
	}
	public void setChange(double change) {
		this.change = change;
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
	
	public String getWiki() {
		return wiki;
	}

	public void setWiki(String wiki) {
		this.wiki = wiki;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
}
