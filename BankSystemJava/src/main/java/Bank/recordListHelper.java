package Bank;


/**
* Bank/recordListHelper.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从./bank.idl
* 2017年6月28日 星期三 下午01时05分25秒 CST
*/

abstract public class recordListHelper
{
  private static String  _id = "IDL:Bank/recordList:1.0";

  public static void insert (org.omg.CORBA.Any a, Bank.record[] that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static Bank.record[] extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = Bank.recordHelper.type ();
      __typeCode = org.omg.CORBA.ORB.init ().create_sequence_tc (0, __typeCode);
      __typeCode = org.omg.CORBA.ORB.init ().create_alias_tc (Bank.recordListHelper.id (), "recordList", __typeCode);
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static Bank.record[] read (org.omg.CORBA.portable.InputStream istream)
  {
    Bank.record value[] = null;
    int _len0 = istream.read_long ();
    value = new Bank.record[_len0];
    for (int _o1 = 0;_o1 < value.length; ++_o1)
      value[_o1] = Bank.recordHelper.read (istream);
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, Bank.record[] value)
  {
    ostream.write_long (value.length);
    for (int _i0 = 0;_i0 < value.length; ++_i0)
      Bank.recordHelper.write (ostream, value[_i0]);
  }

}
