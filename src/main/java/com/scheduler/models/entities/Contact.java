package com.scheduler.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Contact {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "contact_id")
  private int id;
  
  @Column(name = "contact_name")
  private String name;
  
  @Column(name = "contact_email")
  private String email;
  
  @Column(name = "contact_phone")
  private String phone;
  
  @Column(name = "contact_document")
  private String document;
  
  @CreationTimestamp
  @Column(name = "contact_created_at")
  private LocalDateTime createdAt;
  
  @UpdateTimestamp
  @Column(name = "contact_updated_at")
  private LocalDateTime updatedAt;
  
  public int getId() {
    return id;
  }
  
  public void setId(int contactId) {
    this.id = contactId;
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
  
  public LocalDateTime getCreatedAt() {
    return createdAt;
  }
  
  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }
  
  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }
  
  public void setUpdatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }
  
}
