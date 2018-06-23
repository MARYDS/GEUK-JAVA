package com.fordeideas.geuk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fordeideas.geuk.session.State;

@Controller
public class YearSelectionController {
	
	@Autowired
    private State state;
	    
	@RequestMapping(value = "/SelectYear/{selectedYear}", method=RequestMethod.GET)
	public String selectYear(@PathVariable("selectedYear") String selectedYear, ModelMap model) {
		
		if (!state.getElectionYear().equals(selectedYear)) {
			state.setElectionYear(selectedYear);
			state.setSelectedConstituency("");
		}
		
		String[][] electionYears = state.getElectionYears();
		for (String year[] : electionYears) {
			if (year[0].equals(selectedYear)) {
				year[1] = "checked";
			} else {
				year[1] = "";
			}
		}
		
		state.setElectionYears(electionYears);
		
	    return "redirect:/home";

	}
}
