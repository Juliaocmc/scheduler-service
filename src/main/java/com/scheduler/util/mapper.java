package com.scheduler.util;

import com.scheduler.models.entities.Contact;
import com.scheduler.models.forms.ContactForm;
import com.scheduler.models.response.ContactResponse;

public class mapper {
  
  public static ContactResponse ContactsResponse(Contact contact) {
    return new ContactResponse(
        contact.getId(),
        contact.getName(),
        contact.getEmail(),
        contact.getPhone(),
        contact.getDocument()
    );
  }
  
  public static Contact ContactForm(ContactForm contactForm) {
    var contact = new Contact();
    contact.setName(contactForm.getName());
    contact.setEmail(contactForm.getEmail());
    contact.setPhone(contactForm.getPhone());
    contact.setDocument(contactForm.getDocument());
    return contact;
  }
  
}
