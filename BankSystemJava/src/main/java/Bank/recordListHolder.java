package Bank;


/**
* Bank/recordListHolder.java .
* ��IDL-to-Java ������ (����ֲ), �汾 "3.2"����
* ��./bank.idl
* 2017��6��28�� ������ ����01ʱ05��25�� CST
*/

public final class recordListHolder implements org.omg.CORBA.portable.Streamable
{
  public Bank.record value[] = null;

  public recordListHolder ()
  {
  }

  public recordListHolder (Bank.record[] initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = Bank.recordListHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    Bank.recordListHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return Bank.recordListHelper.type ();
  }

}
