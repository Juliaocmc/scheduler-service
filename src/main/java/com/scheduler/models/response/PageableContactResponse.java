package com.scheduler.models.response;

import java.util.List;

public class PageableContactResponse {
    
    private List<ContactResponse> contacts;
    private String                   currentPage;
    private String                   currentSize;
    private String                   totalPages;
    private String                   totalElements;
    
    public PageableContactResponse(
        List<ContactResponse> contacts,
        String currentPage,
        String currentSize,
        String totalPages,
        String totalElements
    ) {
        this.contacts = contacts;
        this.currentPage = currentPage;
        this.currentSize = currentSize;
        this.totalPages = totalPages;
        this.totalElements = totalElements;
    }
  
  public List<ContactResponse> getContacts() {
    return contacts;
  }
  
  public void setContacts(List<ContactResponse> contacts) {
    this.contacts = contacts;
  }
  
  public String getCurrentPage() {
    return currentPage;
  }
  
  public void setCurrentPage(String currentPage) {
    this.currentPage = currentPage;
  }
  
  public String getCurrentSize() {
    return currentSize;
  }
  
  public void setCurrentSize(String currentSize) {
    this.currentSize = currentSize;
  }
  
  public String getTotalPages() {
    return totalPages;
  }
  
  public void setTotalPages(String totalPages) {
    this.totalPages = totalPages;
  }
  
  public String getTotalElements() {
    return totalElements;
  }
  
  public void setTotalElements(String  totalElements) {
    this.totalElements = totalElements;
  }
  
}
