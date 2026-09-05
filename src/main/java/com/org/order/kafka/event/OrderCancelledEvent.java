package com.org.order.kafka.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderCancelledEvent {

    private Long orderId;

    private Long customerId;

    private String reason;

    private String status;
}
