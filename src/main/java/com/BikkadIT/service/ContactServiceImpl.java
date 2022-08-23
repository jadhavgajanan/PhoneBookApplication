package com.BikkadIT.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BikkadIT.model.Contact;
import com.BikkadIT.repository.ContactRepo;
@Service
public class ContactServiceImpl implements ContactServiceI {

	@Autowired
	private ContactRepo contactRepo;
	
	
	@Override
	public boolean saveContact(Contact contact) {
		Contact save = this.contactRepo.save(contact);
		return true;
	}

	@Override
	public List<Contact> getAllContact() {
		List<Contact> contactList = this.contactRepo.findAll();
		return contactList;
	}

	@Override
	public Contact getContactById(Integer contactId) {
	Contact contact = this.contactRepo.findByContactId(contactId);
		return contact;
	}

	@Override
	public boolean deleteContactById(Integer contactId) {
		this.contactRepo.deleteById(contactId);
		return true;
	
	}

	@Override
	public boolean updateContact(Contact contact) {
		return true;
	}

}
