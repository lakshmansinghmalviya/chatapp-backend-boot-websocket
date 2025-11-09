package com.chatapp.chatapp.chat;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo; 
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

@RestController 
public class ChatController {
    
  @MessageMapping("/hello")
  @SendTo("/topic/greetings")
  public String greeting(String message) throws Exception {
    System.out.println("THe message sent here is "+ message);
    return new String("Hello, " + HtmlUtils.htmlEscape(message) + "!");
  }
}