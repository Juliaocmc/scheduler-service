package com.scheduler.models.forms;

import com.scheduler.models.entities.Scheduler;

public class RunMockForm {
  
  private String name;
  private String startTime;
  private String endTime;
  private String date;
  private String local;
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getStartTime() {
    return startTime;
  }
  
  public void setStartTime(String startTime) {
    this.startTime = startTime;
  }
  
  public String getEndTime() {
    return endTime;
  }
  
  public void setEndTime(String endTime) {
    this.endTime = endTime;
  }
  
  public String getDate() {
    return date;
  }
  
  public void setDate(String date) {
    this.date = date;
  }
  
  public String getLocal() {
    return local;
  }
  
  public void setLocal(String local) {
    this.local = local;
  }
  
  public static Builder Builder() {
    return new Builder();
  }
  
  public static class Builder {
    private String name;
    private String startTime;
    private String endTime;
    private String date;
    private String local;
    
    public Builder withScheduler(Scheduler scheduler) {
      this.name = scheduler.getContact().getName();
      this.startTime = scheduler.getStartTime();
      this.endTime = scheduler.getEndTime();
      this.date = String.valueOf(scheduler.getDate());
      this.local = scheduler.getLocal();
      return this;
    }
    
    public RunMockForm build() {
      return new RunMockForm(this);
    }
  }
  
  private RunMockForm(Builder builder) {
    this.name = builder.name;
    this.startTime = builder.startTime;
    this.endTime = builder.endTime;
    this.date = builder.date;
    this.local = builder.local;
  }
  
}
