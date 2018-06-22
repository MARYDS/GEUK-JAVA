package com.fordeideas.geuk.session;

public class State {
	
	private String electionYear;
	private String searchTerm;
	private String[][] electionYears;
	private String[][] selectedRegions;
	private String[][] selectedParties;
	private String[][] sortOrder;
	private String yearsVisible;
	private String regionsVisible;
	private String partiesVisible;
	private String sortVisible;
	private String selectedConstituency;
	
	public State() {
		super();
	}

	public String getElectionYear() {
		return electionYear;
	}

	public void setElectionYear(String electionYear) {
		this.electionYear = electionYear;
	}

	public String getSearchTerm() {
		return searchTerm;
	}

	public void setSearchTerm(String searchTerm) {
		this.searchTerm = searchTerm;
	}

	public String[][] getElectionYears() {
		return electionYears;
	}

	public void setElectionYears(String[][] electionYears) {
		this.electionYears = electionYears;
	}

	public String[][] getSelectedRegions() {
		return selectedRegions;
	}

	public void setSelectedRegions(String[][] selectedRegions) {
		this.selectedRegions = selectedRegions;
	}

	public String[][] getSelectedParties() {
		return selectedParties;
	}

	public void setSelectedParties(String[][] selectedParties) {
		this.selectedParties = selectedParties;
	}

	public String[][] getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(String[][] sortOrder) {
		this.sortOrder = sortOrder;
	}

	public String getYearsVisible() {
		return yearsVisible;
	}

	public void setYearsVisible(String yearsVisible) {
		this.yearsVisible = yearsVisible;
	}

	public String getRegionsVisible() {
		return regionsVisible;
	}

	public void setRegionsVisible(String regionsVisible) {
		this.regionsVisible = regionsVisible;
	}

	public String getPartiesVisible() {
		return partiesVisible;
	}

	public void setPartiesVisible(String partiesVisible) {
		this.partiesVisible = partiesVisible;
	}

	public String getSortVisible() {
		return sortVisible;
	}

	public void setSortVisible(String sortVisible) {
		this.sortVisible = sortVisible;
	}

	public String getSelectedConstituency() {
		return selectedConstituency;
	}

	public void setSelectedConstituency(String selectedConstituency) {
		this.selectedConstituency = selectedConstituency;
	}	
	
}
