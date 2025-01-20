package com.scheduler.services.implementations;

import com.scheduler.clients.IEmailClient;
import com.scheduler.handlers.exceptions.ContactNotFoundException;
import com.scheduler.models.forms.RunMockForm;
import com.scheduler.models.forms.SchedulerForm;
import com.scheduler.models.response.PageSchedulerResponse;
import com.scheduler.models.response.SchedulerResponse;
import com.scheduler.repositories.IContactsRepository;
import com.scheduler.repositories.ISchedulerRepository;
import com.scheduler.services.ISchedulerService;
import com.scheduler.util.DateUtil;
import com.scheduler.util.mapper;
import com.scheduler.models.entities.Scheduler;
import java.util.Comparator;
import java.util.concurrent.CompletableFuture;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SchedulerService implements ISchedulerService {
  
  private final ISchedulerRepository schedulerRepository;
  
  private final IContactsRepository  contactsRepository;
  
  @Value("${resource.email.create-scheduler-template-id}")
  private String templateId;
  
  private final IEmailClient emailClient;
  
  public SchedulerService(
      ISchedulerRepository schedulerRepository,
      IContactsRepository contactsRepository,
      @Qualifier("runMockClient") IEmailClient emailClient
  ) {
    this.schedulerRepository = schedulerRepository;
    this.contactsRepository = contactsRepository;
    this.emailClient         = emailClient;
  }
  
  @Override
  public PageSchedulerResponse getSchedulerByDate(String date) {
    var localDate = DateUtil.convertStringToLocalDate(date);
    var schedulers = this.schedulerRepository.getSchedulerByDate(localDate)
        .stream()
        .sorted(Comparator.comparing(Scheduler::getStartTime))
        .map(mapper::SchedulerResponse)
        .toList();
    return new PageSchedulerResponse(schedulers);
  }
  
  @Override
  public SchedulerResponse createScheduler(SchedulerForm schedulerForm) {
    var contact = this.contactsRepository.getContactsById(schedulerForm.getContactId())
        .orElseThrow(() -> new ContactNotFoundException("Contact not found"));
    var scheduler = mapper.Scheduler(schedulerForm, contact);
    this.schedulerRepository.save(scheduler);
    CompletableFuture.runAsync(() -> {
      this.sendEmail(scheduler);
    });
    return mapper.SchedulerResponse(scheduler);
  }
  
  private void sendEmail(Scheduler scheduler) {
    var email = scheduler.getContact().getEmail();
    var data = RunMockForm.Builder()
        .withScheduler(scheduler)
        .build();
    this.emailClient.sendEmail(email, this.templateId,  data);
  }

}
