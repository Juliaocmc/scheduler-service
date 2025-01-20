package com.scheduler.clients.implamentations;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BasicClient {
  
  private final RestTemplate restTemplate;
  
  public BasicClient() {
    this.restTemplate = new RestTemplate();
  }
  
  protected void makeGetRequest(String url, Object body) {
    restTemplate.exchange
        (url, HttpMethod.GET, new HttpEntity<>(body), String.class).getBody();
  }
  
}
