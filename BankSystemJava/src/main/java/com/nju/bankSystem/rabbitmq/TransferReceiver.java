package com.nju.bankSystem.rabbitmq;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nju.bankSystem.bankJNI.BankJNI;
import com.nju.bankSystem.info.TransferMsg;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by Srf on 2017/6/23
 */

@Component
@RabbitListener(queues = "transfer")
public class TransferReceiver {

    @RabbitHandler
    public boolean process(String json) {
        ObjectMapper mapper = new ObjectMapper();
        boolean result = false;
        try {
            TransferMsg msg = mapper.readValue(json, TransferMsg.class);
            result = BankJNI.transfer(msg.getAccount(), msg.getPassword(), msg.getTarget(), msg.getAmount());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

}
