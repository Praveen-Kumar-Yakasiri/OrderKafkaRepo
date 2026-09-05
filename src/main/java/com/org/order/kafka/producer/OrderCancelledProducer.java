package com.org.order.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.org.order.kafka.constants.KafkaTopics;
import com.org.order.kafka.event.OrderCancelledEvent;

@Component
public class OrderCancelledProducer {
 
	@Autowired
	private KafkaTemplate<String, OrderCancelledEvent> kafkaTemplate;
	
	public void publish(OrderCancelledEvent cancelledEvent) {

        String key = cancelledEvent.getOrderId().toString();

        kafkaTemplate.send(
                KafkaTopics.ORDER_CANCELLED,
                key,
                cancelledEvent
        );

        System.out.println(
                "ORDER CANCELLED EVENT SENT"
        );

        System.out.println(
                "Order ID: " + cancelledEvent.getOrderId()
        );

        System.out.println(
                "Kafka Topic: " + KafkaTopics.ORDER_CANCELLED
        ); 
	}
}
