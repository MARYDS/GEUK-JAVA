package com.fordeideas.geuk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fordeideas.geuk.session.State;


@Controller
public class ConstituencyController {
	
	@Autowired
    private State state;
       
	@RequestMapping(value = "/SelectConstituency/{constituency}", method=RequestMethod.GET)
	public String selectConstituency(@PathVariable("constituency") String constituency, ModelMap model) {

		state.setSelectedConstituency(constituency);

	    return "redirect:/home";	
		
	}

}
