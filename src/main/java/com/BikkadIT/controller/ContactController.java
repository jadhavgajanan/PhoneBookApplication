package com.BikkadIT.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BikkadIT.model.Contact;
import com.BikkadIT.service.ContactServiceI;

@RestController
@RequestMapping("/contact")
public class ContactController {

	@Autowired
	private ContactServiceI contactServiceI;
	
	@PostMapping("/saveContact")
	public ResponseEntity<String> saveContact(@RequestBody Contact contact){
		boolean saveContact = this.contactServiceI.saveContact(contact);
		
		if(saveContact==true) {
			return new ResponseEntity<>("Contact save Successfully.",HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<String>("Contact Not Saved",HttpStatus.BAD_REQUEST);
		}	
		}
	
	@GetMapping("/getAllContact")
	public ResponseEntity<List<Contact>> getAllContact(){
	List<Contact> allContact = this.contactServiceI.getAllContact();
	
	if(allContact!=null) {
		return new ResponseEntity<List<Contact>>(allContact,HttpStatus.OK);
	}
	else {
		return new ResponseEntity<List<Contact>>(allContact,HttpStatus.BAD_REQUEST);
	}
	}
	
	
	@PutMapping("/updateContact")
	public ResponseEntity<String> updateContact(@RequestBody Contact contact){
		
		boolean updateContact = this.contactServiceI.updateContact(contact);
		
		if(updateContact==true) {
			return new ResponseEntity<String>("Update Contact successfully.",HttpStatus.OK);
		}
		else {
		return new ResponseEntity<String>("Contact Not Updated Successfully.",HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/getSigleContact")
	public ResponseEntity<Contact> getSingleContact(Integer contactId){
		Contact contactById = this.contactServiceI.getContactById(contactId);
		
		return new ResponseEntity<Contact>(contactById,HttpStatus.OK); 
	}
	
	@DeleteMapping("/deleteContact")
	public ResponseEntity<String> deleteContact(Integer contactId){
		boolean deleteContact = this.contactServiceI.deleteContactById(contactId);
		if(deleteContact==true) {
			return new ResponseEntity<String>("Delete Contact successfully.",HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("Contact Not Deleted ",HttpStatus.OK);
		}
	}
}

