package lk.ijse.archi.rest.controller;

import lk.ijse.archi.rest.dto.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class WebSocketController {

    private final SimpMessagingTemplate template;

    @Autowired
    WebSocketController(SimpMessagingTemplate template){
        this.template = template;
    }

    @MessageMapping("/send/message")
    @SendTo("/chat")
    public Message onReceivedMesage(String message){
        System.out.println(message);
//        message.setTime(new SimpleDateFormat("HH:mm:ss").format(new Date()));
//        return new Message(message.getMessage(),message.getTime());
        return null;
    }
}
