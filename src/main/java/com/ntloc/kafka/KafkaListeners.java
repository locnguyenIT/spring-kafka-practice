package com.ntloc.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(id = "ntlocListeners", topicPartitions =
            {
            @TopicPartition(topic = "ntloc",partitions = "0"),
            @TopicPartition(topic = "ntloc", partitions = "1")
            })
    public void listen(ConsumerRecord<?, ?> record) {
        System.out.println("ntlocListeners received: " + record.value() + " 😜 ");
    }

}
