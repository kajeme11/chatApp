package com.chat.chatApp.controller;

import com.chat.chatApp.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChatController {

    /**
     * client sends a message to /app/sendMessage
     * this method will process it
     * and will send the response to the clients subscribed
     * to /topic/messages
     * Will broadcast to /topic/message
     *
     *
     * @param chatMessage
     * @return
     */
    @MessageMapping("/sendMessage")
    @SendTo("/topic/message")
    public ChatMessage sendMessage(ChatMessage chatMessage){
        return chatMessage;
    }

    @GetMapping
    public String chat(){
        return "chat";
    }

}
