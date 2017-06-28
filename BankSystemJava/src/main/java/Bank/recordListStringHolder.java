package Bank;


/**
* Bank/recordListStringHolder.java .
* ��IDL-to-Java ������ (����ֲ), �汾 "3.2"����
* ��./bank.idl
* 2017��6��28�� ������ ����04ʱ16��13�� CST
*/

public final class recordListStringHolder implements org.omg.CORBA.portable.Streamable
{
  public String value[] = null;

  public recordListStringHolder ()
  {
  }

  public recordListStringHolder (String[] initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = Bank.recordListStringHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    Bank.recordListStringHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return Bank.recordListStringHelper.type ();
  }

}
