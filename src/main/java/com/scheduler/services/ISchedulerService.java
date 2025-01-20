package com.scheduler.services;

import com.scheduler.models.forms.SchedulerForm;
import com.scheduler.models.response.PageSchedulerResponse;
import com.scheduler.models.response.SchedulerResponse;
import org.springframework.stereotype.Component;

@Component
public interface ISchedulerService {

  PageSchedulerResponse getSchedulerByDate(String date);
  
  SchedulerResponse createScheduler(SchedulerForm schedulerForm);
}
