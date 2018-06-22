package com.fordeideas.geuk.datamodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "party")
public class Party {

	@Id
	@Column(name="partyCode", nullable=false)
	private String partyCode;
	@Column(name="name", nullable=false)
	private String name;
	@Column(name="colour", nullable=false)
	private String colour;
	
	public Party() {}
	
	public Party(String partyCode, String name, String colour) {
		this.partyCode = partyCode;
		this.name = name;
		this.colour = colour;
	}
	
	public String getPartyCode() {
		return partyCode;
	}
	public void setPartyCode(String partyCode) {
		this.partyCode = partyCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}

}
