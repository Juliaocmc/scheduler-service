package com.scheduler.controllers;

import com.scheduler.models.forms.ContactForm;
import com.scheduler.models.response.ContactResponse;
import com.scheduler.services.IContactService;
import java.util.List;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController("/contact")
public class ContactController {
  
  private final IContactService contactService;
  
  public ContactController(IContactService contactService) {
    this.contactService = contactService;
  }
  
  @GetMapping
  public List<ContactResponse> getAllContacts(
      @Param("page") String page,
      @Param("size") String size
  ) {
    return this.contactService.getAllContacts(page, size);
  }
  
  @GetMapping("/{contactId}")
  public ContactResponse getContactById(
      @Param("contactId") int contactId
  ) {
    return this.contactService.getContactById(contactId);
  }
  
  @PostMapping
  public ContactResponse createContact(ContactForm contactForm) {
    return this.contactService.createContact(contactForm);
  }
  
  @PutMapping("/{contactId}")
  public ContactResponse updateContact(
      @Param("contactId") int contactId,
      ContactForm contactForm
  ) {
    return this.contactService.updateContact(contactId, contactForm);
  }
  
  @DeleteMapping("/{contactId}")
  public void deleteContact(
      @Param("contactId") int contactId
  ) {
    this.contactService.deleteContact(contactId);
  }
  
  
}
