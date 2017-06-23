package com.nju.bankSystem.bankJNI;

import com.nju.bankSystem.info.Record;

import java.util.List;

/**
 * Created by sbin on 2017/6/4
 */
public class BankJNI {

    static {
        System.load("E:\\MyCoding\\GroupPurchaseSystem\\BankSystemJava\\native\\BankSystem.dll");
    }

    public static native boolean
        transfer(String account, String password, String target, double amount);

    public static native List<Record>
        listHistory(String account, String password);

}
