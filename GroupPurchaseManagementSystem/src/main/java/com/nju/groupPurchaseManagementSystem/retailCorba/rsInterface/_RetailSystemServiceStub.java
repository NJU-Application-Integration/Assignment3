package com.nju.groupPurchaseManagementSystem.retailCorba.rsInterface;


/**
* com.nju.groupPurchaseManagementSystem.retailCorba.rsInterface/_RetailSystemServiceStub.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从retailSystem.idl
* 2017年6月24日 星期六 下午06时29分24秒 CST
*/

public class _RetailSystemServiceStub extends org.omg.CORBA.portable.ObjectImpl implements com.nju.groupPurchaseManagementSystem.retailCorba.rsInterface.RetailSystemService
{

  public boolean confirmPurchase (String sk, String confirmCode)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("confirmPurchase", true);
                $out.write_string (sk);
                $out.write_string (confirmCode);
                $in = _invoke ($out);
                boolean $result = $in.read_boolean ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return confirmPurchase (sk, confirmCode        );
            } finally {
                _releaseReply ($in);
            }
  } // confirmPurchase

  public boolean publishGroupPurchaseItem (String sk, String productName, String introduction, double price, int limit)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("publishGroupPurchaseItem", true);
                $out.write_string (sk);
                $out.write_string (productName);
                $out.write_string (introduction);
                $out.write_double (price);
                $out.write_long (limit);
                $in = _invoke ($out);
                boolean $result = $in.read_boolean ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return publishGroupPurchaseItem (sk, productName, introduction, price, limit        );
            } finally {
                _releaseReply ($in);
            }
  } // publishGroupPurchaseItem

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:com.nju.groupPurchaseManagementSystem.retailCorba.rsInterface/RetailSystemService:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }

  private void readObject (java.io.ObjectInputStream s) throws java.io.IOException
  {
     String str = s.readUTF ();
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     org.omg.CORBA.Object obj = orb.string_to_object (str);
     org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate ();
     _set_delegate (delegate);
   } finally {
     orb.destroy() ;
   }
  }

  private void writeObject (java.io.ObjectOutputStream s) throws java.io.IOException
  {
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     String str = orb.object_to_string (this);
     s.writeUTF (str);
   } finally {
     orb.destroy() ;
   }
  }
} // class _RetailSystemServiceStub
