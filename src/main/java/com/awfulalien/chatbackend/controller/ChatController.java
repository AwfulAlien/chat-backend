package com.awfulalien.chatbackend.controller;

import com.awfulalien.chatbackend.entity.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

//    @MessageMapping("/resume")
//    @SendTo("/start/initial")
//    public String chat(String msg) {
//        System.out.println(msg);
//        return msg;
//    }

    @MessageMapping("/resume")
    @SendTo("/start/initial")
    public ChatMessage chat(@Payload ChatMessage chatMessage) {
        System.out.println("Chat Message : "+chatMessage);
        return chatMessage;
    }
    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
        return chatMessage;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }

}
