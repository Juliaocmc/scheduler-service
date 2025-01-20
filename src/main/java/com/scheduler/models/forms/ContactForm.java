package com.scheduler.models.forms;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class ContactForm {
  
  @NotBlank(message = "Name is required")
  @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
  private String name;
  
  @NotBlank(message = "Email is required")
  @Email(message = "Invalid email format")
  private String email;
  
  @NotBlank(message = "Phone is required")
  @Pattern(regexp = "\\d{11}", message = "Phone must be between 11 digits")
  private String phone;
  
  @NotBlank(message = "Document is required")
  @Pattern(regexp = "\\d{11}", message = "Document must be 11 digits")
  private String document;
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getEmail() {
    return email;
  }
  
  public void setEmail(String email) {
    this.email = email;
  }
  
  public String getPhone() {
    return phone;
  }
  
  public void setPhone(String phone) {
    this.phone = phone;
  }
  
  public String getDocument() {
    return document;
  }
  
  public void setDocument(String document) {
    this.document = document;
  }
  
}
