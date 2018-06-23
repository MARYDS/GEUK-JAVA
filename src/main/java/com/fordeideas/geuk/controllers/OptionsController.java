package com.fordeideas.geuk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fordeideas.geuk.session.State;

@Controller
public class OptionsController {
	
	@Autowired
    private State state;
       
	@RequestMapping(value = "/SelectOptions/{option}", method=RequestMethod.GET)
	public String selectOptions(@PathVariable("option") String option, ModelMap model) {

		// Toggle the visibility option for the pressed button's section
		switch (option) {
		
		case "years":
			if (state.getYearsVisible().equals("YES")) {
				state.setYearsVisible("NO");
			} else {
				state.setYearsVisible("YES");
			}
			break;
			
		case "regions":
			if (state.getRegionsVisible().equals("YES")) {
				state.setRegionsVisible("NO");
			} else {
				state.setRegionsVisible("YES");
			}
			break;	

		case "parties":
			if (state.getPartiesVisible().equals("YES")) {
				state.setPartiesVisible("NO");
			} else {
				state.setPartiesVisible("YES");
			}
			break;	
					
		case "sort":
			if (state.getSortVisible().equals("YES")) {
				state.setSortVisible("NO");
			} else {
				state.setSortVisible("YES");
			}
			break;
			
		}

	    return "redirect:/home";	
		
	}

}
