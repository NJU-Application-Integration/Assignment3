package Bank;


/**
* Bank/record.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从./bank.idl
* 2017年6月28日 星期三 下午01时05分25秒 CST
*/

public abstract class record implements org.omg.CORBA.portable.StreamableValue
{
  public String source = null;
  public String target = null;
  public double amount = (double)0;

  private static String[] _truncatable_ids = {
    Bank.recordHelper.id ()
  };

  public String[] _truncatable_ids() {
    return _truncatable_ids;
  }

  public void _read (org.omg.CORBA.portable.InputStream istream)
  {
    this.source = istream.read_string ();
    this.target = istream.read_string ();
    this.amount = istream.read_double ();
  }

  public void _write (org.omg.CORBA.portable.OutputStream ostream)
  {
    ostream.write_string (this.source);
    ostream.write_string (this.target);
    ostream.write_double (this.amount);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return Bank.recordHelper.type ();
  }
} // class record
