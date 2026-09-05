package com.org.order.kafka.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentCompletedEvent {

    private Long orderId;

    private Long customerId;

    private Double amount;

    private String status;
}
