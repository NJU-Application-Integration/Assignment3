package com.nju.groupPurchaseManagementSystem.bankSystemMQ;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nju.groupPurchaseManagementSystem.bankSystemMQ.massage.TransferMsg;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * Created by Srf on 2017/6/23
 */

@Configuration
public class TransferMessageSender {

    @Resource
    private AmqpTemplate rabbitTemplate;

    public boolean transfer(String account, String password, String target, double amount) {
        TransferMsg msg = new TransferMsg();
        msg.setAccount(account);
        msg.setPassword(password);
        msg.setTarget(target);
        msg.setAmount(amount);
        ObjectMapper mapper = new ObjectMapper();
        Boolean response = false;
        try {
            response = (Boolean) rabbitTemplate.convertSendAndReceive("transfer", mapper.writeValueAsString(msg));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return response;
    }

}
