package com.scheduler.controllers;

import com.scheduler.models.forms.SchedulerForm;
import com.scheduler.models.response.PageSchedulerResponse;
import com.scheduler.models.response.SchedulerResponse;
import com.scheduler.services.ISchedulerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/scheduler")
public class SchedulerController {
  
  private final ISchedulerService schedulerService;
  
  public SchedulerController(ISchedulerService schedulerService) {
    this.schedulerService = schedulerService;
  }
  
  @GetMapping("")
  public PageSchedulerResponse schedule(
      @RequestParam("date") String date
  ) {
    return this.schedulerService.getSchedulerByDate(date);
  }
  
  @PostMapping("")
  public SchedulerResponse createScheduler(
      @RequestBody SchedulerForm schedulerForm
  ) {
    return this.schedulerService.createScheduler(schedulerForm);
  }
}
