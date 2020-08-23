package com.phonebook.web.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.phonebook.services.ContactsService;
import com.phonebook.services.models.ContactModel;

@Controller
public class PhoneBookController {
	private ContactsService contactService = null;
	
	@Autowired
	public PhoneBookController(ContactsService contactService) {
		this.contactService = contactService;
	}
	
	
	@GetMapping("/")
    public ModelAndView searchContact(@RequestParam(required = false) String keyword) {
    	Iterable<ContactModel> contacts = this.contactService.getItems(1, 100, keyword);
    	ModelAndView model = new ModelAndView("index");
    	model.addObject("contacts", contacts);
    	model.addObject("newContact", new ContactModel());

    	return model;
	}
	
	@PostMapping("/newContact")
	public ModelAndView addContact(@Valid @ModelAttribute("newContact") ContactModel newContact, 
		      BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
	    	Iterable<ContactModel> contacts = this.contactService.getItems(1, 100, "");
	    	ModelAndView md = new ModelAndView("index");
	    	md.addObject("contacts", contacts);
			return md;
        }
		this.contactService.add(newContact);

	    	
    	return new ModelAndView("redirect:/");
	}
}
