package com.org.order.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.org.order.kafka.constants.KafkaTopics;
import com.org.order.kafka.event.OrderCreatedEvent;

@Component
public class OrderCreatedProducer {

	 @Autowired
	    private KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate;

	    public void publish(OrderCreatedEvent createdEvent) {

	        String key = createdEvent.getOrderId().toString();

	        kafkaTemplate
	                .send(KafkaTopics.ORDER_CREATED, key, createdEvent)
	                .whenComplete((result, ex) -> {

	                    if (ex != null) {

	                        System.out.println(
	                                "ORDER CREATED EVENT FAILED"
	                        );

	                        ex.printStackTrace();

	                    } else {

	                        System.out.println(
	                                "ORDER CREATED EVENT SENT SUCCESSFULLY"
	                        );

	                        System.out.println(
	                                "Order ID: " + createdEvent.getOrderId()
	                        );

	                        System.out.println(
	                                "Kafka Topic: "
	                                        + result.getRecordMetadata().topic()
	                        );

	                        System.out.println(
	                                "Partition: "
	                                        + result.getRecordMetadata().partition()
	                        );

	                        System.out.println(
	                                "Offset: "
	                                        + result.getRecordMetadata().offset()
	                        );
	                    }
	                });
	    }
}
