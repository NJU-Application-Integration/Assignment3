package com.nju.bankSystem.corba;

import Bank.BankService;
import Bank.BankServicePOA;
import Bank.record;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nju.bankSystem.bankJNI.BankJNI;
import com.nju.bankSystem.info.Record;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by sbin on 2017/6/28.
 */
public class BankCorbaService extends BankServicePOA{

    @Override
    public record[] listHistory(String account, String password) {
        System.out.println(account);
        System.out.println(password);

        List<Record> recordList = BankJNI.listHistory(account,password);
        System.out.println(recordList);

        record[] rArray = new record[recordList.size()];
        for(int i=0; i<recordList.size() ;i++){
            Record r = recordList.get(i);
            rArray[i] = new RecordCorbaImpl();
            rArray[i].amount = r.getAmount();
            rArray[i].source = r.getSource();
            rArray[i].target = r.getTarget();
        }
        System.out.println(rArray.length);
        return rArray;
    }

    @Override
    public String[] listInListString(String account, String password) {
        ObjectMapper mapper = new ObjectMapper();

        List<Record> recordList = BankJNI.listHistory(account,password);
        String[] listString  = new String[recordList.size()];
        for(int i=0; i<recordList.size() ;i++){
            Record r = recordList.get(i);
            try {
                listString[i] = mapper.writeValueAsString(r);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }

        return listString;
    }

}
