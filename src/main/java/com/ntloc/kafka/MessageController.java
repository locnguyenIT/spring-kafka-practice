package com.ntloc.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(path = "/api/v1/messages")
public class MessageController {

    private final KafkaTemplate<String,String> kafkaTemplate;

    public MessageController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public void publishMessage(@RequestBody MessageRequest messageRequest) {
        kafkaTemplate.send("ntloc", messageRequest.message());
    }
}
