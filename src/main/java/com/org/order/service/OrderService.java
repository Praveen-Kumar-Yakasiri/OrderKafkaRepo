package com.org.order.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.order.kafka.event.OrderCancelledEvent;
import com.org.order.kafka.event.OrderCreatedEvent;
import com.org.order.kafka.producer.OrderCancelledProducer;
import com.org.order.kafka.producer.OrderCreatedProducer;
import com.org.order.model.OrderModel;

@Service
public class OrderService {

	@Autowired
	private OrderCreatedProducer createdProducer;
	
	@Autowired
	private OrderCancelledProducer cancelledProducer;
	
	@Autowired
	private ModelMapper mapper;
	
	
	 public OrderModel createOrder(OrderModel order) {

	        System.out.println(
	                "Creating order: " + order.getOrderId()
	        );

	        OrderCreatedEvent event = mapper.map(order, OrderCreatedEvent.class);

	        createdProducer.publish(event);

	        return order;
	    }

	    public void cancelOrder(OrderModel order) {

	    	 OrderCancelledEvent event = mapper.map(order, OrderCancelledEvent.class);
	                
	    	cancelledProducer.publish(event);
	    }
}
