package com.scheduler.services.implementations;

import com.scheduler.models.forms.ContactForm;
import com.scheduler.models.response.ContactResponse;
import com.scheduler.repositories.IContactsRepository;
import com.scheduler.services.IContactService;
import com.scheduler.util.mapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Component;

@Component
public class ContactService implements IContactService {
  
  private final IContactsRepository contactsRepository;
  
  public ContactService(IContactsRepository contactsRepository) {
    this.contactsRepository = contactsRepository;
  }
  
  @Override
  public List<ContactResponse> getAllContacts(String page, String size) {
    QPageRequest pageRequest = QPageRequest.of(Integer.parseInt(page), Integer.parseInt(size));
    return this.contactsRepository.findAll(pageRequest)
        .stream()
        .map(mapper::ContactsResponse)
        .collect(Collectors.toList());
  }
  
  @Override
  public ContactResponse getContactById(int contactId) {
    var contact = this.contactsRepository.getContactsById(contactId)
        .orElseThrow(() -> new RuntimeException("Contact not found"));
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
        .orElseThrow(() -> new RuntimeException("Contact not found"));
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
        .orElseThrow(() -> new RuntimeException("Contact not found"));
    this.contactsRepository.delete(contact);
  
  }
  
}
