package com.scheduler.models.forms;

public class SchedulerForm {

  private String date;
  private String startHour;
  private String endHour;
  private String local;
  private int contactId;
  
  public String getDate() {
    return date;
  }
  
  public void setDate(String date) {
    this.date = date;
  }
  
  public String getStartHour() {
    return startHour;
  }
  
  public void setStartHour(String startHour) {
    this.startHour = startHour;
  }
  
  public String getEndHour() {
    return endHour;
  }
  
  public void setEndHour(String endHour) {
    this.endHour = endHour;
  }
  
  public String getLocal() {
    return local;
  }
  
  public void setLocal(String local) {
    this.local = local;
  }
  
  public int getContactId() {
    return contactId;
  }
  
  public void setContactId(int contactId) {
    this.contactId = contactId;
  }
  
}
