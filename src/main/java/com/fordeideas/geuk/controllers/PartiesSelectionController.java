package com.fordeideas.geuk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fordeideas.geuk.session.State;

@Controller
public class PartiesSelectionController {
	private static final long serialVersionUID = 1L;
	
	@Autowired
    private State state;
	    
	@RequestMapping(value = "/SelectParty/{selectedParty}", method=RequestMethod.GET)
	public String selectParty(@PathVariable("selectedParty") String selectedParty, ModelMap model) {

		String[][] parties = state.getSelectedParties();
		
		switch (selectedParty) {
		
		case "clearall":
			for (String party[] : parties) {
				party[1] = "";
			}
			break;
		case "selectall":
			for (String party[] : parties) {
				party[1] = "checked";
			}
			break;
		default:
			for (String party[] : parties) {
				if (party[0].equals(selectedParty)) {
					if (party[1].equals("")) {
						party[1] = "checked";
					} else {
						party[1] = "";
					}
					break;
				}
			}
			break;
		}
	
		state.setSelectedParties(parties);
		state.setSelectedConstituency("");
		
	    return "redirect:/home";

	}
}
