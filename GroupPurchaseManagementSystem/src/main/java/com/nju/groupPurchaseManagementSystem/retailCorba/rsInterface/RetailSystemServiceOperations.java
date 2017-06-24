package com.nju.groupPurchaseManagementSystem.retailCorba.rsInterface;


/**
* com.nju.groupPurchaseManagementSystem.retailCorba.rsInterface/RetailSystemServiceOperations.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从retailSystem.idl
* 2017年6月24日 星期六 下午06时29分24秒 CST
*/

public interface RetailSystemServiceOperations 
{
  boolean confirmPurchase (String sk, String confirmCode);
  boolean publishGroupPurchaseItem (String sk, String productName, String introduction, double price, int limit);
} // interface RetailSystemServiceOperations
