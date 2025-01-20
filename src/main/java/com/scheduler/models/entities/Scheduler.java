package com.scheduler.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Scheduler {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "schedule_id")
  private int id;
  
  @Column(name = "schedule_date")
  private LocalDate date;
  
  @Column(name = "schedule_start_time")
  private String startTime;
  
  @Column(name = "schedule_end_time")
  private String endTime;
  
  @Column(name = "schedule_local")
  private String local;
  
  @ManyToOne
  private Contact contact;
  
  @CreationTimestamp
  @Column(name = "schedule_created_at")
  private LocalDateTime createdAt;
  
  @UpdateTimestamp
  @Column(name = "schedule_updated_at")
  private LocalDateTime updatedAt;
  
  public int getId() {
    return id;
  }
  
  public void setId(int id) {
    this.id = id;
  }
  
  public LocalDate getDate() {
    return date;
  }
  
  public void setDate(LocalDate date) {
    this.date = date;
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
  
  public String getLocal() {
    return local;
  }
  
  public void setLocal(String local) {
    this.local = local;
  }
  
  public Contact getContact() {
    return contact;
  }
  
  public void setContact(Contact contact) {
    this.contact = contact;
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
