package com.example.entrypoint.components;

import com.example.entrypoint.DTO.dataoutput.DynamicEpochValue;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QueueSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private Queue queue;

    public void send(DynamicEpochValue output) {
        try {
            var outputJson =  objectMapper.writeValueAsString(output);
            Message message = MessageBuilder
                    .withBody(outputJson.getBytes())
                    .setContentType(MessageProperties.CONTENT_TYPE_JSON)
                    .build();
            rabbitTemplate.convertAndSend(this.queue.getName(), message);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }
}
