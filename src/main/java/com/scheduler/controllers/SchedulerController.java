package com.scheduler.controllers;

import com.scheduler.handlers.exceptions.ContactNotFoundException;
import com.scheduler.models.forms.SchedulerForm;
import com.scheduler.models.response.PageSchedulerResponse;
import com.scheduler.models.response.SchedulerResponse;
import com.scheduler.services.ISchedulerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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
    try {
      return this.schedulerService.getSchedulerByDate(date);
    } catch (Exception e) {
      var message = "An error occurred while trying to get the scheduler";
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, message);
    }
  }
  
  @PostMapping("")
  public SchedulerResponse createScheduler(
      @Valid @RequestBody SchedulerForm schedulerForm
  ) {
    
    try {
      return this.schedulerService.createScheduler(schedulerForm);
    } catch (ContactNotFoundException e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
    } catch (Exception e) {
      var message = "An error occurred while trying to create the scheduler";
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, message);
    }
  }
}
