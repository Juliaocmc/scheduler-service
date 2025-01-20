package com.scheduler.clients.implamentations;

import com.scheduler.clients.IEmailClient;
import org.springframework.stereotype.Component;

@Component("runMockClient")
public class RunMockyClient extends BasicClient implements IEmailClient {
  
  
  
  @Override
  public void sendEmail(String email, String templateID, Object message) {
   var url = "https://run.mocky.io/v3/c9ec2ca3-a7f5-41d0-8550-b859508f4948";
    this.makeGetRequest(url, message);
  }
  
}
