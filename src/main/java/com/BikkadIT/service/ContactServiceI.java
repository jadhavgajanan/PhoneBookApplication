package com.BikkadIT.service;

import java.util.List;
import java.util.Optional;

import com.BikkadIT.model.Contact;

public interface ContactServiceI {
	
	boolean saveContact(Contact contact);
	
	List<Contact> getAllContact();
	
	Contact getContactById(Integer contactId);
	
	boolean updateContact(Contact contact);
	
	boolean deleteContactById(Integer contactId);
	

}
