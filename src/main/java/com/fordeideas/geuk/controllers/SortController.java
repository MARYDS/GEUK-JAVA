package com.fordeideas.geuk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fordeideas.geuk.session.State;

@Controller
public class SortController {
	
	@Autowired
    private State state;
       
	@RequestMapping(value = "/SortClick/{id}", method=RequestMethod.GET)
	public String changeSortOrder(@PathVariable("id") String id, ModelMap model) {

		String[][] sortOrderItems = state.getSortOrder();
		
		for (String sortOrderItem[] : sortOrderItems) {
			if (sortOrderItem[0].equals(id)) {
				if (sortOrderItem[1].equals("ASC")) {
					sortOrderItem[1] = "DESC";
				} else {
					sortOrderItem[1] = "ASC";
				}
				break;
			}
		}

		state.setSortOrder(sortOrderItems);
				
	    return "redirect:/home";	

	}

	@RequestMapping(value = "/SortDrag/{dragged}/{putBefore}", method=RequestMethod.GET)
	public String changeSortOrder(@PathVariable("dragged") String dragged, @PathVariable("putBefore") String putBefore, ModelMap model) {
		
		String[][] sortOrderItems = state.getSortOrder();
		
		String[] drag = new String[2];
		int dragIdx = 0;
		int dropIdx = 0;
		
		// Locate dragged and drop buttons in sort order
		for (int i=0; i<sortOrderItems.length; i++) {
			if (sortOrderItems[i][0].equals(dragged)) {
				drag = sortOrderItems[i];
				dragIdx = i;
			}
			if (sortOrderItems[i][0].equals(putBefore)) {
				dropIdx = i;
			}			
		}
	
		String[][] newSortOrderItems = new String[sortOrderItems.length][];
		
		// Remove the dragged item	
		System.arraycopy(sortOrderItems, 0, newSortOrderItems, 0, dragIdx);
		System.arraycopy(sortOrderItems, dragIdx+1, newSortOrderItems, dragIdx, sortOrderItems.length - 1 - dragIdx);	
		if (dropIdx > dragIdx) {
			dropIdx -=1;
		}
		
		// Put dragged item back in position before drop item
		System.arraycopy(newSortOrderItems, 0, sortOrderItems, 0, dropIdx);
		sortOrderItems[dropIdx] = drag;
		System.arraycopy(newSortOrderItems, dropIdx, sortOrderItems, dropIdx+1, sortOrderItems.length-1-dropIdx);		
					
		state.setSortOrder(sortOrderItems);
		
	    return "redirect:/home";	
	}
	
}
