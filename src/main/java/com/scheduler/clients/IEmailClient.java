package com.scheduler.clients;

import org.springframework.stereotype.Component;

@Component
public interface IEmailClient {

  void sendEmail(String email, String templateID, Object message);
}
