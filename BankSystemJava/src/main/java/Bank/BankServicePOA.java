package Bank;


/**
* Bank/BankServicePOA.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从./bank.idl
* 2017年6月28日 星期三 下午04时16分13秒 CST
*/

public abstract class BankServicePOA extends org.omg.PortableServer.Servant
 implements Bank.BankServiceOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("listHistory", new java.lang.Integer (0));
    _methods.put ("listInListString", new java.lang.Integer (1));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // Bank/BankService/listHistory
       {
         String account = in.read_string ();
         String password = in.read_string ();
         Bank.record $result[] = null;
         $result = this.listHistory (account, password);
         out = $rh.createReply();
         Bank.recordListHelper.write (out, $result);
         break;
       }

       case 1:  // Bank/BankService/listInListString
       {
         String account = in.read_string ();
         String password = in.read_string ();
         String $result[] = null;
         $result = this.listInListString (account, password);
         out = $rh.createReply();
         Bank.recordListStringHelper.write (out, $result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:Bank/BankService:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public BankService _this() 
  {
    return BankServiceHelper.narrow(
    super._this_object());
  }

  public BankService _this(org.omg.CORBA.ORB orb) 
  {
    return BankServiceHelper.narrow(
    super._this_object(orb));
  }


} // class BankServicePOA
