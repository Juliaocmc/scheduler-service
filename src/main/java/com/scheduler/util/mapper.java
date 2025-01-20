package com.scheduler.util;

import com.scheduler.models.entities.Contact;
import com.scheduler.models.entities.Scheduler;
import com.scheduler.models.forms.ContactForm;
import com.scheduler.models.forms.SchedulerForm;
import com.scheduler.models.response.ContactResponse;
import com.scheduler.models.response.SchedulerResponse;

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
  
  public static Contact Contact(ContactForm contactForm) {
    var contact = new Contact();
    contact.setName(contactForm.getName());
    contact.setEmail(contactForm.getEmail());
    contact.setPhone(contactForm.getPhone());
    contact.setDocument(contactForm.getDocument());
    return contact;
  }
  
  public static Scheduler Scheduler(SchedulerForm schedulerForm, Contact contact) {
    var scheduler = new Scheduler();
    var localDate = DateUtil.convertStringToLocalDate(schedulerForm.getDate());
    scheduler.setDate(localDate);
    scheduler.setContact(contact);
    scheduler.setStartTime(schedulerForm.getStartHour());
    scheduler.setEndTime(schedulerForm.getEndHour());
    scheduler.setLocal(schedulerForm.getLocal());
    
    return scheduler;
  }
  
  public static SchedulerResponse SchedulerResponse(Scheduler scheduler) {
    var response = new SchedulerResponse();
    Contact contact = scheduler.getContact();
    response.setContact(contact.getName());
    response.setContactId(String.valueOf(scheduler.getContact()));
    response.setDate(String.valueOf(scheduler.getDate()));
    var maskTime = String.format("%s - %s", scheduler.getStartTime(), scheduler.getEndTime());
    response.setHour(maskTime);
    response.setLocal(scheduler.getLocal());
    return response;
  }
}
