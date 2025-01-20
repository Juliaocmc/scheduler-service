package com.scheduler.controllers;

import com.scheduler.handlers.exceptions.ContactNotFoundException;
import com.scheduler.models.forms.ContactForm;
import com.scheduler.models.response.ContactResponse;
import com.scheduler.models.response.PageableContactResponse;
import com.scheduler.services.IContactService;
import jakarta.validation.Valid;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/contact")
public class ContactController {
  
  private final IContactService contactService;
  
  public ContactController(IContactService contactService) {
    this.contactService = contactService;
  }
  
  @GetMapping
  public PageableContactResponse getAllContacts(
      @Param("page") String page,
      @Param("size") String size
  ) {
    try {
      return this.contactService.getAllContacts(page, size);
    } catch (Exception e) {
      var message = "An error occurred while trying to get all contacts";
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, message);
    }
  }
  
  @GetMapping("/{contactId}")
  public ContactResponse getContactById(
      @PathVariable("contactId") int contactId
  ) {
    try {
      return this.contactService.getContactById(contactId);
    } catch (ContactNotFoundException e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
    } catch (Exception e) {
      var message = "An error occurred while trying to get the contact";
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, message);
    }
  }
  
  @PostMapping
  public ResponseEntity<ContactResponse> createContact(
      @Valid @RequestBody ContactForm contactForm
  ) {
    try {
      return ResponseEntity.ok(this.contactService.createContact(contactForm));
    } catch (Exception e) {
      var message = "An error occurred while trying to create the contact";
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, message);
    }
  }
  
  @PutMapping("/{contactId}")
  public ContactResponse updateContact(
      @PathVariable("contactId") int contactId,
      @RequestBody ContactForm contactForm
  ) {
    try {
      return this.contactService.updateContact(contactId, contactForm);
    } catch (ContactNotFoundException e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
    } catch (Exception e) {
      var message = "An error occurred while trying to update the contact";
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, message);
    }
  }
  
  @DeleteMapping("/{contactId}")
  public void deleteContact(
      @PathVariable("contactId") int contactId
  ) {
    try {
      this.contactService.deleteContact(contactId);
    } catch (ContactNotFoundException e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
    } catch (Exception e) {
      var message = "An error occurred while trying to delete the contact";
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, message);
    }
  }
  
}
