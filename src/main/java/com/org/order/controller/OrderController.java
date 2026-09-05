package com.org.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.order.model.OrderModel;
import com.org.order.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	  @Autowired
	  private OrderService orderService;
	  
	    @PostMapping("createOrder")
	    public ResponseEntity<OrderModel> createOrder(
	    		@RequestBody OrderModel model) {

	        return ResponseEntity.ok(
	                orderService.createOrder(model)
	        );
	    }

	    @PostMapping("cancelOrder")
	    public ResponseEntity<String> cancelOrder(
	            @RequestBody OrderModel model) {

	        orderService.cancelOrder(
	        		model
	        );

	        return ResponseEntity.ok(
	                "Order cancellation event published"
	        );
	    }
}
