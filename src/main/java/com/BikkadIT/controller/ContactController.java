package com.BikkadIT.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.BikkadIT.service.ContactServiceI;

@RestController
public class ContactController {
	
	
	@Autowired
	private ContactServiceI contactServiceI;
	
	
	

}
