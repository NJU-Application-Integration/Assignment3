package com.nju.bankSystem.rabbitmq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nju.bankSystem.info.TransferMsg;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by Srf on 2017/6/23
 */

@Component
public class MockSender {

    @Resource
    private AmqpTemplate rabbitTemplate;

    public void send() {
        TransferMsg msg = new TransferMsg();
        msg.setAccount("buyer");
        msg.setPassword("123");
        msg.setTarget("seller");
        msg.setAmount(100);
        ObjectMapper mapper = new ObjectMapper();
        try {
            Boolean response = (Boolean) rabbitTemplate.convertSendAndReceive("transfer", mapper.writeValueAsString(msg));
            System.out.println(response);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

}
