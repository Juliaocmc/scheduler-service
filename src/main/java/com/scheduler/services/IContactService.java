package com.scheduler.services;

import com.scheduler.models.forms.ContactForm;
import com.scheduler.models.response.ContactResponse;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public interface IContactService {
  
  List<ContactResponse> getAllContacts(String page, String size);
  
  ContactResponse getContactById(int  contact);
  
  ContactResponse createContact(ContactForm contactForm);
  
  ContactResponse updateContact(int contactId, ContactForm contactForm);
  
  void deleteContact(int contactId);
}
