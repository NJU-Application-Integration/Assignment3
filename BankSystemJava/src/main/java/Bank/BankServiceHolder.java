package Bank;

/**
* Bank/BankServiceHolder.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从./bank.idl
* 2017年6月28日 星期三 下午01时05分25秒 CST
*/

public final class BankServiceHolder implements org.omg.CORBA.portable.Streamable
{
  public Bank.BankService value = null;

  public BankServiceHolder ()
  {
  }

  public BankServiceHolder (Bank.BankService initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = Bank.BankServiceHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    Bank.BankServiceHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return Bank.BankServiceHelper.type ();
  }

}
