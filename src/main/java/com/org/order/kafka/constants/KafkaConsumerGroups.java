package com.org.order.kafka.constants;

public final class KafkaConsumerGroups {

	private KafkaConsumerGroups() {
    }

    public static final String ORDER_SERVICE =
            "order-service";

    public static final String PAYMENT_SERVICE =
            "payment-service";
}
