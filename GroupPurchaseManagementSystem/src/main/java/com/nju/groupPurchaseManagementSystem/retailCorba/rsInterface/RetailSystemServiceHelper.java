package com.nju.groupPurchaseManagementSystem.retailCorba.rsInterface;


/**
* com.nju.groupPurchaseManagementSystem.retailCorba.rsInterface/RetailSystemServiceHelper.java .
* ��IDL-to-Java ������ (����ֲ), �汾 "3.2"����
* ��retailSystem.idl
* 2017��6��24�� ������ ����06ʱ29��24�� CST
*/

abstract public class RetailSystemServiceHelper
{
  private static String  _id = "IDL:com.nju.groupPurchaseManagementSystem.retailCorba.rsInterface/RetailSystemService:1.0";

  public static void insert (org.omg.CORBA.Any a, com.nju.groupPurchaseManagementSystem.retailCorba.rsInterface.RetailSystemService that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static com.nju.groupPurchaseManagementSystem.retailCorba.rsInterface.RetailSystemService extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (com.nju.groupPurchaseManagementSystem.retailCorba.rsInterface.RetailSystemServiceHelper.id (), "RetailSystemService");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static com.nju.groupPurchaseManagementSystem.retailCorba.rsInterface.RetailSystemService read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_RetailSystemServiceStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, com.nju.groupPurchaseManagementSystem.retailCorba.rsInterface.RetailSystemService value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static com.nju.groupPurchaseManagementSystem.retailCorba.rsInterface.RetailSystemService narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof com.nju.groupPurchaseManagementSystem.retailCorba.rsInterface.RetailSystemService)
      return (com.nju.groupPurchaseManagementSystem.retailCorba.rsInterface.RetailSystemService)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      com.nju.groupPurchaseManagementSystem.retailCorba.rsInterface._RetailSystemServiceStub stub = new com.nju.groupPurchaseManagementSystem.retailCorba.rsInterface._RetailSystemServiceStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static com.nju.groupPurchaseManagementSystem.retailCorba.rsInterface.RetailSystemService unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof com.nju.groupPurchaseManagementSystem.retailCorba.rsInterface.RetailSystemService)
      return (com.nju.groupPurchaseManagementSystem.retailCorba.rsInterface.RetailSystemService)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      com.nju.groupPurchaseManagementSystem.retailCorba.rsInterface._RetailSystemServiceStub stub = new com.nju.groupPurchaseManagementSystem.retailCorba.rsInterface._RetailSystemServiceStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
