package com.scheduler.models.response;

public class ContactResponse {
  
  private String id;
  private String name;
  private String email;
  private String phone;
  private String document;
  
  
  public ContactResponse(int contactId, String name, String email, String phone, String document) {
    this.id       = String.valueOf(contactId);
    this.name     = name;
    this.email    = email;
    this.phone    = phone;
    this.document = document;
  }
  
  public String getId() {
    return id;
  }
  
  public void setId(String id) {
    this.id = id;
  }
  
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
