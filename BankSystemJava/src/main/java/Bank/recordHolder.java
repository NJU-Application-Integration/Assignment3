package Bank;

/**
* Bank/recordHolder.java .
* ��IDL-to-Java ������ (����ֲ), �汾 "3.2"����
* ��./bank.idl
* 2017��6��28�� ������ ����04ʱ16��13�� CST
*/

public final class recordHolder implements org.omg.CORBA.portable.Streamable
{
  public Bank.record value = null;

  public recordHolder ()
  {
  }

  public recordHolder (Bank.record initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = Bank.recordHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    Bank.recordHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return Bank.recordHelper.type ();
  }

}
