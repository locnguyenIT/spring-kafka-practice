package com.ntloc.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/messages")
public class MessageController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public MessageController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping(path = "/partition/0")
    public void publishMessagePartitions0(@RequestBody MessageRequest messageRequest) {
        kafkaTemplate.send("ntloc", 0, null, messageRequest.message());
    }

    @PostMapping(path = "/partition/1")
    public void publishMessagePartitions1(@RequestBody MessageRequest messageRequest) {
        kafkaTemplate.send("ntloc", 1, null, messageRequest.message());
    }
}
