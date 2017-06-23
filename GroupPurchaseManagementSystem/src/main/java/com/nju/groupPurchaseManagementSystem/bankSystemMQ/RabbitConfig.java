package com.nju.groupPurchaseManagementSystem.bankSystemMQ;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Srf on 2017/6/23
 */

@Configuration
public class RabbitConfig {

    @Bean
    public Queue transferQueue() {
        return new Queue("transfer");
    }

}
