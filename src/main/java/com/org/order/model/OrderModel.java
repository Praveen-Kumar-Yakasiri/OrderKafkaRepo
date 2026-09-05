package com.org.order.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderModel {

	private Long orderId;

    private Long customerId;

    private Double amount;

    private String status;
}
