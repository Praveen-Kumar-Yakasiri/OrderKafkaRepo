package com.org.order.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.org.order.kafka.constants.KafkaConsumerGroups;
import com.org.order.kafka.constants.KafkaTopics;
import com.org.order.kafka.event.PaymentFailedEvent;

@Component
public class PaymentFailedConsumer {

    @KafkaListener(
        topics = KafkaTopics.PAYMENT_FAILED,
        groupId = KafkaConsumerGroups.ORDER_SERVICE
    )
    public void consume(PaymentFailedEvent event) {

        System.out.println("======================================");
        System.out.println("PAYMENT FAILED EVENT RECEIVED");
        System.out.println("======================================");

        System.out.println("Order ID    : " + event.getOrderId());
        System.out.println("Customer ID : " + event.getCustomerId());
        System.out.println("Amount      : " + event.getAmount());
        System.out.println("Reason      : " + event.getReason());
        System.out.println("Status      : " + event.getStatus());

 
    }
}
