package com.org.order.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.org.order.kafka.constants.KafkaConsumerGroups;
import com.org.order.kafka.constants.KafkaTopics;
import com.org.order.kafka.event.PaymentCompletedEvent;

@Component
public class PaymentCompletedConsumer {

    @KafkaListener(
            topics = KafkaTopics.PAYMENT_COMPLETED,
            groupId = KafkaConsumerGroups.ORDER_SERVICE
    )
    public void consumePaymentCompleted(
            PaymentCompletedEvent event) {

        System.out.println(
                "========================================"
        );

        System.out.println(
                "ORDER SERVICE RECEIVED PAYMENT EVENT"
        );

        System.out.println(
                "Order ID    : " + event.getOrderId()
        );

        System.out.println(
                "Customer ID : " + event.getCustomerId()
        );

        System.out.println(
                "Amount      : " + event.getAmount()
        );

        System.out.println(
                "Status      : " + event.getStatus()
        );

        System.out.println(
                "========================================"
        );
    }
}
