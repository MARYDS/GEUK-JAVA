package com.fordeideas.geuk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fordeideas.geuk.session.State;

@Controller
public class RegionSelectionController {
	
	@Autowired
    private State state;
	    
	@RequestMapping(value = "/SelectRegion/{selectedRegion}", method=RequestMethod.GET)
	public String selectRegion(@PathVariable("selectedRegion") String selectedRegion, ModelMap model) {

		String[][] regions = state.getSelectedRegions();
		
		switch (selectedRegion) {
		
		case "clearall":
			for (String region[] : regions) {
				region[1] = "";
			}
			break;
		case "selectall":
			for (String region[] : regions) {
				region[1] = "checked";
			}
			break;
		default:
			for (String region[] : regions) {
				if (region[0].equals(selectedRegion)) {
					if (region[1].equals("")) {
						region[1] = "checked";
					} else {
						region[1] = "";
					}
					break;
				}
			}
			break;
		}		
		
		state.setSelectedRegions(regions);
		state.setSelectedConstituency("");
		
	    return "redirect:/home";

	}
}

