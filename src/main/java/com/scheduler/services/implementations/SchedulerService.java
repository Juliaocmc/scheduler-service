package com.scheduler.services.implementations;

import com.scheduler.handlers.exceptions.ContactNotFoundException;
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
import org.springframework.stereotype.Component;

@Component
public class SchedulerService implements ISchedulerService {
  
  private final ISchedulerRepository schedulerRepository;
  private final IContactsRepository  contactsRepository;
  
  public SchedulerService(
      ISchedulerRepository schedulerRepository,
      IContactsRepository contactsRepository
  ) {
    this.schedulerRepository = schedulerRepository;
    this.contactsRepository = contactsRepository;
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
    return mapper.SchedulerResponse(scheduler);
  }

}
