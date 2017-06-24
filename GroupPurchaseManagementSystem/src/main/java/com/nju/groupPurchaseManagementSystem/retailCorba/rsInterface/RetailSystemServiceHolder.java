package com.nju.groupPurchaseManagementSystem.retailCorba.rsInterface;

/**
* com.nju.groupPurchaseManagementSystem.retailCorba.rsInterface/RetailSystemServiceHolder.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从retailSystem.idl
* 2017年6月24日 星期六 下午06时29分24秒 CST
*/

public final class RetailSystemServiceHolder implements org.omg.CORBA.portable.Streamable
{
  public com.nju.groupPurchaseManagementSystem.retailCorba.rsInterface.RetailSystemService value = null;

  public RetailSystemServiceHolder ()
  {
  }

  public RetailSystemServiceHolder (com.nju.groupPurchaseManagementSystem.retailCorba.rsInterface.RetailSystemService initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = com.nju.groupPurchaseManagementSystem.retailCorba.rsInterface.RetailSystemServiceHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    com.nju.groupPurchaseManagementSystem.retailCorba.rsInterface.RetailSystemServiceHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return com.nju.groupPurchaseManagementSystem.retailCorba.rsInterface.RetailSystemServiceHelper.type ();
  }

}
