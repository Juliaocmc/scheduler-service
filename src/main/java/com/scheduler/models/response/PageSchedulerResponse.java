package com.scheduler.models.response;

import java.util.List;

public class PageSchedulerResponse {
  private List<SchedulerResponse> schedulers;
  
  
  public PageSchedulerResponse(List<SchedulerResponse> schedulers) {
    this.schedulers = schedulers;
  }
  
  public List<SchedulerResponse> getSchedulers() {
    return schedulers;
  }
  
  public void setSchedulers(List<SchedulerResponse> schedulers) {
    this.schedulers = schedulers;
  }
  
}
