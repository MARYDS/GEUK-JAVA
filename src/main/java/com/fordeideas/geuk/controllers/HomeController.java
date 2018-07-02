package com.fordeideas.geuk.controllers;

import com.fordeideas.geuk.dao.*;
import com.fordeideas.geuk.datamodel.*;
import com.fordeideas.geuk.session.State;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.ModelMap;

@Controller
public class HomeController {

	@Autowired
	SummaryUtils summaryUtils;

	@Autowired
	DetailUtils detailUtils;
	
	@Autowired
	EUReferendumUtils euReferendumUtils;
	
	@Autowired
    private State state;
	
	private final String DEFAULT_ELECTION_YEAR = "2017";

	@RequestMapping(value = {"/","/home"}, method = RequestMethod.GET)
	public ModelAndView homePage(ModelMap model) {

		// Default election year if not set
		if (state.getElectionYear() == null) {
			state.setElectionYear(DEFAULT_ELECTION_YEAR);
		}
		model.addAttribute("electionYear", state.getElectionYear());
		
		// Default search term to blanks if not set
		if (state.getSearchTerm() == null) {
			state.setSearchTerm("");
		}
		model.addAttribute("searchTerm", state.getSearchTerm());
		
		// Retrieve a list of election years with results, default if not set
		if (state.getElectionYears() == null) {
			ArrayList<String> years = summaryUtils.getElectionYearsList();
			String[][] electionYears = new String[years.size()][2];
			for (int i=0; i < years.size(); i++) {
				if (years.get(i).equals(state.getElectionYear())) {
					electionYears[i] = new String[]{years.get(i), "checked"};					
				} else {
					electionYears[i] = new String[]{years.get(i), ""};
				}
			}
			state.setElectionYears(electionYears);
		}
		model.addAttribute("electionYears", state.getElectionYears());

		// Retrieve selected regions, default all selected if not set
		if (state.getSelectedRegions() == null) {
			ArrayList<String> regions = summaryUtils.getRegionList();
			String[][] selectedRegions = new String[regions.size()][2];
			for (int i=0; i < regions.size(); i++) {
				selectedRegions[i] = new String[]{regions.get(i), "checked"};
			}
			state.setSelectedRegions(selectedRegions);
		}
		model.addAttribute("selectedRegions", state.getSelectedRegions());

		// Retrieve selected parties, default all selected if not set
		if (state.getSelectedParties() == null) {
			ArrayList<String> parties = summaryUtils.getPartyList();
			String[][] selectedParties = new String[parties.size()][2];
			for (int i=0; i < parties.size(); i++) {
				selectedParties[i] = new String[]{parties.get(i), "checked"};
			}
			state.setSelectedParties(selectedParties);
		}
		model.addAttribute("selectedParties", state.getSelectedParties());

		// Retrieve sort order, default if not set
		if (state.getSortOrder() == null) {
			String[][] sortOrder = new String[][]{{"Region", "ASC"},{"Constituency", "ASC"},{"Party","ASC"},{"MP","ASC"},{"Margin","ASC"},{"Prev_Party","ASC"},{"2nd_Party","ASC"}};
			state.setSortOrder(sortOrder);
		}
		model.addAttribute("sortOrder", state.getSortOrder());
		
		// Default visibility settings if not set - initially hidden
		if (state.getYearsVisible() == null) {
			state.setYearsVisible("NO");
		}
		model.addAttribute("yearsVisible", state.getYearsVisible());		
		
		if (state.getRegionsVisible() == null) {
			state.setRegionsVisible("NO");			
		}
		model.addAttribute("regionsVisible", state.getRegionsVisible());
		
		if (state.getPartiesVisible() == null) {
			state.setPartiesVisible("NO");	
		}
		model.addAttribute("partiesVisible", state.getPartiesVisible());
		
		if (state.getSortVisible() == null) {
			state.setSortVisible("NO");
		}
		model.addAttribute("sortVisible", state.getSortVisible());

		// Get the summary list data filtered by year, region, party and sorted in the required order 
		List<Summary> summaryList = 
				summaryUtils.getSummaryList(state.getElectionYear(), state.getSearchTerm(), state.getSelectedParties(), state.getSelectedRegions(), state.getSortOrder());
		if (model.get("summaryList") != null) {
			if (summaryList.size() > 0) {
				model.replace("summaryList", summaryList);
			} else {
				model.remove("summaryList");
			}
		} else {
			model.addAttribute("summaryList", summaryList);
		}

		// Default the first constituency on the list as selected if no constituency selected
		if (state.getSelectedConstituency() == null || state.getSelectedConstituency().equals("")) {
			if (summaryList.size() > 0) {
				state.setSelectedConstituency(summaryList.get(0).getConstituency().getConstituencyName());
			} else {
				state.setSelectedConstituency("");				
			}
		} 
		model.addAttribute("selectedConstituency", state.getSelectedConstituency());
		
		// Get the summary and detail data for the selected constituency
		Summary constitSummary = summaryUtils.getConstituencyResults(state.getElectionYear(), state.getSelectedConstituency());
		
		if ((String) model.get("selConSummary") != null) {
			if (summaryList.size() > 0) {
				model.replace("selConSummary", constitSummary);
			} else {
				model.remove("selConSummary");
			}
		} else {
			if (summaryList.size() > 0) {
				model.addAttribute("selConSummary", constitSummary);
			}		
		}
		List<Detail> detailList = 
				detailUtils.getDetailList(state.getElectionYear(), state.getSelectedConstituency());
		if (model.get("detailList") != null) {
			if (detailList.size() > 0) {
				model.replace("detailList", detailList);
			} else {
				model.remove("detailList");
			}
		} else {
			model.addAttribute("detailList", detailList);
		}
		
		// Data for current election pie chart
		char quote = '"';
		if (detailList.size() > 0) {
			StringBuilder currentDataPoints = new StringBuilder();
			currentDataPoints.append("[");
			for (Detail detail : detailList) {
				if (!currentDataPoints.toString().equals("[")) {
					currentDataPoints.append(",");
				}
				currentDataPoints.append("[" + quote + detail.getParty().getColour() + quote + "," +  detail.getVotes() + "]");
			}
			currentDataPoints.append("]");
			model.addAttribute("currentPieDetail", currentDataPoints.toString());
			model.addAttribute("currentPieTotalVotes", constitSummary.getValidVotes());		
		}
			
		// Data for previous election pie chart
		List<Detail> detailListPreviousElection = 
				detailUtils.getDetailListPreviousElection(state.getElectionYear(), state.getSelectedConstituency());
		if (detailListPreviousElection.size() > 0) {
			StringBuilder previousDataPoints = new StringBuilder();
			previousDataPoints.append("[");
			for (Detail detail : detailListPreviousElection) {
				if (!previousDataPoints.toString().equals("[")) {
					previousDataPoints.append(",");
				}
				previousDataPoints.append("[" + quote + detail.getParty().getColour() + quote + "," + detail.getVotes() + "]");
			}
			previousDataPoints.append("]");
			Summary constitSummaryPrevious = summaryUtils.getConstituencyResults(detailListPreviousElection.get(0).getYear(), state.getSelectedConstituency());
			model.addAttribute("previousPieDetail", previousDataPoints.toString());
			model.addAttribute("previousPieTotalVotes", constitSummaryPrevious.getValidVotes());
			model.addAttribute("previousElectionYear", detailListPreviousElection.get(0).getYear());
		}
	
		// Get the EU Referendum results for the selected constituency
		//List<EUReferendum> euRefList = euReferendumUtils.getEURefList( state.getSelectedConstituency());
		List<ConstituencyLocAuth> euRefList = euReferendumUtils.getEURefWithWardsList( state.getSelectedConstituency());
		if (model.get("euRefList") != null) {
			if (euRefList.size() > 0) {
				model.replace("euRefList", euRefList);
			} else {
				model.remove("euRefList");
			}
		} else {
			model.addAttribute("euRefList", euRefList);
		}
		
		return new ModelAndView("home", model);

	}
}
