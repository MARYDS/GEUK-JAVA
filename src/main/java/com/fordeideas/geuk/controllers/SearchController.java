package com.fordeideas.geuk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fordeideas.geuk.session.State;

@Controller
public class SearchController {
	
	@Autowired
    private State state;
       
	@RequestMapping(value = "/Search/{searchTerm}", method=RequestMethod.GET)
	public String search(@PathVariable("searchTerm") String searchTerm, ModelMap model) {

		state.setSearchTerm(searchTerm);
		state.setSelectedConstituency("");
	    return "redirect:/home";	
		
	}
	@RequestMapping(value = "/Search/", method=RequestMethod.GET)
	public String search(ModelMap model) {

		state.setSearchTerm("");
		state.setSelectedConstituency("");
		
	    return "redirect:/home";	
		
	}
}
