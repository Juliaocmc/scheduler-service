package com.scheduler.models.forms;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

public class SchedulerForm {
  
  @NotBlank(message = "Date is required")
  @Pattern(
      regexp = "\\d{4}-\\d{2}-\\d{2}",
      message = "Date must be in the format yyyy-MM-dd"
  )
  private String date;
  
  @NotBlank(message = "Start hour is required")
  @Pattern(
      regexp = "^(?:[01]\\d|2[0-3]):[0-5]\\d$",
      message = "Start hour must be 00:00"
  )
  private String startHour;
  
  @NotBlank(message = "End hour is required")
  @Pattern(
      regexp = "^(?:[01]\\d|2[0-3]):[0-5]\\d$",
      message = "End hour must be 00:00"
  )
  private String endHour;
  
  @NotBlank(message = "Local is required")
  private String local;
  
  @Positive(message = "Contact ID must be a positive number")
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
