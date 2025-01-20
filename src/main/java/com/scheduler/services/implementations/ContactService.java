package com.scheduler.services.implementations;

import com.scheduler.handlers.exceptions.ContactNotFoundException;
import com.scheduler.models.forms.ContactForm;
import com.scheduler.models.response.ContactResponse;
import com.scheduler.models.response.PageableContactResponse;
import com.scheduler.repositories.IContactsRepository;
import com.scheduler.services.IContactService;
import com.scheduler.util.mapper;
import java.util.stream.Collectors;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class ContactService implements IContactService {

  private final IContactsRepository contactsRepository;

  public ContactService(IContactsRepository contactsRepository) {
    this.contactsRepository = contactsRepository;
  }

  @Override
  public PageableContactResponse getAllContacts(String page, String size) {
    var pageInt = Integer.parseInt(page);
    var sizeInt = Integer.parseInt(size);
    Pageable pageable = Pageable.ofSize(sizeInt).withPage(pageInt);
    var contacts = this.contactsRepository.findAll(pageable)
        .stream()
        .map(mapper::ContactsResponse)
        .collect(Collectors.toList());
    
    // TOTAL de itens e paginas
    var allContacts = this.contactsRepository.findAll()
        .stream()
        .map(mapper::ContactsResponse)
        .collect(Collectors.toList());
    var totalPages = String.valueOf(allContacts.size() / sizeInt);
    var totalElements = String.valueOf(allContacts.size());
    
    return new PageableContactResponse(contacts, page, size, totalPages, totalElements);
  }

  @Override
  public ContactResponse getContactById(int contactId) {
    var contact = this.contactsRepository.getContactsById(contactId)
        .orElseThrow(() -> new ContactNotFoundException("Contact not found"));
    return mapper.ContactsResponse(contact);
  }

  @Override
  public ContactResponse createContact(ContactForm contactForm) {
    var contact = mapper.ContactForm(contactForm);
    this.contactsRepository.save(contact);
    return mapper.ContactsResponse(contact);

  }

  @Override
  public ContactResponse updateContact(int contactId, ContactForm contactForm) {
    var contact = this.contactsRepository.getContactsById(contactId)
        .orElseThrow(() -> new ContactNotFoundException("Contact not found"));
    contact.setName(contactForm.getName());
    contact.setEmail(contactForm.getEmail());
    contact.setPhone(contactForm.getPhone());
    contact.setDocument(contactForm.getDocument());
    this.contactsRepository.save(contact);
    return mapper.ContactsResponse(contact);

  }

  @Override
  public void deleteContact(int contactId) {
    var contact = this.contactsRepository.getContactsById(contactId)
        .orElseThrow(() -> new ContactNotFoundException("Contact not found"));
    this.contactsRepository.delete(contact);

  }

}
