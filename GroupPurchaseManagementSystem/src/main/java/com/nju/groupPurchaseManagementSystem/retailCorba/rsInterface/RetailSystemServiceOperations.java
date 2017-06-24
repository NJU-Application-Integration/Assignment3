package com.nju.groupPurchaseManagementSystem.retailCorba.rsInterface;


/**
* com.nju.groupPurchaseManagementSystem.retailCorba.rsInterface/RetailSystemServiceOperations.java .
* ��IDL-to-Java ������ (����ֲ), �汾 "3.2"����
* ��retailSystem.idl
* 2017��6��24�� ������ ����06ʱ29��24�� CST
*/

public interface RetailSystemServiceOperations 
{
  boolean confirmPurchase (String sk, String confirmCode);
  boolean publishGroupPurchaseItem (String sk, String productName, String introduction, double price, int limit);
} // interface RetailSystemServiceOperations
