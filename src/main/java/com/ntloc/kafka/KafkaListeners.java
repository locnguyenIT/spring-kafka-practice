package com.ntloc.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(id = "ntlocListeners", topics = "ntloc")
    public void listen(String data) {
        System.out.println("ntlocListeners received: " + data + " 😜 ");
    }
}
