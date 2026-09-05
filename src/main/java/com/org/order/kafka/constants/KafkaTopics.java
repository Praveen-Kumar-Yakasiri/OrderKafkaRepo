package com.org.order.kafka.constants;

public final class KafkaTopics {
  
	private KafkaTopics() {};
	
	public static final String ORDER_CREATED ="order.created";
            
    public static final String ORDER_CANCELLED ="order.cancelled";

    public static final String PAYMENT_COMPLETED ="payment.completed";
            
    public static final String PAYMENT_FAILED ="payment.failed";
             
}
